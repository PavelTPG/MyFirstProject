/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandPost.logic;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
public class DispatcherPost extends HttpServlet {

   protected void forward(String address, HttpServletRequest request, HttpServletResponse response)

    throws ServletException, IOException{

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);

        dispatcher.forward(request, response);

    }
}
