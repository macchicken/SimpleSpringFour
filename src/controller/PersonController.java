package controller;

import javax.validation.Valid;

import model.Person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.DaoFactory;
import dao.PersonDao;

@Controller
public class PersonController {

	private final PersonDao persondao=DaoFactory.getInstance().getProductDao();
	
	
	@RequestMapping(value="/viewperson",method=RequestMethod.GET)
	public String viewPerson(Model model){
		model.addAttribute("personlist", persondao.getAllPerson());
		return "viewperson";
	}

	@RequestMapping(value="/person/edit/{id}",method=RequestMethod.GET)
	public String edit(@PathVariable String id,Model model){
		model.addAttribute("person", persondao.getPersonById(id));
		return "person";
	}
	
	@RequestMapping(value="/person/update",method=RequestMethod.POST)
	public String update(@Valid @ModelAttribute("person") Person person, BindingResult result){
		if (result.hasErrors()){System.out.println("data error");return "person";}
		persondao.updatePerson(person);
		return "redirect:/";
	}

	@RequestMapping(value="/person/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable String id){
		persondao.deletePerson(id);
		return "redirect:/viewperson";
	}

}
