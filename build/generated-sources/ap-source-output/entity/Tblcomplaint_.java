package entity;

import entity.Tbluser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-14T11:57:55")
@StaticMetamodel(Tblcomplaint.class)
public class Tblcomplaint_ { 

    public static volatile SingularAttribute<Tblcomplaint, Date> createdDate;
    public static volatile SingularAttribute<Tblcomplaint, Integer> complaintId;
    public static volatile SingularAttribute<Tblcomplaint, String> complaint;
    public static volatile SingularAttribute<Tblcomplaint, Tbluser> userId;
    public static volatile SingularAttribute<Tblcomplaint, Integer> status;

}