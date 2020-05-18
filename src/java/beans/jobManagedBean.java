/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import client.jobClient;
import entity.Tblrequirement;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sebatsian
 */
@Named(value = "jobManagedBean")
@RequestScoped
public class jobManagedBean {
    
     Response res;
    String username;
    String password;
    jobClient jc;
    Collection<Tblrequirement> job;
    GenericType<Collection<Tblrequirement>> gjob;

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public jobClient getJc() {
        return jc;
    }

    public void setJc(jobClient jc) {
        this.jc = jc;
    }

    public Collection<Tblrequirement> getJob() {
        res=jc.alljob(Response.class);
        job=res.readEntity(gjob);
        return job;
    }

    public void setJob(Collection<Tblrequirement> job) {
        this.job = job;
    }

    /**
     * Creates a new instance of jobManagedBean
     */
    public jobManagedBean() {
         System.out.println("Hello BookCDI Bean ");
          HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";

       token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);
       
       jc=new jobClient(token);
       job=new ArrayList<Tblrequirement>();
       gjob=new GenericType<Collection<Tblrequirement>>(){};
    }
    
}
