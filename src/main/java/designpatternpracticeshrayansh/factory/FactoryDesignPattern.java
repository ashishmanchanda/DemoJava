package designpatternpracticeshrayansh.factory;

// Step : Define the Product interface
 interface Shape {
    void computeArea();
    void draw();
}

// Step : Concrete Product classes
 class Circle implements Shape {

    @Override
    public void computeArea() {
        System.out.println("Inside Circle::computeArea() method.");
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
 class Rectangle implements Shape {

    @Override
    public void computeArea() {
        System.out.println("Inside Rectangle::computeArea() method.");
    }

    @Override
    public void draw() {

        System.out.println("Inside Rectangle::draw() method.");
    }
}
 class Square implements Shape {

    @Override
    public void computeArea() {
        System.out.println("Inside Square::computeArea() method.");
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

 enum ShapeType {
    CIRCLE, RECTANGLE, SQUARE
}
 class ShapeFactory {
    public static Shape createShapeInstance(ShapeType shapeType) {
        if (shapeType == null) {
            return null;
        }
        switch(shapeType) {
            case CIRCLE : return new Circle();
            case RECTANGLE : return new Rectangle();
            case SQUARE : return new Square();
            default : throw new IllegalStateException("ShapeType doesn't exist!");
        }
    }
}
// Step : Simple Factory Demo (Bloated Design)
 class SimpleFactoryDemo {
    public static void main(String[] args) {
        System.out.println("======= Simple Factory Design Pattern ======");

                // set the type you want
                ShapeType shapeType = ShapeType.SQUARE;
        // get the shape
        Shape shape = ShapeFactory.createShapeInstance(shapeType);
        shape.draw();
        shape.computeArea();
    }
}
