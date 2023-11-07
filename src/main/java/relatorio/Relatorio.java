package relatorio;

public interface Relatorio<G> {

	<PdfPTable> void gerarRelatorio(G objeto);
}
