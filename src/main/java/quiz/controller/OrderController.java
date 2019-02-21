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
public class OrderController {
	 
	@Autowired
	 LoginMapper loginmapper;
	 
	 @RequestMapping(value="/createorder", method=RequestMethod.POST)
	   public String loginProcessor(@RequestParam Map<String, String>orderdetail, HttpServletRequest request ) {
		 Map<String,String> userreqest= new HashMap<String,String>();
		   
		 // client side validation 
		 if(orderdetail.get("productId")!=null)
			 userreqest.put("productId", orderdetail.get("productId"));	 
		 else 
			 return "Error : product Id should not be empty";
		 if(orderdetail.get("username")!=null)
			 userreqest.put("username", orderdetail.get("username"));
		 else 
			 return "Error : product Id should not be empty";
		 
		 if(orderdetail.get("quantity")!=null)
			 userreqest.put("quantity", orderdetail.get("quantity"));
		 else 
			 return "Error :quantity should not be empty";
		 
		 if(orderdetail.get("address")!=null)
			 userreqest.put("address", orderdetail.get("address"));
		 else 
			 return "Error :Address should not be empty";
		 
			
		 // check if product is exist in inventory
		 
		 int quantity=loginmapper.checkProductInInventory(orderdetail.get("productId"));
		 
		 if(quantity > Integer.parseInt(orderdetail.get("quantity")))
			 return loginmapper.createOrder(userreqest);
		 else
			 return "Qunatity is Not available in Inventoty";
		  
		
	    }
}
