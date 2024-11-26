<% @page import="airinfo.TESTDB"%>
<%
String source = request.getParameter("Src_name");
String destination = request.getParameter("Dest_name");

TestDB testDB = new TestDB();
String flightinfo = testDB.getinfo(source,destination);
%>

<html>
    <head>
        <title>Flight info</title>
    </head>
    <body>
        <center>
            <h4>Available Flights from <%=source%> to <%=destination%>:</h4>
            <%=flightinfo%>
        </center>
    </body>
</html>