package com.persons;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServ
 */
@WebServlet(
        name = "UserServ",
        urlPatterns = {"/users"}
)
public class UserServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
     /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("searchAction");
        if (action!=null){
            switch (action) {           
            case "searchById":
                searchUserById(req, resp);
                break;           
            case "searchByName":
                searchUserByName(req, resp);
                break;
            }
        }else{
            List<Users> result = UserService.getAllUsers();
            forwardListUsers(req, resp, result);
        }
	}
	
	 private void searchUserById(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        long iduser = Integer.valueOf(req.getParameter("Uid"));
	        Users user = null;
	        try {
	            user = UserService.getUsers(iduser);
	        } catch (Exception ex) {
	            Logger.getLogger(UserServ.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        req.setAttribute("User", user);
	        req.setAttribute("action", "edit");
	        String nextJSP = "/jsp/new-user.jsp";
	        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
	        dispatcher.forward(req, resp);
	    }
	 
	 private void searchUserByName(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        String userName = req.getParameter("firstName");
	        List<Users> result = UserService.searchUsersByName(userName);        
	        forwardListUsers(req, resp, result);
	    }
	 
	 private void forwardListUsers(HttpServletRequest req, HttpServletResponse resp, List UserList)
	            throws ServletException, IOException {
	        String nextJSP = "/jsp/list_users.jsp";
	        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
	        req.setAttribute("userList", UserList);
	        dispatcher.forward(req, resp);
	    } 

}
