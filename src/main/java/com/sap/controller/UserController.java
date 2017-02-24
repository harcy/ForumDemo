package com.sap.controller;

import com.sap.entity.AssertVo;
import com.sap.entity.Post;
import com.sap.entity.User;
import com.sap.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

    private final Logger LOGGER = Logger.getLogger(UserController.class);

	/*@RequestMapping(value="/{userId}",method=RequestMethod.GET)
	public ModelAndView getUserInfoById(@PathVariable String userId){
		ModelAndView mv = new ModelAndView("hello");
		User user=userService.getUserById(userId);
		mv.addObject("user",user);
		return mv;
	}*/

	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody AssertVo userLogin(HttpServletRequest request) {
	    String userName = request.getParameter("Username");
        String userPwd = request.getParameter("Password");
        userName = "admin";
        userPwd = "admin";
        AssertVo vo = userService.verifyUserLogin(userName, userPwd, request);
        return vo;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public @ResponseBody User getProfileById(@PathVariable Integer userId) {
        User user = userService.selectUserById(userId);
        LOGGER.debug(user.toString());
        return user;
    }
    /*public ModelAndView getProfileById(@PathVariable Integer userId) {
        ModelAndView mv = new ModelAndView("hello");
        User user = userService.selectUserById(userId);
        mv.addObject("user", user);
        return mv;
    }*/

    /*@RequestParam(value = "pageSize", required = false, defaultValue = "1") String pageSize) {
        trap1: defaultValue must be String type, however parameters really type, such as pageSize,
        it's real type is Integer but set defaultValue must be use String type
        trap2: we should use Object type not basic type, that's mean @RequestParam parameters
        use Integer instead of int. Because when not use defaultValue, we use URL not bring ?pageSize=2
        to use int will get error but use Integer will work successfully and set pageSize = null
    }*/

    /*@RequestMapping(value = "/json", method = RequestMethod.GET)
    public @ResponseBody Post getAllPost(
       @RequestParam(value = "pageSize", required = false, defaultValue = "1") Integer pageSize) {
        logger.debug("pageSize = "+pageSize);
        logger.debug(pageSize.getClass().getSimpleName());
        Post post = new Post();
        post.setPostId(2);
        post.setItemId(1);
        post.setTags("baby song");
        List<User> userList = new ArrayList<User>();
        User u1 = new User();
        u1.setUserId(5);
        u1.setUserName("aa");
        u1.setUserPwd("admin123");
        User u2 = new User();
        u2.setUserId(6);
        u2.setUserName("bb");
        u2.setUserPwd("admin456");
        userList.add(u1);
        userList.add(u2);
        post.setUserList(userList);
        return post;
    }*/

    /*@RequestMapping(value="/user/{parameters}",method = RequestMethod.GET)
    public User getView(@PathVariable String parameters) {
        //Map<Object, Object> map = new HashMap<Object, Object>();
        User user =new User();
        user.setUserName("leo"+parameters);
        user.setUserPwd("pwd"+parameters);
        return user;
    }*/
}
