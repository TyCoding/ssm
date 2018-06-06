package cn.tycoding.mapper;

import cn.tycoding.pojo.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tycoding
 * @date 18-4-14下午9:14
 */
public interface CustomerMapper {
    void save(Customer customer);

    int selectCount();

    List<Customer> findByPage(HashMap<String,Object> map);

    List<Customer> findCondition(Map<String,Object> conMap);

    int delete(int c_id);

    Customer findById(int c_id);

    int update(Customer customer);
}
