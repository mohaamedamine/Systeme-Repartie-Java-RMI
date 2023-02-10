import java.rmi.*;
import java.rmi.server.*;

public class Object extends UnicastRemoteObject implements ObjectInterface{

	public Object() throws RemoteException {
		super();
	}

	public Matrice produit(Matrice m1, Matrice m2, Matrice m3, Matrice m4) throws RemoteException {
		return additionner(produitMat(m1, m2),produitMat(m3, m4));
	}
	
	public Matrice additionner(Matrice m1, Matrice m2) throws RemoteException {
		Matrice res = new Matrice();
		res.setNbL(m1.getNbL());
		res.setNbCol(m1.getNbCol());
		res.creerTab();
		for (int i = 0; i < m1.getNbL(); i++) {
			for (int j = 0; j < m1.getNbCol(); j++) {
				res.setElement(i, j, m1.getElement(i, j) + m2.getElement(i, j));
			}
		}
		return res;
	}

	public Matrice produitMat(Matrice m1, Matrice m2) throws RemoteException {
		Matrice res = new Matrice();
		res.setNbL(m1.getNbL());
		res.setNbCol(m2.getNbCol());
		res.creerTab();
		int val = 0;
		for (int i = 0; i < res.getNbL(); i++) {
			for (int j = 0; j < res.getNbCol(); j++) {
				for (int k = 0; k < m1.getNbCol(); k++) {
					val += m1.getElement(i, k) * m2.getElement(k, j);
				}
				res.setElement(i, j, val);
				val = 0;
			}
		}
		return res;
	}
}



