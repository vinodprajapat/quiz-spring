package quiz.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import quiz.mappers.LoginMapper;

@RestController
public class LoginController {

	 @Autowired
	 LoginMapper loginmapper;
	 
	 @ResponseBody
	 @RequestMapping(value="/abc", method=RequestMethod.POST)
	   public  String loginProcessor(@RequestParam Map<String, String>user, HttpServletRequest request ) {
		 Map<String,String> userreqest= new HashMap<String,String>();
		   
		 List<String> al= new ArrayList<String>();
		 
		 
		 System.out.println(user.get("email"));
		 System.out.println(user.get("password"));
		 
		 
		 if(user.get("email")!= null &&  user.get("password")!=null) {
			
			userreqest.put("email", user.get("email"));
			userreqest.put("password", user.get("password"));
			
		 al=loginmapper.findUserName(userreqest);
		 
		 System.out.println(al);
		 }
		 
		 return "User is exist " + al;
	    }
	 
	@RequestMapping(value="/home", method=RequestMethod.GET)
	 public String homepage() {
		 return "Home Page";
	 }
}
