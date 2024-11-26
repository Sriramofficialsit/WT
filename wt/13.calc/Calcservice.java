package calpack;

import javax.jws.Webservice;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.stateless;

@Webservice(servicename="Calcservice")
@stateless()

public class Calcservice{
    @WebMethod(operationName="add")
    public int add(@WebParam(name="a")int a,@WebParam(name="b")int b){
        return a+b;
    }
    @WebMethod(operationName="sub")
    public int add(@WebParam(name="a")int a,@WebParam(name="b")int b){
        return a-b;
    }
    @WebMethod(operationName="mul")
    public int add(@WebParam(name="a")int a,@WebParam(name="b")int b){
        return a*b;
    }
    @WebMethod(operationName="div")
    public int add(@WebParam(name="a")int a,@WebParam(name="b")int b){
        return a/b;
    }
    
}
