package springmvc2;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/aaa/")	//	url에서 localhost:9090/aaa/index
public class IndexController 
{	
	@RequestMapping("/index1")
	public String index1() {	
		System.out.println("index.jsp실행");
		return "index.jsp";	
	}
	
	@RequestMapping("/index2")
	public String index2() {	
		System.out.println("/WEB-INF/index.jsp실행");
		return "/WEB-INF/index.jsp";	
	}
	
	@RequestMapping("/index3")
	public String index3() {	
		System.out.println("/WEB-INF/view/index.jsp실행");
		return "/WEB-INF/view/index.jsp";	
	}
	
	@RequestMapping("/index4")
	public String index4() {	
		System.out.println("index4 뷰 리졸버 실행");
		return "index4";	
	}
	
	@RequestMapping("/index5")
	public ModelAndView index5(String page, String count) {	
		System.out.println("index5 뷰 리졸버 실행 : "+page + " " +count);
		ModelAndView mv = new ModelAndView();
		mv.addObject("page",page);
		mv.addObject("count",count);
		mv.setViewName("index5");
		return mv;	
	}
	
	@RequestMapping("/index6")
	public ModelAndView index6(HttpServletRequest request) {	
		
		String page = request.getParameter("page");
		String count = request.getParameter("count");
		
		System.out.println("index6 뷰 리졸버 실행 : "+page + " " +count);
		ModelAndView mv = new ModelAndView();
		mv.addObject("page",page);
		mv.addObject("count",count);
		mv.setViewName("index6");
		return mv;	
	}
	
	@RequestMapping("/serialdata")
	public void serialdata(String data, HttpServletRequest request) {
		System.out.println("web data : " +data);
		
		//	아두이노로부터 전송된 데이터를 활용하여 처리
		
		//	DB처리
		
		//	web jsp에 데이터를 보내는 처리
		ServletContext app = request.getServletContext();	//	전역 저장 객체
		app.setAttribute("data", data);
	}
	
	@RequestMapping("/serial1")
	public String serialdata1() {
		return "arduino1";
	}
	
	@RequestMapping("/serial2")
	public ModelAndView serialdata(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		ServletContext app = request.getServletContext();	//	전역 저장 객체
		String data = (String)app.getAttribute("data");
		
		mv.addObject("data",data);
		mv.setViewName("arduino2");	//	arduino페이지로 이동
		
		return mv;
	}
}
