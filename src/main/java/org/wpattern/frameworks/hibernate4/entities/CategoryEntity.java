package org.wpattern.frameworks.hibernate4.entities;

import org.wpattern.frameworks.hibernate4.utils.BaseBean;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity  extends BaseBean {

    // identificador da versão para verificar compatibilidade do objeto com a classe
    // transformar objeto ou estrutura de dados (que está guardado na memória) em formato linear( como sequencia de bytes ou texto padrão) p armazenar no banco
    private static final long serialVersionUID = 4015190321196669359L;

    @Id // identificador e pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // valor gerado auto
    @Column(name = "Category_id")
    private Integer id;

    @Column(name = "category_name")
    private String categoryName;

    private String description;

    private byte[] picture;

    // construtor vazio: precisa ser criado a fim de poder receber parametros posteiormente permite criar o objeto primeiro e definir ou alterar os valores dos seus atributos depois
    public CategoryEntity() {}

    // construtor
    public CategoryEntity(String categoryName, String description, byte[] picture) {
        this.categoryName = categoryName;
        this.description = description;
        this.picture = picture;
    }

    // métodos get e set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
