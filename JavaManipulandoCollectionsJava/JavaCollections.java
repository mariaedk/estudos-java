import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JavaCollections 
{
    public static void main(String[] args) 
    {
        List<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        arrayList.forEach(n -> System.out.println(n));

        System.out.println();

        // como não foi criado um stream, ele modificou a lista original

        arrayList.removeIf(n -> n % 2 == 0);
        arrayList.forEach(n -> System.out.println(n));
        
        System.out.println();
        
        arrayList.forEach(n -> System.out.println(n));

        System.out.println();
        
        arrayList.replaceAll(n -> n * 2);

        arrayList.forEach(n -> System.out.println(n));

        HashMap<Integer, String> map = new HashMap<>();

        map.put(0, "Olá");
        map.put(1, "Tudo");
        map.put(2, "bem");
        map.put(3, "com");

        // for each bi consumer => chave e valor do mapa
        map.forEach((k, v) -> System.out.println(k + " " + v)); // imprime cada chave e respectivo valor

        // compute
        map.compute(1, (k,v) -> v + " agora"); // na chave 1, concatene ao valor dela, a palavra " agora"

        map.forEach((k, v) -> System.out.println(k + " " + v));

        map.merge(3, "!", (v1,v2) -> v1 + v2); // na chave 3, com o valor "!", concatene (v1+v2) o que está na chave 3 com o valor informado

        map.forEach((k, v) -> System.out.println(k + " " + v));
        
        System.out.println();
        
        map.replaceAll((k,v) -> v + "!"); // todos os valores no mapa agora tem uma exclamação no final

        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
