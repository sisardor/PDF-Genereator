package com.blackiceincx.reports;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ParagraphDetailsReport {
	private Document document;
	private static String text = "\tLorem Ipsum is simply dummy text of the printing and typesetting\t industry.\nLorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
	
	static Font font8 = new Font(Font.HELVETICA, 		8);
	static Font font9italic = new Font(Font.HELVETICA, 		9, Font.ITALIC);
	static Font font8boldUnder = new Font(Font.HELVETICA, 		8, Font.BOLD | Font.UNDERLINE);
	static Font font9bold = new Font(Font.HELVETICA, 		9);
	static Font font9 = new Font(Font.HELVETICA, 		9);
	
<<<<<<< HEAD:src/ParagraphDetailsReport.java
	
	int pdfHeight;
	int pdfWidth;
	private ParagraphDetailsData reportData;
	
	private String test = "Hello World";
=======
	static Font font10 = new Font(Font.TIMES_ROMAN, 	10);
	static Font font10italic = new Font(Font.TIMES_ROMAN, 	10, Font.ITALIC);
	static Font font10bold = new Font(Font.TIMES_ROMAN, 	10, Font.BOLD);
	
	static String headerLabel = "Bank Assessment Detail";
	static String headerRegulation = "Regulation: %s";
	static String headerAssDate = "Assessment Date: %s";
	static String headerAssCriteria = "Assessment Criteria: %s";
	
	String XofYlabel = "Page %d of";
	
	String timestamp="Printed: " + new SimpleDateFormat("EEEE, MMM d, yyyy hh:mm: a").format(new Date());
	
	private ParagraphDetailsData reportData;

>>>>>>> FETCH_HEAD:src/com/blackiceincx/reports/ParagraphDetailsReport.java
	
	public void generateReport(OutputStream os) throws DocumentException, IOException {
 
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfWriter docWriter = null;
<<<<<<< HEAD:src/ParagraphDetailsReport.java
		HeaderFooterEvent event = new HeaderFooterEvent();
		//EventHandler event = new EventHandler(this);
		
		docWriter = PdfWriter.getInstance(document, baos);
		Rectangle mediabox = document.getPageSize();
	    pdfHeight = (int) mediabox.getHeight();
	    pdfWidth = (int) mediabox.getWidth();
	    
	    Rectangle rect = new Rectangle(36, pdfHeight, pdfWidth,pdfHeight);
	    rect.setBorderWidth(2f);
		docWriter.setBoxSize("header", rect);
		docWriter.setBoxSize("footer", new Rectangle(36, 54, pdfWidth,pdfHeight));
		
=======
		HeaderFooterEventHandler event = new HeaderFooterEventHandler();

		event.setHeaderLabel(new Phrase(headerLabel, font10bold));
		event.setHeaderAssDate(new Phrase(String.format(headerAssDate,  reportData.getHeaderAssDate() ), font10) );
		event.setHeaderAssCriteria(new Phrase(String.format(headerAssCriteria, reportData.getHeaderAssCriteria() ), font10) );
		event.setHeaderRegulation(new Phrase(String.format(headerRegulation, reportData.getHeaderRegulation()), font10) );
		event.setXofYlabel(XofYlabel);
		event.setTimestamp(new Phrase(timestamp, font10italic));
		event.setFont10italic(font10italic);
		
		docWriter = PdfWriter.getInstance(document, baos);
>>>>>>> FETCH_HEAD:src/com/blackiceincx/reports/ParagraphDetailsReport.java
		docWriter.setPageEvent(event);

		document.open();
		
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
<<<<<<< HEAD:src/ParagraphDetailsReport.java
	public  void addDirParagraph(Font f1) throws DocumentException {
=======
	public void addDirParagraph(Font f1) throws DocumentException {
>>>>>>> FETCH_HEAD:src/com/blackiceincx/reports/ParagraphDetailsReport.java
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
<<<<<<< HEAD:src/ParagraphDetailsReport.java
	public  void addAssessmentList(Font f1) throws DocumentException {
=======
	public void addAssessmentList(Font f1) throws DocumentException {
>>>>>>> FETCH_HEAD:src/com/blackiceincx/reports/ParagraphDetailsReport.java
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


