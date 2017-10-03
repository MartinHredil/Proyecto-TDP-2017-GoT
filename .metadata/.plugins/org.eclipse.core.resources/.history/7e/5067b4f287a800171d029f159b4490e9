package visitor;
import personajes.Personaje;
import enemigos.Enemigo;
import objetos.Objeto;
import powerups.PowerUp;
import disparos.DisparoEnemigo;
import disparos.DisparoPersonaje;


public class VisitorPersonaje implements Visitor {

	protected Personaje personaje;
	
	public VisitorPersonaje(Personaje p)
	{
		personaje = p;
	}
	
	public boolean visitarEnemigo(Enemigo e)
	{
		e.decrementarVida(personaje.getDanioAtaque());
		if(e.getVida()<=0)
			e.destruir();
		return true;
	}
	
	public boolean visitarPersonaje(Personaje p)
	{
		return true;
	}
	
	public boolean visitarObjeto(Objeto p)
	{
		return false;
	}
	
	public boolean visitarPowerUp(PowerUp pw)
	{
		return false;
	}
	
	public boolean visitarDisparoEnemigo(DisparoEnemigo de)
	{
		return true;
	}
	
	public boolean visitarDisparoPersonaje(DisparoPersonaje dp)
	{
		return true;
	}
	
}
