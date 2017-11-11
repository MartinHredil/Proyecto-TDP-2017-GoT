package disparos;
import javax.swing.ImageIcon;
import mapa.*;

public class FlechaBallesta extends DisparoPersonaje{
	
	
	public FlechaBallesta(Celda c)
	{
		super(c);
		danioAtaque=200;
		velocidad = 1;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/FlechaBallesta.png")));
		moverme = new MoverDisparoPersonaje(this);
		moverme.start();
	}
}