package ch09.unittests;

import java.util.stream.IntStream;

public class ServiceUser {

    ServiceProvider sp;
    Service sv;

    public ServiceUser(ServiceProvider sp) {
        this.sp = sp;
    }

    public void createService(String type) {
        sv = sp.getService(type);
    }

    public void do3This2That() {
        createService("logger");
        IntStream.range(0,3).forEach(i -> sv.doThis());
        IntStream.range(0,2).forEach(i -> sv.doThat());
    }
    
    public void whatDayIsIt() {
        createService("printer");
        sv.doSomethingWithArgument(Service.days.TUESDAY);
    }

}
