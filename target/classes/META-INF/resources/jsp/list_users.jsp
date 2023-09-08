<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Users</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">         
<script src="../js/bootstrap.min.js"></script> 
</head>
<body>          
        <div class="container">
            <h2>Users</h2>
            <!--Search Form -->
            <form action="/users" method="get" id="seachUserForm" role="form">
                <input type="hidden" id="searchAction" name="searchAction" value="searchByName">
                <div class="form-group col-xs-5">
                    <input type="text" name="Name" id="Name" class="form-control" required="true" placeholder="Type the Name or Last Name of the user"/>                    
                </div>
                <button type="submit" class="btn btn-info">
                    <span class="glyphicon glyphicon-search"></span> Search
                </button>
                <br></br>
                <br></br>
            </form>
            
            <!--Users List-->
            <form action="/users" method="post" id="UserForm" role="form" >              
               
                <c:choose>
                    <c:when test="${not empty userList}">
                        <table  class="table table-striped">
                            <thead>
                                <tr>
                                    <td>#</td>
                                    <td>First Name</td>
                                    <td>Last name</td>
                                    <td>Password</td>                               
                                </tr>
                            </thead>
                            <c:forEach var="users" items="${userList}">
                                <c:set var="classSucess" value=""/>
                                <c:if test ="${idUser == users.Uid}">                        	
                                    <c:set var="classSucess" value="info"/>
                                </c:if>
                                <tr class="${classSucess}">
                                    <td>${users.Uid}</td>
                                    <td>${users.firstname}</td>
                                    <td>${users.lastName}</td>
                                    <td>${users.passWord}</td> 
                                   
                                </tr>
                            </c:forEach>               
                        </table>  
                    </c:when>                    
                    <c:otherwise>
                        <br>           
                        <div class="alert alert-info">
                            No people found matching your search criteria
                        </div>
                    </c:otherwise>
                </c:choose>                        
            </form>
           
        </div>
    </body>
</html>