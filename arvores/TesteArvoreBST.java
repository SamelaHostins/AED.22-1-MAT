package arvores;

import java.util.Random;
import java.util.Scanner;

public class TesteArvoreBST {

	public static void main(String[] args) {
		ArvoreBST<Veiculo> teste;
		ArvoreBST<String> arv = new ArvoreBST<>();
		arv.inserir("João");
		arv.inserir("Maria");
		arv.inserir("Ana");
		arv.inserir("Zequinha");
		arv.inserir("Teodoro");
		arv.inserir("Clara");
		System.out.println(arv.toString());
		System.out.println(arv.toStringOrdered());
		
		System.out.println("Teodoro->"+arv.buscar("Teodoro").getInfo());
		System.out.println("fantasma->"+arv.buscar("Fantasma"));
		
		
		ArvoreBST<Integer> arv2 = new ArvoreBST<>();
		System.out.println("Quantos nós?");
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int qtde = s.nextInt();
		int[] vetor = new int[qtde];
		for (int i=0; i < vetor.length; i++) {
			vetor[i] = r.nextInt(100000);
			arv2.inserir(vetor[i]);
		}
		System.out.println(arv2.toString());
		System.out.println(arv2.toStringOrdered());
		System.out.println("Menor valor = "+arv2.buscarMenor());
		System.out.println("Maior valor = "+arv2.buscarMaior());
		
		for (int i=0; i < vetor.length; i++) {
			System.out.println("Sucessor de "+vetor[i]+" = "+arv2.buscarSucessor(vetor[i]));
		}
		for (int i=0; i < vetor.length; i++) {
			System.out.println("Antecessor de "+vetor[i]+" = "+arv2.buscarAntecessor(vetor[i]));
		}
		
		int pos;
		while (qtde != 0) {
			pos = r.nextInt(vetor.length);
			if (vetor[pos] != -1) {
				arv2.retirar(vetor[pos]);
				vetor[pos] = -1;
				qtde--;
				System.out.println(arv2.toString());
			}
		}
	}

}
