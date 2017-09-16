package juego;

public class RefrescarGUI extends Thread{

	protected GUI gui;
	
	public RefrescarGUI(GUI g)
	{
		gui = g;
	}
	
	public void run()
	{
		while(true)
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
