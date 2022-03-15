package lineares;

public interface Lista {

	void inserir(int valor);
	String exibir();
	int buscar(int valor);
	void retirar(int valor);
	Lista copiar();
	void concatenar(Lista outra);
	int getTamanho();
	boolean estaVazia();
	Lista dividir();
	int pegar(int posicao);
}