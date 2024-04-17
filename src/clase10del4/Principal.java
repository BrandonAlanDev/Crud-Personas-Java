package clase10del4;

import javax.swing.SwingUtilities;

import views.Paises;
import views.ventana;

public class Principal {

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeLater(() -> {
	            new ventana().setVisible(true);
	        });
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			SwingUtilities.invokeLater(() -> {
	            new Paises().setVisible(true);
	        });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
