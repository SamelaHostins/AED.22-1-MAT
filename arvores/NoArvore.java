package arvores;

public class NoArvore<T> {
	private T info;
	private NoArvore<T> filho;
	private NoArvore<T> irmao;

	public NoArvore(T info) {
		this.info = info;
	}

	public String imprimePre() {
		String result = "<" + this.info.toString();

		if (this.getFilho() != null) {
			result += filho.imprimePre();
		}

		result += ">";

		if (this.getIrmao() != null) {
			result += irmao.imprimePre();
		}

		return result;
	}

	public void inserirFilho(NoArvore<T> filho) {
		filho.setIrmao(this.getFilho());
		this.filho = filho;
	}

	public NoArvore<T> pertence(T info) {
		if (this.info.equals(info)) {
			return this;
		} else {
			NoArvore<T> no = null;
			if (this.getFilho() != null) {
				no = this.getFilho().pertence(info);
			}
			if (no == null && this.getIrmao() != null) {
				no = this.getIrmao().pertence(info);
			}
			return no;
		}
	}

	private NoArvore<T> getFilho() {
		return filho;
	}

	private NoArvore<T> getIrmao() {
		return irmao;
	}

	private void setIrmao(NoArvore<T> irmao) {
		this.irmao = irmao;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	
}