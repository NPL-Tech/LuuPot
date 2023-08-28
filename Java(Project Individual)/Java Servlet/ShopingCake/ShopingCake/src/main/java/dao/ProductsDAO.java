
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Products;
import model.ProductsDetail;

/**
 * @author MyPC
 *
 */
public class ProductsDAO {

	// hàm get hiển thị ra sản phẩm giao diện Trang chủ và Quản lý
	public ArrayList<Products> getListProducts() {
		DBConnect cs = new DBConnect();
		ArrayList<Products> lst = new ArrayList<Products>();
		try {
			cs.getConnection();
			String sql = " SELECT * FROM sanpham";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// tạo 1 đối tượng gán giá trị
				Products products = new Products();
				products.setId(rs.getLong("id"));
				products.setAnhChinh(rs.getString("anhchinh"));
				products.setGiaGoc(rs.getDouble("giagoc"));
				products.setId_loaiSanPham(rs.getLong("id_loaisp"));
				products.setKhuyenMai(rs.getInt("khuyenmai"));
				products.setMoTa(rs.getString("mota"));
				products.setTenSanPham(rs.getString("tensanpham"));
				products.setTinhTrang(rs.getInt("tinhtrang"));
				// Thêm vào danh sách
				lst.add(products);
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

	// get top 8 sản phẩm ra Trang chủ
	// hàm get hiển thị ra sản phẩm giao diện Trang chủ và Quản lý
	public ArrayList<Products> getListProductsTop8() {
		DBConnect cs = new DBConnect();
		ArrayList<Products> lst = new ArrayList<Products>();
		try {
			cs.getConnection();
			String sql = " SELECT TOP(12)* FROM sanpham";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// tạo 1 đối tượng gán giá trị
				Products products = new Products();
				products.setId(rs.getLong("id"));
				products.setAnhChinh(rs.getString("anhchinh"));
				products.setGiaGoc(rs.getDouble("giagoc"));
				products.setId_loaiSanPham(rs.getLong("id_loaisp"));
				products.setKhuyenMai(rs.getInt("khuyenmai"));
				products.setMoTa(rs.getString("mota"));
				products.setTenSanPham(rs.getString("tensanpham"));
				products.setTinhTrang(rs.getInt("tinhtrang"));
				// Thêm vào danh sách
				lst.add(products);

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

	// hàm get hiển thị ra sản phẩm theo loại sản phẩm giao diện Trang chủ
	public ArrayList<Products> getProductsByCategory(String maLoai) {
		DBConnect cs = new DBConnect();
		ArrayList<Products> lst = new ArrayList<Products>();
		try {
			cs.getConnection();
			String sql = " SELECT * FROM SANPHAM WHERE id_loaisp=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, maLoai);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// tạo 1 đối tượng gán giá trị
				Products products = new Products();
				products.setId(rs.getLong("id"));
				products.setAnhChinh(rs.getString("anhchinh"));
				products.setGiaGoc(rs.getDouble("giagoc"));
				products.setId_loaiSanPham(rs.getLong("id_loaisp"));
				products.setKhuyenMai(rs.getInt("khuyenmai"));
				products.setIdTH(rs.getInt("idTh"));
				products.setMoTa(rs.getString("mota"));
				products.setTenSanPham(rs.getString("tensanpham"));
				products.setTinhTrang(rs.getInt("tinhtrang"));
				// Thêm vào danh sách
				lst.add(products);

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

	// hàm get hiển thị ra sản phẩm khi nhập Tìm kiếm giao diện Trang chủ
	public ArrayList<Products> getProductsByName(String name) {
		DBConnect cs = new DBConnect();
		ArrayList<Products> lst = new ArrayList<Products>();
		try {
			cs.getConnection();
			String sql = " SELECT * FROM SANPHAM WHERE TENSANPHAM LIKE '%" + name + "%' ";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			// cmd.setString(1, name);
			// System.out.println(name+"gt3");
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// tạo 1 đối tượng gán giá trị
				Products products = new Products();
				products.setId(rs.getLong("id"));
				products.setAnhChinh(rs.getString("anhchinh"));
				products.setGiaGoc(rs.getDouble("giagoc"));
				products.setId_loaiSanPham(rs.getLong("id_loaisp"));
				products.setKhuyenMai(rs.getInt("khuyenmai"));
				products.setIdTH(rs.getInt("idTh"));
				products.setMoTa(rs.getString("mota"));
				products.setTenSanPham(rs.getString("tensanpham"));
				products.setTinhTrang(rs.getInt("tinhtrang"));
				// Thêm vào danh sách
				lst.add(products);

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

	// hàm get hiển thị ra sản phẩm theo mã id- giao diện Trang chủ / giỏ hàng
	public Products getProductsByID(long idSanPham) {
		DBConnect cs = new DBConnect();
		Products lst = new Products();
		Products products = new Products();

		try {
			cs.getConnection();
			String sql = " SELECT * FROM SANPHAM WHERE id=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, idSanPham);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {

				products.setId(rs.getLong("id"));
				products.setAnhChinh(rs.getString("anhchinh"));
				products.setGiaGoc(rs.getDouble("giagoc"));
				products.setId_loaiSanPham(rs.getLong("id_loaisp"));
				products.setKhuyenMai(rs.getInt("khuyenmai"));
				products.setIdTH(rs.getInt("idTh"));
				products.setMoTa(rs.getString("mota"));
				products.setTenSanPham(rs.getString("tensanpham"));
				products.setTinhTrang(rs.getInt("tinhtrang"));
				products.setEndDate(rs.getString("enddate"));
				products.setsDate(rs.getString("startdate"));
				products.setStyles(rs.getString("phongcach"));
				return products;

			}
			// đống kết nối
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// System.out.println(lst.getId()+"kkkk");
		return products;
	}

	/* Xong phần hiển thị trang chủ */

	/* Phần quản lý admin */
	// thêm sản phẩm
	public boolean addProduct(Products pr) {
		DBConnect cs = new DBConnect();
		try {
			cs.getConnection();
			String sql = "INSERT INTO sanpham VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, pr.getTenSanPham());
			cmd.setString(2, pr.getMoTa());
			cmd.setDouble(3, pr.getGiaGoc());
			cmd.setInt(4, pr.getKhuyenMai());
			cmd.setString(5, pr.getAnhChinh());
			cmd.setInt(6, pr.getTinhTrang());
			cmd.setInt(7, pr.getIdTH());
			cmd.setLong(8, pr.getId_loaiSanPham());
			cmd.setString(9,  pr.getsDate());
			cmd.setString(10, pr.getEndDate());
			cmd.setString(11, pr.getStyles());
			cmd.setString(12, pr.getDiachi());
			cmd.setInt(13, pr.getSoluong());
			cmd.executeUpdate();
			cs.cn.close();
			cmd.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// sửa sản phẩm
	public boolean editProduct(Products pr) {
		DBConnect cs = new DBConnect();
		try {
			cs.getConnection();
			String sql = "UPDATE sanpham SET tensanpham = ?, mota = ?, giagoc = ?, khuyenmai = ?, anhchinh = ?, tinhtrang = ?, idTH = ?, id_loaisp = ?,startdate=?, enddate=?, phongcach=?, diachi=?, soluong=? WHERE id = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, pr.getTenSanPham());
			cmd.setString(2, pr.getMoTa());
			cmd.setDouble(3, pr.getGiaGoc());
			cmd.setDouble(4, pr.getKhuyenMai());
			cmd.setString(5, pr.getAnhChinh());
			cmd.setInt(6, pr.getTinhTrang());
			cmd.setInt(7, pr.getIdTH());
			cmd.setLong(8, pr.getId_loaiSanPham());
			cmd.setString(9,pr.getsDate() );
			cmd.setString(10,pr.getEndDate() );
			cmd.setString(11,pr.getStyles());
			cmd.setString(12,pr.getDiachi() );
			cmd.setInt(13,pr.getSoluong());
			cmd.setLong(14,pr.getId());
			cmd.executeUpdate();
			cs.cn.close();
			cmd.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// get 1 sản phẩm theo id
	// xóa sản phẩm theo mã id
	public boolean deleteProduct(long id) {
		DBConnect cs = new DBConnect();
		try {
			cs.getConnection();
			String sql = "DELETE FROM sanpham WHERE id = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, id);
			cmd.executeUpdate();
			cs.cn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/* Phân trang sản phẩm ở trang product.jsp */
	// hàm get toàn bộ sản phẩm giới hạn trang
	public ArrayList<Products> getAllProDuctsLimit(int a, int b) {
		ArrayList<Products> lst = new ArrayList<Products>();
		DBConnect cs = new DBConnect();
		try {
			cs.getConnection();
			String sql = "SELECT * FROM ( \r\n" + "  SELECT *, ROW_NUMBER() OVER (ORDER BY id) as row FROM sanpham \r\n"
					+ " ) a WHERE a.row > ? and a.row <=? ";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setInt(1, a);
			cmd.setInt(2, b);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				// tạo 1 đối tượng gán giá trị
				Products products = new Products();
				products.setId(rs.getLong("id"));
				products.setAnhChinh(rs.getString("anhchinh"));
				products.setGiaGoc(rs.getDouble("giagoc"));
				products.setId_loaiSanPham(rs.getLong("id_loaisp"));
				products.setKhuyenMai(rs.getInt("khuyenmai"));
				products.setIdTH(rs.getInt("idTh"));
				products.setMoTa(rs.getString("mota"));
				products.setTenSanPham(rs.getString("tensanpham"));
				products.setTinhTrang(rs.getInt("tinhtrang"));
				// Thêm vào danh sách
				lst.add(products);
			}
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lst;
	}

	// ĐẾM tổng số sản phẩm
	public int getCount() throws Exception {
		DBConnect cs = new DBConnect();
		String sql = "SELECT count(id) FROM sanpham";
		int count = 0;
		try {
			cs.getConnection();
			PreparedStatement stmt = cs.cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			cs.cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public ArrayList<Products> getProductPage(int page) {

		int size = getListProducts().size();
		int residual = size % 9;
		int number = size / 9;
		ArrayList<Products> lst = new ArrayList<Products>();

		DBConnect cs = new DBConnect();
		try {
			cs.getConnection();

			String sql = "SELECT \n"
					+ "  ROW_NUMBER() OVER(ORDER BY id ASC) AS id,tensanpham,mota,giagoc,khuyenmai,anhchinh,tinhtrang,idTh,id_loaisp\n"
					+ "FROM sanpham\n" + "WHERE id > ? and id<?;";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);

			if (residual > 0 && (page - number == 1)) {
				int result = page * 9;
				cmd.setInt(1, number);
				cmd.setInt(2, size);
			} else if (residual > 0 && (page - number == 0)) {
				int result = page - 1;
				cmd.setInt(1, result * 9);
				cmd.setInt(2, page * 9);
			} else if (page < number && page != 0) {
				int result = page - 1;
				cmd.setInt(1, result * 9);
				cmd.setInt(2, page * 9);
			} else if (page == 0) {
				cmd.setInt(1, 0);
				cmd.setInt(2, 9);
			}

			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				Products products = new Products();
				products.setId(rs.getLong("id"));
				products.setAnhChinh(rs.getString("anhchinh"));
				products.setGiaGoc(rs.getDouble("giagoc"));
				products.setId_loaiSanPham(rs.getLong("id_loaisp"));
				products.setKhuyenMai(rs.getInt("khuyenmai"));
				products.setIdTH(rs.getInt("idTh"));
				products.setMoTa(rs.getString("mota"));
				products.setTenSanPham(rs.getString("tensanpham"));
				products.setTinhTrang(rs.getInt("tinhtrang"));
				lst.add(products);
			}
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}

	public ArrayList<Integer> getNumberPagge() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int size = getListProducts().size();
		int residual = size % 9;
		int number = size / 9;
		int run = 0;
		if (residual > 0) {
			run = number + 2;
		} else {
			run = number + 1;
		}
		for (int i = 1; i < run; i++) {
			list.add(i);
		}
		// TODO Auto-generated method stub
		return list;
	}

	public List<ProductsDetail> getListProductDetails(long id) {
		// TODO Auto-generated method stub
		DBConnect cs = new DBConnect();
		List<ProductsDetail> list = new ArrayList<ProductsDetail>();
		try {
			cs.getConnection();
			String sql = "select * from chitietsanpham where id_sanpham=?";

			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, id);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				ProductsDetail pd = new ProductsDetail();
				pd.setId(rs.getLong("id"));
				pd.setAnhChiTiet(rs.getString("anhchitiet"));
				pd.setId_sanPham(rs.getLong("id_sanpham"));
				list.add(pd);
			}
			// đống kết nối
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// System.out.println(lst.getId()+"kkkk");
		return list;
	}

	public Products updateProduct(Products products) {
		
		
		return null;
	}

}
