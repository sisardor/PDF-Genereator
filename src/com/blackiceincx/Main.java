package com.blackiceincx;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.blackice.persistence.model.Assessment;
import com.blackiceincx.reports.ParagraphDetailsData;
import com.blackiceincx.reports.ParagraphDetailsReport;
import com.blackiceincx.reports.ReportData;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
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
		
	
	public static void main(String[] args) throws DocumentException, IOException {

		
		ReportData assList = new ReportData();
			assList.setDirectiveParagraphNum("1");
			assList.setParagraphDescription("Description");
			List<Assessment> ass = new ArrayList<Assessment>();
			assList.setList(ass);
			
			
		  
		List<ReportData> list = new ArrayList<ReportData>();
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

			 


	}


//    public static PdfPTable getHeaderTable(int x, int y) throws DocumentException {
//    	//Color color = new Color(50,50,50);
//    	
//        PdfPTable table = new PdfPTable(4);
//        table.setTotalWidth(775 );
//        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
//        table.getDefaultCell().setBorder(Rectangle.BOTTOM);
//        table.getDefaultCell().setBorderColor(Color.GRAY);
//        table.getDefaultCell().setBorderWidth(1.5f);
//        //table.getDefaultCell().setPaddingBottom(-3);
//
//        float[] columnWidths = new float[] {10f, 10f, 10f, 10f};
//        table.setWidths(columnWidths);
//        
//        table.getDefaultCell().setFixedHeight(20);
//
//        table.addCell(new Paragraph(headerLabel, font10bold));
//        	//table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
//
//        table.addCell(new Paragraph(String.format(headerRegulation, "Basel II"), font10));
//        table.addCell(new Paragraph(String.format(headerAssDate, "2012-Oct-15"), font10));
//        table.addCell(new Paragraph(String.format(headerAssCriteria, "<<All>>"), font10));
//        return table;
//    }
//    
//    public static PdfPTable getFooterTable(int x, int y) throws DocumentException {
//    	Font font = FontFactory.getFont("Times-Roman");
//    	font.setSize(9);
//    	font.setStyle(Font.ITALIC);
//    	
//        PdfPTable table = new PdfPTable(2);
//        table.setTotalWidth(775 );
//        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
//        table.getDefaultCell().setBorder(Rectangle.TOP);
//        //table.getDefaultCell().setBorderColor(Color.GRAY);
//        table.setWidthPercentage(100);
//        table.setWidths(new int[]{700,75});
//        table.setLockedWidth(true);
//        table.getDefaultCell().setFixedHeight(20);
//
//
//        table.addCell(new Paragraph("Printed: Tuesday, Oct 27, 2014 10:52 PM", font));
//        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
//
//        table.addCell(new Paragraph(String.format("Page %d of %d", x, y), font));
//        return table;
//    }
//    

    
    
}












