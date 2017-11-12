package powerups;

public class EntregarPW extends Thread {

	protected volatile boolean execute;
	protected PowerUp powerup;
	
	public EntregarPW(PowerUp pw)
	{
		powerup=pw;
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
			
			powerup.comprobar();
		}
	}
}