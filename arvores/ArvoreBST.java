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
				NoArvoreBinaria<T> filho = (noARetirar.getEsq() == null
											?noARetirar.getDir()
											:noARetirar.getEsq());
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

	private NoArvoreBST<T> buscarPai(NoArvoreBST<T> noARetirar) {
		if (this.getRaiz() == noARetirar) {
			return null;
		}
		NoArvoreBinaria<T> pai = this.getRaiz();
		while (pai.getEsq() != noARetirar && pai.getDir() != noARetirar) {
			if (noARetirar.getInfo().compareTo(pai.getInfo()) < 0) {
				pai = pai.getEsq();
			} else {
				pai = pai.getDir();
			}
		}
		return (NoArvoreBST<T>) pai;
	}
}
