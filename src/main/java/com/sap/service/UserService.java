package com.sap.service;

import com.sap.entity.AssertVo;
import com.sap.entity.User;
import com.sap.map.UserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    private final Logger logger = Logger.getLogger(UserService.class);

    public User selectUserById(Integer userId) {
        User user = userMapper.getUserById(userId);
        logger.debug("******begin******");
        logger.debug(user.toString());
        logger.debug("******end******");
        return user;

    }

    public AssertVo verifyUserLogin(String userName, String userPwd,
                                    HttpServletRequest request) {
        List<User> userList = userMapper.selectAllUsers();
        AssertVo vo = new AssertVo(false);
        HashMap<String, Object> map = new HashMap<String, Object>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (User user:userList
             ) {
            if (user.getUserName().equals(userName)
                    && user.getUserPwd().equals(userPwd)) {
                vo.setFlag(true);
                /*user.setUserLastIp(request.getRemoteAddr());
                user.setUserLastVisit();*/
                map.put("user_id", user.getUserId());
                map.put("last_visit", sdf.format(new Date()));
                map.put("last_ip", request.getRemoteAddr());
                updateUserLogin(map);
                recordLoginInfo(map);
                return vo;
            }
            continue;
        }
        return vo;
    }

    public void updateUserLogin(HashMap<String,Object> map){
        userMapper.updateUserById(map);
    }

    public void recordLoginInfo(HashMap<String,Object> map) {
        userMapper.insertLoginInfo(map);
    }
}
