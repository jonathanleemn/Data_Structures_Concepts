package frameGUIPersonExample;
import javax.swing.JFrame;


public class FrameGUITester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FrameGUIEx newGUI=new FrameGUIEx();
		newGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newGUI.setSize(200, 220);
		newGUI.setVisible(true);

	}

}
