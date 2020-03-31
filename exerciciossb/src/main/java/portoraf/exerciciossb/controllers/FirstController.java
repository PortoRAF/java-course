package portoraf.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

	@GetMapping(path = { "/hello", "/greeting" })
	public String hello() {
		return "Hello Spring Boot!";
	}
}
