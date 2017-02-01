package com.storageservice.person.ws;



import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.storageservice.person.model.Person;

//service definition
@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) 
public interface LocalApiPersonModel {
	
    
    @WebMethod(operationName="getPersonInformation")
    @WebResult(name="bmi") 
    public Person getPersonInformation(@WebParam(name="personId") long id);
    
    @WebMethod(operationName="updatePerson")
    @WebResult(name="idPerson") 
    public int updatePerson(@WebParam(name="person") Person p);
   
   
    @WebMethod(operationName="registration")
    @WebResult(name="registration") 
    public int registration(@WebParam(name="person") Person p);
 
    @WebMethod(operationName="login")
    @WebResult(name="login") 
    public Person login(@WebParam(name="email") String email,@WebParam(name="pwd") String psw);

  
}