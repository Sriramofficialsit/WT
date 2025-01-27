<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Mark List</title>
</head>
<body>
    <h3>Student Mark List</h3>
    <table border="1" align="center">
        <tr>
            <th>Roll Number</th>
            <th>Mark 1</th>
            <th>Mark 2</th>
        </tr>
        <%
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            try {
                String rollNoParam = request.getParameter("rollNumber");
                int rollNo = Integer.parseInt(rollNoParam);
                
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/SDB1", "sairam", "sairam");
                String query = "SELECT * FROM student WHERE rollno = ?";
                pstmt = con.prepareStatement(query);

                pstmt.setInt(1, rollNo);
                rs = pstmt.executeQuery();

            
                if (!rs.isBeforeFirst()) {
                    out.println("<tr><td colspan='3'>No records found for Roll Number " + rollNo + "</td></tr>");
                } else {
                    while (rs.next()) {
                        int rollno = rs.getInt("rollno");
                        int mark1 = rs.getInt("mark1");
                        int mark2 = rs.getInt("mark2");
        %>
                        <tr>
                            <td><%= rollno %></td>
                            <td><%= mark1 %></td>
                            <td><%= mark2 %></td>
                        </tr>
        <%
                    }
                }
            } catch (Exception e) {
                out.println("<p style='color: red;'>Error: " + e.getMessage() + "</p>");
            } finally {
                if (rs != null) try { rs.close(); } catch (SQLException ignored) {}
                if (pstmt != null) try { pstmt.close(); } catch (SQLException ignored) {}
                if (con != null) try { con.close(); } catch (SQLException ignored) {}
            }
        %>
    </table>
</body>
</html>
