package com.sap.map;

import com.sap.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by on 12/26/2016.
 */

@Repository
public interface UserMapper {

    User getUserById(Integer userId);

    List<User> selectAllUsers();

    void updateUserById(HashMap<String, Object> map);

    void insertLoginInfo(HashMap<String, Object> map);
}
