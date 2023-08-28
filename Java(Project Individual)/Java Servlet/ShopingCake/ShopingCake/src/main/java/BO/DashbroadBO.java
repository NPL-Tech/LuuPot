package BO;

import java.util.ArrayList;

import dao.DashboardDAO;
import model.Bills;
import model.Dasboard;

public class DashbroadBO {
	DashboardDAO s = new DashboardDAO();
	// hàm get hiển thị ra sản phẩm giao diện Trang chủ và Quản lý
			public ArrayList<Bills> getThongKe(String tungay, String denngay) {
				return s.getThongKe(tungay, denngay);
			}

}
