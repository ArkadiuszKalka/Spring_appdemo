package andrzej.appdemo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);

    @Modifying
    @Query("UPDATE User u set u.password= :newpassword WHERE u.email= :email")
    public void updateUserPassword(@Param("newpassword") String password, @Param("email") String email);


    @Modifying
    @Query("UPDATE User u set u.name= :newName, u.lastName= :newLastname, u.email= :newEmail where u.id= :id")
    public void updateUserProfile(@Param("newName") String newName, @Param("newLastName") String newLastName,
                                  @Param("newEmail")String newEmail, @Param("id")Integer id);
}
