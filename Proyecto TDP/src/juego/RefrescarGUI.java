package juego;

public class RefrescarGUI extends Thread{

	protected volatile boolean execute;
	protected GUI gui;
	
	public RefrescarGUI(GUI g)
	{
		gui = g;
	}
	
	public void terminate()
	{
		execute = false;
	}
	
	public void run()
	{
		execute = true;
		while(execute)
		{
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gui.refrescar();
		}
	}
}