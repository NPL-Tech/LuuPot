package model;


public class Citys {
	private long id, code;
	private String ten, tenkhongdau, donvi, tendaydu;


	public Citys(long id, long code, String ten, String tenkhongdau, String donvi, String tendaydu) {
		super();
		this.id = id;
		this.code = code;
		this.ten = ten;
		this.tenkhongdau = tenkhongdau;
		this.donvi = donvi;
		this.tendaydu = tendaydu;
	}

	/**
	 * 
	 */
	public Citys() {
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

}
