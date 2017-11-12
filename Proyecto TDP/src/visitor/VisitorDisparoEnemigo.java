package visitor;
import personajes.Personaje;
import enemigos.Enemigo;
import objetos.Objeto;
import powerups.PowerUp;
import disparos.DisparoEnemigo;
import disparos.DisparoPersonaje;

public class VisitorDisparoEnemigo implements Visitor {

	protected DisparoEnemigo disparoEnemigo;
	
	public VisitorDisparoEnemigo(DisparoEnemigo de)
	{
		disparoEnemigo = de;
	}
	
	public boolean visitarEnemigo(Enemigo e)
	{
		return false;
	}
	
	public boolean visitarPersonaje(Personaje p)
	{
		p.decrementarVida(disparoEnemigo.getDanioAtaque());
		if(p.getVida()<=0)
		{
			p.destruir();
		}
		return true;
	}
	
	public boolean visitarObjeto(Objeto p)
	{
		return true;
	}
	
	public boolean visitarPowerUp(PowerUp pw)
	{
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