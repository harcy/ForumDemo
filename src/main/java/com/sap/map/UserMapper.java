package com.sap.map;

import com.sap.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by I337300 on 12/26/2016.
 */

@Repository
public interface UserMapper {

    public User getUserById(Integer userId);
}
