package DecoratorDesignPattern.src.com.howtodoinjava.demo.decorators;

public abstract class ColumDecorator implements Report 
{
	private Report decoratedReport;
	
	public ColumDecorator(Report report){
		this.decoratedReport = report;
	}

	@Override
	public String getFirstColumnData() {
        return addinfo(decoratedReport.getFirstColumnData());
    }

    public String addinfo(String data){
		return data+"column data";
	}
	
	@Override
	public Object[][] getReportData(String reportId) {
		return decoratedReport.getReportData(reportId);
	}
}
