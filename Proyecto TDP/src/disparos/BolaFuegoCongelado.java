package disparos;
import javax.swing.ImageIcon;
import mapa.*;

public class BolaFuegoCongelado extends DisparoEnemigo{
	
	
	public BolaFuegoCongelado(Celda c)
	{
		super(c);
		danioAtaque=30;
		velocidad = 1;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/BolaDeFuegoCongelado.gif")));
		miCelda.getMapa().getJuego().agregar(this);
		
		moverme = new MoverDisparoEnemigo(this);
		moverme.start();
	}

}