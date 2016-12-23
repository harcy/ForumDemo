package com.sap.dao;

import com.sap.entity.Post;
import org.springframework.stereotype.Repository;

/**
 * Created by I337300 on 12/23/2016.
 */

@Repository
public interface PostDao {
    public Post queryPost();
    public Post queryPostByItem(Integer itemId);
    public boolean issuedPost();
}
