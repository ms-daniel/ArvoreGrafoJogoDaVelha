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
	
	private static FileWriter arq1;
	private static FileWriter arq2;
	private static FileWriter arq3;
	private static FileWriter arq4;
	private static FileWriter arq5;
	private static FileWriter arq6;
	private static FileWriter arq7;
	private static FileWriter arq8;
	private static FileWriter arq9;
	
	
	private PrintWriter gravarArq;
	
	public void createArq() {
		try {
			arq1 = new FileWriter("estados/estadosJdV - 1.csv");
			arq2 = new FileWriter("estados/estadosJdV - 2.csv");
			arq3 = new FileWriter("estados/estadosJdV - 3.csv");
			arq4 = new FileWriter("estados/estadosJdV - 4.csv");
			arq5 = new FileWriter("estados/estadosJdV - 5.csv");
			arq6 = new FileWriter("estados/estadosJdV - 6.csv");
			arq7 = new FileWriter("estados/estadosJdV - 7.csv");
			arq8 = new FileWriter("estados/estadosJdV - 8.csv");
			arq9 = new FileWriter("estados/estadosJdV - 9.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void closeArq() {
		try {
			arq1.close();
			arq2.close();
			arq3.close();
			arq4.close();
			arq5.close();
			arq6.close();
			arq7.close();
			arq8.close();
			arq9.close();
			
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
						
						pai.addSon(new TNojo(pai,nivel, verificaGanhador(), no, pai.getMyNumber().replace(" ", "") + "." + Integer.toString(number)));
						
						new arvoreGrafo().Gerar(nivel-1, pai.getMySon(number), true, changeSymbol(symbol));
					}
					number++;
					no[i][j] = '.';
				}
			}
		}
		
		gravarArq();
		
		gravarArq.printf(pai.getMeStringToCSV());
		gravarArq.printf("\n");
		gravarArq.flush();


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
	
	private void gravarArq() {
		String all = "";
		
		for(int i = 0; i < 3; i++) { //percorrer a matriz de caracteres
			for(int j = 0; j < 3; j++) {
				if(no[i][j] != '.')
					all += no[i][j];
			}
		}

		int nArq = all.length();
		
		switch(nArq) {
			case 1:
				gravarArq = new PrintWriter(arq1);
				break;
			case 2:
				gravarArq = new PrintWriter(arq2);
				break;
			case 3:
				gravarArq = new PrintWriter(arq3);
				break;
			case 4:
				gravarArq = new PrintWriter(arq4);
				break;
			case 5:
				gravarArq = new PrintWriter(arq5);
				break;
			case 6:
				gravarArq = new PrintWriter(arq6);
				break;
			case 7:
				gravarArq = new PrintWriter(arq7);
				break;
			case 8:
				gravarArq = new PrintWriter(arq8);
				break;
			case 9:
				gravarArq = new PrintWriter(arq9);
				break;
			default:
				break;

		}

	
		
		
		//gravarArq = new PrintWriter(arq1);
	}
	
}
