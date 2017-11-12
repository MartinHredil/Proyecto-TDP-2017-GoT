package objetos;

public class TemporalizadorCharco extends Thread{

	protected Charco charco;
	
	public TemporalizadorCharco(Charco c)
	{
		charco = c;
	}
	
	public void run()
	{
		try {
			sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		charco.destruir();
	}
}
