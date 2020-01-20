package entity;

import entity.Address;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-19T19:20:47")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> fname;
    public static volatile ListAttribute<Customer, Address> addresses;
    public static volatile SingularAttribute<Customer, String> lname;
    public static volatile SingularAttribute<Customer, Long> id;

}