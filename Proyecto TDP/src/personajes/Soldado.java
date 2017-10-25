package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.*;

public class Soldado extends Personaje{

	
	public Soldado(Celda c)
	{
		super(c);
		grafico = new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Soldado.png")));
	}
}
