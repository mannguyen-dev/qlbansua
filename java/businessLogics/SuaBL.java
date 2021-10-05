package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.Sua;

public class SuaBL {
	private static JdbcTemplate jdbc= CSDL.getJdbc();
	public static List<Sua> docTatCa(){
		String sql= "select * from sua";
		return jdbc.query(sql, new RowMapper<Sua>() {
			@Override
			public Sua mapRow(ResultSet rs, int numRow) throws SQLException {
				Sua s =new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setTenSua(rs.getString("Ten_sua"));
				s.setMaHangSua(rs.getString("ma_hang_sua"));
				s.setMaLoaiSua(rs.getString("ma_loai_sua"));
				s.setTrongLuong(rs.getInt("trong_luong"));
				s.setDonGia(rs.getInt("don_gia"));
				s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				s.setLoiIch(rs.getString("Loi_ich"));
				s.setHinh(rs.getString("hinh"));
				return s;
			}
		});
	}
	
	public static List<Sua> suaBanChay(int top){
		String sql= "SELECT s.*, sum(ct.So_luong) AS tsl from sua s INNER JOIN ct_hoadon ct WHERE s.Ma_sua = ct.Ma_sua "
				+ "GROUP BY 1 ORDER BY tsl DESC LIMIT 0,"+top;
		return jdbc.query(sql, new RowMapper<Sua>() {
			@Override
			public Sua mapRow(ResultSet rs, int numRow) throws SQLException {
				Sua s =new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setTenSua(rs.getString("Ten_sua"));
				s.setMaHangSua(rs.getString("ma_hang_sua"));
				s.setMaLoaiSua(rs.getString("ma_loai_sua"));
				s.setTrongLuong(rs.getInt("trong_luong"));
				s.setDonGia(rs.getInt("don_gia"));
				s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				s.setLoiIch(rs.getString("Loi_ich"));
				s.setHinh(rs.getString("hinh"));
				return s;
			}
		});
	}
	
	
	public static List<Sua> docTheoMaHang(String maHang){
		String sql= "select * from sua where ma_hang_sua='"+maHang+"'";
		return jdbc.query(sql, new RowMapper<Sua>() {
			@Override
			public Sua mapRow(ResultSet rs, int numRow) throws SQLException {
				Sua s =new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setTenSua(rs.getString("Ten_sua"));
				s.setMaHangSua(rs.getString("ma_hang_sua"));
				s.setMaLoaiSua(rs.getString("ma_loai_sua"));
				s.setTrongLuong(rs.getInt("trong_luong"));
				s.setDonGia(rs.getInt("don_gia"));
				s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				s.setLoiIch(rs.getString("Loi_ich"));
				s.setHinh(rs.getString("hinh"));
				return s;
			}
		});
	}
	
	public static List<Sua> docTheoMaLoai(String maLoai){
		String sql= "select * from sua where ma_loai_sua='"+maLoai+"'";
		return jdbc.query(sql, new RowMapper<Sua>() {
			@Override
			public Sua mapRow(ResultSet rs, int numRow) throws SQLException {
				Sua s =new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setTenSua(rs.getString("Ten_sua"));
				s.setMaHangSua(rs.getString("ma_hang_sua"));
				s.setMaLoaiSua(rs.getString("ma_loai_sua"));
				s.setTrongLuong(rs.getInt("trong_luong"));
				s.setDonGia(rs.getInt("don_gia"));
				s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				s.setLoiIch(rs.getString("Loi_ich"));
				s.setHinh(rs.getString("hinh"));
				return s;
			}
		});
	}
	
	public static List<Sua> docTheoHangLoaiTen(String maHang, String maLoai, String ten){
		String sql= "select * from sua where ma_hang_sua='"+maHang+"' and ma_loai_sua='"+maLoai+"' and ten_sua like '%"+ten+"%'";
		return jdbc.query(sql, new RowMapper<Sua>() {
			@Override
			public Sua mapRow(ResultSet rs, int numRow) throws SQLException {
				Sua s =new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setTenSua(rs.getString("Ten_sua"));
				s.setMaHangSua(rs.getString("ma_hang_sua"));
				s.setMaLoaiSua(rs.getString("ma_loai_sua"));
				s.setTrongLuong(rs.getInt("trong_luong"));
				s.setDonGia(rs.getInt("don_gia"));
				s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				s.setLoiIch(rs.getString("Loi_ich"));
				s.setHinh(rs.getString("hinh"));
				return s;
			}
		});
	}
	
	public static Sua docTheoMaSua(String maSua){
		String sql= "select * from sua where ma_sua='"+maSua+"'";
		return jdbc.queryForObject(sql, new RowMapper<Sua>() {
			@Override
			public Sua mapRow(ResultSet rs, int numRow) throws SQLException {
				Sua s =new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setTenSua(rs.getString("Ten_sua"));
				s.setMaHangSua(rs.getString("ma_hang_sua"));
				s.setMaLoaiSua(rs.getString("ma_loai_sua"));
				s.setTrongLuong(rs.getInt("trong_luong"));
				s.setDonGia(rs.getInt("don_gia"));
				s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				s.setLoiIch(rs.getString("Loi_ich"));
				s.setHinh(rs.getString("hinh"));
				return s;
			}
		});
	}
	
	public static int themSua(Sua s) {
		String sql = "insert into sua(ma_sua,ten_sua,ma_hang_sua,ma_loai_sua,trong_luong,don_gia,tp_dinh_duong,loi_ich,hinh) values(?,?,?,?,?,?,?,?,?)";
		return jdbc.update(sql, s.getMaSua(), s.getTenSua(), s.getMaHangSua(),s.getMaLoaiSua(),s.getTrongLuong(),s.getDonGia(),s.getTpDinhDuong(),s.getLoiIch(),s.getHinh());
	}
	
	public static void main(String[] args) {
//		Sua s = docTheoMaSua("AB0001");
//		System.out.println(s.getTenSua());
//		List<Sua> ds = suaBanChay(10);
//		ds.forEach(s->System.out.println(s.getTenSua()));
		Sua s = new Sua();
		s.setMaSua("aa");
		s.setTenSua("aaa");
		s.setMaHangSua("DL");
		s.setMaLoaiSua("SB");
		s.setLoiIch("aaa");
		s.setTrongLuong(100);
		s.setTpDinhDuong("sdv");
		s.setHinh("skks.jps");
		s.setDonGia(22);
		int kq =themSua(s);
		if (kq>0)System.out.println("thanh cong");
	}
}
