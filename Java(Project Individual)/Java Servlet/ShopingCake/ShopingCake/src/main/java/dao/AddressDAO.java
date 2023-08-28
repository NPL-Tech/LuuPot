
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.District;
import model.Citys;
import model.Ward;
public class AddressDAO {
	public ArrayList<Citys> getTinhThanhPho() {
		DBConnect cs = new DBConnect();
		ArrayList<Citys> lst = new ArrayList<Citys>();
		try {
			cs.getConnection();
			String sql = "Select * From tinh_thanh_phos";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				Citys citys = new Citys();
				citys.setId(rs.getLong("id"));
				citys.setCode(rs.getLong("code"));
				citys.setDonvi(rs.getString("donvi"));
				citys.setTen(rs.getString("ten"));
				citys.setTendaydu(rs.getString("tendaydu"));
				citys.setTenkhongdau(rs.getString("tenkhongdau"));
				// ThĂªm vĂ o danh sĂ¡ch
				lst.add(citys);
			}
			rs.close();
			cs.cn.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}

	public ArrayList<District> getQuanHuyenById(long idTinhTP) {
		DBConnect cs = new DBConnect();
		ArrayList<District> lst = new ArrayList<District>();
		try {
			cs.getConnection();
			String sql = "Select * From quan_huyens Where id_tinhthanhpho=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, idTinhTP);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				District dictrict = new District();
				dictrict.setCode(rs.getLong("code"));
				dictrict.setDonvi(rs.getString("donvi"));
				dictrict.setId(rs.getLong("id"));
				dictrict.setId_tinhthanhpho(rs.getLong("id_tinhthanhpho"));
				dictrict.setTen(rs.getString("ten"));
				dictrict.setTendaydu(rs.getString("tendaydu"));
				dictrict.setTenhanhchinh(rs.getString("tenhanhchinh"));
				dictrict.setTenkhongdau(rs.getString("tenkhongdau"));
				dictrict.setTenthuong(rs.getString("tenthuong"));
				lst.add(dictrict);
			}
			rs.close();
			cs.cn.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}

	public ArrayList<Ward> getXaPhuongById(long idQuanHuyen) {
		DBConnect cs = new DBConnect();
		ArrayList<Ward> lst = new ArrayList<Ward>();
		try {
			cs.getConnection();
			String sql = "Select * From xa_phuongs Where id_quanhuyen=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, idQuanHuyen);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				Ward ward = new Ward();
				ward.setCode(rs.getLong("code"));
				ward.setDonVi(rs.getString("donvi"));
				ward.setId(rs.getLong("id"));
				ward.setId_quanHuyen(rs.getLong("id_quanhuyen"));
				ward.setTen(rs.getString("ten"));
				ward.setTenDayDu(rs.getString("tendaydu"));
				ward.setTenHanhChinh(rs.getString("tenhanhchinh"));
				ward.setTenKhongDau(rs.getString("tenkhongdau"));
				ward.setTenThuong(rs.getString("tenthuong"));
				// ThĂªm vĂ o danh sĂ¡ch
				lst.add(ward);
			}
			rs.close();
			cs.cn.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;

	}

	public Citys getCitys(long id) {
		DBConnect cs = new DBConnect();
		Citys lst = new Citys();
		try {
			cs.getConnection();
			String sql = "Select * From tinh_thanh_phos where id=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, id);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				lst.setId(rs.getLong("id"));
				lst.setCode(rs.getLong("code"));
				lst.setDonvi(rs.getString("donvi"));
				lst.setTen(rs.getString("ten"));
				lst.setTendaydu(rs.getString("tendaydu"));
				lst.setTenkhongdau(rs.getString("tenkhongdau"));
				// ThĂªm vĂ o danh sĂ¡ch
			}
			rs.close();
			cs.cn.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;

	}

	public District getDistrict(long id) {
		DBConnect cs = new DBConnect();
		District d = new District();
		try {
			cs.getConnection();
			String sql = "Select * From quan_huyens Where id_tinhthanhpho=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, id);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				d.setCode(rs.getLong("code"));
				d.setDonvi(rs.getString("donvi"));
				d.setId(rs.getLong("id"));
				d.setId_tinhthanhpho(rs.getLong("id_tinhthanhpho"));
				d.setTen(rs.getString("ten"));
				d.setTendaydu(rs.getString("tendaydu"));
				d.setTenhanhchinh(rs.getString("tenhanhchinh"));
				d.setTenkhongdau(rs.getString("tenkhongdau"));
				d.setTenthuong(rs.getString("tenthuong"));
			}
			rs.close();
			cs.cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	public Ward getWard(long id) {
		DBConnect cs = new DBConnect();
		Ward w = new Ward();
		try {
			cs.getConnection();
			String sql = "Select * From xa_phuongs Where id=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, id);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				w.setCode(rs.getLong("code"));
				w.setDonVi(rs.getString("donvi"));
				w.setId(rs.getLong("id"));
				w.setId_quanHuyen(rs.getLong("id_quanhuyen"));
				w.setTen(rs.getString("ten"));
				w.setTenDayDu(rs.getString("tendaydu"));
				w.setTenHanhChinh(rs.getString("tenhanhchinh"));
				w.setTenKhongDau(rs.getString("tenkhongdau"));
				w.setTenThuong(rs.getString("tenthuong"));
			}
			rs.close();
			cs.cn.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return w;
	}

}
