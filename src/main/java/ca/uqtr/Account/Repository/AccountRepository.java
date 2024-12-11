package ca.uqtr.Account.Repository;

import ca.uqtr.Account.Entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

    @Nullable
    Account findByUsername(String username);

    @Nullable
    Account findByUsernameAndPassword(String username, String password);

}
