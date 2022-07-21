import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaStreamsParalelos 
{
    public static void main(String[] args) 
    {
        // perfomance
        List<Integer> list = Arrays.asList(1,2,3,4);
        
        // stream paralelo
        // tem um custo a mais -> nao usar ele demais
        
        // se executar isto, não vai imprimir na ordem
        list.parallelStream()
            .forEach(System.out::println);


        System.out.println();
        
        
        // se executar isto, vai imprimir na ordem
        list.parallelStream()
            .forEachOrdered(System.out::println);

        System.out.println();
        
        // usando stream paralelo
        list.parallelStream() // o número fica alternando pois a thread que terminar primeiro é q vai executar esta tarefa 
        .findAny()
        .ifPresent(System.out::println);
        
        System.out.println();
        // sem ser paralelo
        list.stream()
        .findAny()
        .ifPresent(System.out::println);
        
        System.out.println();
        
        list.parallelStream().forEach(System.out::println);

        System.out.println();

        // unordered
        list.parallelStream()
            .unordered()
            .skip(1)
            .limit(1)
            .forEach(System.out::print);

        System.out.println();

        // reduce
        list.parallelStream()
            .reduce((n1,n2) -> n1 - n2)
            .ifPresent(System.out::print);
        
        System.out.println();

        // cria um mapa para cada thread, popula cada mapa e depois junta todos
        // operação custosa
        Map<Integer, Boolean> collect = 
        list.parallelStream()
            .collect(
                Collectors.toMap(n -> n, n -> n % 2 == 0)
            );
        Map<Integer, Boolean> collect2 = 
        list.parallelStream()
            .collect(
                Collectors.toConcurrentMap(n -> n, n -> n % 2 == 0) // toConcurrentMap cria um único mapa e todas as thread acrescetam o resultado da operação neste mesmo mapa
                // é mais lento
            );
        // número da lista / 2 tem resto 0? se sim recebe true, se não recebe false
        System.out.println(collect);
        System.out.println(collect2);

        Map<Boolean, List<Integer>> collect3 = 
        list.parallelStream()
            .collect(
                Collectors.groupingBy(n -> n % 2 == 0) 
                // é mais lento
            );
        Map<Boolean, List<Integer>> collect4 = 
        list.parallelStream()
            .collect(
                Collectors.groupingByConcurrent(n -> n % 2 == 0) // GroupingByConcurrent cria um único mapa e todas as thread acrescetam o resultado da operação neste mesmo mapa
                // é mais lento
                // pode perder a ordem em q os elementos estao no mapa
            );

        System.out.println(collect3);
        System.out.println(collect4);
    }
}
