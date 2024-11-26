import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Character.UnicodeBlock.of;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {


HttpSession session = request.getSession(true);
Date createTime = new Date(session.getCreationTime());
Date lastAccessTime = new Date(session.getLastAccessedTime());
String title = "Welcome Back to my website";
Integer visitCount;
visitCount = 0;
String visitCountKey = "visitCount";
String userIDKey = "userID";
String userID = "ABCD";
if (session.isNew()) {
title = "Welcome to my website";
session.setAttribute(userIDKey, userID);
} else {
visitCount = (Integer)session.getAttribute(visitCountKey);
visitCount = visitCount + 1;
userID = (String)session.getAttribute(userIDKey);
}
session.setAttribute(visitCountKey, visitCount);
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("Session ID="+session.getId() + "</br>"+"Creation Time="+createTime +
"</br>"+"Time of Last Access="+lastAccessTime + "</br>"+ "USER ID="+userID +"</br>"+
"Number of Visits="+visitCount);
}
}
