package disparos;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import mapa.*;

public class BolaFuego extends DisparoPersonaje{
	
	
	public BolaFuego(Celda c)
	{
		super(c);
		velocidad = 1;
		grafico = new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Flecha.png")));
		miCelda.getMapa().getJuego().agregar(this);
		moverme = new MoverDisparoPersonaje(this);
		moverme.start();
	}

}
