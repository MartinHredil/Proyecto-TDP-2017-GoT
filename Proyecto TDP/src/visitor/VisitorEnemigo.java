package visitor;
import personajes.Personaje;
import enemigos.Enemigo;
import objetos.Objeto;
import powerups.PowerUp;
import disparos.DisparoEnemigo;
import disparos.DisparoPersonaje;


public class VisitorEnemigo implements Visitor {

	protected Enemigo enemigo;
	
	public VisitorEnemigo(Enemigo e)
	{
		enemigo = e;
	}
	
	public boolean visitarEnemigo(Enemigo e)
	{
		return true;
	}
	
	public boolean visitarPersonaje(Personaje p)
	{
		p.decrementarVida(enemigo.getDanioAtaque());
		if(p.getVida()<=0)
			p.destruir();
		else
		{
			enemigo.decrementarVida(p.getDanioAtaque());
			if(enemigo.getVida()<=0)
			{
				enemigo.destruir();
			}
		}
		
		return true;
	}
	
	public boolean visitarObjeto(Objeto p)
	{
		return true;
	}
	
	public boolean visitarPowerUp(PowerUp pw)
	{
		pw.destruir();
		return false;
	}
	
	public boolean visitarDisparoEnemigo(DisparoEnemigo de)
	{
		return false;
	}
	
	public boolean visitarDisparoPersonaje(DisparoPersonaje dp)
	{
		return false;
	}
	
}
