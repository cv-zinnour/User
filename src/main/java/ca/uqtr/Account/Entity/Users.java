package ca.uqtr.Account.Entity;

import ca.uqtr.Account.Entity.VO.Address;
import ca.uqtr.Account.Entity.VO.Email;
import ca.uqtr.Account.Entity.VO.Institution;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "public")
public class Users extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "midlle_name")
    private String midlleName;
    @Column(name = "last_name")
    private String lastName;
    @Temporal(value=TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthday;
    @Enumerated(EnumType.STRING)
    @Column(name = "profile")
    private Profile profile;
    @Embedded
    private Address address;
    @Column(name = "email")
    private Email email;
    @Embedded
    private Institution institution;
    @OneToOne(mappedBy="user", cascade = CascadeType.ALL)
    private Account account;

    public Users(String firstName, String midlleName, String lastName, Date birthday, Profile profile, Address address, Email email, Institution institution) {
        this.firstName = firstName;
        this.midlleName = midlleName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.profile = profile;
        this.address = address;
        this.email = email;
        this.institution = institution;
    }


}
