package ca.uqtr.Account.Service;


import ca.uqtr.Account.DTO.SigninDTO;
import ca.uqtr.Account.DTO.SigninResDTO;
import ca.uqtr.Account.DTO.SignupDTO;
import ca.uqtr.Account.DTO.SignupResDTO;

public interface AccountService {

    SigninResDTO signIn(SigninDTO signinDTO);

    SignupResDTO signUp(SignupDTO signupDTO);


}
