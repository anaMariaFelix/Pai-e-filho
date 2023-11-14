package relatorio;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import dto.PedidoDTO;
import util.Constantes;

public class RelatorioPedido<G> implements Relatorio<G>{

	public <PdfPTable> void gerarRelatorio(G objetoPedido ){

		PedidoDTO pedido = (PedidoDTO)objetoPedido;
		
		Document doc = new Document(PageSize.A4);
		
		FileOutputStream pdf = null;

		try {
			pdf = new FileOutputStream(Constantes.RELATORIO_PEDIDO);
			PdfWriter.getInstance(doc, pdf);

			doc.open();

			Paragraph p = new Paragraph("RELATÓRIO PEDIDO");
			p.setAlignment(p.ALIGN_CENTER);
			doc.add(p);

			p = new Paragraph(" ");
			doc.add(p);

			p = new Paragraph(" ");
			doc.add(p);

			p = new Paragraph(" ");
			doc.add(p);
			
			p = new Paragraph(" ");
			doc.add(p);
			
			p = new Paragraph("Informações do Cliente:");
			doc.add(p);
			
			p = new Paragraph(" ");
			doc.add(p);

			p = new Paragraph("Nome: " + pedido.getNomeCliente());
			doc.add(p);
			
			p = new Paragraph("Email: " + pedido.getEmailCliente());
			doc.add(p);
			
			p = new Paragraph("Telefone: " + pedido.getTelefone());
			doc.add(p);
			
			p = new Paragraph(" ");
			doc.add(p);
			
			p = new Paragraph("Informações do Pedido:");
			doc.add(p);
			
			p = new Paragraph(" ");
			doc.add(p);
			
			p = new Paragraph("Serviço escolhido: " + pedido.getServico());
			doc.add(p);
			
			p = new Paragraph("Valor: " + pedido.getValor());
			doc.add(p);
			
			p = new Paragraph("Descrição adicionais do pedido: " + pedido.getDescricao());
			doc.add(p);

			doc.close();

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}

}
