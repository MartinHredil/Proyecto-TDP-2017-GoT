package juego;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import mapa.*;
import herramientas.*;

public class GUI extends JFrame{

	protected int cantFilas;
	protected int cantColumnas;
	protected int alto;
	protected int ancho;	
	
	protected Juego juego;
	protected Mapa mapa;
	protected FabricaPersonajes fabricaPersonajes;
	protected FabricaObjetos fabricaObjetos;
	protected int fabricado;
	
	protected JPanel panelOpciones;
	protected JPanel panelJuego;
	
	protected JLabel etiqueta;
	protected JLabel etiquetaPuntos;
	protected JLabel etiquetaMonedas;
	
	protected JButton market[];
	protected String nombres[];
	
	public GUI()
	{
		juego = new Juego(this);
		mapa = juego.getMapa();
		cantFilas = juego.getFilas();
		cantColumnas = juego.getColumnas();
		alto = cantFilas * 80;
		
		ancho = cantColumnas;
		//ancho = cantColumnas * 80;
		
		fabricaPersonajes = new FabricaPersonal();
		fabricaObjetos =new FabricaCosas();
		fabricado=-1;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(ancho+6, alto+189);
		
		panelOpciones = new JPanel();
		inicializarPanelBotones();
		
		panelJuego = new JPanel();
		inicializarPanelJuego();
		
		getContentPane().setBackground(Color.green);
		
		getContentPane().add(panelOpciones);
		getContentPane().add(panelJuego);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void inicializarPanelBotones()
	{
		panelOpciones.setLayout(null);
		panelOpciones.setBorder(BorderFactory.createLineBorder(Color.black));
		panelOpciones.setBounds(0,0, ancho, 160);
		
		int i;
		nombres = new String[8];
		market = new JButton[8];
		
		//PERSONAJES
		nombres[0]="SoldadoQuieto.png";
		nombres[1]="ArqueroQuieto.png";
		nombres[2]="DragonQuieto.png";
		nombres[3]="LoboQuieto.png";
		nombres[4]="BallestaQuieto.png";
		
		//OBJETOS
		nombres[5]="Piedra.png";
		nombres[6]="Muro.png";
		nombres[7]="DragonQuieto.png";
		
		for(i=0;i<5;i++)
		{
			market[i]=new JButton();
			market[i].setBounds(0+(i*60), 0, 60, 60);
			market[i].setIcon(new ImageIcon(this.getClass().getResource("/sources/"+nombres[i])));
			market[i].setActionCommand(""+i);
			market[i].addActionListener(new OyenteAgregar());
			panelOpciones.add(market[i]);
		}
		
		int cont = 0;
		for(int j=i;j<i+3;j++)
		{
			market[j]=new JButton();
			market[j].setBounds(0+(cont*60), 60, 60, 60);
			market[j].setIcon(new ImageIcon(this.getClass().getResource("/sources/"+nombres[j])));
			market[j].setActionCommand(""+j);
			market[j].addActionListener(new OyenteAgregar());
			panelOpciones.add(market[j]);
			cont++;
		}
		

		etiquetaPuntos = new JLabel("Puntos: "+juego.getPuntos());
		etiquetaPuntos.setBounds(ancho-100,0 , 80, 20);
		
		etiquetaMonedas = new JLabel("Monedas: "+juego.getMonedas());
		etiquetaMonedas.setBounds(ancho-200,0 , 80, 20);
		
		panelOpciones.add(etiquetaMonedas);
		panelOpciones.add(etiquetaPuntos);
	}
	
	private void inicializarPanelJuego()
	{
		panelJuego.setLayout(null);
		panelJuego.setBackground(new Color(135,206,255));
		panelJuego.setBounds(0, 160, ancho, alto);
		
		for(int i=0;i<cantFilas;i++)
		{
			for(int j=0;j<cantColumnas;j++)
			{
				Iterator<Contenido> it = mapa.getCelda(i,j).getContenido();
				while(it.hasNext())
				{
					etiqueta = it.next().getGrafico();
					etiqueta.setBounds(j,i*80,80,80);
					panelJuego.add(etiqueta);
				}
			}
		}
		
		panelJuego.addMouseListener(new OyentePanelMouse());
	}
	
	public void refrescar()
	{
		for(int i=0;i<cantFilas;i++)
		{
			for(int j=0;j<cantColumnas;j++)
			{
				Iterator<Contenido> it = mapa.getCelda(i,j).getContenido();
				while(it.hasNext())
				{
					etiqueta = it.next().getGrafico();
					etiqueta.setBounds(j,i*80,80,80);
				}
			}
		}
		etiquetaPuntos.setText("Puntos: "+juego.getPuntos());
		etiquetaMonedas.setText("Monedas: "+juego.getMonedas());
	}
	
	public JPanel getPanelJuego()
	{
		return panelJuego;
	}
	
	public void agregar(JLabel j)
	{
		panelJuego.add(j);
	}
	
	public void terminar(boolean gano)
	{
		this.dispose();
	}
	
	public void nuevoJuego()
	{
		
	}
	
	private class OyenteAgregar implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
        	fabricado = Integer.parseInt(e.getActionCommand());
        }
    }
	
	private class OyentePanelMouse implements MouseListener {
        public void mousePressed(MouseEvent e)
        {
        	int i = e.getY() / 80;
        	int j = e.getX();
        	
        	if(fabricado>=0)
        	{
        		Celda aux = mapa.getCelda(i, j);
        		Contenido nuevo=null;
    			switch (fabricado) {
                case 0:  nuevo = fabricaPersonajes.crearSoldado(aux);
                         break;
                case 1:  nuevo = fabricaPersonajes.crearArquero(aux);
                         break;
                case 2:  nuevo = fabricaPersonajes.crearDragon(aux);
                         break;
                case 3:  nuevo = fabricaPersonajes.crearLobo(aux);
                		 break;
                case 4:  nuevo = fabricaPersonajes.crearBallesta(aux);
       		 			 break;
                case 5:  nuevo = fabricaObjetos.crearPiedra(aux);
                		 break;
                case 6:  nuevo = fabricaObjetos.crearMuralla(aux);
                		 break;
                case 7:  nuevo = fabricaObjetos.crearBomba(aux);
       		 			 break;
            	}
    			
        		if(!aux.ocupado(nuevo.getPosicion()))
        		{
        			aux.agregar(nuevo);
        			panelJuego.add(nuevo.getGrafico());
        		}
        		
        		fabricado=-1;	
        	}
        }
        
        public void mouseEntered(MouseEvent e)
        {
        }
        
        public void mouseExited(MouseEvent e)
        {
        }
        
        public void mouseClicked(MouseEvent e)
        {
        }
        
        public void mouseReleased(MouseEvent e)
        {
        }
    }

}
