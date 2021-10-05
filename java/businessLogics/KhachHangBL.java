package businessLogics;

import org.springframework.jdbc.core.JdbcTemplate;

import javaBeans.KhachHang;

public class KhachHangBL {
	private static JdbcTemplate jdbc=CSDL.getJdbc();
	public static int themKH(KhachHang kh) {
		String sql = "insert into khach_hang(ma_khach_hang,ten_khach_hang,phai,dia_chi,dien_thoai,email) values(?,?,?,?,?,?)";
		return jdbc.update(sql, kh.getMaKhachHang(),kh.getTenKhachHang(),kh.isPhai(),kh.getDiaChi(),kh.getDienThoai(),kh.getEmail());
	}
	
//	public static void main(String[] args) {
//		KhachHang kh = new KhachHang();
//		kh.setMaKhachHang("aaaa");
//		kh.setTenKhachHang("nvca");
//		kh.setPhai(false);
//		kh.setDienThoai("01444");
//		kh.setDiaChi("add");
//		kh.setEmail("add");
//		themKH(kh);
//	}
}
