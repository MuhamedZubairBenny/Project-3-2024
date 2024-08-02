package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Login {
    @Id
    private String username;
    private String password;
    private String userType;

    public Login(String username, String password, String userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }
}
