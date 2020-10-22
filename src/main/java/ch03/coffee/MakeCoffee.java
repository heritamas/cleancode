package ch03.coffee;

public class MakeCoffee {
    public static void main(String[] args) {
        CoffeeMaker cm = new CoffeeMaker(0.1, 0.05);

        cm.make(2);
    }
}
