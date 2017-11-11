package disparos;
import javax.swing.ImageIcon;
import mapa.*;

public class BolaFuego extends DisparoPersonaje{
	
	
	public BolaFuego(Celda c)
	{
		super(c);
		danioAtaque=300;
		velocidad = 1;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/BolaDeFuego.gif")));
		miCelda.getMapa().getJuego().agregar(this);
		moverme = new MoverDisparoPersonaje(this);
		moverme.start();
	}

}
