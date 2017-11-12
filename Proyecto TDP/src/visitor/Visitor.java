package visitor;
import personajes.Personaje;
import enemigos.Enemigo;
import objetos.Objeto;
import powerups.PowerUp;
import disparos.DisparoEnemigo;
import disparos.DisparoPersonaje;

public interface Visitor {

	public boolean visitarEnemigo(Enemigo e);
	public boolean visitarPersonaje(Personaje p);
	public boolean visitarObjeto(Objeto o);
	public boolean visitarPowerUp(PowerUp pw);
	public boolean visitarDisparoEnemigo(DisparoEnemigo de);
	public boolean visitarDisparoPersonaje(DisparoPersonaje dp);
}