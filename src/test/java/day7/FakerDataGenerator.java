package day7;
import com.github.javafaker.Faker;
public class FakerDataGenerator {

	void generatedummydata() {
   Faker faker  = new Faker();
   String name = faker.name().fullName(); // Miss Samanta Schmidt
   String firstName = faker.name().firstName(); // Emory
   String lastName = faker.name().lastName(); // Barton
   String username = faker.name().username();
   String password = faker.internet().password();
   
   String phoneno = faker.phoneNumber().cellPhone();
   String email = faker.internet().safeEmailAddress();
	}
}
