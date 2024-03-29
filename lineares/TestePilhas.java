package lineares;

public class TestePilhas {

	public static void main(String[] args) {
		System.out.println("Pilha Est�tica ++++++");
		Pilha<Integer> pilha = new PilhaVetor<Integer>(3);
		pilha.push(2);
		pilha.push(3);
		pilha.push(1);
		try {
			pilha.push(1);
		} catch (Exception e) {
			System.out.println("Deu certo!!!!");
		}
		System.out.println(pilha.toString());

		System.out.println(pilha.pop());
		System.out.println(pilha.peek());
		System.out.println(pilha.pop());
		System.out.println(pilha.peek());
		System.out.println(pilha.pop());
		try {
			System.out.println(pilha.peek());
		} catch (Exception e) {
			System.out.println("Deu certo!!!!");
		}
		try {
			System.out.println(pilha.pop());
		} catch (Exception e) {
			System.out.println("Deu certo!!!!");
		}
		pilha.push(20);
		pilha.push(30);
		pilha.push(10);
		System.out.println(pilha.toString());
		pilha.liberar();
		System.out.println(pilha.toString());

		System.out.println("\n --- Agora com Pilha Din�mica ----");
		pilha = new PilhaVetor<Integer>(3);
		pilha.push(2);
		pilha.push(3);
		pilha.push(1);
		try {
			pilha.push(1);
		} catch (Exception e) {
			System.out.println("Deu certo!!!!");
		}
		System.out.println(pilha.toString());

		System.out.println(pilha.pop());
		System.out.println(pilha.peek());
		System.out.println(pilha.pop());
		System.out.println(pilha.peek());
		System.out.println(pilha.pop());
		try {
			System.out.println(pilha.peek());
		} catch (Exception e) {
			System.out.println("Deu certo!!!!");
		}
		try {
			System.out.println(pilha.pop());
		} catch (Exception e) {
			System.out.println("Deu certo!!!!");
		}
		pilha.push(20);
		pilha.push(30);
		pilha.push(10);
		System.out.println(pilha.toString());
		pilha.liberar();
		System.out.println(pilha.toString());
	}
}
