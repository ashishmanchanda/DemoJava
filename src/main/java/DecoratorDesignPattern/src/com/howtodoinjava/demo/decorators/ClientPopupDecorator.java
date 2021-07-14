package DecoratorDesignPattern.src.com.howtodoinjava.demo.decorators;

public class ClientPopupDecorator extends ColumDecorator{

	public ClientPopupDecorator(Report report) {
		super(report);
	}

	public String getFirstColumnData() {
		return addPopup (super.getFirstColumnData()) ;
	}
	
	private String addPopup(String data){
		return data  + " - client popup - ";
	}
}
