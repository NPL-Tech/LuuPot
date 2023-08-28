package BO;

import java.util.ArrayList;

import dao.BillsDAO;
import model.Bills;

public class BillsBO {
	BillsDAO s = new BillsDAO();

	public ArrayList<Bills> getSelectDatHang_Ship() {
		return s.getListOrder();

	}

	// Danh sách hóa đơn đặt hàng
	public ArrayList<Bills> getSelectDatHang() {
		return s.getBills();

	}

	// Danh sách hóa đơn đang ship
	public ArrayList<Bills> getSelectDangShip() {
		return s.getTranspost();

	}


	// lấy ra 1 thồn tin bills
	public Bills getBillsById(long id) throws Exception {
		return s.getBillsById(id);
	}

	// Phương thức sửa trạng thái hóa đơn
	public boolean editStatusBills(int trangthai, long id) {
		return s.transport(trangthai, id);
	}

}
