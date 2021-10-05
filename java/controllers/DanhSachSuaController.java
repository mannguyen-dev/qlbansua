package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import businessLogics.HangSuaBL;
import businessLogics.LoaiSuaBL;
import businessLogics.SuaBL;
import javaBeans.HangSua;
import javaBeans.LoaiSua;
import javaBeans.Sua;

@Controller
public class DanhSachSuaController {
	@RequestMapping(path = "DanhSachSua")
	public String danhsachsua(Model model, HttpServletRequest rq) {
		List<HangSua> dshs = HangSuaBL.docTatCa();
		List<LoaiSua> dsls = LoaiSuaBL.docTatCa();
		List<Sua> dss = null;
		if (rq.getParameter("maHang")!=null)
			dss = SuaBL.docTheoMaHang(rq.getParameter("maHang"));
		else if (rq.getParameter("maLoai")!=null)
			dss = SuaBL.docTheoMaLoai(rq.getParameter("maLoai"));
		else
			dss = SuaBL.docTatCa();
		int trang =1;
		if (rq.getParameter("trang")!=null)
			trang =Integer.parseInt(rq.getParameter("trang"));
		int tsd = dss.size();
		int sdt = 5;
		int tst = tsd/sdt+(tsd%sdt!=0?1:0);
		int vtd = (trang-1)*sdt;
		int vtc = (trang*sdt<tsd?(vtd+sdt):(vtd+tsd%sdt));
		dss = dss.subList(vtd, vtc);
		
		model.addAttribute("tongSoTrang", tst);
		model.addAttribute("dss",dss);
		model.addAttribute("dshs", dshs);
		model.addAttribute("dsls", dsls);
		return "danh-sach-sua";
	}
}
