package cn.tycoding.service;

import cn.tycoding.pojo.Customer;
import cn.tycoding.pojo.PageBean;

import java.util.Map;

/**
 * @author tycoding
 * @date 18-4-14下午9:13
 */
public interface CustomerService {

    void save(Customer customer);

    // 这里要手动设置为pageBean
//    Object findByPage(int pageCode, int pageSize, Map<String,Object> conMap);
    PageBean<Customer> findByPage(int pageCode, int pageSize, Map<String,Object> conMap);

    int delete(int c_id);

    Customer findById(int c_id);

    int update(Customer customer);
}
