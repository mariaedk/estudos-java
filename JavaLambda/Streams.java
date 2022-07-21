import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams 
{
	public static void main(String[] args)
	{
		// a lista original não é modificada
		List<Integer> lista = Arrays.asList(1,4,5,6,3,1,2,3,5,6,8,5,9);
		lista.stream().skip(2).forEach(e -> System.out.print(e));// pula os dois primeiros
		System.out.println();
		lista.stream().limit(2).forEach(e -> System.out.print(e)); // dois primeiros
		System.out.println();
		lista.stream().distinct().forEach(e -> System.out.print(e)); // elementos repetidos
		
		System.out.println();
		lista.stream().skip(2).limit(2).forEach(e -> System.out.print(e)); 
		
		System.out.println();
		lista.stream().map(e -> e * 2).forEach(e -> System.out.print(e));
		
		// o for each é uma operação final, dps q executa ela n conseegue fazer mais nada, o stream fecha]
		// isso daria erro, pois o stream map ja foi fechado no primeiro for each
//		Stream<Integer> map = lista.stream().limit(2).map(e -> e * 2);
//		map.forEach(e -> System.out.println(e));
//		map.forEach(e -> System.out.println(e));
		
		// limita a qtd a 3 e multiplica esses 3 por 2. imprime a qntd de elementos pares
		System.out.println();
		long count = lista.stream().limit(3).map(e -> e * 2).count();
		System.out.println(count);
		
		// pega só os pares e conta eles
		long count2 = lista.stream().filter(e -> e % 2 == 0).count();
		System.out.println(count2);
		
		// dos valores pares, pega o menor valor entre eles
		Optional<Integer> min = lista.stream().filter(e -> e % 2 == 0).min(Comparator.naturalOrder());
		System.out.println(min.get());
		
		// Filtra numeros pares e coleta o resultado jogando em novaLista
		List<Integer> novaLista = lista.stream()
						.filter(e -> e % 2 == 0)
						.collect(Collectors.toList());
		System.out.println(novaLista);
		
		// agrupar em um mapa
		// true = numeros pares, false = numeros impares
		Map<Boolean, List<Integer>> mapa = lista.stream().map(e -> e * 3).collect(Collectors.groupingBy(e -> e % 2 == 0));
		System.out.println(mapa);
		// agrupando pelo resto da divisao
		Map<Integer, List<Integer>> mapa2 = lista.stream().collect(Collectors.groupingBy(e -> e % 3));
		
		System.out.println(mapa2);
		
		// retorna uma string que é a junção de todos os numeros em uma só string separados por ;
		String collect = lista.stream().map(e -> String.valueOf(e)).collect(Collectors.joining(";"));
		
		System.out.println(collect);
		
		// 
	}
}
