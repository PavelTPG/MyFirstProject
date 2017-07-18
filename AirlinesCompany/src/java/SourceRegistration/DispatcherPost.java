
package SourceRegistration;

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

   public void forward(String address, HttpServletRequest request, HttpServletResponse response)

    throws ServletException, IOException{

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);

        dispatcher.forward(request, response);

    }
}