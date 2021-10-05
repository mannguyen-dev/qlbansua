package controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import businessLogics.HangSuaBL;
import businessLogics.LoaiSuaBL;
import businessLogics.SuaBL;
import javaBeans.Sua;



@Controller
public class ThemSuaMoiController {
	@ModelAttribute
	public void setUTF8(HttpServletRequest rq) {
		try {
			rq.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(path = "ThemSuaMoi", method = RequestMethod.GET)
	public String themSua(Model model) {
		model.addAttribute("dshs", HangSuaBL.docTatCa());
		model.addAttribute("dsls", LoaiSuaBL.docTatCa());
		return "them-sua-moi";
	}
	
	@RequestMapping(path = "ThemSuaMoi", method = RequestMethod.POST)
	public String themSua(Model model, HttpServletRequest rq, MultipartFile txtHinh) {
		Sua s = new Sua();
		s.setMaSua(rq.getParameter("txtMaSua"));
		System.out.println(s.getMaSua());
		s.setTenSua(rq.getParameter("txtTenSua"));
		s.setMaHangSua(rq.getParameter("cboHangSua"));
		s.setMaLoaiSua(rq.getParameter("cboLoaiSua"));
		s.setDonGia(Integer.parseInt(rq.getParameter("txtDonGia")));
		s.setTrongLuong(Integer.parseInt(rq.getParameter("txtTrongLuong")));
		s.setTpDinhDuong(rq.getParameter("txtTPDinhDuong"));
		s.setLoiIch(rq.getParameter("txtLoiIch"));
		System.out.println(s.getDonGia()+" "+s.getTrongLuong());
		
		try {
			String tentt = txtHinh.getOriginalFilename();
			s.setHinh(tentt);
			String tmtl = rq.getServletContext().getRealPath("/images/");
			OutputStream os = new FileOutputStream(tmtl+tentt);
			byte[] mb = txtHinh.getBytes();
			os.write(mb);
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SuaBL.themSua(s);
		model.addAttribute("dshs", HangSuaBL.docTatCa());
		model.addAttribute("dsls", LoaiSuaBL.docTatCa());
		return "redirect:/trang-them-sua-moi.jsp";
	}
}
