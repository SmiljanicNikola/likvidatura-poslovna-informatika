package pi.likvidatura.domain;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class FakturaPDFExporter {
	
	private List<IzlaznaFaktura> listaIzlaznihFaktura;

	public FakturaPDFExporter(List<IzlaznaFaktura> listaIzlaznihFaktura) {
		super();
		this.listaIzlaznihFaktura = listaIzlaznihFaktura;
	}
	
	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		
		cell.setBackgroundColor(Color.YELLOW);
		cell.setPadding(6);
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.BLACK);
		
		cell.setPhrase(new Phrase("Faktura ID", font));
		
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Broj Fakture", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Pocetni iznos za placanje", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Poziv na broj", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Preostali iznos za placanje", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Status Fakture", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Poslovna godina ID", font));
		table.addCell(cell);
		
		
	}
	
	private void writeTableData(PdfPTable table) {
		for(IzlaznaFaktura faktura : listaIzlaznihFaktura) {
			table.addCell(String.valueOf(faktura.getId()));
			table.addCell(faktura.getBrojFakture());
			table.addCell(String.valueOf(faktura.getPocetniIznosZaPlacanje()));
			table.addCell(faktura.getPozivNaBroj());
			table.addCell(String.valueOf(faktura.getPreostaliIznosZaPlacanje()));
			table.addCell(faktura.getStatusFakture());
			table.addCell(String.valueOf(faktura.getPoslovnaGodina()));

		}
	}
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setColor(Color.BLACK);
		font.setSize(18);
		
		
		Paragraph title = new Paragraph("Lista Izlaznih Faktura",font);
		title.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(title);
		
		PdfPTable table = new PdfPTable(7);
		table.setWidthPercentage(100);
		table.setSpacingBefore(15);
		table.setWidths(new float[] {2.7f, 3.0f, 3.0f, 3.0f, 3.0f,3.0f,3.0f});
		
		
		writeTableHeader(table);
		writeTableData(table);

		document.add(table);
		
		document.close();
	}
	

}
