package controller;



import javax.validation.Valid;

import model.Person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DaoFactory;
import dao.PersonDao;

@Controller
public class RegisterController {
	
	private final PersonDao persondao=DaoFactory.getInstance().getProductDao();
	
	@RequestMapping("/registerForm")
	public String index(Model model){
		Person person = new Person();
		model.addAttribute("person",person);
		return "register";
	}
	
	@RequestMapping("/register")
	public String register(@Valid @ModelAttribute("person") Person person, BindingResult result){
		 if (result.hasErrors()) {
			 	System.out.println("data error");
		        return "register";
		 }
		//model.addAttribute("person",person);// do not need this here, ModelAttribute annotation keep the attributes
		 // http://moviedb.com/movies/1234 <= movieid
		 // http://moviedb.com?movieid=1234
		String newId= java.util.UUID.randomUUID().toString();
		newId=newId.replaceAll("-", "");
		person.setId(newId);
		persondao.addPerson(person);
		return "thankyou";
	}

}
