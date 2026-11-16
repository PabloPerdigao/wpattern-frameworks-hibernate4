
package org.wpattern.frameworks.test.hibernate4.daos;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.wpattern.frameworks.hibernate4.daos.OrderDao;
import org.wpattern.frameworks.hibernate4.daos.OrderDetailDao;
import org.wpattern.frameworks.hibernate4.entities.OrderEntity;
import org.wpattern.frameworks.hibernate4.utils.DaoFactory;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class OrderDetailRepositoryTest {

    private static final Logger LOGGER = Logger.getLogger(OrderDetailRepositoryTest.class);

    private OrderDetailDao orderDetailDao = DaoFactory.orderDetailDaoInstance();

    @Test
    public void testeFindAll() {

        List<OrderEntity> ordersDetail =
                this.orderDetailDao.findAll();

        LOGGER.info(ordersDetail);

        assertNotNull(ordersDetail);
    }
}
