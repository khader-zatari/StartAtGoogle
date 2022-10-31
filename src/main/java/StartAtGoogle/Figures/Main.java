package StartAtGoogle.Figures;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(3.0);
        Square square = new Square(3);
        Rectangle rec = new Rectangle(3,4);
        System.out.println(circle.area());
        System.out.println(square.area());
        System.out.println(rec.area());
    }



}
