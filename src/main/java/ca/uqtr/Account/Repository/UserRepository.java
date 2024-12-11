package ca.uqtr.Account.Repository;


import ca.uqtr.Account.Entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {

    @Nullable
    Users findByEmail(String email);

}
