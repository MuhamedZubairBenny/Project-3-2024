package za.ac.cput.domain;

import java.util.Objects;

public class Admin {
    public String admin_id;
    private String username;
    private String password;

    protected Admin() {}

    public Admin(Builder builder){
        this.admin_id = builder.admin_id;
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getAdmin_id() {
        return admin_id;
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
        return Objects.equals(admin_id, admin.admin_id) && Objects.equals(username, admin.username) && Objects.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(admin_id, username, password);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id='" + admin_id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder {
        public String admin_id;
        private String username;
        private String password;

        public Builder setAdmin_id(String admin_id) {
            this.admin_id = admin_id;
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
            this.admin_id = admin.admin_id;
            this.username = admin.username;
            this.password = admin.password;
            return this;
        }
        public Admin build() { return new Admin(this);}
    }
}
