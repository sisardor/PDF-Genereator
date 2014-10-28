import java.util.List;

import com.blackice.persistence.model.Assessment;


public class ReportData {
	private List<Assessment> list;
	private String field1;
	private String field2;
	private String field3;
	private String directiveParagraphNum;
	private String paragraphDescription;
	
	
	
	public ReportData() {
		super();
	}
	public List<Assessment> getList() {
		return list;
	}
	public void setList(List<Assessment> list) {
		this.list = list;
	}
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	public String getField3() {
		return field3;
	}
	public void setField3(String field3) {
		this.field3 = field3;
	}
	public String getDirectiveParagraphNum() {
		return directiveParagraphNum;
	}
	public void setDirectiveParagraphNum(String directiveParagraphNum) {
		this.directiveParagraphNum = directiveParagraphNum;
	}
	public String getParagraphDescription() {
		return paragraphDescription;
	}
	public void setParagraphDescription(String paragraphDescription) {
		this.paragraphDescription = paragraphDescription;
	}
	
	
}
