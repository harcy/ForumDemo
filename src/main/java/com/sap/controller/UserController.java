package com.sap.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sap.service.UserService;
import com.sap.entity.User;

import javax.jws.soap.SOAPBinding;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*@RequestMapping(value="/{userId}",method=RequestMethod.GET)
	public ModelAndView getUserInfoById(@PathVariable String userId){
		ModelAndView mv = new ModelAndView("hello");
		User user=userService.getUserById(userId);
		mv.addObject("user",user);
		return mv;
	}*/

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ModelAndView getProfileById(@PathVariable Integer userId) {
        ModelAndView mv = new ModelAndView("hello");
        User user = userService.selectUserById(userId);
        mv.addObject("user", user);
        return mv;
        //return user;
    }

    @RequestMapping(value="/json/{paraString}",method=RequestMethod.GET)
	public Map<String,String> getParameter(@PathVariable String paraString){
		Map<String,String> map = new HashMap<String, String>();
		map.put("admin", paraString+String.valueOf(1));
		map.put("pwd", paraString+String.valueOf(2));
		return map;
	}

    @RequestMapping(value="/user/{parameters}",method = RequestMethod.GET)
    public User getView(@PathVariable String parameters) {
        //Map<Object, Object> map = new HashMap<Object, Object>();
        User user =new User();
        user.setUserName("leo"+parameters);
        user.setUserPwd("pwd"+parameters);
        return user;
    }
}
