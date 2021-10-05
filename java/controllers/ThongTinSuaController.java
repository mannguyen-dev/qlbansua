package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import businessLogics.SuaBL;
import javaBeans.Sua;

@Controller
public class ThongTinSuaController {
	@RequestMapping(path = "/ThongTinSua")
	public String thongTinSua(HttpServletRequest rq, Model model) {
		String maSua = rq.getParameter("maSua");
		Sua s = SuaBL.docTheoMaSua(maSua);
		
		model.addAttribute("s",s);
		return "thong-tin-sua";
	}
}
