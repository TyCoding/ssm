package cn.tycoding.mapper;

import cn.tycoding.pojo.Customer;
import com.github.pagehelper.Page;

/**
 * @author tycoding
 * @date 18-4-14下午9:14
 */
public interface CustomerMapper {

    void create(Customer customer);

    void delete(Long id);

    Customer findById(Long id);

    void update(Customer customer);

    Page<Customer> findByPage(Customer customer);

//    int selectCount();

//    List<Customer> findCondition(Map<String,Object> conMap);
}
