package enemigos;

import javax.swing.*;

import mapa.*;

public class DragonMuerto extends Enemigo {

	protected GenerarBolaFuegoCongelado generarBolaFuegoCongelado;
	
	public DragonMuerto(Celda c, boolean b)
	{
		super(c,b);
		
		vida=10;
		danioAtaque=20;
		
		velocidad = 10;
		monedas = 300;
		puntos = 600;
		
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/DragonMuerto.gif")));
		
		generarBolaFuegoCongelado = new GenerarBolaFuegoCongelado(this);
		generarBolaFuegoCongelado.start();
		
		moverme = new MoverEnemigo(this);
		moverme.start();
	}
	
	public void destruir()
	{
		generarBolaFuegoCongelado.terminate();
		super.destruir();
	}
	
	public void caminar()
	{
		caminando=true;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/DragonMuerto.gif")));
	}
	
	public void atacar()
	{
		caminando=false;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/DragonMuerto.gif")));
	}
	
}
