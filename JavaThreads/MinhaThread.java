// herança -> está herdando da classe Thread
public class MinhaThread extends Thread
{
	private String nome;
	private int tempo;
	
	public MinhaThread(String nome, int tempo)
	{
		this.nome = nome;
		this.tempo = tempo;
		// o m�todo start do java lang chama o m�todo run, nesse o caso o que foi implementado nessa classe (override)
		start();
	}
	
	public void run()
	{
		try
		{
			for (int i = 0; i < 6; i++)
			{
				System.out.println(nome + " contador " + i); 
				Thread.sleep(tempo);
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
