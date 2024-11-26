package airinfo;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.*;

@WebService(name="Test",servicename="TestDb")
public class TESTDB{
    @WebMethod(operationname="getinfo")
    public String getinfo(@WebParam(name="src")String src,@WebParam(name="dest")String dest){
        String str = "";
        try{
            class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection('jdbc:derby://localhost:3443/SDB','admin','123456');
            Statement s = con.createStatement();
            String query ="SELECT * FROM student.airways_table WHERE Start_from =+src+AND Dest =+dest+"
            ResultSet rs = s.executeQuery(query);

            str+= "<table border=1>";
            while(rs.next()){
                str+="<tr>";
                str+="<td>"+rs.getString("name")+"</td>";
                str+="</tr>";
            }
           

        }catch(ClassNotFoundException ex){
            System.out.println(ex)
        }catch(SQLException ex){
            System.out.println(ex)
        }
        return str;
    }
}