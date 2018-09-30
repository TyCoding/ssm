package cn.tycoding.service.impl;

import cn.tycoding.mapper.UserMapper;
import cn.tycoding.pojo.User;
import cn.tycoding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tycoding
 * @date 18-4-7下午9:09
 */
@Service
public class UserServiceImpl implements UserService {

    //注入
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录的方法
     */
    public User login(String username) {
        return userMapper.login(username);
    }

    public List<User> findAll() {
        return null;
    }

    public User findById(Long id) {
        return null;
    }

    public void create(User user) {

    }

    public void delete(Long id) {

    }

    public void update(User user) {

    }
}
