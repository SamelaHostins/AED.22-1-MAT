package arvores;

public class NoArvoreBinaria<T> {
	private T info;
	private NoArvoreBinaria<T> esq;
	private NoArvoreBinaria<T> dir;

	public NoArvoreBinaria(T info) {
		this.info = info;
	}

	public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
		this.info = info;
		this.esq = esq;
		this.dir = dir;
	}

	public NoArvoreBinaria<T> pertence(T info) {
		if (this.info.equals(info)) {
			return this;
		}
		NoArvoreBinaria<T> retorno = null;
		if (this.esq != null) {
			retorno = this.esq.pertence(info);
		}
		if (retorno == null && this.dir != null) {
			retorno = this.dir.pertence(info);
		}
		return retorno;
	}

	public String imprimePre() {
		String msg = "<" + this.getInfo();
		if (this.getEsq() != null) {
			msg += this.getEsq().imprimePre();
		} else {
			msg += "<>";
		}
		if (this.getDir() != null) {
			msg += this.getDir().imprimePre();
		} else {
			msg += "<>";
		}
		return msg + ">";
	}

	public String imprimePre2() {
		String arvore = this.info.toString();
		if (this.esq != null) {
			arvore += "<" + this.esq.imprimePre() + ">";
		} else {
			arvore += "<>";
		}
		if (this.dir != null) {
			arvore += "<" + this.dir.imprimePre() + ">";
		} else {
			arvore += "<>";
		}
		return arvore;

	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public NoArvoreBinaria<T> getEsq() {
		return esq;
	}

	public void setEsq(NoArvoreBinaria<T> esq) {
		this.esq = esq;
	}

	public NoArvoreBinaria<T> getDir() {
		return dir;
	}

	public void setDir(NoArvoreBinaria<T> dir) {
		this.dir = dir;
	}
}
