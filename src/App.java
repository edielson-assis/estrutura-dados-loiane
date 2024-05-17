import com.edielsonassis.estruturadados.lista.ListaEncadeada;

public class App {
    public static void main(String[] args) {

		ListaEncadeada<Integer> lista = new ListaEncadeada<>();

		lista.adiciona(1);
		lista.adiciona(2);
		lista.adiciona(4);

		System.out.println(lista);
		
		lista.adiciona(0, 0);
		lista.adiciona(4, 5);
		lista.adiciona(2, 3);

		System.out.println(lista);

		System.out.println(lista.busca(3));
		System.out.println(lista.buscaPorPosicao(5));

		lista.remove(2);
		System.out.println(lista);

		System.out.println(lista.removeFinal());
		System.out.println(lista);

		System.out.println(lista.removeInicio());
		System.out.println(lista);

		System.out.println(lista.getTamanho());

		lista.limpa();

		System.out.println(lista);
	}
}