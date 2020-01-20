package facades;

import dto.ItemTypeDTO;
import entities.ItemType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class ItemTypeFacade {

    private static ItemTypeFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private ItemTypeFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static ItemTypeFacade getItemTypeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ItemTypeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ItemTypeDTO addItemType(ItemType item){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(item);
            em.flush();
            em.getTransaction().commit();
        }finally{  
            em.close();
        }   
        return new ItemTypeDTO(item);
    }
    
    public ItemTypeDTO findItemType(int id){
        EntityManager em = emf.createEntityManager();
        try{
            return new ItemTypeDTO(em.find(ItemType.class, id));
        }finally{  
            em.close();
        }
    }
}