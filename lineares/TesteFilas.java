package lineares;

public class TesteFilas {
	public static void main(String[] args) {

		FilaVetor<Integer> filaVetor1 = new FilaVetor<Integer>(5);

		filaVetor1.inserir(1);
		System.out.println(filaVetor1.toString());
		filaVetor1.inserir(2);
		System.out.println(filaVetor1.toString());
		filaVetor1.inserir(3);
		System.out.println(filaVetor1.toString());
		filaVetor1.inserir(4);
		System.out.println(filaVetor1.toString());
		filaVetor1.inserir(5);
		System.out.println(filaVetor1.toString());
		filaVetor1.retirar();
		System.out.println(filaVetor1.toString());
		filaVetor1.retirar();
		System.out.println(filaVetor1.toString());
		filaVetor1.retirar();
		System.out.println(filaVetor1.toString());

		FilaVetor<Integer> filaVetor2 = new FilaVetor<Integer>(5);
		filaVetor2.inserir(9);
		filaVetor2.inserir(7);
		filaVetor2.inserir(8);

		FilaVetor<Integer> filaVetor3 = filaVetor1.concatenar(filaVetor2);
		System.out.println(filaVetor3.toString());
		filaVetor3.retirar();
		filaVetor3.retirar();
		filaVetor3.retirar();
		filaVetor3.retirar();
		filaVetor3.retirar();
		filaVetor3.inserir(-1);
		filaVetor3.inserir(-2);
		filaVetor3.inserir(-3);
		System.out.println(filaVetor3.toString());

		filaVetor1.inserir(4);
		System.out.println(filaVetor1.toString());
		filaVetor1.inserir(5);
		System.out.println(filaVetor1.toString());

		filaVetor1.liberar();
		System.out.println(filaVetor1.toString());
		System.out.println(filaVetor2.toString());
		System.out.println(filaVetor3.toString());
	}
}
