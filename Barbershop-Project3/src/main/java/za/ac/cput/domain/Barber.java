package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Barber {
    @Id
    private String id;
    private String username;
    private String name;
    private String password;
    private String specialization;
    private String phoneNum;

    public Barber(){}

    public Barber(Builder builder){
        this.id = id;
        this.username = username;
        this.name = name;
        this.password =  password;
        this.specialization = specialization;
        this.phoneNum = phoneNum;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Barber barber = (Barber) o;
        return Objects.equals(id, barber.id) && Objects.equals(username, barber.username) && Objects.equals(name, barber.name) && Objects.equals(password, barber.password) && Objects.equals(specialization, barber.specialization) && Objects.equals(phoneNum, barber.phoneNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, name, password, specialization, phoneNum);
    }

    @Override
    public String toString() {
        return "Barber{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", specialization='" + specialization + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }

    public static class Builder{
        private String id;
        private String username;
        private String name;
        private String password;
        private String specialization;
        private String phoneNum;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setSpecialization(String specialization) {
            this.specialization = specialization;
            return this;
        }

        public Builder setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
            return this;
        }

        public Builder copy(Barber barber){
            this.id = barber.id;
            this.username = barber.username;
            this.name = barber.name;
            this.password = barber.password;
            this.specialization = barber.specialization;
            this.phoneNum = barber.phoneNum;
            return this;
        }

        public Barber build(){return new Barber(this);}
    }

}
