package br.com.estudos;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Java8Optional
{
	public static void main(String[] args)
	{
		String numeroValido = "1";
		Optional<Integer> numeroValidoOptional = converteEmNumero(numeroValido);
		
		String numeroInvalido = "INSCREVA-SE";
		Optional<Integer> numeroInvalidoOptional = converteEmNumero(numeroInvalido); 
		System.out.println(numeroInvalidoOptional);	// nesse exemplo retorna um optional.empty pois nao consegue converter "olá" em número
		 
		
		// BOOLEAN
		
		System.out.println(numeroInvalidoOptional.isPresent()); // false
		System.out.println(numeroValidoOptional.isPresent()); // true
		
		
		// GET
		// se chamar o get em uma string não válida, lança exceção
		// System.out.println(numero.get());
		
		
		// IF IMPLICITO
		
		// se tiver algo dentro do option, imprime ele. se não, não faz nada
		// uso de função lambda
		
		numeroInvalidoOptional.ifPresent(objeto -> System.out.println(objeto)); // como não tem nada pois é uma string, não imprime nada
		numeroValidoOptional.ifPresent(objeto -> System.out.println(objeto)); // como tem um numero dentro, imprime ele
		
		
		// OR ELSE
		
		System.out.println(numeroInvalidoOptional.orElse(2)); // se tiver algo dentro do converteNumero, retorna o número, se não, retorna "2"
		System.out.println(numeroValidoOptional.orElse(2));	// retorna numero 1 pois ele é valido
		
		
		// OR ELSE GET
		
		// recebe uma função lambda
		// tenta converter a string não válida. se não der certo, executa uma ação
		
		Integer stringOrElseGet = converteEmNumero(numeroInvalido).orElseGet(() -> 5);
		System.out.println(stringOrElseGet);

		Integer numeroOrElseGet = converteEmNumero(numeroValido).orElseGet(() -> 5);
		System.out.println(numeroOrElseGet);
		
//		 diferença entre OrElseGet e OrElse -> OrElseGet permitiria chamar outro método, por exemplo, executar uma ação
//		Integer numeroOrElseGet = converteEmNumeroHandleException(s).orElseGet(() -> {return algumaOperacao()});
		
		
		// OR ELSE THROW
		
		// lança uma exceção
//		stringOrElseGet = converteEmNumero(numeroInvalido).orElseThrow(() -> new NullPointerException("Valor vazio."));
		
		numeroOrElseGet = converteEmNumero(numeroValido).orElseThrow(() -> new NullPointerException("Valor vazio."));
				
		// encontra o primeiro elemento e imprime ele 
		
		Optional<Integer> findFirst = Stream.of(1,2,3).findFirst();
		System.out.println(findFirst.get());
		
		Stream.of(1,2,3) // nesta sequencia, ao encontrar o primeiro, printa ele.
		.findFirst()
		.ifPresent(n -> System.out.println(n));
		
		Stream.of()
		.findFirst()
		.ifPresent(n -> System.out.println(n)); // como não tem nada no stream, não imprime nada
	}

	public static Optional<Integer> converteEmNumero(String numero)
	{
		// tente converter a string para número
		try
		{
			// se der certo, retorne ela
			Integer integer = Integer.valueOf(numero);
			return Optional.of(integer);
		}
		catch (Exception e)
		{
			// se não, retorne um optional vazio
			return Optional.empty();
		}
	}
	// para tipos primitivos
	public static OptionalInt converteEmNumeroOptionalInt(String numero)
	{
		// tente converter a string para int 
		try
		{
			// se der certo, retorne ela
			int integer = Integer.parseInt(numero);
			return OptionalInt.of(integer);
		}
		catch (Exception e)
		{
			// se não, retorne um optional vazio
			return OptionalInt.empty();
		}
	}

}
