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
		String userName = request.getParameter("username");

		try {
			LoginBusiness.getInstance().loginUser(userName);

			request.setAttribute("username", userName);
			request.getSession().setAttribute("username", userName);
			address = "/view/WelcomeView.jsp";

		} catch (MessageException e) {
			request.setAttribute("ErrorLogin", e.getMessage());
			address = "/view/LoginView.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(address);
		rd.forward(request, response);

	}

}
