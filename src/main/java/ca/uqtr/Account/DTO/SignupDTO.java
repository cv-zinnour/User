package ca.uqtr.Account.DTO;

import ca.uqtr.Account.Entity.Account;
import ca.uqtr.Account.Entity.Profile;
import ca.uqtr.Account.Entity.VO.Address;
import ca.uqtr.Account.Entity.VO.Email;
import ca.uqtr.Account.Entity.VO.Institution;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupDTO implements Serializable {

    static final long serialVersionUID = 1L;
    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String midlleName;
    @NotNull
    @NotEmpty
    private String lastName;
    @NotNull
    @NotEmpty
    private Date birthday;
    @NotNull
    @NotEmpty
    private Profile profile;
    @NotNull
    @NotEmpty
    private Address address;
    @NotNull
    @NotEmpty
    private Email email;
    @NotNull
    @NotEmpty
    private Institution institution;
    @NotNull
    @NotEmpty
    private Account account;
}
