package com.sss.user.service.impl;

import com.github.pagehelper.PageInfo;
import com.sss.user.entity.User;
import com.sss.user.mapper.UserMapper;
import com.sss.user.service.UserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/28.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public PageInfo<User> queryPage(Map<String, Object> map, int start, int limit) {
        List<User> userList = userMapper.selectByCond(map, new RowBounds(start, limit));
        PageInfo<User> page = new PageInfo<>(userList);
        return page;
    }

    @Override
    public void delUserBy(Long id) {
        userMapper.delUserBy(id);
    }

    @Override
    public void save(User user) {
        if (user.getId() == null) {
            userMapper.addUser(user);
        } else {
            userMapper.updateUser(user);
        }
    }
}
