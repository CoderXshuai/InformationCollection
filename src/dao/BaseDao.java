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
     * @param obj 对象实例
     * @return json格式的字符串
     */
    Serializable save(T obj);

    /**
     * 按实例化对象删除记录
     *
     * @param obj
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
     * @param hql    hql语句
     * @param params 参数
     * @return 对象实例
     */
    T find(String hql, Map<String, Object> params);

    /**
     * 通过id查询一条记录
     *
     * @param clazz 类
     * @param id    ID
     * @return 对象实例
     */
    T findById(Class<T> clazz, Serializable id);

    /**
     * 查询记录集合
     *
     * @param hql hql语句
     * @return 对象集合
     */
    List<T> get(String hql);

    /**
     * 查询记录集合
     *
     * @param hql    hql语句
     * @param params 参数
     * @return 对象集合
     */
    List<T> get(String hql, Map<String, Object> params);

    /**
     * 分页查询，传递条件
     *
     * @param hql    hql语句
     * @param params 参数条件
     * @param page   几页
     * @param rows   几行
     * @return 对象集合
     */
    List<T> get(String hql, Map<String, Object> params, Integer page, Integer rows);

    /**
     * 分页查询，不传递条件
     *
     * @param hql  hql语句
     * @param page 页数
     * @param rows 行数
     * @return 对象集合
     */
    List<T> get(String hql, Integer page, Integer rows);

    /**
     * 获取记录数，传递参数
     *
     * @param hql hql语句
     * @return 记录数
     */
    Integer length(String hql);

    /**
     * 获取记录数，传递参数
     *
     * @param hql    hql语句
     * @param params 参数
     * @return 记录数
     */
    Integer length(String hql, Map<String, Object> params);

    /**
     * 更新一条记录
     *
     * @param obj 实例对象
     */
    void update(T obj);

    /**
     * 存在该条记录则更新，不存在则添加
     *
     * @param obj 实例对象
     */
    void saveOrUpdate(T obj);

    /**
     * 执行hql语句
     *
     * @param hql hql语句
     * @return 受影响行数
     */
    Integer executeHql(String hql);

    /**
     * 执行hql语句，携带参数
     *
     * @param hql    hql语句
     * @param params 参数
     * @return 受影响行数
     */
    Integer executeHql(String hql, Map<String, Object> params);
}
