package test;

import java.util.Scanner;

public class testmat {

	public static void main(String[] args) {
		
		int t[] = new int[8];
		Matrice m1= new Matrice();
		m1=m1.saisieMat1(m1.getNbL(), m1.getNbCol());
		System.out.println("Le nbre de lignee de m1 : " +m1.getNbL());
		System.out.println("Le nbre de colle de m1 : " + m1.getNbCol());
		
		System.out.println("Remplir la premi�re matrice : ");
		m1.creerTab();
		m1.remplir(m1.getNbL(), m1.getNbCol());
		
		Matrice m2= new Matrice();
		m2=m2.saisieMat2(m1.getNbCol(), m2.getNbCol(),m1);
		System.out.println("Le nbre de lignee de m2 fixe: " +m1.getNbCol());
		System.out.println("Le nbre de colle de m2 : " + m2.getNbL());
		System.out.println("Remplir la 2eme matrice : ");
		m2.creerTab();
		m2.remplir(m1.getNbCol(), m2.getNbCol());
		
		/*
		System.out.println("\n********************************** Matrice 2 **********************************\n");
		System.out.println("Le nbre de ligne de m2 est deja fix� : " + m1.getNbCol());
		System.out.println("Donner le nbre de colonnes de m2 : ");
		nC2 = s.nextInt();
		Matrice m2 = new Matrice(nC1, nC2);
		System.out.println("Remplir la deuxi�me matrice : ");
		m2.remplir(nC1, nC2);*/
		System.out.println("\n********************************** Matrice 1 **********************************\n");
		m1.afficher();
		System.out.println("\n********************************** Matrice 2 **********************************\n");
		m2.afficher();

	}

}
