package DecoratorDesignPattern.src.com.howtodoinjava.demo.decorators;

public class ClientLinkDecorator extends ColumDecorator{

	public ClientLinkDecorator(Report report) {
		super(report);
	}

	public String getFirstColumnData() {
		return addMoreInfo (super.getFirstColumnData()) ;
	}
	
	private String addMoreInfo(String data){
		return data  + " - client link - ";
	}
}

