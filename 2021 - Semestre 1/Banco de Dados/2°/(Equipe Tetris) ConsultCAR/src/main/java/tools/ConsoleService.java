package tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JTextArea;

public class ConsoleService {
	

	public void carregarConsole(JTextArea console) {
		
		Path caminho = Paths.get("C:\\Users\\Davi Machado\\Desktop\\ConsultCar\\log.txt");
			
		try {
			byte[] texto = Files.readAllBytes(caminho);
			String leitura = new String(texto);
			console.setText(leitura);
			//JOptionPane.showMessageDialog(null, leitura);
				
		} catch (IOException erro) {
					
			}

	}
}
