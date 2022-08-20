package Main;

public class main {

	public static void main(String[] args) {
		arvoreGrafo grafo = new arvoreGrafo();
		
		
		//grafo.mostrar();
		grafo.Gerar(9, null, false);
		TNojo pai = grafo.getPai();
		pai.printAll();

	}

}
