package DecoratorDesignPattern.src.com.howtodoinjava.demo.subclassing;

public class ClientReport implements Report {

	@Override
	public Object[][] getReportData(String reportId) {
		return null;
	}

	@Override
	public String getModifiedFirstColumnData(String data) {
		data = makeAnchorLink(data);
		data = designPopup(data);
		data = applyColor(data);
		return data;
	}
	
	private String makeAnchorLink(String data){
		return data;
	} 
	private String designPopup(String data){
		return data;
	} 
	private String applyColor(String data){
		return data;
	} 

}
