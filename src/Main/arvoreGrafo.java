package Main;

public class arvoreGrafo {
	private int number = 0;
	private char Symbol = 'X';
	private int max = 9;
	private char[][] no = 	{{'0','0','0'},
							{'0','0','0'},
							{'0','0','0'}}
	;
	private TNojo pai = new TNojo(null, 9, false, no, 0); //define the root 
	private TNojo filhoAtual;
	
	public void Gerar(int nivel, TNojo Atual, boolean change) {
		saveChar();
		number = 0;
		if(change) {
			pai = Atual;
		}
		
		//nivel = max-1;
		//while(nivel != 7) { //rodar enquanto houver estados pra gerar
			for(int i = 0; i < 3; i++) { //percorrer a matriz de caracteres
				for(int j = 0; j < 3; j++) {
					if(no[i][j] != 'X' && no[i][j] != 'O') {
						no[i][j] = Symbol;
						
						pai.addSon(new TNojo(pai,nivel-1,verificaGanhador(), no, number+1));
						System.out.println(number);
						//Gerar(max, pai.getMySon(number), true);
						number++;
						no[i][j] = '0';
					}
				}
			}
			
			
			/*pai.print();
			if(number != 0) {
				Gerar(8, pai.getMySon(0), true);
				number = -1;
			}else {
				System.exit(0);
			}*/
			
		//}
	}

	private void saveChar() {
		char[][] nojo = pai.getMatriz();
		for(int i = 0; i < 3; i++) { //percorrer a matriz de caracteres
			for(int j = 0; j < 3; j++) {
				this.no[i][j] = nojo[i][j];
			}
		}
	}
	
	public void mostrar() {
		
		System.out.println("-------");
		
		for(int i = 0; i < 3; i++) { //percorrer a matriz de caracteres
			for(int j = 0; j < 3; j++) {
				System.out.print(no[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void printPai() {
		System.out.println("-------");
		
		for(int i = 0; i < 3; i++) { //percorrer a matriz de caracteres
			for(int j = 0; j < 3; j++) {
				
			}
			System.out.println();
		}
	}
	
	public TNojo getPai() {
		return pai;
	}
	
	private boolean verificaGanhador() {
		
		return false;
	}
	
	private void changeSymbol() {
		if(Symbol == 'X') {
			Symbol = 'O';
		}else {
			Symbol = 'X';
		}
	}
	
}
