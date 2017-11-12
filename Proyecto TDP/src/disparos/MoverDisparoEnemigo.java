package disparos;

public class MoverDisparoEnemigo extends Thread {

	protected volatile boolean execute;
	protected DisparoEnemigo de;
	
	public MoverDisparoEnemigo(DisparoEnemigo d)
	{
		de = d;
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
				sleep(3*de.getVelocidad());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			de.mover();
		}
	}
}