package dao.impl;

import dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author CoderXshuai
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    /**
     * 获取当前事物的的session
     *
     * @return
     */
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Serializable save(T obj) {
        return this.getCurrentSession().save(obj);
    }


    @Override
    public T find(String hql) {
        Query q = this.getCurrentSession().createQuery(hql);
        List<T> list = q.list();
        if (list != null && list.size() >= 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public T find(String hql, Object[] params) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (params != null && params.length > 0) {
            Integer index = 0;
            while (index < params.length) {
                q.setParameter(index, params[index]);
                index++;
            }
        }
        List<T> list = q.list();
        if (list != null && list.size() > 0) {
            return list.get(0);

        }
        return null;
    }

    @Override
    public T find(String hql, Map<String, Object> params) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (params != null && params.size() > 0) {
            Set<String> set = params.keySet();
            for (String key : set) {
                q.setParameter(key, params.get(key));
            }
        }
        List<T> list = q.list();
        if (list != null && list.size() > 0) {
            return list.get(0);

        }
        return null;
    }

    @Override
    public T findById(Class<T> clazz, Serializable id) {
        return this.getCurrentSession().get(clazz, id);
    }

    @Override
    public List<T> get(String hql) {
        Query q = this.getCurrentSession().createQuery(hql);
        return q.list();
    }

    @Override
    public List<T> get(String hql, Map<String, Object> params) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (params != null && params.size() > 0) {
            Set<String> set = params.keySet();
            for (String key : set) {
                q.setParameter(key, params.get(key));
            }

        }
        return q.list();
    }

    @Override
    public List<T> get(String hql, Map<String, Object> params, Integer page,
                       Integer rows) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (params != null && params.size() > 0) {
            Set<String> set = params.keySet();
            for (String key : set) {
                q.setParameter(key, params.get(key));
            }

        }
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }


    @Override
    public List<T> get(String hql, Integer page, Integer rows) {
        Query q = this.getCurrentSession().createQuery(hql);
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    @Override
    public Integer length(String hql) {
        Query q = this.getCurrentSession().createQuery(hql);
        return Integer.valueOf(q.uniqueResult().toString());
    }


    @Override
    public Integer length(String hql, Map<String, Object> params) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (params != null && params.size() > 0) {
            Set<String> set = params.keySet();
            for (String key : set) {
                q.setParameter(key, params.get(key));
            }

        }
        return Integer.valueOf(q.uniqueResult().toString());
    }

    @Override
    public void update(T obj) {
        obj = (T) this.getCurrentSession().merge(obj);
        this.getCurrentSession().update(obj);
    }

    @Override
    public void delete(T obj) {
        this.getCurrentSession().delete(obj);
    }

    @Override
    public void saveOrUpdate(T obj) {
        obj = (T) this.getCurrentSession().merge(obj);
        this.getCurrentSession().saveOrUpdate(obj);
    }

    @Override
    public Integer executeHql(String hql) {
        Query q = this.getCurrentSession().createQuery(hql);
        return q.executeUpdate();
    }

    @Override
    public Integer executeHql(String hql, Map<String, Object> params) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (params != null && params.size() > 0) {
            Set<String> set = params.keySet();
            for (String key : set) {
                q.setParameter(key, params.get(key));
            }
        }
        return q.executeUpdate();
    }
}
