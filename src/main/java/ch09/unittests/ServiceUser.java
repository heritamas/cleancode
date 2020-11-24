package ch09.unittests;

public class ServiceUser {

    public static void main(String[] args) {
        Service sv = ServiceProvider.getService("printer");

        sv.doThisAndThat();
    }
}
