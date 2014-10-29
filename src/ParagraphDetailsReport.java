import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;




public class ParagraphDetailsReport {
	private static Document document;
	private static String text = "\tLorem Ipsum is simply dummy text of the printing and typesetting\t industry.\nLorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
	
	static Font font8 = new Font(Font.HELVETICA, 		8);
	static Font font9italic = new Font(Font.HELVETICA, 		9, Font.ITALIC);
	static Font font8boldUnder = new Font(Font.HELVETICA, 		8, Font.BOLD | Font.UNDERLINE);
	static Font font9bold = new Font(Font.HELVETICA, 		9);
	static Font font9 = new Font(Font.HELVETICA, 		9);
	
	static Font font10 = new Font(Font.TIMES_ROMAN, 	10);
	static Font font10bold = new Font(Font.TIMES_ROMAN, 	10, Font.BOLD);
	static String headerLabel = "Bank Assessment Detail";
	static String headerRegulation = "Regulation: %s";
	static String headerAssDate = "Assessment Date: %s";
	static String headerAssCriteria = "Assessment Criteria: %s";
	int pdfHeight;
	int pdfWidth;
	private ParagraphDetailsData reportData;
	
	
	
	public void generateReport(OutputStream os) throws DocumentException, IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfWriter docWriter = null;
		//HeaderFooterX event = new HeaderFooterX();
		HeaderFooter event = new HeaderFooter();
		
		docWriter = PdfWriter.getInstance(document, baos);
		Rectangle mediabox = document.getPageSize();
	      pdfHeight = (int) mediabox.getHeight();
	      pdfWidth = (int) mediabox.getWidth();
		docWriter.setBoxSize("art", new Rectangle(36, 54, pdfWidth,pdfHeight));
		docWriter.setPageEvent(event);
		//event.setHeader("Basel");
		document.open();
		
	      System.out.println("page " +pdfHeight + " x " + pdfWidth);
		// Add content
	    for (int i = 0; i < 20; i++) {
	    	
			addDirParagraph(font9);
			addAssessmentList(font8boldUnder);
	    }
	    
	    
	    
	    
		document.close();
		docWriter.close();
      
        baos.writeTo(os);
        os.flush();
	}
	public static void addDirParagraph(Font f1) throws DocumentException {
        PdfPTable table = new PdfPTable(2); // 3 columns.
        table.setSpacingAfter(3);
        PdfPCell parNumCell = new PdfPCell(new Paragraph("121", f1));
        parNumCell.setBorderWidthBottom(0f);
        parNumCell.setBorderWidthLeft(0f);
        parNumCell.setBorderWidthTop(0f);
        parNumCell.setPadding(3);
        
        Phrase memPargraphDetails = new Phrase();
        memPargraphDetails.setLeading(25);
        memPargraphDetails.setFont(f1);
        memPargraphDetails.add(text);
        
        PdfPCell parDetailCell = new PdfPCell(memPargraphDetails);
        parDetailCell.setPadding(3);
        parDetailCell.setPaddingTop(1);
        parDetailCell.setPaddingBottom(5);
        parDetailCell.setLeading(10, 0);
        
        table.addCell(parNumCell);
        table.addCell(parDetailCell);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{30,400});
        
		document.add(table);
		
	}
	public static void addAssessmentList(Font f1) throws DocumentException {
		PdfPTable table = new PdfPTable(8);
		table.getDefaultCell().setPaddingTop(4);
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER); 
		float[] columnWidths = {20f, 12f, 15f, 28f, 30f, 16f, 45f,45f};

		table.setWidths(columnWidths);
		
		//table.getDefaultCell().setBorder(Rectangle.BOTTOM);

		table.addCell(new Phrase("Bank", f1));
		table.addCell(new Paragraph("WS", f1));
		table.addCell(new Paragraph("1-Gap", f1));
		table.addCell(new Paragraph("2-Project Status", f1));
		table.addCell(new Paragraph("3-Compliance", f1));
		table.addCell(new Paragraph("Target Date", f1));
		table.addCell(new Paragraph("Measure of Success", f1));
		table.addCell(new Paragraph("Comments", f1));
		
		table.addCell(new Phrase("Bank China America",font8));
		table.addCell(new Paragraph("WS",font8));
		table.addCell(new Paragraph("Major",font8));
		table.addCell(new Paragraph("2-Peoject Status",font8));
		table.addCell(new Paragraph("3-Compliance",font8));
		table.addCell(new Paragraph("2014-23-12",font8));
		
		List unorderedList = new List(List.UNORDERED);
        	unorderedList.add(new ListItem("Item 1 Comment rinting and typesetting Lorem Ipsum is simply",font8));
        	unorderedList.add(new ListItem("Item 2 smg and typesetting Lorem Ipsum is simply",font8));
        	unorderedList.add(new ListItem("Item 3 Comment  Comment rinting and typesetting Lorem Ipsum is simplypesetting",font8));
        	//unorderedList.
        
        // We add this phrase to a cell
        PdfPCell phraseCell = new PdfPCell();
        	phraseCell.setBorder(Rectangle.NO_BORDER);
        	phraseCell.addElement(unorderedList);
        	phraseCell.setPaddingTop(-3);
        
		table.addCell(phraseCell );
		table.addCell(new Paragraph("Comment rinting and typesetting Lorem Ipsum is simply dummy text ting and typesetting",font8));
		
		table.addCell(new Phrase("New West China America",font8));
		table.addCell(new Paragraph("PMO",font8));
		table.addCell(new Paragraph("Major",font8));
		table.addCell(new Paragraph("Completed",font8));
		table.addCell(new Paragraph("Substantial Compliance",font8));
		table.addCell(new Paragraph("2014-23-12",font8));
		table.addCell(new Paragraph("Lorem Ipsums simply dummy text of the printing and typesetting",font8));
		table.addCell(new Paragraph("Commit ting and typesetting",font8));
		
		table.setWidthPercentage(100);
		table.setSpacingAfter(18);
		document.add(table);
		
	}
	
	
	
	public  Document getDocument() {
		return document;
	}
	public  void setDocument(Document document) {
		this.document = document;
	}
	public ParagraphDetailsData getReportData() {
		return reportData;
	}
	public void setReportData(ParagraphDetailsData reportData) {
		this.reportData = reportData;
	}
	
	
	
}
class HeaderFooterX extends PdfPageEventHelper {
	int pagenumber;
	String header;
	PdfTemplate total;
	public void setHeader(String header) {
        this.header = header;
    }
	public void onOpenDocument(PdfWriter writer, Document document) {
		//header[0] = new Phrase("Movie history");
		Rectangle mediabox = document.getPageSize();
	    
		total = writer.getDirectContent().createTemplate(30,16);
		System.out.println("Document created " + total.getWidth());
	}
    
    public void onEndPage(PdfWriter writer, Document document) {
    	System.out.println("onEndPage");
    	PdfPTable table = new PdfPTable(3);
        try {
            table.setWidths(new int[]{24, 24, 2});
            table.setTotalWidth(770);
            table.setLockedWidth(true);
            table.getDefaultCell().setFixedHeight(20);
            table.getDefaultCell().setBorder(Rectangle.BOTTOM);

            table.addCell(header);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(String.format("Page %d of", writer.getPageNumber()));
            PdfPCell cell = new PdfPCell(Image.getInstance(total));
            cell.setBorder(Rectangle.BOTTOM);
            table.addCell(cell);
            table.writeSelectedRows(0, -1, 34, 595-10, writer.getDirectContent());
        }
        catch(DocumentException de) {
            throw new ExceptionConverter(de);
        }
    }
    
    public void onCloseDocument(PdfWriter writer, Document document) {
        ColumnText.showTextAligned(total, Element.ALIGN_LEFT, new Phrase(String.valueOf(writer.getPageNumber() - 1)), 2, 2, 0);
    }
}


/** Inner class to add a header and a footer. */
class HeaderFooter extends PdfPageEventHelper {
    /** Alternating phrase for the header. */
    Phrase[] header = new Phrase[2];
    /** Current page number (will be reset for every chapter). */
    int pagenumber;

    /**
     * Initialize one of the headers.
     * @see com.itextpdf.text.pdf.PdfPageEventHelper#onOpenDocument(
     *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
     */
    public void onOpenDocument(PdfWriter writer, Document document) {
        header[0] = new Phrase("Movie history");
    }

    /**
     * Initialize one of the headers, based on the chapter title;
     * reset the page number.
     * @see com.itextpdf.text.pdf.PdfPageEventHelper#onChapter(
     *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document, float,
     *      com.itextpdf.text.Paragraph)
     */

    public void onChapter(PdfWriter writer, Document document, float paragraphPosition, Paragraph title) {
        System.out.println("onChapter");
    }

    /**
     * Increase the page number.
     * @see com.itextpdf.text.pdf.PdfPageEventHelper#onStartPage(
     *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
     */
    public void onStartPage(PdfWriter writer, Document document) {
        pagenumber++;
    }

    /**
     * Adds the header and the footer.
     * @see com.itextpdf.text.pdf.PdfPageEventHelper#onEndPage(
     *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
     */
    public void onEndPage(PdfWriter writer, Document document) {
        Rectangle rect = writer.getBoxSize("art");
        System.out.println(rect.getHeight());
        ColumnText.showTextAligned(writer.getDirectContent(),
                Element.ALIGN_CENTER, new Phrase(String.format("page %d", pagenumber), new Font(Font.BOLD,9)),
                (rect.getLeft() + rect.getRight()) / 2, rect.getBottom() - 35, 0);
    }
}
