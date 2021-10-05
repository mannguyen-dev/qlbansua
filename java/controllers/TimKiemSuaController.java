package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import businessLogics.HangSuaBL;
import businessLogics.LoaiSuaBL;
import businessLogics.SuaBL;
import javaBeans.Sua;

@Controller
public class TimKiemSuaController {
	@RequestMapping(path = "TimKiemSua", method = RequestMethod.GET)
	public String timKiemSua(Model model) {
		model.addAttribute("dshs", HangSuaBL.docTatCa());
		model.addAttribute("dsls", LoaiSuaBL.docTatCa());
		return "tim-kiem-sua";
	}
	
	@RequestMapping(path = "TimKiemSua", method = RequestMethod.POST)
	public String timKiemSua(HttpServletRequest rq, Model model) {
		model.addAttribute("dshs", HangSuaBL.docTatCa());
		model.addAttribute("dsls", LoaiSuaBL.docTatCa());
		
		String maHang = rq.getParameter("cboHangSua");
		String maLoai = rq.getParameter("cboLoaiSua");
		String ten = "";
		if (rq.getParameter("ten")!=null)
			ten = rq.getParameter("ten");
		List<Sua> dss = SuaBL.docTheoHangLoaiTen(maHang, maLoai, ten);
		int sosp = dss.size();
		
		model.addAttribute("dss", dss);
		model.addAttribute("sosp", sosp);
		return "tim-kiem-sua";
	}
}
