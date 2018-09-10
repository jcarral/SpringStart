package com.demo.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String sayHello(Model model) {
		model.addAttribute("saludo", "Hola mundo");
		model.addAttribute("mensaje", "bla bla bla bla bla bla");
		model.addAttribute("url", "https://google.es");
		return "hello"; //Nombre de la vista
	}
}
