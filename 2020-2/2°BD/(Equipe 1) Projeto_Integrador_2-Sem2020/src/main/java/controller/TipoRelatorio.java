package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert.AlertType;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.DocListener;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import javafx.scene.control.Alert;
import com.itextpdf.text.ListItem;
import javafx.scene.control.ButtonType;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import classes.Cliente;
import classes.Instalacao;
import conexao.ConexaoBd;

import application.Main;

public class TipoRelatorio implements Initializable {
	   @FXML
	   private Button btnRelatorioLuz;
	   @FXML
       private Button btnRelatorioAgua;
       @FXML
       private Button btnRetornarTipoR;
       @FXML
       private Button btnRelatorioCliente;
       @FXML
       private Button btnGerarPDF;
       @FXML
        private TextField txtBuscarInstalacao;
        private static String FILE = "Relatorio.pdf";
        private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18);
        private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.BLUE);
        private static Instalacao i = new Instalacao();

        @Override
        public void initialize(URL arg0, ResourceBundle arg1) {
            // TODO Auto-generated method stub
        }

        public void changeScreenRelatorioAgua(ActionEvent event) {
            Main.changeScreen("relatorioagua");
        }

        public void changeScreenRelatorioLuz(ActionEvent event) {
            Main.changeScreen("relatorioenergia");
        }

        public void changeScreenRelatorioCliente(ActionEvent event) {
            Main.changeScreen("relatoriocliente");
        }

        public void changeScreenRetornar(ActionEvent event) {
            Main.changeScreen("main");
        }

        public void gerarRelatorio(ActionEvent event) {
            i.setInt_numero_instalacao(BigInteger.valueOf(Long.parseLong(txtBuscarInstalacao.getText())));
            try {
                Document document = new Document(PageSize.A4);
                PdfWriter.getInstance(document, new FileOutputStream(FILE));
                document.open();
                addMetaData(document);
                addTitlePage(document);

                document.close();
                Alert Alert = new Alert(AlertType.INFORMATION);
                Alert.setTitle("PDF salvo");
                Alert.setHeaderText(null);
                Alert.setContentText("O PDF com o relatório foi salvo na pasta em que você iniciou o aplicativo");
                Alert.showAndWait(); 
                txtBuscarInstalacao.setText("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static void addMetaData(Document document) {
            document.addTitle("Relatório");
            document.addSubject("Using iText");
            document.addKeywords("Java, PDF, iText");
        }

        private static void addTitlePage(Document document) throws DocumentException {
            Paragraph preface = new Paragraph();

            addEmptyLine(preface, 1);

            preface.add(new Paragraph("Relatorios cliente", catFont));

            addEmptyLine(preface, 1);

            createTable(preface);
            document.add(preface);

            PdfPTable table = new PdfPTable(4);

            PdfPTable table2 = new PdfPTable(4);

            PdfPTable table3 = new PdfPTable(4);

            PdfPTable table4 = new PdfPTable(5);

            PdfPTable table5 = new PdfPTable(4);

            PdfPTable table6 = new PdfPTable(3);

            PdfPCell c1 = new PdfPCell(new Phrase("Número de instalação", redFont));
            c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(c1);

            PdfPCell c2 = new PdfPCell(new Phrase("Nome cliente", redFont));
            c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(c2);

            PdfPCell c3 = new PdfPCell(new Phrase("Doc cliente", redFont));
            c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(c3);

            PdfPCell c4 = new PdfPCell(new Phrase("Nome fornecedor", redFont));
            c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(c4);

            PdfPCell c5 = new PdfPCell(new Phrase("CNPJ fornecedor", redFont));
            c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            table2.addCell(c5);

            PdfPCell c6 = new PdfPCell(new Phrase("CEP", redFont));
            c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            table2.addCell(c6);

            PdfPCell c7 = new PdfPCell(new Phrase("Rua", redFont));
            c7.setHorizontalAlignment(Element.ALIGN_LEFT);
            table2.addCell(c7);

            PdfPCell c8 = new PdfPCell(new Phrase("Número", redFont));
            c8.setHorizontalAlignment(Element.ALIGN_LEFT);
            table2.addCell(c8);

            Connection con = ConexaoBd.getConnection();

            PreparedStatement stmt = null;
            ResultSet rs = null;

            try {
                stmt = con.prepareStatement(
                        "SELECT int_numero_instalacao,cli_nome,cli_cliente.cli_documento,for_nome,for_fornecedor.for_cnpj,int_instalacao.cep_cep,cep_cep.cep_rua,int_instalacao.end_numero FROM cli_cliente,int_instalacao,for_fornecedor,end_endereco,cep_cep WHERE cli_cliente.cli_documento = int_instalacao.cli_documento and for_fornecedor.for_cnpj = int_instalacao.for_cnpj and int_instalacao.cep_cep = end_endereco.cep_cep and int_instalacao.end_numero = end_endereco.end_numero and end_endereco.cep_cep = cep_cep.cep_cep and int_numero_instalacao = ?");
                stmt.setObject(1, i.getInt_numero_instalacao());
            rs = stmt.executeQuery();

            while (rs.next()) {
            	table.addCell(rs.getString("int_numero_instalacao"));
            	table.addCell(rs.getString("cli_nome"));
            	table.addCell(rs.getString("cli_documento"));
            	table.addCell(rs.getString("for_nome"));
            	table2.addCell(rs.getString("for_cnpj"));
            	table2.addCell(rs.getString("cep_cep"));
            	table2.addCell(rs.getString("cep_rua"));
            	table2.addCell(rs.getString("end_numero"));
            }
        } catch (SQLException ex) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }

       document.add(table);      
       document.add(table2);
       	
       document.newPage();
       
       Paragraph preface2 = new Paragraph();  
       addEmptyLine(preface2, 1);
      
       
       preface2.add(new Paragraph("Relatorio Água", catFont));
       
       addEmptyLine(preface2, 1);
       
       document.add(preface2);
       
       PdfPCell c9 = new PdfPCell(new Phrase("Número instalação",redFont));
       c9.setHorizontalAlignment(Element.ALIGN_LEFT );   
       table3.addCell(c9);
   
       PdfPCell c10 = new PdfPCell(new Phrase("Mês referência",redFont));
       c10.setHorizontalAlignment(Element.ALIGN_LEFT);
       table3.addCell(c10);
       
       PdfPCell c11 = new PdfPCell(new Phrase("Tipo ligação",redFont));
       c11.setHorizontalAlignment(Element.ALIGN_LEFT);
       table3.addCell(c11);     
       
       PdfPCell c12 = new PdfPCell(new Phrase("Hidrômetro",redFont));
       c12.setHorizontalAlignment(Element.ALIGN_LEFT);
       table3.addCell(c12);
       
       PdfPCell c13 = new PdfPCell(new Phrase("Consumo",redFont));
       c13.setHorizontalAlignment(Element.ALIGN_LEFT );   
       table4.addCell(c13);
   
       PdfPCell c14 = new PdfPCell(new Phrase("Valor Água",redFont));
       c14.setHorizontalAlignment(Element.ALIGN_LEFT);
       table4.addCell(c14);
       
       PdfPCell c15 = new PdfPCell(new Phrase("Valor esgoto",redFont));
       c15.setHorizontalAlignment(Element.ALIGN_LEFT);
       table4.addCell(c15);     
       
       PdfPCell c16 = new PdfPCell(new Phrase("Taxa Regulamento",redFont));
       c16.setHorizontalAlignment(Element.ALIGN_LEFT);
       table4.addCell(c16);
       
       PdfPCell c17 = new PdfPCell(new Phrase("Multa",redFont));
       c17.setHorizontalAlignment(Element.ALIGN_LEFT);
       table4.addCell(c17);

        try {
        	stmt = con.prepareStatement("SELECT int_numero_instalacao,cta_mes_referencia,agu_tipo_ligacao,agu_hidrometro,agu_consumo,agu_valor_agua,agu_valor_esgoto,agu_taxa_regulamentacao,agu_multa FROM agu_agua WHERE int_numero_instalacao = ?");
            stmt.setObject(1,i.getInt_numero_instalacao());
            rs = stmt.executeQuery();

            while (rs.next()) {
            	table3.addCell(rs.getString("int_numero_instalacao"));
            	table3.addCell(rs.getString("cta_mes_referencia"));
            	table3.addCell(rs.getString("agu_tipo_ligacao"));
            	table3.addCell(rs.getString("agu_hidrometro"));
            	table4.addCell(rs.getString("agu_consumo"));
                table4.addCell(rs.getString("agu_valor_agua"));
                table4.addCell(rs.getString("agu_valor_esgoto"));
                table4.addCell(rs.getString("agu_taxa_regulamentacao"));
                table4.addCell(rs.getString("agu_multa"));
            }
        } catch (SQLException e) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, e);
        }
       document.add(table3);
       document.add(table4);
       
       document.newPage();
       
       Paragraph preface3 = new Paragraph();  
      
       addEmptyLine(preface3, 1);
      
       preface3.add(new Paragraph("Relatorio energia", catFont));
       
       addEmptyLine(preface3, 1);
       
       document.add(preface3);
       
       PdfPCell c25 = new PdfPCell(new Phrase("Número instalação",redFont));
       c25.setHorizontalAlignment(Element.ALIGN_LEFT );   
       table5.addCell(c25);
   
       PdfPCell c18 = new PdfPCell(new Phrase("Mês referência",redFont));
       c18.setHorizontalAlignment(Element.ALIGN_LEFT);
       table5.addCell(c18);
       
       PdfPCell c19 = new PdfPCell(new Phrase("Consumo",redFont));
       c19.setHorizontalAlignment(Element.ALIGN_LEFT);
       table5.addCell(c19);     
       
       PdfPCell c20 = new PdfPCell(new Phrase("N° Medidor",redFont));
       c20.setHorizontalAlignment(Element.ALIGN_LEFT);
       table5.addCell(c20);
       
       PdfPCell c21 = new PdfPCell(new Phrase("Bandeira",redFont));
       c21.setHorizontalAlignment(Element.ALIGN_LEFT );   
       table6.addCell(c21);
   
       PdfPCell c22 = new PdfPCell(new Phrase("Tensão nominal",redFont));
       c22.setHorizontalAlignment(Element.ALIGN_LEFT);
       table6.addCell(c22);
       
       PdfPCell c23 = new PdfPCell(new Phrase("Valor total",redFont));
       c23.setHorizontalAlignment(Element.ALIGN_LEFT);
       table6.addCell(c23);   
       
       try {
        	stmt = con.prepareStatement("SELECT int_numero_instalacao,cta_mes_referencia,ene_consumo_conta_mes,ene_tensao_nominal,ene_numero_medidor,ene_tipo_bandeira,ene_valor_total FROM ene_energia WHERE int_numero_instalacao = ?");
            stmt.setObject(1,i.getInt_numero_instalacao());
            rs = stmt.executeQuery();

            while (rs.next()) {
            	table5.addCell(rs.getString("int_numero_instalacao"));
            	table5.addCell(rs.getString("cta_mes_referencia"));
            	table5.addCell(rs.getString("ene_consumo_conta_mes"));
            	table5.addCell(rs.getString("ene_numero_medidor"));
            	table6.addCell(rs.getString("ene_tipo_bandeira"));
                table6.addCell(rs.getString("ene_tensao_nominal"));
                table6.addCell(rs.getString("ene_valor_total"));
            }
        } catch (SQLException e) {
           Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, e);

        // Finally usado para fechar a conexao e statement se der ou nÃ£o erro
        } finally {
            ConexaoBd.closeConnection(con, stmt);
        }
       
       document.add(table5);
       document.add(table6);
    }

   public static  void createTable(Paragraph preface)
            throws BadElementException {       

    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}