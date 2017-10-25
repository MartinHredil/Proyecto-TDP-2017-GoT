package disparos;

public class MoverDisparoPersonaje extends Thread {

	protected volatile boolean execute;
	
	protected DisparoPersonaje dp;
	
	public MoverDisparoPersonaje(DisparoPersonaje d)
	{
		dp = d;
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
				sleep(3*dp.getVelocidad());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			dp.mover();
		}
	}
}