/*
 * Dise�adores: Miguel Angel Bernal Colonia Codigo: 201153852 - 3743
 * 				Yeison Betancourt Solis Codigo: 201153328 - 3743 				
 * 				Andrea Mora Ospina Codigo: 201153685 - 3743
 * 
 * Instituto: Universidad del Valle - 06 Tulu�
 */

public class VertexCover {
	
	private int aristas;
	private int VC;
	private int [ ] [ ] matrix;
	private int tamMatriz;
	
	public int getAristas() {
		return aristas;
	}

	public void setAristas(int aristas) {
		this.aristas = aristas;
	}
	
	public int getVC() {
		return VC;
	}

	public void setVC(int vC) {
		VC = vC;
	}
	
	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	public int getTamMatriz() {
		return tamMatriz;
	}

	public void setTamMatriz(int tamMatriz) {
		this.tamMatriz = tamMatriz;
	}
	
}