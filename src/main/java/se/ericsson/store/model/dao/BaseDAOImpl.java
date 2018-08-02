package se.ericsson.store.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class BaseDAOImpl<T> {

    @PersistenceContext(unitName = "corePU")
    protected EntityManager em;

    public T update(T entity) {
        try {
            return em.merge(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean delete(T entity) {
        try {
            em.remove(em.merge(entity));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean create(T entity) {
        try {
            em.persist(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public T find(T entity, Object primaryKey) {
        try {
            return (T) em.find(entity.getClass(), primaryKey);
        } catch (Exception e) {
            return null;
        }
    }

    public long maximumId(String query, boolean isNamedQuery) {
        try {
            return ((long) (isNamedQuery ? em.createNamedQuery(query).getSingleResult()
                    : em.createQuery(query).getSingleResult())) + 1;
        } catch (Exception e) {
            return 1;
        }
    }

    public List<T> findAll(String query, boolean isNamedQuery) {
        try {
            return isNamedQuery ? em.createNamedQuery(query).getResultList()
                    : em.createQuery(query).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<T> findLastDataWithNativeQuery(String query, long atmId) {
        try {
            Query qu = em.createNamedQuery(query);
            qu.setParameter("atmId", atmId);
            return qu.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void detach(T entity) {
        try {
            em.detach(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
