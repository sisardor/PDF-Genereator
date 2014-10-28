import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
public class Main {
	static Document document = new Document(PageSize.LETTER.rotate());
	private static String text = "\tLorem Ipsum is simply dummy text of the printing and typesetting\t industry.\n Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
	
	public static void main(String[] args) {
		//pdfParagarph();
		pdfTable();

		System.out.println(text);
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

            Phrase phrase = new Phrase(50);

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
	
	public static void pdfTable() {
		Font f1 = new Font();
		f1.setSize(9);

        try {
            PdfWriter.getInstance(document,
                new FileOutputStream("xx.pdf"));

            document.open();


            //paragraph2.setAlignment(Element.ALIGN_CENTER);

        

	        for(int i=0; i<100; i++){
//	            Chunk chunk = new Chunk(
//	                "This is a sentence which is long " + i + ". ");
//	            paragraph1.add(chunk);
	            
	            addDirParagraph(f1);

	        }
	        
//	        Paragraph paragraph = new Paragraph();
//	        paragraph.add(new Phrase(text));
//	        Chapter chapter = new Chapter(paragraph, 1);
//
//	        Section section1 = chapter.addSection("This is section 1", 2);
//	        Section section2 = chapter.addSection("This is section 2", 2);
//
//	        document.add(chapter);
            
            document.close();
        } catch(Exception e){

        }
	}
	public static void addDirParagraph(Font f1) throws DocumentException {
        PdfPTable table = new PdfPTable(2); // 3 columns.

        PdfPCell cell1 = new PdfPCell(new Paragraph("121"));
        Paragraph memPargraphDetails = new Paragraph(10);
        memPargraphDetails.setFont(f1);
        memPargraphDetails.add(text);
        PdfPCell cell2 = new PdfPCell(memPargraphDetails);
        cell1.setBorderWidthBottom(0f);
        cell1.setBorderWidthLeft(0f);
        cell1.setBorderWidthTop(0f);
        table.addCell(cell1);
        table.addCell(cell2);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{30,400});
		document.add(table);
		document.add(memPargraphDetails);
	}
}
