package personajes;

import javax.swing.ImageIcon;
import mapa.*;

public class Arquero extends Personaje{

	protected GenerarFlechasArquero generarFlechas;
	
	public Arquero(Celda c)
	{
		super(c);
		costo=25;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Arquero.gif")));
		generarFlechas = new GenerarFlechasArquero(this);
		generarFlechas.start();
	}

	public void destruir()
	{
		generarFlechas.terminate();
		super.destruir();
	}
	
	public void atacar()
	{
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Arquero.gif")));
	}
	
	public void esperar()
	{
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Arquero.gif")));
	}
}
	
