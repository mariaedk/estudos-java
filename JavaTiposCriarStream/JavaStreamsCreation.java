
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamsCreation {
    public static void main(String[] args) {
        // Colection
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        list.stream()
                .forEach(System.out::println);

        System.out.println();

        // Arrays
        Integer[] intArray = new Integer[] { 1, 2, 3, 4 };
        Arrays.stream(intArray)
                .forEach(System.out::println);

        System.out.println();

        // Stream of
        Stream<String> streamString = Stream.of("Oi", "Tudo", "Bem");
        streamString.forEach(System.out::println);

        System.out.println();

        // IntStream.range (stream de números sequenciais)
        IntStream.range(0, 5)
                .forEach(System.out::println);

        System.out.println();

        // stream iterate
        // 5 * 2 = 10 . 10 * 2 = 20 . 20 * 2 = 40 ...
        Stream.iterate(5, n -> n * 2)
                .limit(10)
                .forEach(System.out::println);

        // buffered reader
        // File file1 = new File("../streams.txt");
        // FileReader in = new FileReader(file1);
        // BufferedReader br = new BufferedReader(in);
        // br.lines().forEach(System.out::println);

        // files
        // Path p = Paths.get("");
        // Files.list(p).forEach(System.out::println);
        System.out.println();
        // Random -> stream de numeros aleatorios
        new Random().ints()
        .limit(5)
        .forEach(System.out::println);

        System.out.println();

        // pattern
        //regex
        String s = "Lorem ipsum dolor";
        Pattern compile = Pattern.compile(" ");
        compile.splitAsStream(s).forEach(System.out::println);
    }
}