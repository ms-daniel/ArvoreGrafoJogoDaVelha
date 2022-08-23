package Main;

public class main {

	public static void main(String[] args) {
		arvoreGrafo grafo = new arvoreGrafo();
		grafo.createArq();
		
		
		//grafo.mostrar();
		grafo.Gerar(8, null, false, 'O');
		TNojo pai = grafo.getPai();
		//pai.printAll();
		//grafo.closeArq();

	}

}
