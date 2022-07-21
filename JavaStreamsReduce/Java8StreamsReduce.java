

import java.util.Arrays;
import java.util.List;
import java.util.Optional;	
import java.util.stream.DoubleStream;

public class Java8StreamsReduce 
{
	public static void main(String[] args)
	{
		// reduce -> pegar todos os elementos do stream, e transformar em uma s� coisa
		// a opera��o vai variar, por�m o resultado vai ser sempre uma coisa s�
		
		List<Integer> lista = Arrays.asList(1,2,3,4,5,6);
		
		// FUN��O DE ACUMULA��O
		
		// reduce - soma
		
		// .reduce(accumulator) -> este acumulador � a fun��o que vai ser chamada para fazer o reduce dos n�meros
		// 1 + 2 = 3. n1 = 3, n2 = 3. 3 + 3 = 6. n1 = 6, n2 = 4.
		// vai acumulando o resultado no primeiro argumento
		Optional<Integer> reduce = lista.stream()
						 .reduce((n1, n2) -> n1 + n2);
		
		System.out.println(reduce.get());
		

		// reduce - multiplica��o
		
		Optional<Integer> reduce2 = lista.stream()
				 .reduce((n1, n2) -> n1 * n2);

		System.out.println(reduce2.get());	
		
		
		// reduce - concatena��o
		
		String mensagem = "Este � um programa em java 8.";
		String[] concatenacao = mensagem.split(" ");
		List<String> listaStr = Arrays.asList(concatenacao);
		
		Optional<String> reduce3 = listaStr.stream()
				.reduce((s1, s2) -> s1.concat(s2)); // ou s1 + s2
		
		System.out.println(reduce3.get());	
		
		
		// FUN��O DE ASSOCIA��O
		
		// subtra��o - N�o fazer isto. 
		
		Optional<Integer> reduce4 = lista.stream()
				 .reduce((n1, n2) -> n1 - n2);

		System.out.println(reduce4.get());	
		
		Optional<Integer> reduce8 = lista.stream()
				.parallel()
				.reduce((n1, n2) -> n1 - n2);
		
		System.out.println(reduce8.get());	
		
		
		// usando valor de identidade
		
		// valor de identidade -> 0 
		// para algumas opera��es, especialmente se quiser ter um valor padr�o, o valor de identidade � �til
		// tem que ser um valor que quando chamada a fun��o, passando ele e outro n�mero, o resultado
		// tem que ser o outro n�mero
		
		Integer reduce5 = lista.stream()
				 .reduce(0, (n1, n2) -> n1 + n2);

		System.out.println(reduce5);
		
		
		// reduce - multiplica��o
		
		Integer reduce6 = lista.stream()
				 .reduce(1, (n1, n2) -> n1 * n2);
		
		System.out.println(reduce6);	
		
		
		// reduce - concatena��o
		
		String mensagem2 = "Este � um programa em java 8.";
		String[] concatenacao2 = mensagem2.split(" ");
		List<String> listaStr2 = Arrays.asList(concatenacao2);
		
		String reduce7 = listaStr2.stream()
				.reduce("", (s1, s2) -> s1.concat(s2)); // ou s1 + s2
		
		System.out.println(reduce7);		
		
		
		// reduce do menor valor
		double reduce9 = DoubleStream.of(1.5, 2.9, 3.7)
					.reduce(Double.POSITIVE_INFINITY, (d1, d2) -> Math.min(d1, d2));
		
		System.out.println(reduce9);
	
		
		// fun��o de combina��o
		// fun��o chamada pelo reduce quando ele divide em v�rias partes os elementos do stream
		Integer reduce10 = lista.stream()
				 .reduce(0, (n1, n2) -> n1 + n2,  (n1, n2) -> n1 + n2);

		System.out.println(reduce10);
		
		// reduce - map + combiner
		Optional<String> reduce11 = lista.stream()
						.map(n1 -> n1.toString())
						.reduce((n1, n2) -> n1.concat(n2));
		
		System.out.println(reduce11); 
	}
}

