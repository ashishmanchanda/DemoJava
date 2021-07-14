package DecoratorDesignPattern.src.com.howtodoinjava.demo.subclassing;

public interface Report {
	public Object[][] getReportData(final String reportId);
	public String getModifiedFirstColumnData(String data);
}
