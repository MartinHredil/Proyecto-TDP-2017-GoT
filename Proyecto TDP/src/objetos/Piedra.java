package objetos;
import javax.swing.ImageIcon;
import mapa.Celda;

public class Piedra extends Objeto {

	public Piedra(Celda c)
	{
		super(c);
		costo=40;
		vida=900;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Piedra80.png")));
	}
}