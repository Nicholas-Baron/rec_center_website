package control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.stream.IntStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dataccess.ReservationBusiness;

@SuppressWarnings("serial")
public class ViewRegistrationsControl extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		String userName = request.getParameter("username");

		var reservations = ReservationBusiness.getInstance().getReservations(userName);

		request.setAttribute("reservations",
						IntStream.range(0, reservations.size()).mapToObj(index -> {

							var o = reservations.get(index);
							var ts = o.getDatetime();
							return new String[] { "Reservation " + (index + 1),
											new SimpleDateFormat("MM/dd/yyyy").format(ts),
											new SimpleDateFormat("h:mm aa").format(ts),
											o.getStatus().toString() };
						}).toArray());

		RequestDispatcher rd = request.getRequestDispatcher("/view/ViewRegistrations.jsp");
		rd.forward(request, response);
	}
}
