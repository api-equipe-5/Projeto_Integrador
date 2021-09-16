package DigiCont;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

public class TelaRelatorio {

	JFrame frmRelatrio;
	protected Object frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorio window = new TelaRelatorio();
					window.frmRelatrio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaRelatorio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRelatrio = new JFrame();
		frmRelatrio.setTitle("RELAT\u00D3RIO");
		frmRelatrio.getContentPane().setBackground(Color.WHITE);
		frmRelatrio.setBounds(100, 100, 960, 720);
		frmRelatrio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRelatrio.setLocationRelativeTo(null);

	}

}
