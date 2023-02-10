import java.rmi.registry.*;
import java.util.Scanner;

public class Client {
	public Client(String[] args) {
		try {
			if (System.getSecurityManager() == null)
				System.setSecurityManager(new SecurityManager());

			Registry reg = LocateRegistry.getRegistry("localhost", 1099);

			FabObjectInterface fabrique = (FabObjectInterface) reg.lookup("Fabrique");

			ObjectInterface Obj1;
			Obj1 = (ObjectInterface) fabrique.newObject();

			ObjectInterface Obj2;
			Obj2 = (ObjectInterface) fabrique.newObject();

			ObjectInterface Obj3;
			Obj3 = (ObjectInterface) fabrique.newObject();

			ObjectInterface Obj4;
			Obj4 = (ObjectInterface) fabrique.newObject();

			ClientDecomposer c = new ClientDecomposer();

			int t[] = new int[8];
			int nL1 = 0;
			int nC1 = 0;
			int nC2 = 0;
			System.out.println("\n*******************Calcul de produit matriciel en mode r�parti******************\n");

			Scanner s = new Scanner(System.in);
			//Saisir Matrice 1
			Matrice m1= new Matrice();
			m1=m1.saisieMat1(m1.getNbL(), m1.getNbCol());
			
			//Remplir Matrice 1
			System.out.println("Remplir la premi�re matrice : ");
			m1.creerTab();
			m1.remplir(m1.getNbL(), m1.getNbCol());
			
			//Saisir Matrice 2
			Matrice m2= new Matrice();
			m2=m2.saisieMat2(m1.getNbCol(), m2.getNbCol(),m1);
			
			//Remplir Matrice 2
			System.out.println("Remplir la 2eme matrice : ");
			m2.creerTab();
			m2.remplir(m1.getNbCol(), m2.getNbCol());
			
			//Afficher les deux matrices
			System.out.println("\n********************************** Matrice 1 **********************************\n");
			m1.afficher();
			System.out.println("\n********************************** Matrice 2 **********************************\n");
			m2.afficher();
			
			//D�composer Matrice 1 en 4 sous matrices
			Matrice m3=new Matrice();
			Matrice m4=new Matrice();
			Matrice m5=new Matrice();
			Matrice m6=new Matrice();
			c.decomposerMat1(m1, m3, m4, m5, m6, t);
			
			//D�composer Matrice 2 en 4 sous matrices
			Matrice m7=new Matrice();
			Matrice m8=new Matrice();
			Matrice m9=new Matrice();
			Matrice m10=new Matrice();
			c.decomposerMat2(m2, m7, m8, m9, m10, t);
			
			//Calculer le produit de chaque deux sous matrice
			Matrice res1=new Matrice();
			Matrice res2=new Matrice();
			Matrice res3=new Matrice();
			Matrice res4=new Matrice();
			res1=Obj1.produit(m3, m7, m4, m9);
			res2=Obj2.produit(m3, m8, m4, m10);
			res3=Obj3.produit(m5, m7, m6, m9);
			res4=Obj4.produit(m5, m8, m6, m10);
			
			//Ramasser les resultats en une matrice resultat
			Matrice resultat=new Matrice();
			resultat=c.Ramasser(res1, res2, res3, res4);
			
			//Afficher la matrice r�sultat
			System.out.println("\n********************************** R�sultat **********************************\n");
			resultat.afficher();
			

		} catch (Exception e) {
			System.out.println("Erreur d'acces a l'objet distant.");
			System.out.println(e.toString());
		}
	}
}
/*
Matrice matrices[] = new Matrice[8];

for (int i = 0; i < 8; i++) {
	matrices[i] = new Matrice();
}

c.decomposerMat1(m1, matrices[0], matrices[1], matrices[2], matrices[3], t);

matrices[0].afficher();

// c.decomposerMat1(m2, matrices[4], matrices[5], matrices[6], matrices[7],t);

/*
 * for(int i=0;i<8;i++) {
 * System.out.println("sous mat ["+(i+1)+"]"+matrices[i]); }
 */

/*
 * Matrice subMatResult[] = new Matrice[3]; for(int i=0;i<8;i++) {
 * subMatResult[i] = new Matrice(); }
 * 
 * subMatResult[0] =
 * Obj1.produit(matrices[0],matrices[4],matrices[1],matrices[6]);
 * subMatResult[1] =
 * Obj2.produit(matrices[0],matrices[6],matrices[1],matrices[7]);
 * subMatResult[2] =
 * Obj3.produit(matrices[2],matrices[4],matrices[3],matrices[6]);
 * subMatResult[3] =
 * Obj4.produit(matrices[2],matrices[5],matrices[3],matrices[7]);
 * 
 * Matrice result=new Matrice(); result =
 * c.Ramasser(subMatResult[0],subMatResult[1],subMatResult[2],subMatResult[3]);
 * System.out.println("resultat"); result.afficher();
 */
