package za.ac.cput.factory;

import za.ac.cput.domain.Service;

public class ServiceFactory {
    public static Service createService(String serviceId, String serviceName, String serviceDescription, double servicePrice) {
        if (serviceId == null || serviceId.trim().isEmpty()) {
            throw new IllegalArgumentException("Service ID cannot be null or empty");
        }
        if (serviceName == null || serviceName.trim().isEmpty()) {
            throw new IllegalArgumentException("Service name cannot be null or empty");
        }
        if (serviceDescription == null || serviceDescription.trim().isEmpty()) {
            throw new IllegalArgumentException("Service description cannot be null or empty");
        }
        if (servicePrice < 0) {
            throw new IllegalArgumentException("Service price cannot be negative");
        }

        return new Service.Builder()
                .setServiceId(serviceId)
                .setServiceName(serviceName)
                .setServiceDescription(serviceDescription)
                .setServicePrice(servicePrice)
                .build();
    }
}


