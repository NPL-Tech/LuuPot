package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Bills;
import model.Dasboard;

public class DashboardDAO {
	// hàm get hiển thị ra sản phẩm giao diện Trang chủ và Quản lý
	public ArrayList<Bills> getThongKe(String tungay, String denngay) {
		DBConnect cs = new DBConnect();
		ArrayList<Bills> lst = new ArrayList<Bills>();
		try {
			cs.getConnection();
			String sql = "select * from hoadon where ngaydat BETWEEN '" + tungay + "' AND '" + denngay + "'"+" AND trangthai=2";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// Tạo một đối tượng gán giá trị
				Bills bill = new Bills();
				bill.setId(rs.getLong("id"));
				bill.setHoTen(rs.getString("hoten"));
				bill.setSoNha(rs.getString("sonha"));
				bill.setDiaChi(rs.getString("diachi"));
				bill.setSoDienThoai(rs.getString("dienthoai"));
				bill.setEmail(rs.getString("email"));
				bill.setGhiChu(rs.getString("ghichu"));
				bill.setTrangThai(rs.getInt("trangthai"));
				bill.setNgayDat(rs.getString("ngaydat"));
				bill.setTotal(rs.getString("total"));
				// Thêm vào danh sách
				lst.add(bill);
			}
			// đống kết nối
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}

}
