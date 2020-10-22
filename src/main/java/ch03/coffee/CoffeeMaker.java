package ch03.coffee;

import java.util.logging.Logger;

public class CoffeeMaker {
    Logger log = Logger.getLogger(this.getClass().getName());

    final double waterForCaffee = 0.1;
    final double beanForCaffee = 0.05;

    private int temp = 10;
    private double waterLevel = 0;
    private double amountOfBeans = 0;

    public static void main(String[] args) {
        CoffeeMaker cm = new CoffeeMaker();

        cm.makeCoffee(2);
    }

    public void makeCoffee(int count) {
        log.info("Making coffee ...");
        for (int i = 0 ; i < count ; ++i) {
            log.info("coffee no " + i);
            if (amountOfBeans < beanForCaffee) {
                log.info("Not enough beans, refilling...");
                amountOfBeans = 1.0;
            }
            grindBeans();

            if (waterLevel < waterForCaffee) {
                log.info("Not enough water, refilling...");
                waterLevel = 1.0;
            }
            boilWater();

            releaseWater();
        }
    }

    private void releaseWater() {
        waterLevel -= waterForCaffee;
        log.info("Coffee is ready!");
    }

    private void boilWater() {
        do {
            log.info("Heating up ... " + getTemp());
            heatWater();
        } while (getTemp() <= 100 );
    }

    private int getTemp() {
        return temp;
    }

    private void heatWater() {
        temp += 10;
    }

    private void grindBeans() {
        amountOfBeans -= beanForCaffee;
    }
}
