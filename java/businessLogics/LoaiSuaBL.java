package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.LoaiSua;

public class LoaiSuaBL {
	private static JdbcTemplate jdbc= CSDL.getJdbc();
	public static List<LoaiSua> docTatCa(){
		String sql ="select * from loai_sua";
		return jdbc.query(sql, new RowMapper<LoaiSua>() {
			@Override
			public LoaiSua mapRow(ResultSet rs, int numRow) throws SQLException {
				LoaiSua ls = new LoaiSua();
				ls.setMaLoaiSua(rs.getString("ma_loai_sua"));
				ls.setTenLoai(rs.getString("ten_loai"));
				return ls;
			}
		});
	}
}
