package facades;

import dto.CustomerDTO;
import entities.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class CustomerFacade {

    private static CustomerFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private CustomerFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CustomerDTO addCustomer(Customer c){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(c);
            em.flush();
            em.getTransaction().commit();
        }finally{  
            em.close();
        }   
        return new CustomerDTO(c);
    }
    public CustomerDTO findCustomer(int id){
        EntityManager em = emf.createEntityManager();
        try{
            return new CustomerDTO(em.find(Customer.class, id));
        }finally{  
            em.close();
        }
    }
    public List<CustomerDTO> allCustomers(){
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT new dto.CustomerDTO(c) FROM Customer c", 
                    CustomerDTO.class).getResultList();
        } finally {
            em.close();
        }
    }
}