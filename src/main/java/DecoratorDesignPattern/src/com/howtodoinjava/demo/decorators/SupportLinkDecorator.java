package DecoratorDesignPattern.src.com.howtodoinjava.demo.decorators;

public class SupportLinkDecorator extends ColumDecorator{

	public SupportLinkDecorator(Report report) {
		super(report);
	}

	public String getFirstColumnData() {
		return addMoreInfo (super.getFirstColumnData()) ;
	}
	
	private String addMoreInfo(String data){
		return data  + " - support link - ";
	}
}
