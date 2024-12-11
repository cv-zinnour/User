package ca.uqtr.Account;

import ca.uqtr.Account.Controller.AccountController;
import ca.uqtr.Account.DTO.SigninDTO;
import ca.uqtr.Account.DTO.SigninResDTO;
import ca.uqtr.Account.DTO.SignupDTO;
import ca.uqtr.Account.DTO.SignupResDTO;
import ca.uqtr.Account.Entity.Account;
import ca.uqtr.Account.Entity.Profile;
import ca.uqtr.Account.Entity.VO.Address;
import ca.uqtr.Account.Entity.VO.Email;
import ca.uqtr.Account.Entity.VO.Institution;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;

public abstract class AbstractAccountControllerTests {


    @Autowired
    AccountController accountController;

    @Test
    public void signInTest() {
        Logger.getGlobal().info("Start signInTest test");
        ResponseEntity<SigninResDTO> account = accountController.signin(new SigninDTO("lacen", "pass"));
        Assert.assertEquals(HttpStatus.OK, account.getStatusCode());
        Assert.assertTrue(account.hasBody());
        Assert.assertNotNull(account.getBody());
        Logger.getGlobal().info(String.valueOf(account.toString()));
        Logger.getGlobal().info("End signInTest test");
    }

    @Test
    public void signUpTest() throws ParseException {
        Logger.getGlobal().info("Start signUpTest test");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        Date date = sdf.parse("06/24/2017");
        Address address = new Address("jean tallon", 10, "TR", "XYZ 123", "QB");
        Email email = new Email("email@gmail.com");
        Institution institution = new Institution("healthcare uqtr", "UQTR110223");
        Account account = new Account("lacen1", "pass1", false);

        SignupDTO signupDTO = new SignupDTO("zin", "", "lac", date, Profile.ADMIN, address, email, institution, account);
        ResponseEntity<SignupResDTO> user = accountController.signup(signupDTO);
        Assert.assertEquals(HttpStatus.OK, user.getStatusCode());
        Assert.assertTrue(user.hasBody());
        Assert.assertNotNull(user.getBody());
        Logger.getGlobal().info("End signUpTest test");
    }
}
