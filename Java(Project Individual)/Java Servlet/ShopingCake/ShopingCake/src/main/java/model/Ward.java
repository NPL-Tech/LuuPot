package model;


public class Ward {
	private long id, code, id_quanHuyen;
	private String ten, tenKhongDau, tenDayDu, donVi, tenThuong, tenHanhChinh;

	/**
	 * 
	 */
	public Ward() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param code
	 * @param id_quanHuyen
	 * @param ten
	 * @param tenKhongDau
	 * @param tenDayDu
	 * @param donVi
	 * @param tenThuong
	 * @param tenHanhChinh
	 */
	public Ward(long id, long code, long id_quanHuyen, String ten, String tenKhongDau, String tenDayDu,
			String donVi, String tenThuong, String tenHanhChinh) {
		super();
		this.id = id;
		this.code = code;
		this.id_quanHuyen = id_quanHuyen;
		this.ten = ten;
		this.tenKhongDau = tenKhongDau;
		this.tenDayDu = tenDayDu;
		this.donVi = donVi;
		this.tenThuong = tenThuong;
		this.tenHanhChinh = tenHanhChinh;
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
	 * @return the code
	 */
	public long getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(long code) {
		this.code = code;
	}

	/**
	 * @return the id_quanHuyen
	 */
	public long getId_quanHuyen() {
		return id_quanHuyen;
	}

	/**
	 * @param id_quanHuyen
	 *            the id_quanHuyen to set
	 */
	public void setId_quanHuyen(long id_quanHuyen) {
		this.id_quanHuyen = id_quanHuyen;
	}

	/**
	 * @return the ten
	 */
	public String getTen() {
		return ten;
	}

	/**
	 * @param ten
	 *            the ten to set
	 */
	public void setTen(String ten) {
		this.ten = ten;
	}

	/**
	 * @return the tenKhongDau
	 */
	public String getTenKhongDau() {
		return tenKhongDau;
	}

	/**
	 * @param tenKhongDau
	 *            the tenKhongDau to set
	 */
	public void setTenKhongDau(String tenKhongDau) {
		this.tenKhongDau = tenKhongDau;
	}

	/**
	 * @return the tenDayDu
	 */
	public String getTenDayDu() {
		return tenDayDu;
	}

	/**
	 * @param tenDayDu
	 *            the tenDayDu to set
	 */
	public void setTenDayDu(String tenDayDu) {
		this.tenDayDu = tenDayDu;
	}

	/**
	 * @return the donVi
	 */
	public String getDonVi() {
		return donVi;
	}

	/**
	 * @param donVi
	 *            the donVi to set
	 */
	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	/**
	 * @return the tenThuong
	 */
	public String getTenThuong() {
		return tenThuong;
	}

	/**
	 * @param tenThuong
	 *            the tenThuong to set
	 */
	public void setTenThuong(String tenThuong) {
		this.tenThuong = tenThuong;
	}

	/**
	 * @return the tenHanhChinh
	 */
	public String getTenHanhChinh() {
		return tenHanhChinh;
	}

	/**
	 * @param tenHanhChinh
	 *            the tenHanhChinh to set
	 */
	public void setTenHanhChinh(String tenHanhChinh) {
		this.tenHanhChinh = tenHanhChinh;
	}

}
