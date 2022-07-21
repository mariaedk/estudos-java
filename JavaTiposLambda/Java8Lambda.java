import java.util.stream.IntStream;

public class Java8Lambda 
{
    public static void main(String[] args)
    {
        IntStream.range(0, 5)  
        // se tiver só uma variável, não precisa colocar ((n) -> n % 2 == 0) (entre parênteses)
                 .filter(n -> n % 2 == 0)
                 .forEach(n -> System.out.println(n));

        System.out.println();

        // na interface runnable, o único método que ela tem, run(), não recebe nenhum parâmetro.
        Runnable runnable = () -> System.out.println("Olá mundo!");

        IntStream.range(0, 5)  
        // se quiser colocar o tipo, usar parênteses
                 .filter((int n) -> n % 2 == 0)
                 .reduce((int n1, int n2) -> n1 + n2) // se declarar o tipo de uma, tem que declarar da outra também
                 .ifPresent(n -> System.out.println(n));

        System.out.println();

        IntStream.range(0, 5)  
                 .filter((int n) -> { return n % 2 == 0; }) // se usar chaves -> ;
                 .forEach(n -> System.out.println(n));


        IntStream.range(0, 5)  
                 .filter((int n) -> { 
                    System.out.println("Entrando nas chaves do método!");
                    return n % 2 == 0;
                 })
                 .forEach(n -> System.out.println(n));

    }
    
}
