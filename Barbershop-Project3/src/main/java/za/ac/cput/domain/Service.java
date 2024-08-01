package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Service {

    @Id
    private String serviceId;
    private String serviceName;
    private String serviceDescription;
    private double servicePrice;

    protected Service() {}

    private Service(Builder builder) {
        this.serviceId = builder.serviceId;
        this.serviceName = builder.serviceName;
        this.serviceDescription = builder.serviceDescription;
        this.servicePrice = builder.servicePrice;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Double.compare(service.servicePrice, servicePrice) == 0 &&
                Objects.equals(serviceId, service.serviceId) &&
                Objects.equals(serviceName, service.serviceName) &&
                Objects.equals(serviceDescription, service.serviceDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, serviceName, serviceDescription, servicePrice);
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceId='" + serviceId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", servicePrice=" + servicePrice +
                '}';
    }

    public static class Builder {
        private String serviceId;
        private String serviceName;
        private String serviceDescription;
        private double servicePrice;

        public Builder setServiceId(String serviceId) {
            if (serviceId == null || serviceId.trim().isEmpty()) {
                throw new IllegalArgumentException("Service ID cannot be null or empty");
            }
            this.serviceId = serviceId;
            return this;
        }

        public Builder setServiceName(String serviceName) {
            if (serviceName == null || serviceName.trim().isEmpty()) {
                throw new IllegalArgumentException("Service name cannot be null or empty");
            }
            this.serviceName = serviceName;
            return this;
        }

        public Builder setServiceDescription(String serviceDescription) {
            if (serviceDescription == null || serviceDescription.trim().isEmpty()) {
                throw new IllegalArgumentException("Service description cannot be null or empty");
            }
            this.serviceDescription = serviceDescription;
            return this;
        }

        public Builder setServicePrice(double servicePrice) {
            if (servicePrice < 0) {
                throw new IllegalArgumentException("Service price cannot be negative");
            }
            this.servicePrice = servicePrice;
            return this;
        }

        public Builder copy(Service service) {
            this.serviceId = service.serviceId;
            this.serviceName = service.serviceName;
            this.serviceDescription = service.serviceDescription;
            this.servicePrice = service.servicePrice;
            return this;
        }

        public Service build() {
            return new Service(this);
        }
    }
}


