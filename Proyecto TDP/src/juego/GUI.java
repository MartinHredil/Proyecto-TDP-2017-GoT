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
	protected JLabel etiquetaInformacion;
	protected JLabel etiquetaMarket;
	
	protected JButton market[];
	protected String nombres[];
	
	public GUI(Juego j)
	{
		juego = j;
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
		
		//Panel con etiqueta de fondo
		JPanel panelFondo = new JPanel();
		panelFondo.setLayout(null);
		panelFondo.setBounds(0, 160, ancho, alto);
		panelFondo.setOpaque(false);
	    
		JLabel fondo = new JLabel();
	    fondo.setIcon(new ImageIcon(this.getClass().getResource("/sources/FondoJuego.png")));
	    fondo.setBounds(0, 0, ancho, alto);
	    panelFondo.add(fondo);
	    
	    //Panel con efecto nevando
	    JPanel panelNevando = new JPanel();
	    panelNevando.setLayout(null);
		panelNevando.setBounds(0, 160, ancho, alto);
		panelNevando.setOpaque(false);
		
		JLabel nevando = new JLabel();
	    nevando.setIcon(new ImageIcon(this.getClass().getResource("/sources/Nevando.gif")));
	    nevando.setBounds(0, 0, ancho, alto);
	    panelNevando.add(nevando);
		
		
	    getContentPane().setBackground(Color.green);
		
		getContentPane().add(panelOpciones);
		getContentPane().add(panelNevando);
		getContentPane().add(panelJuego);
		getContentPane().add(panelFondo);
		
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void inicializarPanelBotones()
	{
		panelOpciones.setLayout(null);
		panelOpciones.setBorder(BorderFactory.createLineBorder(Color.black));
		panelOpciones.setBounds(0,0, ancho, 160);
		
		
		
		int i;
		nombres = new String[10];
		market = new JButton[10];
		
		//PERSONAJES
		nombres[0]="SoldadoQuieto.png";
		nombres[1]="ArqueroQuieto.png";
		nombres[2]="DragonQuieto.png";
		nombres[3]="LoboQuieto.png";
		nombres[4]="BallestaQuieto.png";
		nombres[5]="Torre60.png";
		
		//OBJETOS
		nombres[6]="Piedra.png";
		nombres[7]="Muro.png";
		nombres[8]="BombaQuieto.png";
		nombres[9]="Muro60x60.png";
		
		for(i=0;i<6;i++)
		{
			market[i]=new JButton();
			market[i].setBounds(0+(i*60), 20, 60, 60);
			market[i].setIcon(new ImageIcon(this.getClass().getResource("/sources/"+nombres[i])));
			market[i].setActionCommand(""+i);
			market[i].addActionListener(new OyenteAgregar());
			panelOpciones.add(market[i]);
		}
		
		int cont = 0;
		for(int j=i;j<i+4;j++)
		{
			market[j]=new JButton();
			market[j].setBounds(0+(cont*60), 80, 60, 60);
			market[j].setIcon(new ImageIcon(this.getClass().getResource("/sources/"+nombres[j])));
			market[j].setActionCommand(""+j);
			market[j].addActionListener(new OyenteAgregar());
			panelOpciones.add(market[j]);
			cont++;
		}
		
		etiquetaMarket = new JLabel("MarketPlace");
		etiquetaMarket.setBounds(120, 0, 500, 25);
		
		etiquetaInformacion = new JLabel("NO DISPONE DE DINERO SUFICIENTE");
		etiquetaInformacion.setBounds(5, 140, 500, 25);

		etiquetaPuntos = new JLabel("Puntos: "+juego.getPuntos());
		etiquetaPuntos.setBounds(ancho-100,0 , 80, 20);
		
		etiquetaMonedas = new JLabel("Monedas: "+juego.getMonedas());
		etiquetaMonedas.setBounds(ancho-200,0 , 80, 20);
		
		panelOpciones.add(etiquetaMarket);
		panelOpciones.add(etiquetaInformacion);
		panelOpciones.add(etiquetaMonedas);
		panelOpciones.add(etiquetaPuntos);
	}
	
	private void inicializarPanelJuego()
	{
		panelJuego.setLayout(null);
		panelJuego.setBackground(new Color(135,206,255));
		panelJuego.setBounds(0, 160, ancho, alto);
		panelJuego.setOpaque(false);
		
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
					Contenido c = it.next();
					if(c!=null)
					{
						etiqueta = c.getGrafico();
						etiqueta.setBounds(j,i*80,80,80);
					}
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
		if(j!=null)
		{
			panelJuego.add(j);
		}
	}
	
	public boolean terminar(boolean gano)
	{
		
		boolean respuesta=false;
		
		if(gano)
		{
			int seleccion = JOptionPane.showOptionDialog( null,"FELICIDADES, GANASTE",
					  "Selector de opciones",JOptionPane.YES_NO_CANCEL_OPTION,
					   JOptionPane.QUESTION_MESSAGE,null,// null para icono por defecto.
					  new Object[] { "Nivel Siguiente", "Cerrar"},"Nivel Siguiente");
					      
			if(seleccion==0) respuesta = true;
			else respuesta = false;
		}
		else
		{
			int seleccion = JOptionPane.showOptionDialog( null,"USTED PERDIO",
					  "Selector de opciones",JOptionPane.YES_NO_CANCEL_OPTION,
					   JOptionPane.QUESTION_MESSAGE,null,// null para icono por defecto.
					  new Object[] { "Jugar de Nuevo", "Cerrar"},"Jugar de Nuevo");
					      
			if(seleccion==0) respuesta = true;
			else respuesta = false;
		}
		
		this.dispose();
		return respuesta;
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
                case 5:  nuevo = fabricaPersonajes.crearTorre(aux);
		 			 	 break;
                case 6:  nuevo = fabricaObjetos.crearPiedra(aux);
                		 break;
                case 7:  nuevo = fabricaObjetos.crearMuralla(aux);
                		 break;
                case 8:  nuevo = fabricaObjetos.crearBomba(aux);
       		 			 break;
                case 9:  nuevo = fabricaObjetos.crearMuro(aux);
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
