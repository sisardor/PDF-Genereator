package com.blackiceincx.reports;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;

/** Inner class to add a header and a footer. */
class HeaderFooterEventHandler extends PdfPageEventHelper {
	int pagenumber;
	PdfTemplate total;
	int width;
	int height;

	Phrase headerLabel;
	Phrase headerRegulation ;
	Phrase headerAssDate;
	Phrase headerAssCriteria;
	Phrase timestamp;
	String XofYlabel;
	Font font10italic;
	
	/**
     * Initialize one of the headers.
     * @see com.itextpdf.text.pdf.PdfPageEventHelper#onOpenDocument(
     *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
     */
	public void onOpenDocument(PdfWriter writer, Document document) {
		Rectangle mediabox = document.getPageSize();
	    System.out.println("Width:" + mediabox.getWidth() + "   Height:" + mediabox.getHeight() + "  Top:" + mediabox.getTop() +
	    		"   Bottom:" + mediabox.getBottom() + "   Right:" + mediabox.getRight() + "   Left:" + mediabox.getLeft() + 
	    		"   Rotation:" + mediabox.getRotation());
	    
	    width = (int) mediabox.getWidth();
	    height = (int) mediabox.getHeight();
		total = writer.getDirectContent().createTemplate(30,16);
		System.out.println("Document created W:" + total.getWidth() + "  H:" + total.getHeight() + " Scaling " + total.getHorizontalScaling());
	}
    
	/**
     * Adds the header and the footer.
     * @see com.itextpdf.text.pdf.PdfPageEventHelper#onEndPage(
     *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
     */
    public void onEndPage(PdfWriter writer, Document document) {
        PdfPTable headerTable = new PdfPTable(4);
        try {
			headerTable.setWidths(new int[]{18, 26, 20, 30});
	        headerTable.setTotalWidth(770);
	        headerTable.setLockedWidth(true);
	        headerTable.getDefaultCell().setFixedHeight(20);
	        headerTable.getDefaultCell().setBorder(Rectangle.BOTTOM);
	
	        headerTable.addCell(headerLabel);
	        
	        headerTable.addCell(headerRegulation);
	        headerTable.addCell(headerAssDate);
	        headerTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
	        headerTable.addCell(headerAssCriteria);
	        headerTable.writeSelectedRows(0, -1, 34, height-10, writer.getDirectContent());
        } catch (DocumentException e) {
			e.printStackTrace();
		}
        
        PdfPTable footer = new PdfPTable(3);
        try {
            footer.setWidths(new int[]{24, 24, 2});
            footer.setTotalWidth(770);
            footer.setLockedWidth(true);
            footer.getDefaultCell().setFixedHeight(20);
            footer.getDefaultCell().setBorder(Rectangle.TOP);

            footer.addCell(timestamp);
            footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
            footer.addCell( new Phrase( String.format(XofYlabel, writer.getPageNumber()), font10italic) );
            PdfPCell cell = new PdfPCell(Image.getInstance(total));
            cell.setBorder(Rectangle.TOP);

            footer.addCell(cell);
            footer.writeSelectedRows(0, -1, 34, 35, writer.getDirectContent());
        }
        catch(DocumentException de) {
            throw new ExceptionConverter(de);
        }
    }
    
    /**
     * Initialize the footer with label X page of Y.
     * @see com.itextpdf.text.pdf.PdfPageEventHelper#onCloseDocument(
     *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
     */
    public void onCloseDocument(PdfWriter writer, Document document) {
        ColumnText.showTextAligned(total, Element.ALIGN_LEFT, new Phrase(String.valueOf(writer.getPageNumber() - 1), font10italic), 2, 4, 0);
    }
    
    
    
    

	

	protected void setHeaderLabel(Phrase headerLabel) {
		this.headerLabel = headerLabel;
	}
	protected void setHeaderRegulation(Phrase headerRegulation) {
		this.headerRegulation = headerRegulation;
	}
	protected void setHeaderAssDate(Phrase headerAssDate) {
		this.headerAssDate = headerAssDate;
	}
	
	protected void setHeaderAssCriteria(Phrase headerAssCriteria) {
		this.headerAssCriteria = headerAssCriteria;
	}
	protected void setTimestamp(Phrase timestamp) {
		this.timestamp = timestamp;
	}
	protected void setXofYlabel(String xofYlabel) {
		XofYlabel = xofYlabel;
	}
	
	protected void setFont10italic(Font font10italic) {
		this.font10italic = font10italic;
	}  
}
