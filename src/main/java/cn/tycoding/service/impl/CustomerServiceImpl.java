package cn.tycoding.service.impl;

import cn.tycoding.mapper.CustomerMapper;
import cn.tycoding.pojo.Customer;
import cn.tycoding.pojo.PageBean;
import cn.tycoding.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户的service层
 * @author tycoding
 * @date 18-4-14下午9:14
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    /**
     * 注入
     */
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 客户信息保存的方法
     */
    public void save(Customer customer) {
        customerMapper.save(customer);
    }

    /**
     * 分页查询的方法
     */
    public PageBean<Customer> findByPage(int pageCode, int pageSize, Map<String, Object> conMap) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Customer> pageBean = new PageBean<Customer>();

        //封装当前页
        pageBean.setPageCode(pageCode);
        pageBean.setPageSize(pageSize);

        // 封装总记录数（从数据库中查询）
        int totalCount = customerMapper.selectCount();
        System.out.println("查询到的总记录数："+totalCount);
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());

        // 设置limit分页查询的起始位置和终止位置
        map.put("start",(pageCode - 1) * pageSize);
        map.put("size",pageBean.getPageSize());

        //封装每页显示的数据
        List<Customer> list = customerMapper.findByPage(map);
        pageBean.setBeanList(list);

        // 分页查询功能也要封装显示起始页和终止页
        conMap.put("start",(pageCode - 1) * pageSize);
        conMap.put("size",pageBean.getPageSize());

        // 封装
        List<Customer> listCondition = customerMapper.findCondition(conMap);
        pageBean.setBeanList(listCondition);

        return pageBean;
    }

    /**
     * 根据id删除信息的方法
     */
    public int delete(int c_id) {
        return customerMapper.delete(c_id);
    }

    /**
     * 根据客户id查询客户信息的方法
     */
    public Customer findById(int c_id) {
        return customerMapper.findById(c_id);
    }

    /**
     * 更新客户信息的方法
     */
    public int update(Customer customer) {
        return customerMapper.update(customer);
    }
}
