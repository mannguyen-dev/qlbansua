package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import businessLogics.SuaBL;
import javaBeans.Sua;

@Controller
public class SuaBanChayController {
	@RequestMapping(path = "SuaBanChay")
	public String suaBanChay(Model model, HttpServletRequest rq) {
		List<Sua> dss = SuaBL.suaBanChay(5);
		Sua s = dss.get(0);
		if (rq.getParameter("maSua")!=null)
			s = SuaBL.docTheoMaSua(rq.getParameter("maSua"));
		model.addAttribute("dss", dss);
		model.addAttribute("sua", s);
		return "sua-ban-chay";
	}
}
