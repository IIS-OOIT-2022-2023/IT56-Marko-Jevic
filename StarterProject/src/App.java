
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class App {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setSize(900, 600);
		frame.setTitle("Fake Paint");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon icon = new ImageIcon("../icon1.png");
		frame.setIconImage(icon.getImage());

		frame.setVisible(true);
	}

}
