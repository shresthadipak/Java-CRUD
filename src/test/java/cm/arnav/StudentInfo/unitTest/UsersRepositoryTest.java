package cm.arnav.StudentInfo.unitTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
////import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import com.arnav.StudentInfo.domain.Users;
import com.arnav.StudentInfo.repository.UsersRepository;

//@DataJpaTest
@ContextConfiguration(classes={UsersRepository.class})
@EnableJpaRepositories(basePackages = {"com.arnav.StudentInfo.repository.UsersRepository"})
@AutoConfigureTestDatabase(replace = Replace.NONE)
////@Rollback(false)
//@EnableAutoConfiguration
@SpringBootTest
public class UsersRepositoryTest {
	
	@Autowired
	private UsersRepository userrepo;
	
	@Test
	public void saveUsersTest() {
		Users user = Users.builder()
				.first_name("Ramesh")
				.last_name("Ghimire")
				.email("abc@abc.com")
				.password("test")
				.build();
		
		userrepo.save(user);
		Assertions.assertThat(user.getId()).isGreaterThan(0);
	}
}
