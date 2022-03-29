package lineares;

public class TestePilhas {

	public static void main(String[] args) {
		PilhaVetor<Integer> pilhaVetor = new PilhaVetor<Integer>(3);
		pilhaVetor.push(2);
		pilhaVetor.push(3);
		pilhaVetor.push(1);
		try {
			pilhaVetor.push(1);
		} catch (Exception e) {
			System.out.println("Deu certo!!!!");
		}
		System.out.println(pilhaVetor.toString());

		System.out.println(pilhaVetor.pop());
		System.out.println(pilhaVetor.peek());
		System.out.println(pilhaVetor.pop());
		System.out.println(pilhaVetor.peek());
		System.out.println(pilhaVetor.pop());
		try {
			System.out.println(pilhaVetor.peek());
		} catch (Exception e) {
			System.out.println("Deu certo!!!!");
		}
		try {
			System.out.println(pilhaVetor.pop());
		} catch (Exception e) {
			System.out.println("Deu certo!!!!");
		}
		pilhaVetor.push(20);
		pilhaVetor.push(30);
		pilhaVetor.push(10);
		System.out.println(pilhaVetor.toString());
		pilhaVetor.liberar();
		System.out.println(pilhaVetor.toString());
	}
}
