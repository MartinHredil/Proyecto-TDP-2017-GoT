package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.*;

public class Arquero extends Personaje{

	protected GenerarFlechas generarFlechas;
	
	public Arquero(Celda c)
	{
		super(c);
		grafico = new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Arquero.png")));
		generarFlechas = new GenerarFlechas(this);
		generarFlechas.start();
		
	}

	public void destruir()
	{
		generarFlechas.terminate();
		super.destruir();
	}
}
	
