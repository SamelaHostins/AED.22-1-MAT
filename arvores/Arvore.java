package arvores;

public class Arvore<T> {

	private NoArvore<T> raiz;

	public void setRaiz(NoArvore<T> raiz) {
		this.raiz = raiz;
	}

	public NoArvore<T> pertence(T info) {
		if (this.vazia()) {
			return null;
		}
		return raiz.pertence(info);
	}

	public boolean vazia() {
		return (this.raiz == null);
	}

	@Override
	public String toString() {
		if (this.vazia()) {
			return "<>";
		}
		return raiz.imprimePre();
	}

}
