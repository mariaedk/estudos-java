import java.util.Arrays;
import java.util.List;

public class JavaLambdaRunnable
{
	public static void main(String[] args)
	{
		// THREAD EM JAVA < 8
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("OL� MUNDO!");				
			}
		}).run();
	
		// mesmo c�digo em java 8
		// como a interface Runnable s� tem um m�todo na interface, logicamente s� tem um m�todo para ser chamado. Logo, o sysout � logicamente a implementa��o do m�todo run()
		new Thread(() -> System.out.println("Ol� mundo!")).run();
		
		// SAM
		// Single Abstract Method
		// Qualquer interface que tenha apenas um m�todo abstrato.
		
		// fun��o lambda permite usar a fun��o stream tamb�m
		// isso
		List<Integer> asList = Arrays.asList(1,2,3,4);
		asList.stream().forEach(e -> System.out.println(e));
		
		// em vez disso
		for (Integer integer : asList) 
		{
			System.out.println(integer);
		}
		
		// outras fun��es podem ser aplicadas com o stream()
		// filter vai filtrar os elementos da lista
		// se o elemento analisado agora for par, ele segue para a proxima condi��o e imprime, se n�o n faz nada
		asList.stream()
		.filter(e -> e % 2 == 0)
		.forEach(e -> System.out.println(e));
	}

}
