package com.example.demo.web.main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.web.main.service.MainService;
import com.example.demo.web.main.vo.LoginVo;

@RestController
public class MainController {

	@Autowired
	MainService mainService;
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginPage");
		
		//LoginVo result = mainService.getLoginInfo("user1");
		
		return mav;
	}
	
	@RequestMapping(value = "/test", method=RequestMethod.GET)
	public ModelAndView test() {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<> ();
		map.put("title", "title");
		map.put("contents", "contents");
		mav.addObject("news", map);
		mav.setViewName("test");
		return mav;
	}	
	
	@RequestMapping(value = "/main", method=RequestMethod.GET)
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<> ();
		map.put("title", "title");
		map.put("contents", "contents");
		mav.addObject("news", map);
		mav.setViewName("main");
		return mav;
	}		
}
