package CommandPost.logic;

 

import CommandPost.entity.User;
import CommandPost.logic.DispatcherPost;
import TimePost.view.UserList;
import java.io.*;

import java.net.*;

 

import javax.servlet.*;

import javax.servlet.http.*;


 

public class CheckUser extends DispatcherPost {

    public String getServletInfo(){

        return "Registration servlet";

    }

   

    public void service(HttpServletRequest request, HttpServletResponse response)

    throws ServletException, IOException {

        User user = UserList.(request.getParameter("user"));

        if (user == null){

            this.forward("/registration.html", request, response);

         } else {

            if

                    (!user.getPassword().equals(request.getParameter("password"))){

                this.forward("/registration.html", request, response);

                } else {

                 this.forward("/successLogin.jsp", request, response);

                }

         }

    }

   

   }