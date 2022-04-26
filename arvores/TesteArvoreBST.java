package arvores;

public class TesteArvoreBST {

	public static void main(String[] args) {
		ArvoreBST<String> arv = new ArvoreBST<>();
		arv.inserir("João");
		arv.inserir("Maria");
		arv.inserir("Ana");
		arv.inserir("Zequinha");
		arv.inserir("Teodoro");
		arv.inserir("Clara");
		System.out.println(arv.toString());

		System.out.println("Teodoro->"+arv.buscar("Teodoro").getInfo());
		System.out.println("fantasma->"+arv.buscar("Fantasma"));
	}

}
