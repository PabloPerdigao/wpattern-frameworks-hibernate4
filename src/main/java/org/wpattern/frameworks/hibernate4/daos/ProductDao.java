
package org.wpattern.frameworks.hibernate4.daos;

import javax.persistence.EntityManagerFactory;

import org.wpattern.frameworks.hibernate4.entities.ProductEntity;
import org.wpattern.frameworks.hibernate4.utils.GenericDao;

public class ProductDao extends GenericDao<ProductEntity, Integer> {

    public ProductDao(EntityManagerFactory factory) {
        super(factory);
    }

    // UPDATE  ESTOQUE
    public void atualizarEstoqueProduto(
            ProductEntity produto, Short novoEstoque) {


        // Atualizar estoque
        produto.setUnitsInStock(novoEstoque);

        // Persistir alteração
        this.update(produto);

    }

}
