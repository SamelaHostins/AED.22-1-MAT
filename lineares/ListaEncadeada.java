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
			resultado += p.getInfo() + ", ";
			p = p.getProximo();
		}

		return resultado + "]";
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

		while (p != null && p.getInfo() != valor) {
			anterior = p;
			p = p.getProximo();
		}

		if (p != null) { // significa que encontrou o elemento a ser retirado
			if (anterior == null) {
				primeiro = p.getProximo();
			} else {
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
		ListaEncadeada novaLista = new ListaEncadeada();
		NoLista no = primeiro;

		while (no != null) {
			novaLista.inserir(no.getInfo());
			no = no.getProximo();
		}

		return novaLista;
	}

	@Override
	public void concatenar(Lista outra) { // contribuição do Adrian
		for (int i = 0; i < outra.getTamanho(); i++) {
			this.inserir(outra.pegar(i));
		}
	}

	@Override
	public int getTamanho() {
		return qtdElem;
	}

	@Override
	public boolean estaVazia() {
		return (primeiro == null);
	}

	@Override
	 public Lista dividir() {  // Contribuição do Vinícius
        NoLista no = primeiro;
        ListaEncadeada listaNova = new ListaEncadeada();
        int metade = this.getTamanho() / 2;
        int contador = 1;
        NoLista novoUltimo = null;
       
        while(no != null) {
            if(contador > metade) {
                listaNova.inserir(no.getInfo());
            }
            else {
            	novoUltimo = no;
            }
            contador++;
            no = no.getProximo();
        }
        ultimo = novoUltimo;
        ultimo.setProximo(null);
        qtdElem = metade;
        return listaNova;
    }
	
	@Override
	public int pegar(int pos) { // Contribuição do Vinícius
		if (pos < 0 || pos >= this.qtdElem) {
			throw new IndexOutOfBoundsException("Posicao=" + pos + "; Tamanho=" + qtdElem);
		}
		NoLista no = primeiro;

		for (int i = 0; i < pos; i++) {
			no = no.getProximo();
		}

		return no.getInfo();
	}

	public int pegar2(int posicao) { // contribuição do Rodrigo
		if (posicao < 0 || posicao >= this.qtdElem) {
			throw new IndexOutOfBoundsException("Posicao=" + posicao + "; Tamanho=" + qtdElem);
		}

		NoLista p = primeiro;
		int pos = 0;
		while (p != null) {
			if (pos == posicao) {
				return p.getInfo();
			}
			pos++;
			p = p.getProximo();
		}
		return -1; // nunca deveria chegar aqui
	}

}
