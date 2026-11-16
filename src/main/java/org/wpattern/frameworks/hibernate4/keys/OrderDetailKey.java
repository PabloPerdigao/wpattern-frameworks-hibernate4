package org.wpattern.frameworks.hibernate4.keys;


import org.wpattern.frameworks.hibernate4.utils.BaseBean;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable // guardar chaves primárias das tabelas
public class OrderDetailKey  extends BaseBean {
    private static final long serialVersionUID = 4022744788768596635L;

    @Column(name="order_id")
    private Integer orderID;

    @Column(name = "product_id")
    private Integer productID;

    private OrderDetailKey(){};

    public OrderDetailKey(Integer orderID, Integer productID) {
        this.orderID = orderID;
        this.productID = productID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }
}
