package Main;

public class TNojo {
	private TNojo pai;
	private String myNumber = "";
	private TNojo[] sons;
	private int indSon = 0;
	private char[][] no = new char[3][3];
	private int maxSons;
	private boolean terminal;
	
	public TNojo(TNojo pai, int filhos, boolean finau, char nojo[][], int number) {
		this.myNumber += ".";
		this.myNumber += number;
		
		this.pai = pai;
		saveChar(nojo);
		//if(!finau) {
			this.maxSons = filhos;
			this.sons = new TNojo[filhos];
			this.terminal = false;
		/*}else {
			this.terminal = true;
			this.maxSons = 0;
		}*/
	}
	
	//return true if the son was added and false if not 
	public boolean addSon(TNojo son) {
		if(maxSons>indSon) {
			this.sons[indSon] = son;
			indSon++;
			return true;
		}else {
			return false;
		}
	}
	
	public TNojo getPai() {
		return this.pai;
	}
	
	public void printAll() {
		TNojo filhoaux;
		for(int i = 0; i < maxSons; i++) {
			//System.out.println("Filho: " + i);
			filhoaux = sons[i];
			filhoaux.print();
		}
	}
	
	public void print() {
		System.out.println("------------");
		printMyNumber();
		
		for(int i = 0; i < 3; i++) { //percorrer a matriz de caracteres
			for(int j = 0; j < 3; j++) {
				System.out.print(this.no[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void printFilhos() {
		System.out.println(maxSons);
	}
	
	public void printFilho(int index) {
		TNojo filhoAux = sons[index];
		filhoAux.print();
	}
	
	private void saveChar(char[][] nojo) {
		for(int i = 0; i < 3; i++) { //percorrer a matriz de caracteres
			for(int j = 0; j < 3; j++) {
				this.no[i][j] = nojo[i][j];
			}
		}
	}
	
	private void printMyNumber() {
		System.out.println(myNumber);
	}
	
	public char[][] getMatriz(){
		return this.no;
	}
	
	public TNojo getMySon(int index) {
		return sons[index];
	}
}
