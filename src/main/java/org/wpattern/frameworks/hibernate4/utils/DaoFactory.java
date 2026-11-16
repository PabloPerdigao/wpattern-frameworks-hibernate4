
package org.wpattern.frameworks.hibernate4.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

import org.wpattern.frameworks.hibernate4.daos.CategoryDao;
import org.wpattern.frameworks.hibernate4.daos.OrderDao;
import org.wpattern.frameworks.hibernate4.daos.OrderDetailDao;
import org.wpattern.frameworks.hibernate4.daos.ProductDao;

public final class DaoFactory {

    private static final String PERSISTENCE_UNIT_NAME =
            "wprojectPersistenceUnit";

    // EntityManagerFactory
    private static EntityManagerFactory entityManagerFactory;

    // DAOs
    private static CategoryDao categoryDaoInstance;
    private static ProductDao productDaoInstance;
    private static OrderDao orderDaoInstance;
    private static OrderDetailDao orderDetailDaoInstance;

    // Criar ou recuperar EntityManagerFactory
    public static synchronized EntityManagerFactory
    entityManagerFactoryInstance() {

        if (entityManagerFactory == null ||
                !entityManagerFactory.isOpen()) {

            // Recuperar variáveis de ambiente
            String dbHost = System.getenv("DB_HOST");
            String dbPort = System.getenv("DB_PORT");
            String dbName = System.getenv("DB_NAME");
            String dbUser = System.getenv("DB_USER");
            String dbPassword = System.getenv("DB_PASSWORD");

            // Verificar configurações
            if (dbHost == null || dbPort == null ||
                    dbName == null || dbUser == null ||
                    dbPassword == null) {

                throw new IllegalStateException(
                        "Variáveis de ambiente do banco de dados não configuradas."
                );
            }

            // Montar URL de conexão
            String url = "jdbc:postgresql://" +
                    dbHost + ":" + dbPort + "/" + dbName;

            // Configurar propriedades do Hibernate
            Map<String, Object> properties =
                    new HashMap<String, Object>();

            properties.put("javax.persistence.jdbc.driver",
                    "org.postgresql.Driver");

            properties.put("javax.persistence.jdbc.url", url);
            properties.put("javax.persistence.jdbc.user", dbUser);
            properties.put("javax.persistence.jdbc.password", dbPassword);

            // Inicializar EntityManagerFactory
            entityManagerFactory =
                    Persistence.createEntityManagerFactory(
                            PERSISTENCE_UNIT_NAME,
                            properties
                    );
        }

        return entityManagerFactory;
    }

    // Criar ou recuperar CategoryDao
    public static synchronized CategoryDao categoryInstance() {

        if (categoryDaoInstance == null) {

            categoryDaoInstance = new CategoryDao(
                    entityManagerFactoryInstance()
            );
        }

        return categoryDaoInstance;
    }

    // Criar ou recuperar ProductDao
    public static synchronized ProductDao productInstance() {

        if (productDaoInstance == null) {

            productDaoInstance = new ProductDao(
                    entityManagerFactoryInstance()
            );
        }

        return productDaoInstance;
    }

    // Criar ou recuperar OrderDao
    public static synchronized OrderDao orderDaoInstance() {

        if (orderDaoInstance == null) {

            orderDaoInstance = new OrderDao(
                    entityManagerFactoryInstance()
            );
        }

        return orderDaoInstance;
    }

    // Criar ou recuperar OrderDetailDao
    public static synchronized OrderDetailDao orderDetailDaoInstance() {

        if (orderDetailDaoInstance == null) {

            orderDetailDaoInstance = new OrderDetailDao(
                    entityManagerFactoryInstance()
            );
        }

        return orderDetailDaoInstance;
    }

    // Encerrar recursos
    public static synchronized void close() {

        if (categoryDaoInstance != null) {
            categoryDaoInstance.close();
            categoryDaoInstance = null;
        }

        if (productDaoInstance != null) {
            productDaoInstance.close();
            productDaoInstance = null;
        }

        if (orderDaoInstance != null) {
            orderDaoInstance.close();
            orderDaoInstance = null;
        }

        if (orderDetailDaoInstance != null) {
            orderDetailDaoInstance.close();
            orderDetailDaoInstance = null;
        }

        if (entityManagerFactory != null &&
                entityManagerFactory.isOpen()) {

            entityManagerFactory.close();
            entityManagerFactory = null;
        }
    }
}
