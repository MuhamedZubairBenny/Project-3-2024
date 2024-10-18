package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Admin {
    @Id
    public String adminId;
    private String username;
    private String password;

    public Admin() {}

    public Admin(Builder builder){
        this.adminId = builder.adminId;
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getAdminId() {
        return adminId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(adminId, admin.adminId) && Objects.equals(username, admin.username) && Objects.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, username, password);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id='" + adminId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder {
        public String adminId;
        private String username;
        private String password;

        public Builder setAdmin_id(String admin_id) {
            this.adminId = admin_id;
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

        public Builder copy(Admin admin){
            this.adminId = admin.adminId;
            this.username = admin.username;
            this.password = admin.password;
            return this;
        }
        public Admin build() { return new Admin(this);}
    }
}
