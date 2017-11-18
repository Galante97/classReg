package classAlert;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class mainClass {
	public static void main(String[] args) {
		/*// take the menu bar off the jframe
		System.setProperty("apple.laf.useScreenMenuBar", "true");

		// set the name of the application menu item
		System.setProperty("com.apple.mrj.application.apple.menu.about.name", "ImageRotator");

		// set the look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} */

		firstClass aClass = new firstClass();

		try {
			aClass.checkUdelClasses();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
