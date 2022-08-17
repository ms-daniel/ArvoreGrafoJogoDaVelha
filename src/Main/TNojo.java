package Main;

public class TNojo {
	private TNojo pai;
	private TNojo[] sons;
	private int indSon = 0;
	private char[][] no = new char[3][3];
	private int maxSons;
	private boolean terminal;
	
	public TNojo(TNojo pai, int filhos, boolean finau, char[][]no) {
		
		this.pai = pai;
		this.no = no;
		//
		if(!finau) {
			this.maxSons = filhos;
			this.sons = new TNojo[filhos];
			this.terminal = false;
		}else {
			this.terminal = true;
			this.maxSons = 0;
		}
	}
	
	//return true if the son was added and false if not 
	public boolean addSon(TNojo son) {
		if(maxSons>indSon+1) {
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
	
}
