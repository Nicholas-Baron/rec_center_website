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
public class LoginControl extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
		doPost(req, resp);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		String address = "";

		try {

			String userName = request.getParameter("username");
			String password = request.getParameter("password");

			LoginBusiness.getInstance().loginUser(userName);

			request.setAttribute("username", userName);
			request.getSession().setAttribute("username", userName);
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
