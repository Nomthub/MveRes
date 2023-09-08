package com.persons;
import java.util.ArrayList;
import java.util.List;

public class UserList {
	private static final List<Users> UserList = new ArrayList();
	private UserList() {
		// TODO Auto-generated constructor stub
	}
	    
	    static{
	        UserList.add(new Users("John","Smith","12-12-1980"));
	        UserList.add(new Users("Laura","Adams","02-11-1979"));
	        UserList.add(new Users("Peter","Williams","22-10-1966"));
	        UserList.add(new Users("Joana","Sanders","11-11-1976"));
	        UserList.add(new Users("John","Drake","18-08-1988"));
	        UserList.add(new Users("Samuel","Williams","22-03-1985"));
	    }
	    
	    public static List <Users> getInstance(){
	        return UserList;
	    }
	}

