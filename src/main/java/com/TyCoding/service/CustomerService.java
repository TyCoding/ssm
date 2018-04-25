package com.TyCoding.service;

import com.TyCoding.pojo.Customer;
import com.TyCoding.pojo.PageBean;

import java.util.Map;

/**
 * @author TyCoding
 * @date 18-4-14下午9:13
 */
public interface CustomerService {
    void save(Customer customer);

    int findLastId();

    // 这里要手动设置为pageBean
    PageBean<Customer> findByPage(int pageCode, int pageSize, Map<String,Object> conMap);

    int delete(int c_id);

    Customer findById(int c_id);

    int update(Customer customer);
}
