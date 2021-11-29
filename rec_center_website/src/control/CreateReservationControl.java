package control;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dataccess.MessageException;
import model.dataccess.ReservationBusiness;

@SuppressWarnings("serial")
public class CreateReservationControl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
		var activityNames = ReservationBusiness.getInstance().getActivites().stream()
						.map(a -> a.getName()).toArray();

		req.setAttribute("activities", Arrays.toString(activityNames).replace("[", "").replace("]", ""));

		RequestDispatcher rd = req.getRequestDispatcher("/view/CreateReservation.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		String address = "";

		String userName = request.getParameter("username");
		String datetime = request.getParameter("datetime");

		try {

			ReservationBusiness.getInstance().makeReservation(userName, datetime);

			request.setAttribute("username", request.getParameter("username"));
			address = "/view/WelcomeView.jsp";

		} catch (MessageException e) {
			if (e.getMessage().equals("Username not informed.")) {
				request.setAttribute("ErrorLogin", "Username not informed.");
				address = "/view/LoginView.jsp";
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher(address);
		rd.forward(request, response);
	}
}
