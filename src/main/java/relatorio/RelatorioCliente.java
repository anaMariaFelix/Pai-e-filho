package relatorio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import dto.ClienteDTO;
import util.Constantes;

public class RelatorioCliente<G> implements Relatorio<G>{

	
	public <PdfPTable> void gerarRelatorio(G objetoCliente){
		ClienteDTO cliente = (ClienteDTO)objetoCliente;
		
		Document doc = new Document(PageSize.A4);
		
		FileOutputStream pdf = null;

		try {
			pdf = new FileOutputStream(Constantes.RELATORIO_CLIENTE);
			PdfWriter.getInstance(doc, pdf);

			doc.open();

			Paragraph p = new Paragraph("RELATÓRIO CLIENTE");
			p.setAlignment(p.ALIGN_CENTER);
			doc.add(p);

			p = new Paragraph(" ");
			doc.add(p);

			p = new Paragraph(" ");
			doc.add(p);
		
			p = new Paragraph("Informações Pessoas do Cliente:");
			doc.add(p);

			p = new Paragraph(" ");
			doc.add(p);

			p = new Paragraph("Nome: " + cliente.getNome());
			doc.add(p);
			
			p = new Paragraph("Telefone: " + cliente.getTelefone());
			doc.add(p);
			
			p = new Paragraph("Email: " + cliente.getEmail());
			doc.add(p);
			
			p = new Paragraph("CPF: " + cliente.getCpf());
			doc.add(p);
			
			p = new Paragraph("Apto para Notificações: " + (cliente.isNotificacao()? "Sim": "Não"));
			doc.add(p);
			
			doc.close();

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}


}
