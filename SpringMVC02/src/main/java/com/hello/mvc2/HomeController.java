package com.hello.mvc2;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hello.mvc2.dto.AddressDto;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	//@RequestMapping:요청받은걸 서블릿 매핑(HttpServletRequest request)하듯이 매핑해주는 것
	@RequestMapping(value = "/command.do", method = RequestMethod.GET)
	public String getCommand(Model model, @RequestParam("name") String name, String addr, HttpServletRequest request) { //넘어오는 애랑 변수이름이 같으면 자동으로 넣어줌
		//모델은 값을 저장해서 전달해주기위해	//?쿼리스트링 형태로 전달해주기 위해 담아둠, 넘어오는 애랑 변수이름이 같으면 생략 가능
		
		String phone = request.getParameter("phone");
		
		model.addAttribute("dto", new AddressDto(name, addr, phone));
		
		return "get";
	}
	
	@RequestMapping(value = "/command.do", method = RequestMethod.POST)
	public String postCommand(Model model, @ModelAttribute AddressDto dto) {// @ModelAttribute 생략가능, AddressDto로 보내고 있음
																			//세터의 이름과 전달해주는 값이 같으면 자동으로 매핑된다.
		
		model.addAttribute("dto", dto);
		
		return "post";
	}
	
	@RequestMapping("/void.do")//리턴 스트링이 없으면 void.do이름으로 찾는다.
	public void voidPage(Model model) {
		model.addAttribute("message", "viewname 안써도 들어갑니다.");
	}
	
}
