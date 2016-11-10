

import javax.swing.JFrame;

/**
 * @author Daniel
 * 25 de jun. de 2016
 */
public class MarcoProcesador2 extends JFrame{

	public MarcoProcesador2(){
		
		setTitle("Procesador de texto sencillo");
		setBounds(500, 250, 500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LaminasProcesador2 lamina = new LaminasProcesador2();
		add(lamina);
		
		setVisible(true);
	}
}
