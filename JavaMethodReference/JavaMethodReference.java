import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class JavaMethodReference 
{
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream()
            .forEach(System.out::println); // method reference: System.out::println
        // mesma coisa
        list.stream()
            .forEach(n -> System.out.println(n)); // sem method reference


        System.out.println();


        // métodos estáticos

        list.stream()
        .map(n -> multiplicaPorDois(n)) // sem method reference
        .forEach(n -> System.out.println(n)); 

        System.out.println();

        list.stream()
        .map(JavaMethodReference::multiplicaPorDois) // com method reference
        .forEach(n -> System.out.println(n)); 

        // construtores
        list.stream()
        .map(n -> new BigDecimal(n))
        .forEach(n -> System.out.println(n)); // sem method reference

        list.stream()
        .map(BigDecimal::new)
        .forEach(n -> System.out.println(n)); 

        // várias instâncias
        list.stream()
        .map(n -> n.doubleValue()) // SEM method reference
        .forEach(n -> System.out.println(n)); 

        list.stream()
        .map(Integer::doubleValue) // com method reference
        .forEach(n -> System.out.println(n)); 

        // unica instancia
        BigDecimal dois = new BigDecimal(2);
        list.stream()
        .map(BigDecimal::new) // transforma o integer para big decimal
        .map(b -> dois.multiply(b)) // multplica o intger por bigdecimal 2
        .forEach(n -> System.out.println(n)); 

        
    }

    private static Integer multiplicaPorDois(Integer numero)
    {
        return numero * 2;
    }
}
