public class ClientDecomposer {
	public ClientDecomposer() {
	}

	public void decomposerMat1(Matrice m, Matrice m1, Matrice m2, Matrice m3, Matrice m4, int t[]){
		int ligne, col;
		ligne = (int) (Math.random() * (m.getNbL() - 1)) + 1;
		col = (int) (Math.random() * (m.getNbCol() - 1)) + 1;
		m1.setNbL(ligne);
		m1.setNbCol(col);
		m1.creerTab();
		t[0] = m1.getNbL();
		t[1] = m1.getNbCol();		

		for (int i = 0; i < ligne; i++) {
			for (int j = 0; j < col; j++) {
				m1.setElement(i, j, m.getElement(i, j));
			}
		}
		m2.setNbL(ligne);
		m2.setNbCol(m.getNbCol() - col);
		m2.creerTab();
		t[2] = m2.getNbL();
		t[3] = m2.getNbCol();
		for (int i = 0; i < ligne; i++) {
			for (int j = 0; j < m2.getNbCol(); j++) {
				m2.setElement(i, j, m.getElement(i, j + col));
			}
		}

		m3.setNbL(m.getNbL() - ligne);
		m3.setNbCol(col);
		m3.creerTab();
		t[4] = m3.getNbL();
		t[5] = m3.getNbCol();
		for (int i = 0; i < m3.getNbL(); i++) {
			for (int j = 0; j < col; j++) {
				m3.setElement(i, j, m.getElement(i + ligne, j));
			}
		}
		m4.setNbL(m.getNbL() - ligne);
		m4.setNbCol(m.getNbCol() - col);
		m4.creerTab();
		t[6] = m4.getNbL();
		t[7] = m4.getNbCol();
		for (int i = 0; i < m4.getNbL(); i++) {
			for (int j = 0; j < m4.getNbCol(); j++) {
				m4.setElement(i, j, m.getElement(i + ligne, j + col));
			}
		}

	}

	public void decomposerMat2(Matrice m, Matrice m1, Matrice m2, Matrice m3, Matrice m4, int t[]){
		int col = (int) (Math.random() * (m.getNbCol() - 1)) + 1;
		m1.setNbL(t[1]);
		m1.setNbCol(col);
		m1.creerTab();
		for (int i = 0; i < m1.getNbL(); i++) {
			for (int j = 0; j < col; j++) {
				m1.setElement(i, j, m.getElement(i, j));
			}
		}
		m2.setNbL(t[1]);
		m2.setNbCol(m.getNbCol() - col);
		m2.creerTab();
		for (int i = 0; i < m1.getNbL(); i++) {
			for (int j = 0; j < m2.getNbCol(); j++) {
				m2.setElement(i, j, m.getElement(i, j + col));
			}
		}
		m3.setNbL(t[3]);
		m3.setNbCol(col);
		m3.creerTab();
		t[4] = m3.getNbL();
		t[5] = m3.getNbCol();
		for (int i = 0; i < m3.getNbL(); i++) {
			for (int j = 0; j < col; j++) {
				m3.setElement(i, j, m.getElement(i + t[1], j));
			}
		}
		m4.setNbL(t[3]);
		m4.setNbCol(m.getNbCol() - col);
		m4.creerTab();
		for (int i = 0; i < m4.getNbL(); i++) {
			for (int j = 0; j < m4.getNbCol(); j++) {
				m4.setElement(i, j, m.getElement(i + t[1], j + col));
			}
		}
	}

	public Matrice Ramasser(Matrice m1, Matrice m2, Matrice m3, Matrice m4){
		Matrice res = new Matrice();
		res.setNbL(m1.getNbL() + m3.getNbL());
		res.setNbCol(m1.getNbCol() + m2.getNbCol());
		res.creerTab();
		for (int i = 0; i < m1.getNbL(); i++) {
			for (int j = 0; j < m1.getNbCol(); j++) {
				res.setElement(i, j, m1.getElement(i, j));
			}
		}
		for (int i = 0; i < m2.getNbL(); i++) {
			for (int j = 0; j < m2.getNbCol(); j++) {
				res.setElement(i, j + m1.getNbCol(), m2.getElement(i, j));
			}
		}
		for (int i = 0; i < m3.getNbL(); i++) {
			for (int j = 0; j < m3.getNbCol(); j++) {
				res.setElement(i + m1.getNbL(), j, m3.getElement(i, j));
			}
		}
		for (int i = 0; i < m4.getNbL(); i++) {
			for (int j = 0; j < m4.getNbCol(); j++) {
				res.setElement(i + m1.getNbL(), j + m1.getNbCol(), m4.getElement(i, j));
			}
		}
		return res;
	}
}
