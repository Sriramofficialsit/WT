package tier;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "act_6a",urlPatterns = {"/act_6a"})

public class act_6a extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
int score=0;
try {
String str=request.getParameter("s1");
if(str.equals("IBM"))
score++;
str=request.getParameter("s2");

if(str.equals("COLOMBO"))
score++;
str=request.getParameter("s3");
if(str.equals("HOCKEY"))
score++;
str=request.getParameter("s4");
if(str.equals("FLANKERS"))
score++;
str=request.getParameter("s5");
if(str.equals("MOZILLA"))
score++;

str=request.getParameter("s6");
if(str.equals("Alang turing"))
score++;


str=request.getParameter("s7");
if(str.equals("Hypertext Transfer Protocol"))
score++;


str=request.getParameter("s8");
if(str.equals("Hypertext Transfer Protocol"))
score++;

str=request.getParameter("s9");
if(str.equals("Abstract Class"))
score++;


str=request.getParameter("s10");
if(str.equals("JavaScript"))
score++;



out.println("<html>");
out.println("<head>");
out.println("<title>Three tier</title>");
out.println("</head>");
out.println("<body><center> <p> THE TOTAL SCORE IS:</p>");
out.println(Integer.toString(score));
out.println("</center></body>");
out.println("</html>");
} finally {
out.close();
}
}
}

