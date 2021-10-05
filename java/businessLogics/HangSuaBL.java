package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.HangSua;

public class HangSuaBL {
	private static JdbcTemplate jdbc = CSDL.getJdbc();
	public static List<HangSua> docTatCa() {
		String sql = "select * from hang_sua";
		return jdbc.query(sql, new RowMapper<HangSua>() {
			@Override
			public HangSua mapRow(ResultSet rs, int numRow) throws SQLException {
				HangSua hs = new HangSua();
				hs.setMaHangSua(rs.getString("Ma_hang_sua"));
				hs.setTenHangSua(rs.getString("ten_hang_sua"));
				hs.setDiaChi(rs.getString("Dia_chi"));
				hs.setDienThoai(rs.getString("Dien_thoai"));
				hs.setEmail(rs.getString("Email"));
				return hs;
			}
		});
	}
	
	public static void main(String[] args) {
		List<HangSua> dshs = docTatCa();
		dshs.forEach(s->System.out.println(s.getTenHangSua()));
	}
}
