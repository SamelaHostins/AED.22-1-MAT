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
		int[] novo = new int[info.length+10];
		for (int i=0; i < info.length; i++) {
			novo[i] = info[i];
		}
		info = novo;
	}
	
	public String exibir() {
		String retorno = "[";
		for (int i=0; i < tamanho; i++) {
			retorno += info[i]+", ";
		}
		return retorno+"]";
	}
	
	public int buscar(int valor) {
		for (int i=0; i < tamanho; i++) {
			if (info[i] == valor) {
				return i;
			}
		}
		return -1;
	}
	
}
