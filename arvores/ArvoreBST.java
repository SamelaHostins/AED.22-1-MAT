package arvores;

public class ArvoreBST<T extends Comparable<T>> 
				extends ArvoreBinariaAbstract<T> {

	public void inserir(T valor) {
		if (this.vazia()) {
			this.setRaiz(new NoArvoreBST<>(valor));
		}
		else {
			((NoArvoreBST<T>)this.getRaiz()).inserir(valor);
		}
	}
	
	public NoArvoreBST<T> buscar(T valor){
		if (this.vazia()) {
			return null;
		}
		else {
			return ((NoArvoreBST<T>)this.getRaiz()).buscar(valor);
		}
	}
}
