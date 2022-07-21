import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class JavaFuncInterface {
    public static void main(String[] args) {

        // gera 5 numeros aleatorios e imprime eles
        // SUPPLIER -> FORNECEDOR. NÃO CONSOME NADA, SÓ FORNECE
        // CONSUMIDOR NÃO RETORNA NADA, MAS RECEBE UM VALOR
        Stream.generate(() -> new Random().nextInt())
                .limit(5)
                .forEach(e -> System.out.println(e));// FOR EACH É UM CONSUMIDOR. RECEBE UM VALOR MAS NAO RETORNA NADA,
                                                     // SÓ EXECUTA UMA AÇÃO

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        list.stream()
            .filter(e -> e % 2 == 0)
            .forEach(System.out::println);

    }
}
