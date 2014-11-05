package com.blackiceincx;
import com.blackiceincx.reports.ParagraphDetailsReport;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;

/** Inner class to add a header and a footer. */
class HeaderFooter extends PdfPageEventHelper {
	ParagraphDetailsReport report;
    public HeaderFooter(ParagraphDetailsReport report) {
		super();
		this.report = report;
	}

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
    

    /**
     * Adds the header and the footer.
     * @see com.itextpdf.text.pdf.PdfPageEventHelper#onEndPage(
     *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
     */
    public void onEndPage(PdfWriter writer, Document document) {
        Rectangle header = writer.getBoxSize("header");
        System.out.println(header.getLeft() +  " " + header.getRight() + " " +header.getBottom()); 
        ColumnText.showTextAligned(writer.getDirectContent(),
                Element.ALIGN_CENTER, new Phrase(String.format("page %d", pagenumber), new Font(Font.BOLD,9)),
                (header.getLeft() + header.getRight()) / 2, header.getBottom() -30, 0);
        
        Rectangle footer = writer.getBoxSize("footer");
       
        ColumnText.showTextAligned(writer.getDirectContent(),
                Element.ALIGN_CENTER, new Phrase(String.format("page %d", pagenumber), new Font(Font.BOLD,9)),
                (footer.getLeft() + footer.getRight()) / 2, footer.getBottom() -30, 0);
    }
}
