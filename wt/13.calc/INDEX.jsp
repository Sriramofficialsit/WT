<% page contentType = "text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculator</title>
</head>
<body>
    <h1>Calculator</h1>
    <%
    try{
        calpack.Calcservice_Service service = new calpack.Calcservice_service();
        calpack.Calcservice port = service.getCalcservicePort();
        int a = 0;
        int b = 0;

        int result1 = port.add(5,6);
        int result2 = port.mul(5,6);
        int result3 = port.sub(6,5);
        double result4 = port.duv(6,5);
        out.println("<br><b>Sum</b>="+result1);
        out.println("<br><b>Sum</b>="+result2);
        out.println("<br><b>Sum</b>="+result3);
        out.println("<br><b>Sum</b>="+result4);
    }  
    catch(Exception e){
        out.println("Error"+e.getMessage());
    } 

%>

</body>
</html>