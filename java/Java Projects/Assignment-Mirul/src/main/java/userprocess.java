
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class userprocess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		String fname = request.getParameter("name");
		String lname = request.getParameter("lname");
		String email = request.getParameter("mail");
		String zcode = request.getParameter("zcode");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pwd");
		String cpass = request.getParameter("cpwd");
		String[] cb1 = request.getParameterValues("cb1");
		String[] rb1 = request.getParameterValues("rb1");
		
		String message = "Please Provide valid input";
		
		if (fname == "" || lname == "" || email == "" || zcode == "" || uname == "" || pass == "" || cpass == "" ) 
		{
			out.println("<html>");
			out.println("<head>");
			out.println("<body>");
			out.println("<script type='text/javascript'>");
			out.println("alert(" + "'" + message + "'" + ");</script>");
			out.println("</body>");
			out.println("</head>");
			out.println("</html>");
		}
		else
		{
			out.println("<html>");
			out.println("<link rel=\"stylesheet\" href=\"output.css\">");
			out.println("<head>");
			out.println("<body>");
			out.println("<link rel=\"stylesheet\" href=\"outout.css\">\r\n"
					+ "<title>Assignment1</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<div id=\"container\">"
					+ "			<h2>Thank you for joining our mailing list</h2>\r\n"
					+ "			<h4>Here is the information that you entered:</h4>\r\n"
					+ "			<br>\r\n"
					+ "			<t1>First Name:" +fname+"</t1><br><br>\r\n"
					+ "			<t1>Last Name:" +lname+ "</t1><br><br>\r\n"
					+ "			<t1>Email:" +email+ "</t1><br><br>\r\n"
					+ "			<t1>Zip code:" +zcode+ "</t1><br><br>\r\n"
					+ "			<t1>usename:" +uname+ "</t1><br><br>\r\n"
					+ "			<t1>password:" +pass+ "</t1><br><br>\r\n"
					);
			out.print("<h4>");
			out.print("Favourite music:&nbsp");
			for( String s : cb1)
			{
				
				out.print("<t1>" +  s  +",</t1>");
			}
			out.println("<br><br>");
			out.print("receive special sale notification:&nbsp");
			for( String w : rb1)
			{
				
				out.print("<t1>" +  w  +"</t1>");
			}
			out.print("</h4>");
			out.println("</div>");
			out.println("</body>");
			out.println("</head>");
			out.println("</html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

};