package com.bing.service;

import com.bing.dao.IUserDao;
import com.bing.entity.User;
import com.bing.entity.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guobing
 * @version 1.0
 * @date 2019/9/3 下午3:35
 * @description
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    @Override
    public void saveUser(User user) {

        iUserDao.saveUser(user);

    }

    @Override
    public User queryUserByNameAndPassword(User user) {

        return iUserDao.queryUserByNameAndPassword(user);
    }

    @Override
    public List<User> queryUserByPage(Integer pageNow, Integer pageSize, String column, Object value) {

        int beginIndex = (pageNow - 1) * pageSize;
        Map<String, Object> params = new HashMap<>();
        params.put("beginIndex", beginIndex);
        params.put("pageSize", pageSize);
        params.put("column", column);
        params.put("value", value);

        return iUserDao.queryUserByPage(beginIndex, pageSize);
    }

    @Override
    public int queryUserCount(String column, Object value) {
        UserVo userVo = new UserVo();
        if(column.equals("name")){
            userVo.setName(String.valueOf(value));
        }
        if(column.equals("password")){
            userVo.setPassword(String.valueOf(value));
        }
        return iUserDao.queryUserCount(userVo);
    }

    @Override
    public User queryUserById(Integer id) {
        return iUserDao.queryUserById(id);
    }

    @Override
    public void deleteByUserIds(Integer[] ids) {

        iUserDao.deleteUserByIds(ids);
    }

    @Override
    public void updateUser(User user) {

        iUserDao.updateUser(user);
    }
}
