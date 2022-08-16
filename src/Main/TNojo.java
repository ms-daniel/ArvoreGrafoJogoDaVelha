package Main;

public class TNojo {
	private TNojo pai;
	private TNojo[] filhos;
	private char[][] no = new char[3][3];
	private int maxFilhos;
	private boolean terminal;
	
	public TNojo(TNojo pai, int filhos, boolean finau) {
		this.terminal = false;
		this.pai = pai;
		if(!finau) {
			this.maxFilhos = filhos;
			this.filhos = new TNojo[filhos];
		}
	}
	
	public TNojo getPai() {
		return this.pai;
	}
	
}
