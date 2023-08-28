package model;


public class Brand {
	private long id;
	private String thuonghieu;

	/**
	 * 
	 */
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param tenLoaiSanPham
	 */
	public Brand(long id, String tenLoaiSanPham) {
		super();
		this.id = id;
		this.thuonghieu = tenLoaiSanPham;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the tenLoaiSanPham
	 */
	public String getTenLoaiSanPham() {
		return thuonghieu;
	}

	/**
	 * @param tenLoaiSanPham
	 *            the tenLoaiSanPham to set
	 */
	public void setTenLoaiSanPham(String tenLoaiSanPham) {
		this.thuonghieu = tenLoaiSanPham;
	}

}
