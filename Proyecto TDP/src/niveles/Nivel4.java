package niveles;
import juego.Juego;
import mapa.Celda;
import objetos.Arbol;
import objetos.Charco;
import objetos.Objeto;

import java.util.Random;

import enemigos.*;
import herramientas.Coleccion;

public class Nivel4 extends Nivel {

	protected Coleccion<String> Oleadas;
	
	public Nivel4(Juego j)
	{
		juego = j;
		monedasIniciales=1500;
		Oleadas = new Coleccion<String>();
		String S1 = "MMOODMMOODCDMMHHOMOMCCHHMMHOMCCDDOMCD";
		String S2 = "OOMMDDOMOMDDMMCMMHHMODCHMHODCHDOMCHDOMMOOCHDHDH";
		String S3 = "OOMMDDOMOMDDMMCMMHHMODCHMHODCHDOMCHDOMMOOCHDHDH";
		String S4 = "OOMMDDOMOMDDMMCMMHHMODCHMHODCHDOMCHDOMMOOCHDHDH";
		Oleadas.add(S1);
		Oleadas.add(S2);
		Oleadas.add(S3);
		Oleadas.add(S4);
	}
	
	public void run()
	{
		Enemigo basura = new Muerto(null,false);
		juego.agregarEnemigo(basura);
		Random r1 = new Random();
		int Rnd1 = r1.nextInt(juego.getFilas());
		int Rnd2 = r1.nextInt(juego.getColumnas()-80);
		if(Rnd2<100 && juego.getColumnas()>100)
			Rnd2+=100;
		
		Objeto charco = new Charco(juego.getMapa().getCelda(Rnd1,Rnd2));
		juego.getMapa().getCelda(Rnd1,Rnd2).agregar(charco);
		juego.agregar(charco);
		
		Rnd1 = r1.nextInt(juego.getFilas());
		Rnd2 = r1.nextInt(juego.getColumnas()-80);
		if(Rnd2<100 && juego.getColumnas()>100)
			Rnd2+=100;
		
		Objeto arbol = new Arbol(juego.getMapa().getCelda(Rnd1,Rnd2));
		juego.getMapa().getCelda(Rnd1,Rnd2).agregar(arbol);
		juego.agregar(arbol);
		
		Rnd1 = r1.nextInt(juego.getFilas());
		Rnd2 = r1.nextInt(juego.getColumnas()-80);
		if(Rnd2<100 && juego.getColumnas()>100)
			Rnd2+=100;
		
		charco = new Charco(juego.getMapa().getCelda(Rnd1,Rnd2));
		juego.getMapa().getCelda(Rnd1,Rnd2).agregar(charco);
		juego.agregar(charco);
		
		Rnd1 = r1.nextInt(juego.getFilas());
		Rnd2 = r1.nextInt(juego.getColumnas()-80);
		if(Rnd2<100 && juego.getColumnas()>100)
			Rnd2+=100;
		
		arbol = new Arbol(juego.getMapa().getCelda(Rnd1,Rnd2));
		juego.getMapa().getCelda(Rnd1,Rnd2).agregar(arbol);
		juego.agregar(arbol);
		
		Rnd1 = r1.nextInt(juego.getFilas());
		Rnd2 = r1.nextInt(juego.getColumnas()-80);
		if(Rnd2<100 && juego.getColumnas()>100)
			Rnd2+=100;
		
		charco = new Charco(juego.getMapa().getCelda(Rnd1,Rnd2));
		juego.getMapa().getCelda(Rnd1,Rnd2).agregar(charco);
		juego.agregar(charco);
		
		Rnd1 = r1.nextInt(juego.getFilas());
		Rnd2 = r1.nextInt(juego.getColumnas()-80);
		if(Rnd2<100 && juego.getColumnas()>100)
			Rnd2+=100;
		
		arbol = new Arbol(juego.getMapa().getCelda(Rnd1,Rnd2));
		juego.getMapa().getCelda(Rnd1,Rnd2).agregar(arbol);
		juego.agregar(arbol);
		
		try {
			sleep(5000);
			for(String s:Oleadas)
			{
				for(int i =0;i<s.length();i++)
				{
					Rnd1 = r1.nextInt(juego.getFilas());
					Celda celda = juego.getMapa().getCelda(Rnd1, juego.getColumnas()-1);
					Enemigo nuevo = null;
					char Proximo = s.charAt(i);
					
					boolean pw = false;
					Rnd1 = r1.nextInt(100);
					if(Rnd1%5==0)
						pw = true;
					
					switch (Proximo) {
	                case 'M':  nuevo = new Muerto(celda,pw);
	                         break;
	                case 'O':  nuevo = new Oso(celda,pw);
	                         break;
	                case 'D':  nuevo = new DragonMuerto(celda,pw);
	                         break;
	                case 'C':  nuevo = new Caminante(celda,pw);
	                		 break;
	                case 'H':  nuevo = new CaminanteCaballo(celda,pw);
	       		 			 break;
	            	}
					
					celda.agregar(nuevo);
					juego.agregar(nuevo);
					juego.agregarEnemigo(nuevo);
					sleep(4000);
				}
				
				sleep(6000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		juego.quitarEnemigo(basura);
	}
	
	public Nivel siguienteNivel()
	{
		return new Nivel4(null);
	}
	
	public Nivel reiniciarNivel()
	{
		return new Nivel4(null);
	}
}