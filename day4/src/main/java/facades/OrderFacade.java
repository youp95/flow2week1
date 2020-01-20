/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.ItemTypeDTO;
import dto.OrderLineDTO;
import dto.OrderDTO;
import entities.Customer;
import entities.ItemType;
import entities.Order;
import entities.OrderLine;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Younes
 */
public class OrderFacade {

    private static OrderFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private OrderFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static OrderFacade getOrderFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new OrderFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public OrderDTO addOrder(Order o, int id) {
        EntityManager em = emf.createEntityManager();
        o.setCustomer(em.find(Customer.class, id));
        try {
            em.getTransaction().begin();
            em.persist(o);
            em.flush();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new OrderDTO(o);
    }

    public List<OrderDTO> findCustomerOrders(int id) {
        EntityManager em = emf.createEntityManager();
        Customer c = em.find(Customer.class, id);
        try {
            TypedQuery<OrderDTO> query = em.createQuery("SELECT new dto.OrderDTO(o) from Order o WHERE o.customer.id = :arg", OrderDTO.class);
            query.setParameter("arg", id);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public OrderLineDTO addOrderLine(OrderLine oline, int orderId, int itemId) {
        EntityManager em = emf.createEntityManager();
        Order order = em.find(Order.class, orderId);
        ItemType it = em.find(ItemType.class, itemId);
        order.getOrderLines().add(oline);
        oline.setItemType(it);
        try {
            em.getTransaction().begin();
            em.persist(oline);
            em.flush();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new OrderLineDTO(oline);
    }
    public ItemTypeDTO addItemType(ItemType it) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(it);
            em.flush();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new ItemTypeDTO(it);
    }
}