package DecoratorDesignPattern.src.com.howtodoinjava.demo.decorators;

public class DecoratorPatternTest 
{
	public static void main(String[] args) 
	{
		
		//ClientPopupDecorator popupDecoratored = new ClientPopupDecorator
		//													(new ClientLinkDecorator(
		//														new ClientReport()));
		//System.out.println(popupDecoratored.getFirstColumnData());
		
		SupportPopupDecorator supportPopupDecoratored = new SupportPopupDecorator
																(new SupportLinkDecorator(new ColumDecorator(new SupportReport()) {
																}));
		System.out.println(supportPopupDecoratored.getFirstColumnData());
	}
}
