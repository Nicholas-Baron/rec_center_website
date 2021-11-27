package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ViewRegistrationsControl extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		String userName = request.getParameter("username");
		System.out.println("User " + userName + " is looking at their reservations.");

		request.setAttribute("reservations", new String[] { "123", "test" });

		RequestDispatcher rd = request.getRequestDispatcher("/view/ViewRegistrations.jsp");
		rd.forward(request, response);
	}
}
