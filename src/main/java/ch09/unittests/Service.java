package ch09.unittests;

public interface Service {

    void doThis();
    void doThat();
    void doSomethingWithArgument(days day);
    void doThisAndThat();
    
    enum days{MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY};
}
