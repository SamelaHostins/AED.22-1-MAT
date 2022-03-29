package lineares;

public class PilhaVetor<T> implements Pilha<T> {
	private int limite;
	private int tamanho = 0;
	private T[] info;

	public PilhaVetor(int limite) {
		this.info = (T[]) new Object[limite];
		this.limite = limite;
	}

	@Override
	public void push(T valor) {
		if (this.tamanho == this.limite) {
			throw new RuntimeException("A pilha está cheia!");
		}
		this.info[tamanho] = valor;
		this.tamanho += 1;

	}

	@Override
	public T pop() {
		if (!estaVazia()) {
			T elemento = this.info[tamanho - 1];
			this.info[tamanho - 1] = null;
			this.tamanho -= 1;
			return elemento;
		} else {
			throw new RuntimeException("A pilha vazia.");
		}
	}

	public T pop2() {
		T elemento = this.peek();
		this.info[tamanho - 1] = null;
		this.tamanho -= 1;
		return elemento;
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new RuntimeException("A pilha vazia.");
		}
		return this.info[tamanho - 1];
	}

	@Override
	public boolean estaVazia() {
		return this.tamanho == 0;
	}

	@Override
	public void liberar() {
		this.info = (T[]) new Object[this.limite];
		this.tamanho = 0;
	}

	@Override
	public String toString() {
		String elementos = "";

		for (int i = this.tamanho-1; i >= 0; i--) {
			elementos += this.info[i]+", ";
		}
		elementos = elementos.substring(0, Math.max(0,elementos.length()-2));
		return "topo[" + elementos + "]base";
	}
}