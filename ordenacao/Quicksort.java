package ordenacao;

import java.util.Random;

public class Quicksort<T extends Comparable<T>> implements Sort<T>
{

	@Override
	public void sort(T[] vetor)
	{
		// chama dessa forma para aplicar o algoritmo no array inteiro
		this.quicksort(vetor, 0, vetor.length - 1);	
	}
	// vetor = array que vai ser ordenada, inicio e fim da subarray
	private void quicksort(T[] vetor, int inicio, int fim)
	{
		if (inicio >= fim) // se chegar em um array de tamanho 1, por exemplo, não há mais o que ordenar
		{
			return;
		}
		// escolhendo um pivô
		// vai dar um index entre o menor index e o maior index do vetor
		int indexPivo = new Random().nextInt(fim - inicio) + inicio;
		
		T pivo = vetor[indexPivo]; 

		// troca o pivô escolhido aleatoriamente com o numero que esta no fim do array
		this.troca(vetor, indexPivo, fim);
		
		int p = particionamento(vetor, inicio, fim, pivo);
		
		// recursivamente aplicar o algoritmo no array da esquerda do pivo e no array da direita do pivo
		// para a esquerda
		this.quicksort(vetor, inicio,  p - 1);
		// para a direita
		this.quicksort(vetor, p + 1,  fim);
	}
	
	private int particionamento(T[] vetor, int inicio, int fim, T pivo) 
	{
		// início do vetor
		int ponteiroEsquerda = inicio;
		
		// fim do vetor ( não conta o pivo junto )
		int ponteiroDireita = fim;
		
		while (ponteiroEsquerda < ponteiroDireita) // enquanto os dois ponteiros não forem iguais, ou seja, não estarem na mesma posição
		{
			// enquanto não encontra um número maior do que o pivo e enquanto os dois ponteiros não são iguais 
			// caminha para a direita
			while ((vetor[ponteiroEsquerda].compareTo(pivo) <= 0) && ponteiroEsquerda < ponteiroDireita)
			{
				ponteiroEsquerda++;
			}
			// andar para a esquerda até encontrar um número menor que o pivo
			while ((vetor[ponteiroDireita].compareTo(pivo) >= 0) && ponteiroEsquerda < ponteiroDireita)
			{
				ponteiroDireita--;
			}
			
			// quando sair dos dois while, essas variaveis vao estar apontando para um numero maior que o pivo e um numero menor que o pivo
			// devemos então realizar a troca de lugares
			this.troca(vetor, ponteiroEsquerda, ponteiroDireita);
		}
		// quando o ponteiro da esquerda e da direita se encontrarem, e sair do while principal, queremos trocar o pivô com o valor que o ponteiro da esquerda aponta.
		this.troca(vetor, ponteiroEsquerda, fim);
		
		return ponteiroEsquerda;
	}
	
	private void troca(T[] vetor, int index1, int index2)
	{
		T temp = vetor[index1];
		vetor[index1] = vetor[index2];
		vetor[index2] = temp;
	}

}
