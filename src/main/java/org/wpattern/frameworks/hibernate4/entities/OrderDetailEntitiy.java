package org.wpattern.frameworks.hibernate4.entities;


import org.wpattern.frameworks.hibernate4.keys.OrderDetailKey;
import org.wpattern.frameworks.hibernate4.utils.BaseBean;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="order_details")
public class OrderDetailEntitiy  extends BaseBean {

    private static final long serialVersionUID = 4145513888438234634L;

    @Id
    private OrderDetailKey id;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    private Short quantity;

    private Double discount;

    public OrderDetailEntitiy(){};

    public OrderDetailEntitiy(OrderDetailKey id, BigDecimal unitPrice, Short quantity, Double discount) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.discount = discount;
    }

    public OrderDetailKey getId() {
        return id;
    }

    public void setId(OrderDetailKey id) {
        this.id = id;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
