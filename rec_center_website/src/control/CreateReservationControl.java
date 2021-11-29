package control;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dataccess.ActivityBusiness;
import model.dataccess.MessageException;
import model.dataccess.ReservationBusiness;

@SuppressWarnings("serial")
public class CreateReservationControl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
		var activityNames = ActivityBusiness.getInstance().getActivities().stream()
						.map(a -> a.getName()).toArray();

		req.setAttribute("activities",
						Arrays.toString(activityNames).replace("[", "").replace("]", "").trim());

		RequestDispatcher rd = req.getRequestDispatcher("/view/CreateReservation.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		String userName = request.getSession().getAttribute("username").toString();
		String datetime = request.getParameter("datetime");
		String[] activities = request.getParameterValues("activities");
		
		System.out.println(userName);

		String redirect = "";

		try {
			ReservationBusiness.getInstance().makeReservation(userName, datetime, Arrays
							.stream(activities).map(s -> s.trim()).collect(Collectors.toList()));

			request.setAttribute("username", request.getParameter("username"));
			redirect = "/view/ThankYou.jsp";
		} catch (MessageException e) {
			request.setAttribute("error", e.getMessage());
			redirect = "/view/WelcomeView.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(redirect);
		rd.forward(request, response);
	}
}
