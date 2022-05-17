package arvores;

public class ArvoreBST<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

	public void inserir(T valor) {
		if (this.vazia()) {
			this.setRaiz(new NoArvoreBST<>(valor));
		} else {
			((NoArvoreBST<T>) this.getRaiz()).inserir(valor);
		}
	}

	public NoArvoreBST<T> buscar(T valor) {
		if (this.vazia()) {
			return null;
		} else {
			return ((NoArvoreBST<T>) this.getRaiz()).buscar(valor);
		}
	}

	public void retirar(T valor) {
		NoArvoreBST<T> noARetirar = this.buscar(valor);
		if (noARetirar != null) {
			this.retirar(noARetirar);
		}
	}

	private void retirar(NoArvoreBST<T> noARetirar) {
		NoArvoreBST<T> noPai = this.buscarPai(noARetirar);

		if (noARetirar.ehFolha()) { // caso 1
			if (noARetirar == this.getRaiz()) { // para saber se é a raiz
				this.setRaiz(null);
			} else {
				if (noPai.getEsq() == noARetirar) {
					noPai.setEsq(null);
				} else {
					noPai.setDir(null);
				}
			}
		} else {
			if (noARetirar.temApenasUmFilho()) { // caso 2
				NoArvoreBinaria<T> filho = (noARetirar.getEsq() == null ? noARetirar.getDir() : noARetirar.getEsq());
				if (noARetirar == this.getRaiz()) {
					this.setRaiz(filho);
				} else {
					if (noPai.getEsq() == noARetirar) {
						noPai.setEsq(filho);
					} else {
						noPai.setDir(filho);
					}
				}
			} else { // caso 3
				NoArvoreBST<T> noSucessor = noARetirar.getNoSucessor();
				T info = noSucessor.getInfo();
				this.retirar(noSucessor);
				noARetirar.setInfo(info);
			}
		}

	}

	private NoArvoreBST<T> buscarPai(NoArvoreBST<T> no) {
		if (this.getRaiz() == no) {
			return null;
		}
		NoArvoreBinaria<T> pai = this.getRaiz();
		while (pai.getEsq() != no && pai.getDir() != no) {
			if (no.getInfo().compareTo(pai.getInfo()) < 0) {
				pai = pai.getEsq();
			} else {
				pai = pai.getDir();
			}
		}
		return (NoArvoreBST<T>) pai;
	}

	public T buscarMenor() {
		if (this.vazia()) {
			return null;
		}
		NoArvoreBST<T> no = (NoArvoreBST<T>) this.getRaiz();
		while (no.getEsq() != null) {
			no = (NoArvoreBST<T>) no.getEsq();
		}
		return no.getInfo();
	}

	public T buscarMaior() {
		if (this.vazia()) {
			return null;
		}
		NoArvoreBST<T> no = (NoArvoreBST<T>) this.getRaiz();
		while (no.getDir() != null) {
			no = (NoArvoreBST<T>) no.getDir();
		}
		return no.getInfo();
	}

	public T buscarSucessor(T info) {
		if (this.vazia()) {
			return null;
		}
		NoArvoreBST<T> no = this.buscar(info);
		if (no == null) { // valor não está na árvore
			return null;
		}

		if (this.buscarMaior().equals(info)) {
			return null; // o maior não tem sucessor
		}

		if (no.getDir() != null) { // sucessor está para baixo
			return no.getNoSucessor().getInfo();
		} else {// sucessor está para cima
			NoArvoreBST<T> pai = this.buscarPai(no);
			while (pai.getInfo().compareTo(info) <= 0) { // buscando pelo valor
				pai = this.buscarPai(pai);
			}
			return pai.getInfo();
		}
	}

	public T buscarAntecessor(T info) {
		if (this.vazia()) {
			return null;
		}
		NoArvoreBST<T> no = this.buscar(info);
		if (no == null) { // valor não está na árvore
			return null;
		}

		if (this.buscarMenor().equals(info)) {
			return null; // o menor não tem antecessor
		}

		if (no.getEsq() != null) { // antecessor está para baixo
			return no.getNoAntecessor().getInfo();
		} else {// antecessor está para cima
			NoArvoreBST<T> pai = this.buscarPai(no);
			while (pai.getInfo().compareTo(info) >= 0) { // buscando pelo valor
				pai = this.buscarPai(pai);
			}
			return pai.getInfo();
		}
	}

	public String toStringOrdered() {
		if (this.vazia()) {
			return "";
		} else {
			return ((NoArvoreBST<T>)this.getRaiz()).imprimeEmOrdem();
		}
	}
}
