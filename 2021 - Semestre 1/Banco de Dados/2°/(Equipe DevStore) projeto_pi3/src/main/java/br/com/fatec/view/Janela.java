package br.com.fatec.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Janela {
	
	public JFrame frame;
	public JPanel panel;
	public JButton btnProcessar;
	public JTextArea txaLog;
	public JScrollPane sclLog;
	
	public Janela() {
		frame = new JFrame("DevStore - CAR");
		panel = new JPanel();
		btnProcessar = new JButton("Processar");
		txaLog = new JTextArea(20, 40);
		sclLog = new JScrollPane(txaLog);
		
		sclLog.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		txaLog.setEditable(false);
		panel.add(sclLog);
		panel.add(btnProcessar);
		frame.setSize(550, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		
	}

}
