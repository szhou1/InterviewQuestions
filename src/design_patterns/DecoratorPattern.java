package design_patterns;

public class DecoratorPattern {

    public interface Shape {
        void draw();
    }

    public class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("Shape: Rectangle");
        }
    }

    public class Circle implements Shape {

        @Override
        public void draw() {
            System.out.println("Shape: Circle");
        }
    }

    public abstract class ShapeDecorator implements Shape {
        protected Shape decoratedShape;

        public ShapeDecorator(Shape decoratedShape) {
            this.decoratedShape = decoratedShape;
        }

        public void draw() {
            decoratedShape.draw();
        }
    }

    public class RedShapeDecorator extends ShapeDecorator {

        public RedShapeDecorator(Shape decoratedShape) {
            super(decoratedShape);
        }

        @Override
        public void draw() {
            decoratedShape.draw();
            setRedBorder(decoratedShape);
        }

        private void setRedBorder(Shape decoratedShape) {
            System.out.println("Border Color: Red");
        }
    }
    
//    public static void main(String [] args) {
//        Shape circle = new Circle();
//        
//    }

}
