/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Tblrequirement;
import entity.Tbluser;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author sebatsian
 */
@Local
public interface UserbeanLocal {
    Tbluser storeSession(String userName);
    Collection<Tblrequirement> alljob();
}
