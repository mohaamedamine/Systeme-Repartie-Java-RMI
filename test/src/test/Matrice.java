package test;

import java.io.Serializable;
import java.lang.*;

import java.util.Scanner;

public class Matrice implements Serializable{

		private int nbL;             
	    private int nbCol;             
	    private int[][] data; 
	
	    public int getNbL() {
			return nbL;
		}

		public void setNbL(int nbL) {
			this.nbL = nbL;
		}

		public int[][] getData() {
			return data;
		}

		public void setData(int[][] data) {
			this.data = data;
		}

		public int getNbCol() {
			return nbCol;
		}

		public void setNbCol(int nbCol) {
			this.nbCol = nbCol;
		}
		
		public void setElement(int i,int j,int valeur) {
			data[i][j]=valeur;
		}
		public int getElement(int i,int j) {
			return data[i][j];
		}
		
		public Matrice(int nbL, int nbCol) {
	    	 this.nbL = nbL;
	    	 this.nbCol = nbCol;
	         data = new int[nbL][nbCol];
	    }
		
		public Matrice() {
		}
		
		public void creerTab() {
			 data = new int[nbL][nbCol];
		}
	    //remplir matrice
	    public Matrice(int[][] data) {
	        nbL = data.length;
	        nbCol = data[0].length;
	        this.data = new int[nbL][nbCol];
	        for (int i = 0; i < nbL; i++)
	            for (int j = 0; j < nbCol; j++)
	                    this.data[i][j] = data[i][j];
	    }
	    
	 
	    public void remplir(int nbL,int nbCol) {
	    	Scanner n = new Scanner(System.in);
	        for (int i = 0; i < nbL; i++)
	        {
	        	for (int j = 0; j < nbCol; j++) {
	            	System.out.print(" m["+(i+1)+"]["+(j+1)+"]= ");
	            	setElement(i, j, n.nextInt());
	               // data[i][j] = n.nextInt();
	            }
	        	System.out.print("\n");
	        }
	    }
	    public Matrice saisieMat1(int nL1,int nC1) {
	    	Scanner s = new Scanner(System.in);
	    	System.out.println("\n********************************** Matrice 1 **********************************\n");
			System.out.println("Donner le nbre de lignes de m1 : ");
			nL1 = s.nextInt();
			System.out.println("Donner le nbre de colonnes de m1 : ");
			nC1 = s.nextInt();
			Matrice m1 = new Matrice();
			m1.setNbL(nL1);
			m1.setNbCol(nC1);
			System.out.println("f west Le nbre de lignee de m1 : " +m1.getNbL());
			System.out.println("f west Le nbre de colle de m1 : " + m1.getNbCol());
			return m1;

	    }
	    public Matrice saisieMat2(int nL1,int nC1,Matrice m1) {
	    	Scanner s = new Scanner(System.in);
	    	System.out.println("\n********************************** Matrice 2 **********************************\n");
			Matrice m = new Matrice();
			m.setNbL(m1.getNbCol());
			System.out.println("f west Le nbre de lignee de m2 fixe: " +m1.getNbCol());
			System.out.println("Donner le nbre de colonnes de m2 : ");
			nC1 = s.nextInt();
			m.setNbCol(nC1);
			System.out.println("f west Le nbre de colle de m2 : " + m.getNbCol());
			return m;

	    }
	    
	    public void afficher() {
	        for (int i = 0; i < nbL; i++) {
	            for (int j = 0; j < nbCol; j++) 
	                System.out.print(" "+data[i][j]);
	            System.out.println();
	        }
	    }
	    

	}

