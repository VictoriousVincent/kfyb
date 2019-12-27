package com.icbc.bjfh.kfyb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//@controller不是@RestController，使用@RestController会返回“index”字符串
@Controller
public class IndexController {
	
	@RequestMapping("/index")
    public String test(){ 
        return "index";
    }

}
