package juego;
import personajes.Arquero;

public class GenerarFlechas extends Thread {

	protected volatile boolean execute;
	
	protected Arquero arquero;
	
	public GenerarFlechas(Arquero a)
	{
		arquero=a;
	}
	
	public void terminate()
	{
		execute = false;
	}
	
	public void run()
	{
		this.execute = true;
		
		while(execute)
		{
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			arquero.crear();
		}
	}
}