package org.ifi.p20.gla.control;

import org.ifi.p20.gla.model.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	@Autowired
	private HelloWorld helloWorld;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public void helloWorld() {
		helloWorld.setMessage("Hello World from Spring MVC to JSF");
	}

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public void helloWorldPost(@RequestParam String msg) {
		helloWorld.setMessage(msg);
	}
}