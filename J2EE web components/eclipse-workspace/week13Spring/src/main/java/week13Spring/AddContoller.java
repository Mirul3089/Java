package week13Spring;

import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddContoller {
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest req,HttpServletResponse res) {
		int a = Integer.parseInt(req.getParameter("t1"));
		int b = Integer.parseInt(req.getParameter("t2"));
		
		int sum= a+b;
		
	ModelAndView mv = new ModelAndView();
	mv.setViewName("output.jsp");
	mv.addObject("result",sum);
	
	return mv;
	}
}
