package juego;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

import mapa.*;
import enemigos.*;

public class GUI extends JFrame{

	int cantFilas;
	int cantColumnas;
	int alto;
	int ancho;
	
	Juego juego;
	Mapa mapa;
	
	JPanel panelOpciones;
	JPanel panelJuego;
	
	JLabel etiqueta;
	
	public GUI(Juego ju)
	{
		juego = ju;
		mapa = juego.getMapa();
		cantFilas = juego.getFilas();
		cantColumnas = juego.getColumnas();
		alto = cantFilas * 80;
		ancho = cantColumnas * 80;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(ancho+16, alto+138);
		
		inicializarPanelBotones();
		inicializarPanelJuego();
		
		getContentPane().setBackground(Color.green);
		
		getContentPane().add(panelOpciones);
		getContentPane().add(panelJuego);
	}
	
	private void inicializarPanelBotones()
	{
		panelOpciones = new JPanel();
		panelOpciones.setLayout(null);
		panelOpciones.setBorder(BorderFactory.createLineBorder(Color.black));
		panelOpciones.setBounds(0,0, ancho, 100);
	}
	
	private void inicializarPanelJuego()
	{
		panelJuego = new JPanel();
		panelJuego.setLayout(null);
		panelJuego.setBackground(new Color(135,206,255));
		panelJuego.setBounds(0, 100, ancho, alto);
		/*
		for(int i=0;i<cantFilas;i++)
		{
			for(int j=0;j<cantColumnas;j++)
			{
				//etiqueta= mapa.getEtiqueta(i, j);
				etiqueta.setBounds(j*80,i*80,80,80);
				panelJuego.add(etiqueta);
			}
		}
		*/
		
		for(int i=0;i<cantFilas;i++)
		{
			for(int j=0;j<cantColumnas;j++)
			{
				Iterator<Contenido> it = mapa.getCelda(i, j).getContenido();
				while(it.hasNext())
				{
					etiqueta = it.next().getGrafico();
					etiqueta.setBounds(j*80,i*80,80,80);
					panelJuego.add(etiqueta);
				}
			}
		}
		
		
	}
}
