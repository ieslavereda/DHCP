package es.ieslavereda.DHCP;

import java.awt.EventQueue;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import es.ieslavereda.DHCP.controller.ControladorPrincipal;
import es.ieslavereda.DHCP.model.Model;
import es.ieslavereda.DHCP.view.Principal;

import javax.swing.UIManager.LookAndFeelInfo;

public class App {
public static void main( String[] args ) {
		
    	EventQueue.invokeLater(new Runnable() {
			public void run() {

				// se crean los objetos MODELO y VISTA
				Model modelo = new Model();
				Principal vista = new Principal();
				
				// Para colocar un skin propio de java
				try {
					
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							SwingUtilities.updateComponentTreeUI(vista);
							break;
						}
					}

					new ControladorPrincipal(vista, modelo).go();
					
				} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
					ex.printStackTrace();
				} 
			}
    	});
	}
}
