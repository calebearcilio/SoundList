package api.soundlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoundListApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoundListApplication.class, args);
		System.out.println("Server on: http://localhost:3333/api");
	}

}
