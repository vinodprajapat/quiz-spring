package quiz.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import quiz.model.Order;
import quiz.model.User;

@Component
public class LoginMapper {

	private final SqlSession sqlsession;
	
	public LoginMapper(SqlSession sqlsession) {
		this.sqlsession=sqlsession;
	}
	
	public int SelectCount(int id) {
		return this.sqlsession.selectOne("totalcount");
	}
	// check username is valid or not by checking password
	public List<String> findUserName(Map<String, String> request) {
		 User us= new User();
		 us.setName(request.get("email"));
		 us.setSubject(request.get("password"));
		 
		 List<String> al = new ArrayList<String>();
		 
		 al= this.sqlsession.selectList("finduser", us);
		
		System.out.println("mapper" + al);
		
		return al;
	}
	
	public int checkProductInInventory(String productid) {
		
		int count=this.sqlsession.selectOne("checkProduct", productid);
		return count;
	}
	
     public String createOrder(Map<String, String> request) {
		Order o= new Order();
		
		o.setProductId(request.get("productid"));
		o.setUsername(request.get("username"));
		o.setQuantity(request.get("quantity"));
		o.setAddress(request.get("address"));
		
		int temp=this.sqlsession.insert("insertOrder", o);
		if(temp==1)
		return "Order is successfully created";
		else
			return "Error: order is not created";
	}
}
