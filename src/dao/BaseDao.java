package dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author CoderXshuai
 */
public interface BaseDao<T> {
    /**
     * 添加新纪录
     *
     * @param obj
     * @return json格式的字符串
     */
    Serializable save(T obj);

    /**
     * 按id删除记录
     *
     * @param obj
     * @author Jhon
     */
    void delete(T obj);

    /**
     * 查询一条记录
     *
     * @param hql hql查询语句
     * @return
     */
    T find(String hql);

    /**
     * 查询一条记录
     *
     * @param obj
     * @return
     * @author Jhon
     */
    @Deprecated
    T find(String hql, Object[] params);

    /**
     * 查询一条记录
     *
     * @param obj
     * @return
     * @author Jhon
     */
    T find(String hql, Map<String, Object> params);

    /**
     * 通过id查询一条记录
     *
     * @param clazz
     * @param id
     * @return
     * @author Jhon
     */
    T findById(Class<T> clazz, Serializable id);

    /**
     * 查询记录集合
     *
     * @param hql
     * @return
     * @author Jhon
     */
    List<T> get(String hql);

    /**
     * 查询记录集合
     *
     * @param hql
     * @param params
     * @return
     * @author Jhon
     */
    List<T> get(String hql, Map<String, Object> params);

    /**
     * 分页查询，传递条件
     *
     * @param hql
     * @param params
     * @param page
     * @param rows
     * @return
     * @author Jhon
     */
    List<T> get(String hql, Map<String, Object> params, Integer page, Integer rows);

    /**
     * 分页查询，不传递条件
     *
     * @param hql
     * @param params
     * @param page
     * @param rows
     * @return
     * @author Jhon
     */
    List<T> get(String hql, Integer page, Integer rows);

    /**
     * 获取记录数，传递参数
     *
     * @param hql
     * @return
     * @author Jhon
     */
    Integer length(String hql);

    /**
     * 获取记录数，传递参数
     *
     * @param hql
     * @param params
     * @return
     * @author Jhon
     */
    Integer length(String hql, Map<String, Object> params);

    /**
     * 更新一条记录
     *
     * @param obj
     * @author Jhon
     */
    void update(T obj);

    /**
     * 存在该条记录则更新，不存在则添加
     *
     * @param obj
     * @author Jhon
     */
    void saveOrUpdate(T obj);

    /**
     * 执行hql语句
     *
     * @param hql
     * @return
     * @author Jhon
     */
    Integer executeHql(String hql);

    /**
     * 执行hql语句，携带参数
     *
     * @param hql
     * @param params
     * @return
     * @author Jhon
     */
    Integer executeHql(String hql, Map<String, Object> params);
}
