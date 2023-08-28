package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Bills;

public class BillsDAO {

	public ArrayList<Bills> getListOrder() {
		DBConnect cs = new DBConnect();
		ArrayList<Bills> lst = new ArrayList<Bills>();
		try {
			cs.getConnection();
			String sql = " SELECT * FROM hoadon WHERE trangthai = 0 ";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
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

	public ArrayList<Bills> getBills() {
		DBConnect cs = new DBConnect();
		ArrayList<Bills> lst = new ArrayList<Bills>();
		try {
			cs.getConnection();
			String sql = " SELECT * FROM hoadon WHERE trangthai =2";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
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

	// Danh sách hóa đơn đang ship
	public ArrayList<Bills> getTranspost() {
		DBConnect cs = new DBConnect();
		ArrayList<Bills> lst = new ArrayList<Bills>();
		try {
			cs.getConnection();
			String sql = " SELECT * FROM hoadon WHERE trangthai = 1";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
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

	public boolean getAddData(Bills bill) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		DBConnect cs = new DBConnect();
		try {
			cs.getConnection();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}


	public boolean transport(int trangthai, long id) {
		DBConnect cs = new DBConnect();
		try {
			cs.getConnection();
			String sql = "UPDATE hoadon SET trangthai = ? WHERE id = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setInt(1, trangthai);
			cmd.setLong(2, id);
			cmd.executeUpdate();
			cmd.close();
			cs.cn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public Bills getBillsById(long id) throws Exception {
		DBConnect cs = new DBConnect();
		Bills bill = new Bills();
		try {
			cs.getConnection();
			String sql = "SELECT * FROM hoadon WHERE id =?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, id);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// bill.setId(rs.getLong("id"));
				bill = new Bills(rs.getLong("id"), rs.getString("hoten"), rs.getString("sonha"), rs.getString("diachi"),
						rs.getString("dienthoai"), rs.getString("email"), rs.getString("ghichu"),
						rs.getString("ngaydat"), rs.getInt("trangthai"), rs.getNString("total"));
			}
			// Đóng kết nối
			cmd.close();
			cs.cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bill;
	}


	public boolean cancelOrder(long id) {
		DBConnect cs = new DBConnect();
		try {
			cs.getConnection();
			String sql = "delete from hoadon WHERE id = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, id);
			cmd.executeUpdate();
			cmd.close();
			cs.cn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public double getSumBills() {
		List<Bills> list = new ArrayList<Bills>();
		list = getBills();
		double revenu = 0;
		for (Bills b : list) {
			String d = b.getTotal().replace(",", "");
			double price = Double.parseDouble(d);
			revenu = revenu + price;
		}
		return revenu;
	}
	public ArrayList<Bills> getCancelOrder() {
		DBConnect cs = new DBConnect();
		ArrayList<Bills> lst = new ArrayList<Bills>();
		try {
			cs.getConnection();
			String sql = " SELECT * FROM hoadon WHERE trangthai = 3 ";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
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
