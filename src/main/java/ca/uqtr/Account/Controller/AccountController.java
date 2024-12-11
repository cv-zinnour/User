package ca.uqtr.Account.Controller;

import ca.uqtr.Account.DTO.SigninDTO;
import ca.uqtr.Account.DTO.SigninResDTO;
import ca.uqtr.Account.DTO.SignupDTO;
import ca.uqtr.Account.DTO.SignupResDTO;
import ca.uqtr.Account.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    protected Logger logger = Logger.getLogger(AccountController.class.getName());

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * sign in.
     * *
     *
     * @param signinDTO
     * @return A bool.
     * @throws Exception If there are no matches at all.
     */
    @PostMapping("/signin")
    public ResponseEntity<SigninResDTO> signin(@RequestBody SigninDTO signinDTO){
        SigninResDTO sign_in = new SigninResDTO();
        try {
            sign_in = accountService.signIn(signinDTO);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised sign in REST Call", ex);
            return new ResponseEntity<>(sign_in, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(sign_in, HttpStatus.OK);
    }


    /**
     * sign up.
     * *
     *
     * @param signupDTO
     * @return A bool.
     * @throws Exception If there are no matches at all.
     */
    @PostMapping("/signup")
    public ResponseEntity<SignupResDTO> signup(@RequestBody SignupDTO signupDTO){

        SignupResDTO sign_up = new SignupResDTO();
        try {
            sign_up = accountService.signUp(signupDTO);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised sign up REST Call", ex);
            return new ResponseEntity<>(sign_up, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(sign_up, HttpStatus.OK);
    }
}
