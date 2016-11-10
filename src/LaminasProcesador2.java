

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;

/**
 * @author Daniel
 * 25 de jun. de 2016
 */
public class LaminasProcesador2 extends JPanel{

	private JTextPane area;
	private ButtonGroup grupo = new ButtonGroup();
	private JMenu tipo, formato, tamano;
	private String[] jmenus = {"Tipo", "Tipo", "Tipo", "Formato", "Formato", "Tamaño", "Tamaño", "Tamaño", "Tamaño"};
	private String[] menus = {"Serif", "Dialog", "Monospaced", "Negrita", "Cursiva", "8", "12", "16", "20"};
	private String[] tipos = {"Serif", "Dialog", "Monospaced", "", "", "", "", "", ""};
	private int[] formatos = {9, 9, 9, Font.BOLD, Font.ITALIC, 9, 9, 9, 9};
	private int[] tamanos = {12, 12, 12, 12, 12, 8, 12, 16, 20};
	
	public LaminasProcesador2(){
		
		setLayout(new BorderLayout());
		
		area = new JTextPane();
		JScrollPane scroll = new JScrollPane(area);

		JPanel laminaNorte = new JPanel();
		laminaNorte.setLayout(new BorderLayout());
		
		JMenuBar barra = new JMenuBar();
		
		tipo = new JMenu("Tipo");
		formato = new JMenu("Formato");
		tamano = new JMenu("Tamaño");
		barra.add(tipo);
		barra.add(formato);
		barra.add(tamano);
		
		for(int i=0; i<tipos.length; i++){
			
			submenus(jmenus[i], menus[i], tipos[i], formatos[i], tamanos[i]);
		}

		laminaNorte.add(barra, BorderLayout.NORTH);
		
		add(laminaNorte, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		
		JPopupMenu emergente = new JPopupMenu();
		JMenuItem negritaE = new JMenuItem("Negrita");
		JMenuItem cursivaE = new JMenuItem("Cursiva");
		negritaE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		negritaE.addActionListener(new StyledEditorKit.BoldAction());
		cursivaE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
		cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
		emergente.add(negritaE);
		emergente.add(cursivaE);
		
		area.setComponentPopupMenu(emergente);
		
		//Creacion barra herramientas
		JToolBar barraH = new JToolBar();
		
		JButton negritaH = new JButton(new ImageIcon("C:/negrita.gif"));
		JButton cursivaH = new JButton(new ImageIcon("C:/cursiva.gif"));
		JButton subrayadoH = new JButton(new ImageIcon("C:/subrayado.gif"));
		JButton azulH = new JButton(new ImageIcon("C:/azul.gif"));
		JButton rojoH = new JButton(new ImageIcon("C:/rojo.gif"));
		JButton amarilloH = new JButton(new ImageIcon("C:/amarillo.gif"));
		JButton izquierdaH = new JButton(new ImageIcon("C:/izquierda.gif"));
		JButton centradoH = new JButton(new ImageIcon("C:/centrado.gif"));
		JButton derechaH = new JButton(new ImageIcon("C:/derecha.gif"));
		JButton justificadoH = new JButton(new ImageIcon("C:/justificado.gif"));
		
		negritaH.addActionListener(new StyledEditorKit.BoldAction());
		cursivaH.addActionListener(new StyledEditorKit.ItalicAction());
		subrayadoH.addActionListener(new StyledEditorKit.UnderlineAction());
		azulH.addActionListener(new StyledEditorKit.ForegroundAction("PonAzul", Color.BLUE));
		rojoH.addActionListener(new StyledEditorKit.ForegroundAction("PonRojo", Color.RED));
		amarilloH.addActionListener(new StyledEditorKit.ForegroundAction("PonAmarillo", Color.YELLOW));
		izquierdaH.addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
		centradoH.addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));
		derechaH.addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));
		justificadoH.addActionListener(new StyledEditorKit.AlignmentAction("Justificado", 3));
		
		barraH.add(negritaH);
		barraH.add(cursivaH);
		barraH.add(subrayadoH);
		barraH.addSeparator();
		barraH.add(azulH);
		barraH.add(rojoH);
		barraH.add(amarilloH);
		barraH.addSeparator();
		barraH.add(izquierdaH);
		barraH.add(centradoH);
		barraH.add(derechaH);
		barraH.add(justificadoH);
		
		
		laminaNorte.add(barraH, BorderLayout.SOUTH);
	}
	
	private void submenus(String jmenu, String menu, String tipoLetra, int estilo, int tam){
		
		JMenuItem elemento;
		JRadioButtonMenuItem tamagno;
		
		if(jmenu=="Tipo"){
			
			elemento = new JMenuItem(menu);
			Font fuenteMenusTipo = tipo.getFont();
			
			tipo.add(elemento);
			if(tipoLetra=="Serif"){
				
				elemento.addActionListener(new StyledEditorKit.FontFamilyAction("cambioLetra", "Serif"));
			}else if(tipoLetra=="Dialog"){
				
				elemento.addActionListener(new StyledEditorKit.FontFamilyAction("cambioLetra", "Dialog"));
			}else{
				
				elemento.addActionListener(new StyledEditorKit.FontFamilyAction("cambioLetra", "Monospaced"));
			}
			
			elemento.setFont(new Font(tipoLetra, fuenteMenusTipo.getStyle(), fuenteMenusTipo.getSize()));
			
		}else if(jmenu == "Formato"){
			
			elemento = new JMenuItem(menu);
			Font fuenteMenusFormato = formato.getFont();
			
			formato.add(elemento);
			
			if(estilo==Font.BOLD){
				
				elemento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
				
				elemento.addActionListener(new StyledEditorKit.BoldAction());
			}else{
				
				elemento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
				
				elemento.addActionListener(new StyledEditorKit.ItalicAction());
			}
			
			elemento.setFont(new Font(fuenteMenusFormato.getFontName(), estilo, fuenteMenusFormato.getSize()));
			
		}else{
			
			tamagno = new JRadioButtonMenuItem(menu);
			grupo.add(tamagno);
			tamano.add(tamagno);
			
			tamagno.addActionListener(new StyledEditorKit.FontSizeAction("cambioTamano", tam));
		}
	}
}
