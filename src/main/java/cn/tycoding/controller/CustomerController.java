package cn.tycoding.controller;

import cn.tycoding.pojo.Customer;
import cn.tycoding.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 这是客户管理的Controller层
 *
 * @author tycoding
 * @date 18-4-7下午7:26
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    /**
     * 注入service层
     * 使用@Resource和@Autowired都可以实现Bean的自动注入
     */
    @Autowired
    private CustomerService customerService;

    /**
     * 跳转到添加客户功能页面
     */
    @RequestMapping("/toSavePage")
    public String toSavePage() {
        return "page/save";
    }

    /**
     * 跳转到客户列表页面
     */
    @RequestMapping(value = "/toListPage")
    public String toListPage(Model model) {
        return "redirect:findByPage.do";
    }

    /**
     * 客户信息保存
     *
     * @param customer
     * @param model
     * @return
     */
    @RequestMapping(value = "/save")
    public String create(Customer customer, Model model) {
        try {
            customerService.create(customer);
            model.addAttribute("message", "保存客户信息系成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "page/info";
    }

    /**
     * 客户信息删除的方法
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam Long id, Model model) {
        try {
            customerService.delete(id);
            model.addAttribute("message", "删除客户信息成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "page/info";
    }


    /**
     * 根据id查询客户信息方法
     *
     * @param customer
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findById")
    public Customer findById(@RequestBody Customer customer) {
        Customer customer_info = customerService.findById(customer.getId());
        if (customer_info != null) {
            return customer_info;
        } else {
            return null;
        }
    }

    /**
     * 更新客户信息的方法
     *
     * @param customer
     * @param model
     * @return
     */
    @RequestMapping(value = "/update")
    public String update(Customer customer, Model model) {
        try {
            customerService.update(customer);
            model.addAttribute("message", "更新客户信息成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "page/info";
    }

    /**
     * 分页查询
     *
     * @param customer 查询条件
     * @param pageCode 当前页
     * @param pageSize 每页显示的记录数
     * @return
     */
    @RequestMapping("/findByPage")
    public String findByPage(Customer customer,
                             @RequestParam(value = "pageCode", required = false, defaultValue = "1") int pageCode,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize,
                             Model model) {
        // 回显数据
        model.addAttribute("page", customerService.findByPage(customer, pageCode, pageSize));
        return "page/list";
    }

}
