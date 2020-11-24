package ch09.unittests;

public class ServiceProvider {

    public Service getService(String serviceType) {
        if ("printer".equals(serviceType)) {
            return new PrinterService();
        } else if ("logger".equals(serviceType)) {
            return new LoggerService();
        } else {
            return new PrinterService();
        }
    }
}
