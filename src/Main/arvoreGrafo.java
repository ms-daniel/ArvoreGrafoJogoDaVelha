package Main;

public class arvoreGrafo {
	private char Symbol = 'o';
	private int max = 9;
	private char[][] no = 	{{'0','0','0'},
							{'0','0','0'},
							{'0','0','0'}}
	;
	private TNojo pai = new TNojo(null, 9, false, no); //define the root 
	
	public void Gerar(int nivel) {
		nivel = max;
		while(nivel != 1) { //rodar enquanto houver estados pra gerar
			for(int i = 0; i < 3; i++) { //percorrer a matriz de caracteres
				for(int j = 0; j < 3; j++) {
					if(no[i][j] != 'x' && no[i][j] != 'o') {
						no[i][j] = Symbol;
						
					}
				}
			}
			break;
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
	
	private boolean verificaGanhador() {
		
		return true;
	}
	
	private void changeSymbol() {
		if(Symbol == 'x') {
			Symbol = 'o';
		}else {
			Symbol = 'x';
		}
	}
	
}
