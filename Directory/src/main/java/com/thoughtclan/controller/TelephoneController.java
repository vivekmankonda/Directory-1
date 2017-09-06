package com.thoughtclan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.thoughtclan.entites.PersonModel;
import com.thoughtclan.service.TelephoneService;
import com.thoughtclan.validator.ToDoValidator;

@Controller
public class TelephoneController {

	@Autowired
	TelephoneService myBean;
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value= HttpStatus.BAD_REQUEST)
	public String handleBadRequestException(MethodArgumentNotValidException ex) {
       return "error";
   }
	
//	@InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.addValidators(new ToDoValidator());
//    }
//	@PostMapping("/addPerson")
//    public String addName(ModelMap model, @Valid@ModelAttribute(name = "person")Person eObj, BindingResult result) {
//        if (result.hasErrors())
//        {
//            return "add";
//        } 
//        else
//        {
//            myBean.addPerson(eObj.getName(),eObj.getPhoneno());
//            return "index";
//        }
//        
//    }
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(ModelMap model,@Validated @RequestParam(value = "name", defaultValue = "Guest") String name,
			@RequestParam(value = "phoneno", defaultValue = "0") String phoneno) {
		List<PersonModel> persons;
		if(phoneno.length()!=10) {
			return "errorPhoneLength";
		}
		boolean check=(myBean.addPerson(name, phoneno));
		if(check) {
		persons = myBean.getAllPersons();
		model.addAttribute("person", persons);
		return "index";
		}
		else 
			return "errorAdd";
	}
	@RequestMapping("/add")
	public String add() {
		return "add";
	}
//	@PostMapping("/addN")
//    public String addPerson(ModelMap model, @Valid @ModelAttribute(name = "personDetails") Person personDetails,
//            BindingResult result) {
//        if (result.hasErrors()) {
//            return "add";
//        } else {
//            List<Person> persons;
//            System.out.println(personDetails.getName());
//            boolean check = myBean.addPerson(personDetails.getName(), personDetails.getPhoneno());
//            if (check) {
//                persons = myBean.getAllPersons();
//                model.addAttribute("person", persons);
//                return "index";
//            } else
//                return "errorAdd";
//        }
//    }
//
//    @RequestMapping("/add")
//    public String add(ModelMap model) {
//        Person personDetails = new Person();
//        model.addAttribute("personDetails", personDetails);
//        return "add";
//    }
	// @RequestMapping("/editNumber")
	// public String editNumber(ModelMap model) {
	//
	// PhoneNumber p = new PhoneNumber();
	// model.addAttribute("phoneno", p);
	// return "edit";
	// }
	@RequestMapping("/deleteId")
	public String deletePerson(ModelMap model, @RequestParam(value = "id", defaultValue = "0") int id) {

		List<PersonModel> persons;
		boolean flag=myBean.delete(id);
    if(flag)
    {
		persons = myBean.getAllPersons();
		model.addAttribute("person", persons);
		return "index";

	}
    else 
    	return "error";
	}
	@RequestMapping("/delete")
	public String delete() {
		return "delete";
	}

	@RequestMapping("/searchId")
	public String searchId(ModelMap model, @RequestParam(value = "id", defaultValue = "0") int id) {

		PersonModel person = new PersonModel();

		person = myBean.searchId(id);

		model.addAttribute("person", person);
		return "searchResultById";

	}

	@RequestMapping("/searchI")
	public String searchI() {
		return "searchI";
	}
	@RequestMapping("/searchName")
	public String searchName(ModelMap model, @RequestParam(value = "username", defaultValue = "guest") String name) {
System.out.println(name);
		List<PersonModel> person = new ArrayList<PersonModel>();
				person=myBean.searchName(name);
		
		model.addAttribute("person", person);
		return "searchResultByName";

	}

	@RequestMapping("/searchN")
	public String searchN() {
		return "searchN";
	}
	@RequestMapping("/searchPhone")
	public String searchPhone(ModelMap model, @RequestParam(value = "phoneno", defaultValue = "0") String phoneno) {
System.out.println(phoneno);
		PersonModel personSearched= new PersonModel();
		personSearched=myBean.searchPhone(phoneno);
		
		model.addAttribute("person", personSearched);
		return "searchResultByPhone";

	}

	@RequestMapping("/searchP")
	public String searchP() {
		return "searchP";
	}
	@RequestMapping("/editId")
    public String editId(ModelMap model, @RequestParam(value = "id", defaultValue = "0") int id) {

        PersonModel person = myBean.searchId(id);
        System.out.println("editID" + id);

        model.addAttribute("person", person);
        return "editId";

    }
	@RequestMapping("/editRequest")
    public String editRequest(ModelMap model, @RequestParam(value = "id", defaultValue = "0") String id,
            @RequestParam(value = "username", defaultValue = "guest") String name,
            @RequestParam(value = "phone", defaultValue = "0") String phoneno,
            @RequestParam(value = "secondaryphone", defaultValue = "0") String secondaryphoneno) {
    
        System.out.println("editrequest" + id);
        PersonModel person=new PersonModel();
        //person =
        int id1;
        id1=(Integer.parseInt(id));
        person.setId(id1);
        
        person.setName(name);
        person.setPhoneno(phoneno);
        person.setSecondaryphoneno(secondaryphoneno);


        myBean.edit(person);
        List<PersonModel> persons;
        persons = myBean.getAllPersons();
        model.addAttribute("person", persons);
        return "index";

    }

	@RequestMapping("/edit")
	public String edit() {
		return "edit";
	}

	@GetMapping("/")
    public String welcome(ModelMap model) {
        List<PersonModel> persons2;
        persons2 = myBean.getAllPersons();
        model.addAttribute("person", persons2);
        return "index";
    }

}
