package DecoratorDesignPattern.src.com.howtodoinjava.demo.decorators;

public interface Report {
	public Object[][] getReportData(final String reportId);
	public String getFirstColumnData();
}
