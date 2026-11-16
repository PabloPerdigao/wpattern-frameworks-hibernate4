package org.wpattern.frameworks.hibernate4.daos;

import org.wpattern.frameworks.hibernate4.entities.OrderEntity;
import org.wpattern.frameworks.hibernate4.utils.GenericDao;


import javax.persistence.EntityManagerFactory;
import java.util.List;

public class OrderDao extends GenericDao<OrderEntity, Integer> {

    public OrderDao(EntityManagerFactory factory) {
        super(factory);
    }


    // anotação para ignorar avisos relacionados a operações não verificadas sobre conversão de tipos relacionados ao Generic
    // conversão object -> list
    @SuppressWarnings("unchecked")

    // classe retorna lista pedidos buscados pela cidade
    public List<OrderEntity> findByShipCity(String city) {


        // jpql- busca sobre as entidades
        List<OrderEntity> orders = (List<OrderEntity>)
                this.executeQuery("SELECT o FROM OrderEntity o WHERE o.shipCity = ?1",
                        city
                );

        return orders;
    }


}
