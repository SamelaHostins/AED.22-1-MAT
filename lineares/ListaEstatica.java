package lineares;

public class ListaEstatica {
	private int[] info;
	private int tamanho;

	public ListaEstatica() {
		info = new int[10];
		tamanho = 0;
	}

	public void inserir(int valor) {
		if (tamanho == info.length) {
			this.redimensionar();
		}
		info[tamanho] = valor;
		tamanho++;
	}

	private void redimensionar() {
		int[] novo = new int[info.length + 10];
		for (int i = 0; i < info.length; i++) {
			novo[i] = info[i];
		}
		info = novo;
	}

	public String exibir() {
		String retorno = "[";
		for (int i = 0; i < tamanho; i++) {
			retorno += info[i] + ", ";
		}
		return retorno + "]";
	}

	public int buscar(int valor) {
		for (int i = 0; i < tamanho; i++) {
			if (info[i] == valor) {
				return i;
			}
		}
		return -1;
	}

	public void retirar(int valor) {
		int posicao = buscar(valor);
		if (posicao != -1) {
			for (int i = posicao; i < tamanho - 1; i++) {
				info[i] = info[i + 1];
			}
			tamanho--;
		}
	}

	public ListaEstatica copiar() {
		ListaEstatica novaLista = new ListaEstatica();

		for (int i = 0; i < this.tamanho; i++) {
			novaLista.inserir(this.info[i]);
		}

		return novaLista;
	}

	public void concatenar(ListaEstatica outra) {
		for (int i = 0; i < outra.getTamanho(); i++) {
			inserir(outra.info[i]);
		}
	}

	public int getTamanho() {
		return this.tamanho;
	}

	public boolean estaVazia() {
		return (tamanho == 0);
	}

	public ListaEstatica dividir() {
		int metade = tamanho / 2;
		ListaEstatica novaLista = new ListaEstatica();

		for (int i = metade; i < tamanho; i++) {
			novaLista.inserir(this.info[i]);
		}
		tamanho = metade;

		return novaLista;
	}
}
