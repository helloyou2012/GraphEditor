package xuzhenzhen.structure.test;

import xuzhenzhen.structure.view.GraphFrame;

public class GraphTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}*/
		GraphFrame frame=new GraphFrame();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
