package ca.uqtr.Account.DTO;

public class SignupResDTO {

    private Boolean emailExist;
    private Boolean professionIsSet;
    private Boolean isSignup;

    public SignupResDTO() {
    }

    public void setEmailExist(Boolean emailExist) {
        this.emailExist = emailExist;
    }

    public void setProfessionIsSet(Boolean professionIsSet) {
        this.professionIsSet = professionIsSet;
    }

    public void isSignup(Boolean signup) {
        isSignup = signup;
    }
}
