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
	private TNojo pai = new TNojo(null, 9, false, no, ""); //define the root 
	private TNojo filhoAtual;
	
	private static FileWriter arq;
	private static PrintWriter gravarArq;
	
	public void createArq() {
		try {
			arq = new FileWriter("arquivo.txt");
			gravarArq = new PrintWriter(arq);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void closeArq() {
		try {
			arq.close();
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
					if(no[i][j] != 'X' && no[i][j] != 'O') {
						no[i][j] = symbol;
						
						
						pai.addSon(new TNojo(pai,nivel,false, no, pai.getMyNumber() + "." + Integer.toString(number)));

						new arvoreGrafo().Gerar(nivel-1, pai.getMySon(number), true, changeSymbol(symbol));
						
						number++;
						no[i][j] = '.';
					}
				}
			}
			
			
			gravarArq.printf(pai.getMeString());
			gravarArq.printf("\n");


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
	
	private char changeSymbol(char symbol) {
		if(symbol == 'X') {
			return 'O';
		}else {
			return 'X';
		}
	}
	
}
