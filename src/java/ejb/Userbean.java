/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Tblrequirement;
import entity.Tbluser;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sebatsian
 */
@Stateless
public class Userbean implements UserbeanLocal {
    
     @PersistenceContext(unitName = "Engiworks-ejbPU")
    EntityManager em;
    @PostConstruct()
    public void init()
    {
      em = Persistence.createEntityManagerFactory("Engiworks-ejbPU").createEntityManager();
    }

    @Override
    public Tbluser storeSession(String userName) {
         Tbluser u=(Tbluser)em.createNamedQuery("Tbluser.findByUserName").setParameter("userName",userName).getSingleResult();
        return u;
    }

    @Override
    public Collection<Tblrequirement> alljob() {
        return em.createNamedQuery("Tblrequirement.findAll").getResultList();
    }

}
