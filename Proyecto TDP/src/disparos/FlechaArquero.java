package disparos;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import mapa.*;

public class FlechaArquero extends DisparoPersonaje{
	
	
	public FlechaArquero(Celda c)
	{
		super(c);
		velocidad = 1;
		grafico = new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Flecha.png")));
		moverme = new MoverDisparoPersonaje(this);
		moverme.start();
	}
}
