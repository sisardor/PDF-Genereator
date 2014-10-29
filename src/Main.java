
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import com.blackice.persistence.model.Assessment;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
/*
 *	this.source = Assessment.class
 *		var json = [];
	        var id = 0;
	        for (var i = 0, len = this.source.length; i < len; i++) {
	            if(id != this.source[i].directiveParagraph.directiveParagraphNum){
	              	id = this.source[i].directiveParagraph.directiveParagraphNum
	              	var assessments = this.get_assessments(i, this.source[i].directiveParagraph.directiveParagraphNum)
	              	json.push({
	                	regulation       		: this.source[i].directiveParagraph.directive.txtDirName,
	                	directiveParagraphNum   : this.source[i].directiveParagraph.directiveParagraphNum , 
	                	paragraphDescription 		: this.source[i].directiveParagraph.memDirParDetails, 
	                	assessments          	: assessments
	              	})
	          	} 
	        };
	        return json
 */
public class Main {
	//static Document document = new Document(PageSize.LETTER.rotate());
	static Document document = new Document(PageSize.A4.rotate());
	private static String text = "\tLorem Ipsum is simply dummy text of the printing and typesetting\t industry.\nLorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
	
	static Font font8 = new Font(Font.HELVETICA, 		8);
	static Font font9italic = new Font(Font.HELVETICA, 		9, Font.ITALIC);
	static Font font8boldUnder = new Font(Font.HELVETICA, 		8, Font.BOLD | Font.UNDERLINE);
	static Font font9bold = new Font(Font.HELVETICA, 		9);
	
	static Font font10 = new Font(Font.TIMES_ROMAN, 	10);
	static Font font10bold = new Font(Font.TIMES_ROMAN, 	10, Font.BOLD);
	
	static Font font25 = new Font(Font.HELVETICA, 		25);
	static Font font25bold = new Font(Font.HELVETICA, 	25, Font.BOLD);
	static Font font18 = new Font(Font.HELVETICA, 		18);
	static Font font18bold = new Font(Font.HELVETICA, 	18, Font.BOLD);
	static Font font18italic = new Font(Font.HELVETICA, 18,	Font.ITALIC);
	static Font font27 = new Font(Font.HELVETICA, 		27);
	
	static String headerLabel = "Bank Assessment Detail";
	static String headerRegulation = "Regulation: %s";
	static String headerAssDate = "Assessment Date: %s";
	static String headerAssCriteria = "Assessment Criteria: %s";
	
	public static void main(String[] args) throws DocumentException, IOException {

		//pdfTable();

		
		
		ReportData assList = new ReportData();
			assList.setDirectiveParagraphNum("1");
			assList.setParagraphDescription("Description");
			java.util.List<Assessment> ass = new ArrayList<Assessment>();
			assList.setList(ass);
			
			
		  
		java.util.List<ReportData> list = new ArrayList<ReportData>();
		ParagraphDetailsData data = new ParagraphDetailsData();
			data.setData(list);
			data.setHeaderLabel("Basel");
			data.setHeaderRegulation("Basel");
			data.setHeaderAssDate("2012-12-12");
			data.setHeaderAssCriteria("<<All>>");
		
		ParagraphDetailsReport report = new ParagraphDetailsReport();
		report.setReportData(data);
		report.setDocument(document);
		
		report.generateReport(new FileOutputStream("NewFile.pdf"));


//        // SECOND PASS, ADD THE HEADER
//		OutputStream os = new FileOutputStream("out-to-file.pdf");
//        // Create a reader
//        PdfReader reader = new PdfReader(baos.toByteArray());
//        // Create a stamper
//        PdfStamper stamper = new PdfStamper(reader, os);
//        // Loop over the pages and add a header to each page
//        int n = reader.getNumberOfPages();
//        Rectangle mediabox = reader.getPageSizeWithRotation(1);
//        int pdfHeight = (int) mediabox.getHeight();
//        int pdfWidth = (int) mediabox.getWidth();
//        System.out.println("page " +pdfHeight + " x " + pdfWidth);
//        for (int i = 1; i <= n; i++) {
//        	getHeaderTable(i, n).writeSelectedRows(
//                    0, -1, 35, pdfHeight-10, stamper.getOverContent(i));
//        	
//            getFooterTable(i, n).writeSelectedRows(
//                    0, -1, 35, 27, stamper.getOverContent(i));
//        }
//        // Close the stamper
//        stamper.close();
//        reader.close();
        

        
        // We write the PDF bytes to the OutputStream
        
//        baos.writeTo(os);
//        os.flush();
		

	}


    public static PdfPTable getHeaderTable(int x, int y) throws DocumentException {
    	//Color color = new Color(50,50,50);
    	
        PdfPTable table = new PdfPTable(4);
        table.setTotalWidth(775 );
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.getDefaultCell().setBorder(Rectangle.BOTTOM);
        table.getDefaultCell().setBorderColor(Color.GRAY);
        table.getDefaultCell().setBorderWidth(1.5f);
        //table.getDefaultCell().setPaddingBottom(-3);

        float[] columnWidths = new float[] {10f, 10f, 10f, 10f};
        table.setWidths(columnWidths);
        
        table.getDefaultCell().setFixedHeight(20);

        table.addCell(new Paragraph(headerLabel, font10bold));
        	//table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);

        table.addCell(new Paragraph(String.format(headerRegulation, "Basel II"), font10));
        table.addCell(new Paragraph(String.format(headerAssDate, "2012-Oct-15"), font10));
        table.addCell(new Paragraph(String.format(headerAssCriteria, "<<All>>"), font10));
        return table;
    }
    
    public static PdfPTable getFooterTable(int x, int y) throws DocumentException {
    	Font font = FontFactory.getFont("Times-Roman");
    	font.setSize(9);
    	font.setStyle(Font.ITALIC);
    	
        PdfPTable table = new PdfPTable(2);
        table.setTotalWidth(775 );
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.getDefaultCell().setBorder(Rectangle.TOP);
        //table.getDefaultCell().setBorderColor(Color.GRAY);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{700,75});
        table.setLockedWidth(true);
        table.getDefaultCell().setFixedHeight(20);


        table.addCell(new Paragraph("Printed: Tuesday, Oct 27, 2014 10:52 PM", font));
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);

        table.addCell(new Paragraph(String.format("Page %d of %d", x, y), font));
        return table;
    }
    

    
    
}












