package model;


public class District {
	private long id, code, id_tinhthanhpho;
	private String ten, tenkhongdau, tendaydu, donvi, tenthuong, tenhanhchinh;

	/**
	 * @param id
	 * @param code
	 * @param id_tinhthanhpho
	 * @param ten
	 * @param tenkhongdau
	 * @param tendaydu
	 * @param donvi
	 * @param tenthuong
	 * @param tenhanhchinh
	 */
	public District(long id, long code, long id_tinhthanhpho, String ten, String tenkhongdau, String tendaydu,
			String donvi, String tenthuong, String tenhanhchinh) {
		super();
		this.id = id;
		this.code = code;
		this.id_tinhthanhpho = id_tinhthanhpho;
		this.ten = ten;
		this.tenkhongdau = tenkhongdau;
		this.tendaydu = tendaydu;
		this.donvi = donvi;
		this.tenthuong = tenthuong;
		this.tenhanhchinh = tenhanhchinh;
	}

	/**
	 * 
	 */
	public District() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the id_tinhthanhpho
	 */
	public long getId_tinhthanhpho() {
		return id_tinhthanhpho;
	}

	/**
	 * @param id_tinhthanhpho
	 *            the id_tinhthanhpho to set
	 */
	public void setId_tinhthanhpho(long id_tinhthanhpho) {
		this.id_tinhthanhpho = id_tinhthanhpho;
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
	 * @return the tenkhongdau
	 */
	public String getTenkhongdau() {
		return tenkhongdau;
	}

	/**
	 * @param tenkhongdau
	 *            the tenkhongdau to set
	 */
	public void setTenkhongdau(String tenkhongdau) {
		this.tenkhongdau = tenkhongdau;
	}

	/**
	 * @return the tendaydu
	 */
	public String getTendaydu() {
		return tendaydu;
	}

	/**
	 * @param tendaydu
	 *            the tendaydu to set
	 */
	public void setTendaydu(String tendaydu) {
		this.tendaydu = tendaydu;
	}

	/**
	 * @return the donvi
	 */
	public String getDonvi() {
		return donvi;
	}

	/**
	 * @param donvi
	 *            the donvi to set
	 */
	public void setDonvi(String donvi) {
		this.donvi = donvi;
	}

	/**
	 * @return the tenthuong
	 */
	public String getTenthuong() {
		return tenthuong;
	}

	/**
	 * @param tenthuong
	 *            the tenthuong to set
	 */
	public void setTenthuong(String tenthuong) {
		this.tenthuong = tenthuong;
	}

	/**
	 * @return the tenhanhchinh
	 */
	public String getTenhanhchinh() {
		return tenhanhchinh;
	}

	/**
	 * @param tenhanhchinh
	 *            the tenhanhchinh to set
	 */
	public void setTenhanhchinh(String tenhanhchinh) {
		this.tenhanhchinh = tenhanhchinh;
	}

}
