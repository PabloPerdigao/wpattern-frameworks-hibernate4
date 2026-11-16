
package org.wpattern.frameworks.hibernate4.utils;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

// decorator warning
@SuppressWarnings("unchecked")
public abstract class GenericDao<T, PK> {

    private final EntityManager entityManager;
    private final EntityManagerFactory factory;
    private final Class<T> clazz;

    public GenericDao(EntityManagerFactory factory) {

        if (factory == null) {
            throw new IllegalArgumentException(
                    "EntityManagerFactory não pode ser nula."
            );
        }

        this.factory = factory;
        this.entityManager = factory.createEntityManager();

        this.clazz = (Class<T>) (
                (ParameterizedType) this.getClass()
                        .getGenericSuperclass()
        ).getActualTypeArguments()[0];
    }

    // metodo genérico para executar consultas
    public Object executeQuery(String query, Object... params) {

        Query queryObject = entityManager.createQuery(query);

        for (int i = 0; i < params.length; i++) {
            queryObject.setParameter(i + 1, params[i]);
        }

        return queryObject.getResultList();
    }

    public List<T> findAll() {

        String jpql = "FROM " + this.clazz.getSimpleName();

        return this.entityManager
                .createQuery(jpql)
                .getResultList();
    }

    public T findById(PK id) {
        return (T) entityManager.find(this.clazz, id);
    }

    public void save(T entity) {

        try {
            this.beginTransaction();
            this.entityManager.persist(entity);
            this.commitTransaction();

        } catch (RuntimeException e) {
            this.rollbackTransaction();
            throw e;
        }
    }

    public void update(T entity) {

        try {
            this.beginTransaction();
            this.entityManager.merge(entity);
            this.commitTransaction();

        } catch (RuntimeException e) {
            this.rollbackTransaction();
            throw e;
        }
    }

    public void delete(T entity) {

        try {
            this.beginTransaction();

            Object managedEntity = this.entityManager.contains(entity)
                    ? entity
                    : this.entityManager.merge(entity);

            this.entityManager.remove(managedEntity);

            this.commitTransaction();

        } catch (RuntimeException e) {
            this.rollbackTransaction();
            throw e;
        }
    }

    public void beginTransaction() {
        this.entityManager.getTransaction().begin();
    }

    public void commitTransaction() {
        this.entityManager.getTransaction().commit();
    }

    public void rollbackTransaction() {

        if (this.entityManager.getTransaction().isActive()) {
            this.entityManager.getTransaction().rollback();
        }
    }

    public void close() {

        if (this.entityManager.isOpen()) {
            this.entityManager.close();
        }
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

}
