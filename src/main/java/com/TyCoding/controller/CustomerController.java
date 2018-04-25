package com.TyCoding.controller;

import com.TyCoding.pojo.Customer;
import com.TyCoding.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 这是客户管理的Controller层
 *
 * @author TyCoding
 * @date 18-4-7下午7:26
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    /**
     * 注入service层
     */
    @Autowired
    private CustomerService customerService;

    /**
     * 跳转到添加客户功能页面
     */
    @RequestMapping("/toSavePage")
    public String toSavePage(Model model) {
        // 先去后台查询数据库中最后一个主键值，默认设置下一个主键值是新插入数据的id
        int id = customerService.findLastId();
        System.out.println("后台查询到的id值：" + id);
        // 将查询到的值设置到Model中
        model.addAttribute("newId", id + 1);
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
     * 客户信息保存的方法
     */
    @RequestMapping(value = "/save")
    public String save(Customer customer, Model model) {
        customerService.save(customer);
        model.addAttribute("message", "保存客户信息系成功");
        return "page/info";
    }

    /**
     * 客户信息列表（分页查询功能）
     */
    @RequestMapping(value="/findByPage")
    public String findByPage(@RequestParam(value="pageCode",defaultValue = "1",required = false)int pageCode,
                             @RequestParam(value="pageSize",defaultValue = "2",required = false)int pageSize,
                             HttpServletRequest request,
                             Model model){
        // 封装分页数据
        String c_name = request.getParameter("c_name");
        String c_telephone = request.getParameter("c_telephone");
        Map<String,Object> conMap = new HashMap<String,Object>();
        conMap.put("c_name",c_name);
        conMap.put("c_telephone",c_telephone);

        // 回显数据
        model.addAttribute("page",customerService.findByPage(pageCode,pageSize,conMap));
        return "page/list";
    }

    /**
     * 客户信息删除的方法
     */
    @RequestMapping(value="/delete")
    public String delete(@RequestParam int c_id,Model model){
        int rows = customerService.delete(c_id);
        if(rows > 0){
            model.addAttribute("message","删除客户信息成功");
            return "page/info";
        }else{
            model.addAttribute("message","删除客户信息失败");
            return "page/info";
        }
    }

    /**
     * 根据id查询客户信息方法
     */
    @ResponseBody
    @RequestMapping(value="/findById")
    public Customer findById(@RequestBody Customer customer){
        Customer customer_info = customerService.findById(customer.getC_id());
        if(customer_info != null){
            return customer_info;
        }else{
            return null;
        }
    }

    /**
     * 更新客户信息的方法
     */
    @RequestMapping(value="/update")
    public String update(Customer customer,Model model){
        int rows = customerService.update(customer);
        if(rows > 0){
            model.addAttribute("message","更新客户信息成功");
            return "page/info";
        }else{
            model.addAttribute("message","更新客户信息失败");
            return "page/info";
        }

    }

}
