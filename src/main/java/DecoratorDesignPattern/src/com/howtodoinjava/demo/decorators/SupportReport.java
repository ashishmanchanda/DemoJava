package DecoratorDesignPattern.src.com.howtodoinjava.demo.decorators;

public class SupportReport implements Report {

	@Override
	public Object[][] getReportData(String reportId) {
		return null;
	}

	@Override
	public String getFirstColumnData() {
		return "Support data";
	}
	
}
