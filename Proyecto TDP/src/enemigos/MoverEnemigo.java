package enemigos;

public class MoverEnemigo extends Thread {

	protected volatile boolean execute;
	protected Enemigo enemigo;
	
	public MoverEnemigo(Enemigo e)
	{
		enemigo=e;
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
			enemigo.mover();
			
			try {
				sleep(3*enemigo.getVelocidad());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}