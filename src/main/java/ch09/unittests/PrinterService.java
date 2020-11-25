package ch09.unittests;

public class PrinterService implements Service {

    @Override
    public void doThis() {
        System.out.println("doing this ...");
    }

    @Override
    public void doThat() {
        System.out.println("doing that ...");
    }

    @Override
    public void doSomethingWithArgument(days day) {
        System.out.println("Today is " + day);
    }

    @Override
    public void doThisAndThat() {
        doThis();
        doThat();
    }
}
