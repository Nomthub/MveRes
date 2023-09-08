package com.persons;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserService {

	    static List<Users> userList = UserList.getInstance();

	    public static List<Users> getAllUsers() {       
	        return userList;
	    }

	    public static List<Users> searchUsersByName(String name) {
	        Comparator<Users> groupByComparator = Comparator.comparing(Users::getFirstName)
	                                                    .thenComparing(Users::getLastName);
	        List<Users> result = userList
	                .stream()
	                .filter(e -> e.getFirstName().equalsIgnoreCase(name) || e.getLastName().equalsIgnoreCase(name))
	                .sorted(groupByComparator)
	                .collect(Collectors.toList());
	        return result;
	    }

	    public static Users getUsers(long id) throws Exception {
	        Optional<Users> match
	                = userList.stream()
	                .filter(e -> e.getUId() == id)
	                .findFirst();
	        if (match.isPresent()) {
	            return match.get();
	        } else {
	            throw new Exception("The user id " + id + " not found");
	        }
	    }   

}
