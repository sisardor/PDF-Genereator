import java.util.List;



public class ParagraphDetailsData {
	private String headerLabel;
	private String headerRegulation;
	private String headerAssDate;
	private String headerAssCriteria;
	private List<ReportData> data;
	
	
	public ParagraphDetailsData() {
		super();
	}
	public String getHeaderLabel() {
		return headerLabel;
	}
	public void setHeaderLabel(String headerLabel) {
		this.headerLabel = headerLabel;
	}
	public String getHeaderRegulation() {
		return headerRegulation;
	}
	public void setHeaderRegulation(String headerRegulation) {
		this.headerRegulation = headerRegulation;
	}
	public String getHeaderAssDate() {
		return headerAssDate;
	}
	public void setHeaderAssDate(String headerAssDate) {
		this.headerAssDate = headerAssDate;
	}
	public String getHeaderAssCriteria() {
		return headerAssCriteria;
	}
	public void setHeaderAssCriteria(String headerAssCriteria) {
		this.headerAssCriteria = headerAssCriteria;
	}
	public List<ReportData> getData() {
		return data;
	}
	public void setData(List<ReportData> data) {
		this.data = data;
	}
	
	
	
}
