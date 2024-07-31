package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Client {
    @Id
    private String email;
    private String username;
    private String password;
    private String phone;
    private String firstName;
    private String surname;

    protected Client() {}

    public Client(Builder builder){
        this.email = builder.email;
        this.username = builder.username;
        this.password = builder.password;
        this.phone = builder.phone;
        this.firstName = builder.firstName;
        this.surname = builder.surname;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(email, client.email) && Objects.equals(username, client.username) && Objects.equals(password, client.password) && Objects.equals(phone, client.phone) && Objects.equals(firstName, client.firstName) && Objects.equals(surname, client.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, username, password, phone, firstName, surname);
    }

    @Override
    public String toString() {
        return "Client{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public static class Builder {

        private String email;
        private String username;
        private String password;
        private String phone;
        private String firstName;
        private String surname;

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }
        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }
        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }
        public Builder copy(Client client) {
            this.email = client.email;
            this.username = client.username;
            this.password = client.password;
            this.phone = client.phone;
            this.firstName = client.firstName;
            this.surname = client.surname;
            return this;
        }
        public Client build() {return new Client(this);
        }
    }
}
