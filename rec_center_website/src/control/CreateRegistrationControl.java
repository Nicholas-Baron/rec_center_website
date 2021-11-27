package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dataccess.LoginBusiness;
import model.dataccess.MessageException;

@SuppressWarnings("serial")
public class CreateRegistrationControl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
		doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		String address = "";

		try {

			String userName = request.getParameter("username");
			String datetime = request.getParameter("datetime");
			System.out.println(userName + " reserved time " + datetime);

			request.setAttribute("username", request.getParameter("username"));
			address = "/view/WelcomeView.jsp";

		} catch (MessageException e) {
			if (e.getMessage().equals("Username not informed.")) {
				request.setAttribute("ErrorLogin", "Username not informed.");
				address = "/view/LoginView.jsp";
			} else if (e.getMessage().equals("Password not informed.")) {
				request.setAttribute("ErrorLogin", "Password not informed.");
				address = "/view/LoginView.jsp";
			} else if (e.getMessage().equals("Incorrect credentials.")) {
				request.setAttribute("ErrorLogin", "Incorrect credentials.");
				address = "/view/LoginView.jsp";
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher(address);
		rd.forward(request, response);
	}
}
