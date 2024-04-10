package clase10del4;

import views.ventana;

public class Principal {

	public static void main(String[] args) {
		try {
			ventana frame = new ventana();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
