package DecoratorDesignPattern.src.com.howtodoinjava.demo.decorators;

public class ClientReport implements Report {

	@Override
	public Object[][] getReportData(String reportId) {
		return null;
	}

	@Override
	public String getFirstColumnData() {
		return "Client data";
	}
	
}
