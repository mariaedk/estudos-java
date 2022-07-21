import java.util.Arrays;
import java.util.List;

public class JavaDebugLambda
{
    public static void main(String[] args) 
    {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        list.stream()
            .map(n -> new StringBuilder().append(n).append("s").append("a"))
            .forEach(System.out::println);
        
        // transformar em blocos para facilitar debug
        list.stream()
            .map(n ->
            {
                StringBuilder builder = new StringBuilder();
                builder.append(n);
                builder.append("s");
                builder.append("a");

                return builder;
            })
            .forEach(System.out::println);
        
        
    }
    
}
