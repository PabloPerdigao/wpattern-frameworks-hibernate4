package org.wpattern.frameworks.hibernate4;

import org.wpattern.frameworks.hibernate4.daos.OrderDao;
import org.wpattern.frameworks.hibernate4.daos.ProductDao;
import org.wpattern.frameworks.hibernate4.entities.OrderEntity;
import org.wpattern.frameworks.hibernate4.entities.ProductEntity;
import org.wpattern.frameworks.hibernate4.entities.CategoryEntity;
import org.wpattern.frameworks.hibernate4.utils.DaoFactory;
import org.wpattern.frameworks.hibernate4.daos.CategoryDao;

import java.util.List;

import static org.wpattern.frameworks.hibernate4.daos.CategoryDao.*;


public class Main {

    public static void main(String[] args) {

        try {

            // instancia dos DAOs (operações crud disponiveis)
            CategoryDao categoryDao = DaoFactory.categoryInstance();
            ProductDao productDao = DaoFactory.productInstance();
            OrderDao orderDao = DaoFactory.orderDaoInstance();


            // metodos de execucao das operacoes
            executarOperacaoCategoria(categoryDao);
            executarOperacaoProduto(productDao);
            executarOperacaoPedido(orderDao);


        } catch (Exception e) {

            System.err.println("Erro ao executar programa.");
            e.printStackTrace();

        } finally {

            // encerrar hibernate
            DaoFactory.close();

            System.out.println("\nAplicação encerrada.");
        }
    }

    // MANUTENÇÃO DE CATEGORIAS
    private static void executarOperacaoCategoria(
            CategoryDao categoryDao) {

        // CREATE
        CategoryEntity category = cadastrarCategoria(categoryDao);

        Integer id = category.getId();

        // READ
        consultarCategoria(categoryDao, id);

        // UPDATE
        atualizarCategoria(categoryDao, id);

        // Verificar atualização
        consultarCategoria(categoryDao, id);

        // DELETE
        excluirCategoria(categoryDao, id);

        // Verificar exclusão
        CategoryEntity deletedCategory = categoryDao.findById(id);

        if (deletedCategory == null) {
            System.out.println("\nCategoria removida do banco com sucesso!");
        }

    }

    // ATUALZIAÇÃO ESTOQUE
    private static void executarOperacaoProduto(ProductDao productDao) {

        System.out.println("\n ATUALIZA ESTOQUE:");


        Integer id = 3;

        // consulta produto
        ProductEntity produto = productDao.findById(id);

        if (produto == null) {
            System.out.println("\nProduto não encontrado");
            return;
        }

        // exibe produto e estoque atual
        System.out.println("Produto: " + produto.getProductName());

        Short estoqueAtual = produto.getUnitsInStock();
        System.out.println("\n Estoque atual: " + estoqueAtual);


        // atribui novo  e atualiza estoqeu
        Short novoEstoque = 1;
        productDao.atualizarEstoqueProduto(produto, novoEstoque);


        // resultado
        System.out.println("\n Estoque atualziado");
        System.out.println("Novo valor estoque: " + produto.getUnitsInStock());
    }

    // CONSULTA PEDIDO POR CIDADE
    private static void executarOperacaoPedido(OrderDao orderDao) {
        System.out.println("CONSULTA PEDIDOS POR CIDADE");

        String city = "Mexico City";

        // consulta
        List<OrderEntity> orders = orderDao.findByShipCity(city);

        // verifico itens da lista
        if (orders.isEmpty()) {
            System.out.println("\n Nenhum pedido encontrado pela cidade buscada.");
            return;
        }

        // percorre lista e exibe pedidos retornados
        for (OrderEntity order : orders) {
            System.out.println(order);
        }

        System.out.println("\nTotal pedidos: " + orders.size());

    }

}