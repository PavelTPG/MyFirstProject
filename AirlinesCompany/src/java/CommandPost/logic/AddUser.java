/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandPost.logic;

import AirLines.DAL.dto.User;
import TimePost.view.UserList;
import java.io.*;

import javax.servlet.*;

import javax.servlet.http.*;


public class AddUser extends DispatcherPost {

     public String getServletInfo(){

        return "Add user servlet";

    } 

       public void doPost(HttpServletRequest request, HttpServletResponse response)

    throws ServletException, IOException {

           ServletContext ctx = getServletContext();

        if (request.getParameter("save")!=null){

               String user = request.getParameter("user");
               
               String login = request.getParameter("login");

               String password = request.getParameter("password");

               String email = request.getParameter("email");

               String address = request.getParameter("address");

               String phone = request.getParameter("phone");

               User newUser = new User();

               newUser.setName(phone);
               
               newUser.setLogin(login);

               newUser.setPassword(password);

               newUser.setEmail(email);

               newUser.setAddress(address);

               newUser.setPhone(phone);

               ctx.setAttribute("user", newUser);

               boolean res = UserList.addUser(user);

               if (res) {

            this.forward("/successRegistration.jsp", request, response);

        } else {

            this.forward("/errorRegistration.html", request, response);

        }

        } else if (request.getParameter("cancel")!=null){

               this.forward("/login.html", request, response);

    }

}

}