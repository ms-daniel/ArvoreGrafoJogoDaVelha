package Main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class arvoreGrafo {
	private int number = 0;
	private String Symbol = "O";
	private int max = 9;
	private char[][] no = 	{{'.','.','.'},
							{'.','.','.'},
							{'.','.','.'}}
	;
	private TNojo pai = new TNojo(null, 9, false, no, "i"); //define the root 
	
	private static TNojo anterior = null;
	
	private static FileWriter arq;
	private static PrintWriter gravarArq;
	
	public void createArq() {
		try {
			arq = new FileWriter("arquivo2.txt");
			gravarArq = new PrintWriter(arq);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void closeArq() {
		try {
			arq.close();
			gravarArq.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void Gerar(int nivel, TNojo Atual, boolean change, char symbol) {
		number = 0;
		if(change) {
			pai = Atual;
			saveChar();
		}
		
		for(int i = 0; i < 3; i++) { //percorrer a matriz de caracteres
			for(int j = 0; j < 3; j++) {
				if(no[i][j] != 'X' && no[i][j] != 'O' && number <= nivel) {
					no[i][j] = symbol;
					
					
					
					if(!pai.terminal()) {
						//System.out.println(verificaGanhador());
						
						pai.addSon(new TNojo(pai,nivel, verificaGanhador(), no, pai.getMyNumber().replace(" ", "") + "." + Integer.toString(number)));
						
						new arvoreGrafo().Gerar(nivel-1, pai.getMySon(number), true, changeSymbol(symbol));
					}
					number++;
					no[i][j] = '.';
				}
			}
		}
		
		if(pai != anterior){
			pai.print();
			gravarArq.printf(pai.getMeStringToCSV());
			gravarArq.printf("\n");
			gravarArq.flush();
			anterior = pai;
		}
		
		


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
		boolean win = false;
		
		if(		 (no[0][0] == no[0][1]) && (no[0][1] == no[0][2]) && no[0][0] != '.') {//linhas
			win = true;
		}else if((no[1][0] == no[1][1]) && (no[1][1] == no[1][2]) && no[1][0] != '.'){
			win = true;
		}else if((no[2][0] == no[2][1]) && (no[2][1] == no[2][2]) && no[2][0] != '.') { 
			win = true;
		}else if((no[0][0] == no[1][0]) && (no[1][0] == no[2][0]) && no[0][0] != '.') { //colunas
			win = true;
		}else if((no[0][1] == no[1][1]) && (no[1][1] == no[2][1]) && no[0][1] != '.') { 
			win = true;
		}else if((no[0][2] == no[1][2]) && (no[1][2] == no[2][2]) && no[0][2] != '.') {
			win = true;
		}else if((no[0][0] == no[1][1]) && (no[1][1] == no[2][2]) && no[0][0] != '.') { //diagonais
			win = true;
		}else if((no[0][2] == no[1][1]) && (no[1][1] == no[2][0]) && no[0][2] != '.') { //diagonais
			win = true;
		}
		
		return win;
	}
	
	private char changeSymbol(char symbol) {
		if(symbol == 'X') {
			return 'O';
		}else {
			return 'X';
		}
	}
	
}
