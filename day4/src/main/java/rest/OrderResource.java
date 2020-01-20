package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CustomerDTO;
import dto.OrderDTO;
import entities.Customer;
import entities.ItemType;
import entities.Order;
import entities.OrderLine;
import utils.EMF_Creator;
import facades.CustomerFacade;
import facades.OrderFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("order")
public class OrderResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/examprep",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final OrderFacade FACADE = OrderFacade.getOrderFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    
    @POST
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String addOrder(@PathParam("id") int id, String json) {
        Order o = GSON.fromJson(json, Order.class);
        return GSON.toJson(FACADE.addOrder(o, id));
    }
    @Path("/orders/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getCustomerOrders(@PathParam("id") int id) {
        return GSON.toJson(FACADE.findCustomerOrders(id));
    }
    @Path("/itemtype")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String addItemType(String json) {
        ItemType it = GSON.fromJson(json, ItemType.class);
        return GSON.toJson(FACADE.addItemType(it));
    }
    @Path("/orders/{id}/{it_id}")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String addOrderLine(String json, @PathParam("id") int id, @PathParam("it_id") int it_id) {
        OrderLine ol = GSON.fromJson(json, OrderLine.class);
        return GSON.toJson(FACADE.addOrderLine(ol, id, it_id));
    }
    
}