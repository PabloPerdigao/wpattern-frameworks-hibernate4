package org.wpattern.frameworks.hibernate4.entities;

import org.wpattern.frameworks.hibernate4.utils.BaseBean;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class ProductEntity extends BaseBean {

    private static final long serialVersionUID = -7596122831728650013L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // variáveis / colunas tabela
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "product_name", nullable = false, length = 40)
    private String productName;

    @Column(name = "supplier_id")
    private Integer supplierID;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "units_in_stock")
    private Short unitsInStock;

    @Column(name = "units_on_order")
    private Short unitsOnOrder;

    @Column(name = "reorder_level")
    private Short reorderLevel;

    @Column(name = "discontinued")
    private boolean discontinued;


    // construtor vazio: obrigatório para que o framework consiga instanciar suas entidades a partir dos dados do banco | permitir que você instancie um objeto sem teer que definir seus atributos
    public ProductEntity() {
    }

    // construtor
    public ProductEntity(Integer id, String productName, Integer supplierID, String quantityPerUnit, BigDecimal unitPrice, Short unitsInStock, Short unitsOnOrder, Short reorderLevel, boolean discontinued, Integer categoryId) {
        this.id = id;
        this.productName = productName;
        this.supplierID = supplierID;
        this.categoryId = categoryId;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.unitsOnOrder = unitsOnOrder;
        this.reorderLevel = reorderLevel;
        this.discontinued = discontinued;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Integer supplierID) {
        this.supplierID = supplierID;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Short getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Short unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public Short getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(Short unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    public Short getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Short reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

}
