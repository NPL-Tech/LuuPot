package model;

import java.sql.Date;


public class Products {
	private long id;
	private long id_loaiSanPham;
	private String tenSanPham;
	private String moTa;
	private String anhChinh;
	private double giaGoc;
	private int khuyenMai;
	private int idTH;
	private int tinhTrang;
	private String sDate;
	private String endDate;
	private String styles;
	private int soluong;
	private String diachi;

	/**
	 * @param id
	 * @param id_loaiSanPham
	 * @param tenSanPham
	 * @param moTa
	 * @param anhChinh
	 * @param giaGoc
	 * @param khuyenMai
	 * @param luotThich
	 * @param tinhTrang
	 */
	
	

	/**
	 * 
	 */
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(long id, long id_loaiSanPham, String tenSanPham, String moTa, String anhChinh, double giaGoc,
			int khuyenMai, int idTH, int tinhTrang, String sDate, String endDate, String styles, int soluong,
			String diachi) {
		super();
		this.id = id;
		this.id_loaiSanPham = id_loaiSanPham;
		this.tenSanPham = tenSanPham;
		this.moTa = moTa;
		this.anhChinh = anhChinh;
		this.giaGoc = giaGoc;
		this.khuyenMai = khuyenMai;
		this.idTH = idTH;
		this.tinhTrang = tinhTrang;
		this.sDate = sDate;
		this.endDate = endDate;
		this.styles = styles;
		this.soluong = soluong;
		this.diachi = diachi;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId_loaiSanPham() {
		return id_loaiSanPham;
	}

	public void setId_loaiSanPham(long id_loaiSanPham) {
		this.id_loaiSanPham = id_loaiSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getAnhChinh() {
		return anhChinh;
	}

	public void setAnhChinh(String anhChinh) {
		this.anhChinh = anhChinh;
	}

	public double getGiaGoc() {
		return giaGoc;
	}

	public void setGiaGoc(double giaGoc) {
		this.giaGoc = giaGoc;
	}

	public int getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(int khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public int getIdTH() {
		return idTH;
	}

	public void setIdTH(int idTH) {
		this.idTH = idTH;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStyles() {
		return styles;
	}

	public void setStyles(String styles) {
		this.styles = styles;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	
}
