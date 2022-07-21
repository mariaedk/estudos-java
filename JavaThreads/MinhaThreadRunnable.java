//implementa a interface runnable
public class MinhaThreadRunnable implements Runnable
{
	private String nome;
	private int tempo;
	
	public MinhaThreadRunnable(String nome, int tempo)
	{
		this.nome = nome;
		this.tempo = tempo;
		Thread t1 = new Thread(this);
		// método start chama o método run
		t1.start();
	}
	// devido ao contrato de interface, devemos implementar este método
	@Override
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
		System.out.println("Terminou a execu��o");
	}
	
}
