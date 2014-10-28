import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
public class Main {
	//static Document document = new Document(PageSize.LETTER.rotate());
	static Document document = new Document(PageSize.A4.rotate());
	private static String text = "\tLorem Ipsum is simply dummy text of the printing and typesetting\t industry.\nLorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
	
	static Font font9 = new Font(Font.FontFamily.HELVETICA, 		9);
	static Font font9italic = new Font(Font.FontFamily.HELVETICA, 		9, Font.ITALIC);
	static Font font9boldUnder = new Font(Font.FontFamily.HELVETICA, 		9, Font.BOLD | Font.UNDERLINE);
	static Font font9bold = new Font(Font.FontFamily.HELVETICA, 		9);
	
	static Font font25 = new Font(Font.FontFamily.HELVETICA, 		25);
	static Font font25bold = new Font(Font.FontFamily.HELVETICA, 	25, Font.BOLD);
	static Font font18 = new Font(Font.FontFamily.HELVETICA, 		18);
	static Font font18bold = new Font(Font.FontFamily.HELVETICA, 	18, Font.BOLD);
	static Font font18italic = new Font(Font.FontFamily.HELVETICA, 18,	Font.ITALIC);
	static Font font27 = new Font(Font.FontFamily.HELVETICA, 		27);
	
	public static void main(String[] args) throws DocumentException, IOException {
		//pdfParagarph();
		pdfTable();
		//pdfPhrase2();

	}
	
	public void pdfPhrase() {



        try {
            PdfWriter.getInstance(document,
                   new FileOutputStream("Phrase-l.pdf"));

            document.open();
            document.add(new Phrase("This is sentence 1. "));
            document.add(new Phrase("This is sentence 2. "));
            document.add(new Phrase("This is sentence 3. "));
            document.add(new Phrase("This is sentence 4. "));
            document.add(new Phrase("This is sentence 5. "));
            document.add(new Phrase("This is sentence 6. "));
            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public static void pdfPhrase2() {

        try {
            PdfWriter.getInstance(document,
                new FileOutputStream("Phrase2.pdf"));

            document.open();
            Chunk chunk = new Chunk("This is a sentence ");

            Phrase phrase = new Phrase(14);

            phrase.add(chunk);
            phrase.add(chunk);
            phrase.add(chunk);
            phrase.add(chunk);
            phrase.add(chunk);
            phrase.add(chunk);

            phrase.add(chunk);
            phrase.add(chunk);
            phrase.add(chunk);
            phrase.add(chunk);
            phrase.add(chunk);
            phrase.add(chunk);

            phrase.add(chunk);
            phrase.add(chunk);
            phrase.add(chunk);
            phrase.add(chunk);
            phrase.add(chunk);
            phrase.add(chunk);

            document.add(phrase);
            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	public static void pdfParagarph() {

	    

		try {
            PdfWriter.getInstance(document,
                new FileOutputStream("Paragraph2.pdf"));

            document.open();
            Paragraph paragraph1 = new Paragraph();
            
                Paragraph paragraph2 = new Paragraph(13);

                paragraph2.setSpacingAfter(25);
                paragraph2.setSpacingBefore(25);
                paragraph2.setAlignment(Element.ALIGN_CENTER);
                paragraph2.setIndentationLeft(50);
                paragraph2.setIndentationRight(50);
            

            for(int i=0; i<10; i++){
                Chunk chunk = new Chunk(
                    "This is a sentence which is long " + i + ". ");
                paragraph1.add(chunk);
                paragraph2.add(chunk);
            }

            document.add(paragraph1);
            document.add(paragraph2);
            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

	  }
	
	public static void pdfTable() throws DocumentException, IOException {
		Font f1 = new Font();
		f1.setSize(9);
		 //HeaderFooter event = new HeaderFooter();
		// step 1
        //Document document = new Document(PageSize.A4, 36, 36, 54, 36);
        // step 2
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        // step 3
        document.open();
        // step 4

        	//PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("xx.pdf"));
//        	writer.setBoxSize("art", new Rectangle(50, 30, 25, 200));
//        	writer.setPageEvent(event);
//            document.setPageSize(PageSize.A4.rotate());
//            document.setMargins(25, 20, 25, 20);
//            document.setMarginMirroringTopBottom(true);
            

	        
	        Paragraph paragraph = new Paragraph(15);
	        paragraph.add(new Phrase(text));

	        for (int i = 0; i < 20; i++) {
				addDirParagraph(f1);
				addAssessmentList(font9boldUnder);
			}
			

            document.close();
            
         // SECOND PASS, ADD THE HEADER
            
            // Create a reader
            PdfReader reader = new PdfReader(baos.toByteArray());
            // Create a stamper
            PdfStamper stamper
                = new PdfStamper(reader, new FileOutputStream("out.pdf"));
            // Loop over the pages and add a header to each page
            int n = reader.getNumberOfPages();
            Rectangle mediabox = reader.getPageSize(1);
            for (int i = 1; i <= n; i++) {
            	System.out.println("page " +mediabox.getTop() + "," + mediabox.getRight());
                getHeaderTable(i, n).writeSelectedRows(
                        0, -1, 35, 27, stamper.getOverContent(i));
                getHeaderTable(i, n).writeSelectedRows(
                        0, -1, 35, 595-10, stamper.getOverContent(i));
            }
            // Close the stamper
            stamper.close();
            reader.close();

	}
	public static void addDirParagraph(Font f1) throws DocumentException {
        PdfPTable table = new PdfPTable(2); // 3 columns.
        table.setSpacingAfter(8f);
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
		PdfPTable table = new PdfPTable(7);
		//table.getDefaultCell().setBorder(Rectangle.BOTTOM);
		PdfPCell column01 = new PdfPCell(new Paragraph("Bank", f1));
		PdfPCell column02 = new PdfPCell(new Paragraph("WS", f1));
		PdfPCell column03 = new PdfPCell(new Paragraph("1-Gap", f1));
		PdfPCell column04 = new PdfPCell(new Paragraph("2-Peoject Status", f1));
		PdfPCell column05 = new PdfPCell(new Paragraph("3-Compliance", f1));
		PdfPCell column06 = new PdfPCell(new Paragraph("Target Date", f1));
		PdfPCell column07 = new PdfPCell(new Paragraph("Measure of Success", f1));
		
		column01.setBorder(Rectangle.NO_BORDER);
		column02.setBorder(Rectangle.NO_BORDER);
		column03.setBorder(Rectangle.NO_BORDER);
		column04.setBorder(Rectangle.NO_BORDER);
		column05.setBorder(Rectangle.NO_BORDER);
		column06.setBorder(Rectangle.NO_BORDER);
		column07.setBorder(Rectangle.NO_BORDER);
		
		column01.setPaddingBottom(5);
		column02.setPaddingBottom(5);
		column03.setPaddingBottom(5);
		column04.setPaddingBottom(5);
		column05.setPaddingBottom(5);
		column06.setPaddingBottom(5);
		column07.setPaddingBottom(5);
		
		
		table.addCell(column01);
		table.addCell(column02);
		table.addCell(column03);
		table.addCell(column04);
		table.addCell(column05);
		table.addCell(column06);
		table.addCell(column07);
		table.setWidthPercentage(100);
		table.setSpacingAfter(10);
		document.add(table);
		
	}
	/**
     * Create a header table with page X of Y
     * @param x the page number
     * @param y the total number of pages
     * @return a table that can be used as header
	 * @throws DocumentException 
     */
    public static PdfPTable getHeaderTable(int x, int y) throws DocumentException {
    	Font font = FontFactory.getFont("Times-Roman");
    	font.setSize(9);
    	font.setStyle(Font.ITALIC);
    	
        PdfPTable table = new PdfPTable(2);
        table.setTotalWidth(775 );
        //table.setWidthPercentage(100);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{700,75});
        table.setLockedWidth(true);
        table.getDefaultCell().setFixedHeight(20);

        PdfPCell cell = new PdfPCell(new Paragraph("Printed: Tuesday, Oct 27, 2014 10:52 PM", font));
        cell.setBorder(Rectangle.NO_BORDER); 
        cell.setBorder(Rectangle.TOP);
        
        table.addCell(cell);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
        PdfPCell cell2 = new PdfPCell(new Paragraph(String.format("Page %d of %d", x, y), font));
        cell2.setBorder(Rectangle.NO_BORDER);
        cell2.setBorder(Rectangle.TOP  );
        
        table.addCell(cell2);
        return table;
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
    public void onChapter(PdfWriter writer, Document document,
            float paragraphPosition, Paragraph title) {
        header[1] = new Phrase(title.getContent());
        pagenumber = 1;
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
        switch(writer.getPageNumber() % 2) {
        case 0:
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_RIGHT, header[0],
                    rect.getRight(), rect.getTop(), 0);
            break;
        case 1:
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_LEFT, header[1],
                    rect.getLeft(), rect.getTop(), 0);
            break;
        }
        ColumnText.showTextAligned(writer.getDirectContent(),
                Element.ALIGN_CENTER, new Phrase(String.format("page %d", pagenumber)),
                (rect.getLeft() + rect.getRight()) / 2, rect.getBottom() - 18, 0);
    }
}
