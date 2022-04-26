package arvores;

public class NoArvoreBST<T extends Comparable<T>> extends NoArvoreBinaria<T> {

	public NoArvoreBST(T info) {
		super(info);
	}

	public void inserir(T valor) {
		if (valor.compareTo(this.getInfo()) < 0) {
			if (this.getEsq() == null) {
				this.setEsq(new NoArvoreBST<T>(valor));
			} else {
				((NoArvoreBST<T>) this.getEsq()).inserir(valor);
			}
		} else {
			if (this.getDir() == null) {
				this.setDir(new NoArvoreBST<T>(valor));
			} else {
				((NoArvoreBST<T>) this.getDir()).inserir(valor);
			}
		}
	}

	public NoArvoreBST<T> buscar(T valor) {
		if (valor.compareTo(this.getInfo()) == 0) {
			return this;
		} else {
			if (valor.compareTo(this.getInfo()) < 0) {
				if (this.getEsq() == null) {
					return null;
				} else {
					return ((NoArvoreBST<T>) this.getEsq()).buscar(valor);
				}
			} else {
				if (this.getDir() == null) {
					return null;
				} else {
					return ((NoArvoreBST<T>) this.getDir()).buscar(valor);
				}
			}
		}
	}
}
