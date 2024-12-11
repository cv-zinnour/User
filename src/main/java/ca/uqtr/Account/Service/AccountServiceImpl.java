package ca.uqtr.Account.Service;


import ca.uqtr.Account.DTO.SigninDTO;
import ca.uqtr.Account.DTO.SigninResDTO;
import ca.uqtr.Account.DTO.SignupDTO;
import ca.uqtr.Account.DTO.SignupResDTO;
import ca.uqtr.Account.Entity.Account;
import ca.uqtr.Account.Entity.Users;
import ca.uqtr.Account.Repository.AccountRepository;
import ca.uqtr.Account.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private UserRepository userRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public SigninResDTO signIn(SigninDTO signinDTO) {
//        Account account = new Account();
//        BeanUtils.copyProperties(signinDTO, account);

        SigninResDTO signinResDTO = new SigninResDTO();
        if (accountRepository.findByUsername(signinDTO.getUsername()) == null){
            signinResDTO.setUserNameExist(false);

        } else {
            signinResDTO.setUserNameExist(true);
            if (accountRepository.findByUsernameAndPassword(signinDTO.getUsername(), signinDTO.getPassword()) == null) {
                signinResDTO.setPasswordIsTrue(false);
            } else {
                signinResDTO.setPasswordIsTrue(true);
            }
        }

        return signinResDTO;
    }

    @Override
    public SignupResDTO signUp(SignupDTO signupDTO) {
        Users users = new Users(
                signupDTO.getFirstName(),
                signupDTO.getMidlleName(),
                signupDTO.getLastName(),
                signupDTO.getBirthday(),
                signupDTO.getProfile(),
                signupDTO.getAddress(),
                signupDTO.getEmail(),
                signupDTO.getInstitution());
        Account account = new Account(signupDTO.getAccount().getUsername(),
                signupDTO.getAccount().getPassword(),
                signupDTO.getAccount().getIsActive());

        users.setAccount(account);
        account.setUser(users);
        //BeanUtils.copyProperties(signupDTO, users);
        SignupResDTO signupResDTO = new SignupResDTO();
        if (userRepository.findByEmail(signupDTO.getEmail().getValue()) != null){
            signupResDTO.setEmailExist(true);
            return signupResDTO;
        }

        if (signupDTO.getProfile() == null){
            signupResDTO.setProfessionIsSet(false);
            return signupResDTO;
        }
        userRepository.save(users);
        signupResDTO.setProfessionIsSet(true);
        signupResDTO.isSignup(true);

        return signupResDTO;
    }
}
