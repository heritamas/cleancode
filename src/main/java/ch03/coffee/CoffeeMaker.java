package ch03.coffee;

import java.util.logging.Logger;

public class CoffeeMaker {
    Logger log = Logger.getLogger(this.getClass().getName());

    final double waterForCaffee;
    final double beanForCaffee;

    public CoffeeMaker(double waterForCaffee, double beanForCaffee) {
        this.waterForCaffee = waterForCaffee;
        this.beanForCaffee = beanForCaffee;
    }

    private int temp = 10;
    private double waterLevel = 0;
    private double amountOfBeans = 0;
    

    public void make(int count) {
        log.info("Making coffee ...");
        for (int i = 0 ; i < count ; ++i) {
            log.info("coffee no " + i);
            checkAndRefillIngredients();
            
            grindBeans();
            
            boilWater();

            releaseWater();
        }
    }

    private void checkAndRefillIngredients() {
        if (!isThereEnoughBeans()){
            reloadBeans();
        }
        if (!isThereEnoughWater()){
            reloadWater();
        }
    }

    private void reloadWater() {
        waterLevel = 1.0;
    }

    private void reloadBeans() {
        amountOfBeans = 1.0;
    }


    private boolean isThereEnoughWater() {
        return waterLevel < waterForCaffee;
    }

    private boolean isThereEnoughBeans() {
        return amountOfBeans < beanForCaffee;
    }

    private void releaseWater() {
        waterLevel -= waterForCaffee;
        log.info("Coffee is ready!");
    }

    private void boilWater() {
        while (getTemp() <= 100 ){
            log.info("Heating up ... " + getTemp());
            heatWater();
        }
    }

    private int getTemp() {
        return temp;
    }

    private void heatWater() {
        temp += 10;
    }

    private void grindBeans() {
        log.info("Grinding beans.");
        amountOfBeans -= beanForCaffee;
        log.info("Remained beans: " + amountOfBeans);
    }
}
