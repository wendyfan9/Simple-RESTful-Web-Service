package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController{

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")  //ensure HTTP request to /greeting are mapped to the greeting method
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name){
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}


/*The above does not specify GET vs. PUT, POST and so forth, becuase:
	@RequestMapping maps all HTTP operations by default;
	@RequestMapping(method=GET) to narrow this mapping;
*/

// RequestParam binds the value of the query string parameter name into the name parameter of the greeting() method. 

//ESTful web service controller simply populates and returns an Greeting object. The object data will be writtern directly to the HTTP response as JSON

//@RestController: marks the class as a controller where every method returns a domain object instead of a view.

