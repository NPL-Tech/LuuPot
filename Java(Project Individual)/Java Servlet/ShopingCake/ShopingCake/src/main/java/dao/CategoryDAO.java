package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Category;
import model.Products;
import model.ProductsDetail;

/**
 * @author MyPC
 *
 */
public class CategoryDAO {
	public ArrayList<Category> getListCategory() {
		DBConnect cs = new DBConnect();
		ArrayList<Category> lst = new ArrayList<Category>();
		try {
			cs.getConnection();
			String sql = " SELECT * FROM loaisanpham where theloai ='false'";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// tạo 1 đối tượng gán giá trị
				Category category = new Category();
				category.setId(rs.getLong("id"));
				category.setTenLoaiSanPham(rs.getString("tenloai"));
				// Thêm vào danh sách
				lst.add(category);
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
	public ArrayList<Category> getListBrand() {
		DBConnect cs = new DBConnect();
		ArrayList<Category> lst = new ArrayList<Category>();
		try {
			cs.getConnection();
			String sql = " SELECT * FROM loaisanpham where theloai ='true' ";
			
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// tạo 1 đối tượng gán giá trị
				Category category = new Category();
				category.setId(rs.getLong("id"));
				category.setTenLoaiSanPham(rs.getString("tenloai"));
				// Thêm vào danh sách
				lst.add(category);
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
	/* Xong phần hiển thị trang chủ */

	/* Phần quản lý admin */

	// thêm mới 1 loại sản phẩm
	public boolean addCategory(Category ca) {
		DBConnect cs = new DBConnect();
		try {
			cs.getConnection();
			String sql = "INSERT INTO loaisanpham VALUES(?,?)";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ca.getTenLoaiSanPham());
			cmd.setString(2, ca.getTheloai());
			cmd.executeUpdate();
			cs.cn.close();
			cmd.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// hàm get hiển thị ra loại sản phẩm theo mã id-
	public Category getCategoryByID(long id) {
		DBConnect cs = new DBConnect();
		Category lst = new Category();
		try {
			cs.getConnection();
			String sql = " SELECT * FROM LOAISANPHAM WHERE id=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, id);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {				
				long id_loaiSanPham = rs.getLong("id");
				String tenLoaiSanPham = rs.getString("tenloai");	
				String theloai = rs.getString("theloai");			

				lst = new Category(id_loaiSanPham, tenLoaiSanPham,theloai);
			}
			rs.close();
			cs.cn.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}
		// System.out.println(lst.getId()+"kkkk");
		return lst;
	}	

	// sửa loại sản phẩm
	public boolean editCategory(Category ca) {
		DBConnect cs = new DBConnect();
		try {
			cs.getConnection();
			String sql = "UPDATE loaisanpham SET tenloai = ? where id=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ca.getTenLoaiSanPham());
			cmd.setLong(2, ca.getId());
			cmd.executeUpdate();
			cs.cn.close();
			cmd.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// xóa sản phẩm theo mã id
	public int deleteProduct(long id) {
		DBConnect cs = new DBConnect();
		int kq=0;
		try {
			cs.getConnection();
			String sql = "DELETE FROM loaisanpham WHERE id = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, id);
			kq =cmd.executeUpdate();
			cs.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}
	public static void main(String[] args) {
		ProductDetailDAO productsDAO = new ProductDetailDAO();
		ArrayList<ProductsDetail> list = productsDAO.getProductDetail();
		for (int i = 0; i < list.size(); i++) {
			DBConnect cs = new DBConnect();
			try {
				cs.getConnection();
				String sql = "UPDATE chitietsanpham SET id=? WHERE id = ?;";
				PreparedStatement cmd = cs.cn.prepareStatement(sql);
				int a = i + 1;
				cmd.setLong(1, a);
				cmd.setLong(2, list.get(i).getId());
				cmd.executeUpdate();
				cs.cn.close();
				cmd.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
