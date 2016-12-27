package com.sap.map;

import com.sap.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by on 12/26/2016.
 */

@Repository
public interface UserMapper {

    User getUserById(Integer userId);
}
