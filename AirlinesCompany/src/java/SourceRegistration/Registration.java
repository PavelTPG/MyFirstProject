/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceRegistration;

import java.io.*;

import java.net.*;

import javax.servlet.*;

import javax.servlet.http.*;

public class Registration extends DispatcherPost {

    public String getServletInfo(){

        return "Registration servlet";

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)

    throws ServletException, IOException {

        ServletContext ctx = getServletContext();

        if (request.getParameter("login")!=null){

            this.forward("/CheckUser", request, response);

        } else if (request.getParameter("registration")!=null) {

            this.forward("/registration.jsp", request, response);

        }

    }

}