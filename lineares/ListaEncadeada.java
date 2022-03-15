package lineares;

public class ListaEncadeada implements Lista {
	private NoLista primeiro;
	private NoLista ultimo;
	private int qtdElem;

	@Override
	public void inserir(int valor) {
		// inserção ao final da lista
		NoLista novo = new NoLista();
		novo.setInfo(valor);

		if (this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProximo(novo);
		}
		ultimo = novo;
		qtdElem++;
	}

	@Override
	public String exibir() {
		NoLista p = primeiro;
		String resultado = "[";
		
		while (p != null) {
			resultado += p.getInfo()+", ";
			p = p.getProximo();
		}
		
		return resultado+"]";
	}

	@Override
	public int buscar(int valor) {
		int posicao = 0;
		NoLista p = primeiro;
		
		while (p != null) {		
			if (p.getInfo() == valor) {
				return posicao;
			}
			posicao++;
			p = p.getProximo();
		}
		return -1;
	}

	@Override
	public void retirar(int valor) {
		NoLista anterior = null;
		NoLista p = primeiro;
		
		while(p != null && p.getInfo() != valor) {
			anterior = p;
			p = p.getProximo();
		}
		
		if (p != null) {  // significa que encontrou o elemento a ser retirado
			if(anterior == null) {
				primeiro = p.getProximo();
			}
			else {
				anterior.setProximo(p.getProximo());
			}
			qtdElem--;
			if (ultimo == p) {
				ultimo = anterior;
			}
		}

	}

	@Override
	public Lista copiar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void concatenar(Lista outra) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getTamanho() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean estaVazia() {
		return (primeiro == null);
	}

	@Override
	public Lista dividir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int pegar(int posicao) {
		// TODO Auto-generated method stub
		return 0;
	}

}
