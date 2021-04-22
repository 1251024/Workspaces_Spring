package com.mvc.upgrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mvc.upgrade.biz.MYBoardBiz;

@Controller
public class MYBoardController {
	
	@Autowired
	private MYBoardBiz biz;

}
