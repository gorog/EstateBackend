package hu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1031422249396784970L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		out.print("Hello");
		out.flush();
		out.close();

	}

}
