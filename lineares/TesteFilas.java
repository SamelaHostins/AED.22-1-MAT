package lineares;

public class TesteFilas {
	public static void main(String[] args) {

		Fila<Integer> fila1 = new FilaVetor<Integer>(5);

		fila1.inserir(1);
		System.out.println(fila1.toString());
		fila1.inserir(2);
		System.out.println(fila1.toString());
		fila1.inserir(3);
		System.out.println(fila1.toString());
		fila1.inserir(4);
		System.out.println(fila1.toString());
		fila1.inserir(5);
		System.out.println(fila1.toString());
		fila1.retirar();
		System.out.println(fila1.toString());
		fila1.retirar();
		System.out.println(fila1.toString());
		fila1.retirar();
		System.out.println(fila1.toString());

		FilaVetor<Integer> filaVetor2 = new FilaVetor<Integer>(5);
		filaVetor2.inserir(9);
		filaVetor2.inserir(7);
		filaVetor2.inserir(8);

		FilaVetor<Integer> filaVetor3 = ((FilaVetor)fila1).concatenar(filaVetor2);
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

		fila1.inserir(4);
		System.out.println(fila1.toString());
		fila1.inserir(5);
		System.out.println(fila1.toString());

		fila1.liberar();
		System.out.println(fila1.toString());
		System.out.println(filaVetor2.toString());
		System.out.println(filaVetor3.toString());
		
		
		
		System.out.println("\n========Fila Dinâmica=====");
		fila1 = new FilaLista<Integer>();

		fila1.inserir(1);
		System.out.println(fila1.toString());
		fila1.inserir(2);
		System.out.println(fila1.toString());
		fila1.inserir(3);
		System.out.println(fila1.toString());
		fila1.inserir(4);
		System.out.println(fila1.toString());
		fila1.inserir(5);
		System.out.println(fila1.toString());
		fila1.retirar();
		System.out.println(fila1.toString());
		fila1.retirar();
		System.out.println(fila1.toString());
		fila1.retirar();
		System.out.println(fila1.toString());
		fila1.inserir(4);
		System.out.println(fila1.toString());
		fila1.inserir(5);
		System.out.println(fila1.toString());
	}
}
