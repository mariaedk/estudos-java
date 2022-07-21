import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8StreamsCollect 
{
    public static void main(String[] args) 
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        // fornecedor - acumulação - combinação

        // jeito mais customizado de fazer 
        // recebe 3 parâmetros
        List<Integer> collect = list.stream()
            .collect
            (
                () -> new ArrayList<>(), // fornecedor
                (l, e) -> l.add(e), // acumulador
                (l1, l2) -> l1.addAll(l2) // combinação das listas
            );

        System.out.println(list);
        System.out.println(collect);
        
        // armazenar o resultado em uma lista

        // filtra por números pares
        // jeito mais simples
        System.out.println("lista");
        List<Integer> lista2 = list.stream()
            .filter(e -> e % 2 == 0)
            .collect(Collectors.toList());
        
        System.out.println(lista2);

        // collectors joining
        // coloca tudo em uma string
        String join = list.stream()
                .map(n -> n.toString())
                .collect(Collectors.joining());

        System.out.println(join);
    
        // funções matemáticas

        // pega a média de todos os elementos da lista
        Double media = list.stream()
            .collect(Collectors.averagingInt(n -> n.intValue()));

        System.out.println(media);

        // soma
        Integer sum = list.stream()
            .collect(Collectors.summingInt(n -> n.intValue()));

        System.out.println(sum);

        // sumarização
        IntSummaryStatistics summarize = list.stream()
            .collect(Collectors.summarizingInt(n -> n.intValue()));

        System.out.println(summarize.getAverage());
        System.out.println(summarize.getCount());
        System.out.println(summarize.getMax());
        System.out.println(summarize.getMin());
        System.out.println(summarize.getSum());

        // counting
        // forma de ver quantos elementos tem no stream
        Long count = list.stream()
            .collect(Collectors.counting());

        System.out.println(count);

        Optional<Integer> elementoMaximo = list.stream()
            .collect(
                Collectors.maxBy(Comparator.naturalOrder())
            );

        System.out.println(elementoMaximo.get());

        Optional<Integer> elementoMinimo = list.stream()
            .collect(
                Collectors.minBy(Comparator.naturalOrder())
            );

        System.out.println(elementoMinimo.get());

        // groupingBy
        // mapa que agrupa por resto da divisão por 3
        Map<Integer, List<Integer>> collect3 = list.stream()
            .collect
            (
                Collectors.groupingBy((n) -> n % 3)
            );

        System.out.println(collect3);

        // partitioning by

        Map<Boolean, List<Integer>> partitioningBy = list.stream()
            .collect
            (
                Collectors.partitioningBy((n) -> n % 3 == 0)
            );

        System.out.println(partitioningBy);


        Map<Integer, Integer> toMap = list.stream()
            .collect
            (
                Collectors.toMap(n -> n, n -> n * 2)
            );
        System.out.println(toMap);
    }

}