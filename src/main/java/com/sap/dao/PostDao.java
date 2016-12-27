package com.sap.dao;

import com.sap.entity.Post;
import org.springframework.stereotype.Repository;

/**
 * Created by  on 12/23/2016.
 */

@Repository
public interface PostDao {
     Post queryPost();
     Post queryPostByItem(Integer itemId);
     boolean issuedPost();
}
