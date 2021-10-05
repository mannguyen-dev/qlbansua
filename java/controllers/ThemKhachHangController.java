package controllers;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import businessLogics.KhachHangBL;
import javaBeans.KhachHang;

@Controller
public class ThemKhachHangController {
	@ModelAttribute
	public void setUTF8(HttpServletRequest rq) {
		try {
			rq.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(path = "ThemKhachHang")
	public String themKH() {
		
		return "them-khach-hang";
	}
	
	@RequestMapping(path = "ThemKhachHang",method = RequestMethod.POST)
	public String themKH(HttpServletRequest rq) {
		KhachHang kh = new KhachHang();
		kh.setMaKhachHang(rq.getParameter("txtMaKH"));
		kh.setTenKhachHang(rq.getParameter("txtTenKH"));
		kh.setPhai(rq.getParameter("rdbPhai")!="nam"?true:false);
		kh.setDiaChi(rq.getParameter("txtDiaChi"));
		kh.setDienThoai(rq.getParameter("txtDienThoai"));
		kh.setEmail(rq.getParameter("txtEmail"));
		KhachHangBL.themKH(kh);
		return "them-khach-hang";
	}
}
