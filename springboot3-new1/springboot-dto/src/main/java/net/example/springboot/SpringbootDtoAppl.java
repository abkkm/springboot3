package net.example.springboot;

import net.example.springboot.model.Location;
import net.example.springboot.model.User;
import net.example.springboot.repository.LocationRepository;
import net.example.springboot.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootDtoAppl implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDtoAppl.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public void run(String... args) throws Exception {

		Location location = new Location();
		location.setPlace("India");
		location.setDescription("India is great place to live");
		location.setLongitude(60.5);
		location.setLatitude(20.5);
		locationRepository.save(location);

		User user1 = new User();
		user1.setFirstName("A");
		user1.setLastName("K");
		user1.setEmail("ak@gmail.com");
		user1.setPassword("secret");
		user1.setLocation(location);
		userRepository.save(user1);

		User user2 = new User();
		user2.setFirstName("K");
		user2.setLastName("A");
		user2.setEmail("ka@gmail.com");
		user2.setPassword("secret");
		user2.setLocation(location);
		userRepository.save(user2);

	}
}
