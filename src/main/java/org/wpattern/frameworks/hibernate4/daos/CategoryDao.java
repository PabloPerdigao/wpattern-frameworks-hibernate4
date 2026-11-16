
package org.wpattern.frameworks.hibernate4.daos;

import javax.persistence.EntityManagerFactory;

import org.wpattern.frameworks.hibernate4.entities.CategoryEntity;
import org.wpattern.frameworks.hibernate4.utils.GenericDao;

import java.util.List;

// herança
public class CategoryDao extends GenericDao<CategoryEntity, Integer> {

    public CategoryDao(EntityManagerFactory factory) {
        super(factory);
    }

    //hql -> sql do hibernate: de consulta orientada  objetos , opera em classes e atributos
    @SuppressWarnings("unchecked")
    public List<CategoryEntity> findByCategoryName(String categoryName) {
        List<CategoryEntity> categories = (List<CategoryEntity>)
                this.executeQuery("SELECT c FROM CategoryEntity c WHERE c.categoryName = ?1", categoryName);
        return categories;
    }

    // CREATE
    public static CategoryEntity cadastrarCategoria(
            CategoryDao categoryDao) {

        System.out.println("\n CADASTRO CATEGORIA:");

        //cria objeto passando dados
        CategoryEntity category = new CategoryEntity(
                "Tecnologia",
                "Produtos eletrônicos e tecnológicos",
                null
        );


        categoryDao.save(category);

        System.out.println("Categoria cadastrada!");
        System.out.println("ID gerado: " + category.getId());

        return category;
    }

    // READ
    public static CategoryEntity consultarCategoria(
            CategoryDao categoryDao, Integer id) {

        System.out.println("\nCONSULTA CATEGORIA:");

        CategoryEntity category = categoryDao.findById(id);

        if (category == null) {
            System.out.println("Categoria não encontrada.");
            return null;
        }

        System.out.println("ID: " + category.getId());
        System.out.println("Nome: " + category.getCategoryName());
        System.out.println("Descrição: " + category.getDescription());

        return category;
    }

    // UPDATE
    public static void atualizarCategoria(
            CategoryDao categoryDao, Integer id) {

        System.out.println("\nUPDATE CATEGORIA:");

        // recupera registro por id
        CategoryEntity category = categoryDao.findById(id);

        if (category == null) {
            System.out.println("Categoria não encontrada.");
            return;
        }

        // atribuindo novos valores
        category.setCategoryName("Informática");
        category.setDescription("Computadores e periféricos");

        categoryDao.update(category);

        System.out.println("Categoria atualizada com sucesso!");
    }

    // DELETE
    public static void excluirCategoria(
            CategoryDao categoryDao, Integer id) {

        System.out.println("\nEXCLUI CATEGORIA:");

        CategoryEntity category = categoryDao.findById(id);

        if (category == null) {
            System.out.println("Categoria não encontrada.");
            return;
        }

        categoryDao.delete(category);

        System.out.println("Categoria excluída com sucesso!");
    }
}
