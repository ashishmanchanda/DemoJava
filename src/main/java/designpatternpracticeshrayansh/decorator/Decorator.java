package designpatternpracticeshrayansh.decorator;

 interface BasePizza {
    String getDescription();
    double getCost();
}

class PlainPizza implements BasePizza {
    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 200.0;
    }
}
 class Farmhouse implements BasePizza {
    @Override
    public String getDescription() {
        return "Farmhouse Pizza";
    }
    @Override
    public double getCost() {
        return 300.0;
    }
}
 class TandooriPaneerDelight implements BasePizza {
    @Override
    public String getDescription() {
        return "Tandoori Paneer Delight Pizza";
    }
    @Override
    public double getCost() {
        return 400.0;
    }
}
 class ChickenDominator implements BasePizza {
    @Override
    public String getDescription() {
        return "Chicken Dominator Pizza";
    }

    @Override
    public double getCost() {
        return 500.0;
    }
}
// Step : Define the Abstract Base Decorator
abstract class ToppingDecorator implements BasePizza {
    BasePizza pizza;

    public ToppingDecorator(BasePizza pizza) {
        this.pizza = pizza;
    }
}
// Step : Define the Concrete Decorator
 class ExtraCheeseTopping extends ToppingDecorator {

    public ExtraCheeseTopping(BasePizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Extra Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 20 ;
    }
}
 class VeggiesTopping extends ToppingDecorator {

    public VeggiesTopping(BasePizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {

        return pizza.getDescription() + " + Veggies";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 30 ;
    }
}
 class MushroomTopping extends ToppingDecorator {

    public MushroomTopping(BasePizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Mushroom";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 40 ;
    }
}
 class PepperoniTopping extends ToppingDecorator {

    public PepperoniTopping(BasePizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Pepperoni";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 50 ;
    }
}
// Step : Client Demonstration
 class PizzaShop {
    public static void main(String[] args) {
        System.out.println("======= Decorator Design Pattern ======");
        // Create a plain pizza
        BasePizza pizza = new PlainPizza();
        System.out.println("Order : " + pizza.getDescription() + " = Rs." + pizza.getCost());

                // Add toppings to the PlainPizza - Extra Cheese Only
                BasePizza pizza1 = new ExtraCheeseTopping(new PlainPizza());
        System.out.println("Order : " + pizza1.getDescription() + " = Rs." + pizza1.getCost());

                // Add toppings to the PlainPizza - Extra Cheese and Veggies
                BasePizza pizza2 = new VeggiesTopping(new
                        ExtraCheeseTopping(new PlainPizza()));
        System.out.println("Order : " + pizza2.getDescription() + " = Rs." + pizza2.getCost());

                // Add toppings to the PlainPizza - Extra Cheese and Pepperoni
                BasePizza pizza3 = new PepperoniTopping(new
                        ExtraCheeseTopping(new PlainPizza()));
        System.out.println("Order : " + pizza3.getDescription() + " = Rs." + pizza3.getCost());

                // Add toppings to the PlainPizza - Extra Cheese, Mushroom andPepperoni
                BasePizza pizza4 = new MushroomTopping(new
                        PepperoniTopping(new ExtraCheeseTopping(new PlainPizza())));



        System.out.println("Order : " + pizza4.getDescription() + " = Rs." + pizza4.getCost());

                // Farmhouse Pizza
               BasePizza pizza5 = new Farmhouse();
        System.out.println("Order : " + pizza5.getDescription() + " = Rs." + pizza5.getCost());

                // Farmhouse Pizza with Extra Cheese and Mushroom
                BasePizza pizza6 = new MushroomTopping(new
                        ExtraCheeseTopping(new Farmhouse()));
        System.out.println("Order : " + pizza6.getDescription() + " = Rs." + pizza6.getCost());

                // Tandoori Paneer Delight Pizza
                BasePizza pizza7 = new TandooriPaneerDelight();
        System.out.println("Order : " + pizza7.getDescription() + " = Rs." + pizza7.getCost());

                // Chicken Dominator
                BasePizza pizza8 = new ChickenDominator();
        System.out.println("Order : " + pizza8.getDescription() + " = Rs." + pizza8.getCost());

                // Chicken Dominator with Mushroom
                BasePizza pizza9 = new MushroomTopping(new
                        ChickenDominator());
        System.out.println("Order : " + pizza9.getDescription() + " = Rs." + pizza9.getCost());
    }
}