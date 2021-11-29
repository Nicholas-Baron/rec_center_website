package control;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

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

		req.setAttribute("activities",
						Arrays.toString(activityNames).replace("[", "").replace("]", "").trim());

		RequestDispatcher rd = req.getRequestDispatcher("/view/CreateReservation.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		String userName = request.getParameter("username");
		String datetime = request.getParameter("datetime");
		String[] activities = request.getParameterValues("activities");

		try {
			ReservationBusiness.getInstance().makeReservation(userName, datetime, Arrays
							.stream(activities).map(s -> s.trim()).collect(Collectors.toList()));

			request.setAttribute("username", request.getParameter("username"));
		} catch (MessageException e) {
			request.setAttribute("error", e.getMessage());
		}

		RequestDispatcher rd = request.getRequestDispatcher("/view/WelcomeView.jsp");
		rd.forward(request, response);
	}
}
