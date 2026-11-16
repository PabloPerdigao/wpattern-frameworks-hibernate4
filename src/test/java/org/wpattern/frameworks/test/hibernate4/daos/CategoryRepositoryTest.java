package org.wpattern.frameworks.test.hibernate4.daos;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.wpattern.frameworks.hibernate4.daos.CategoryDao;
import org.wpattern.frameworks.hibernate4.entities.CategoryEntity;
import org.wpattern.frameworks.hibernate4.utils.DaoFactory;

import java.util.List;

import static org.junit.Assert.assertNotNull;

//classe JUnit p testar acesso ao banco consultando categorias cadastradas e registra resorno com Log4j
public class CategoryRepositoryTest {
    private static final Logger LOGGER =  Logger.getLogger(CategoryRepositoryTest.class);

    private CategoryDao categoryDao = DaoFactory.categoryInstance();

    @Test // anotação JUnit p identificação como metodo de teste das categorias
    public void testFindAll() {
        List<CategoryEntity>  categories = this.categoryDao.findAll();

        // registra resultado
        LOGGER.info(categories);

        assertNotNull(categories);
    }

    // READ
    @Test
    public void testeFindById() {
        Integer id = this.save().getId();

        CategoryEntity category = this.categoryDao.findById(id);

        LOGGER.info(category);

    }

    // INSERT
    @Test
    public void testInsert() {
        this.save();
    }

    // UPDATE
    @Test
    public void testUpdate() {
        Integer id = 9;

        CategoryEntity category = this.categoryDao.findById(id);

        category.setCategoryName(("Spanish football club"));
        category.setDescription(("Real Madrid"));

        LOGGER.info(category);

        this.categoryDao.update(category);
    }

    // DELETE
    @Test
    public void testDelete() {
        CategoryEntity category = this.save();

        this.categoryDao.delete((category));

        LOGGER.info("Category deleted " + category);
    }



    // CREATE - contrutor do metodo save, onde instancia o objeto para cadastrar novos dados no banco.
    private CategoryEntity save() {
        CategoryEntity category = new CategoryEntity("Player of Hungria", "Szoboszlai", null);

        this.categoryDao.save(category);

        LOGGER.info("Caregory saved" + category);

        return category;
    }

    @Test
    public void testFindCategoryName() {
        List<CategoryEntity> categories = this.categoryDao.findByCategoryName("Beverages");

        LOGGER.info(categories);
    }
}
