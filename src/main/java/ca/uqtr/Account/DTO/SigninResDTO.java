package ca.uqtr.Account.DTO;

import lombok.ToString;
import org.springframework.web.bind.annotation.DeleteMapping;

@ToString
public class SigninResDTO {

    private Boolean userNameExist;
    private Boolean passwordIsTrue;

    public SigninResDTO() {
    }

    public void setUserNameExist(Boolean userNameExist) {
        this.userNameExist = userNameExist;
    }

    public void setPasswordIsTrue(Boolean passwordIsTrue) {
        this.passwordIsTrue = passwordIsTrue;
    }
}
