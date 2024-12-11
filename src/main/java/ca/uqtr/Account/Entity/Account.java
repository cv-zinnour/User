package ca.uqtr.Account.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account", schema = "public")
public class Account  {
    @Id
    UUID id;

    @Version
    @Column(name = "version", nullable = false)
    private int version;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "is_active")
    private Boolean isActive;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    Users user;

    public Account(String username, String password, Boolean isActive) {
        this.username = username;
        this.password = password;
        this.isActive = isActive;
    }
}
