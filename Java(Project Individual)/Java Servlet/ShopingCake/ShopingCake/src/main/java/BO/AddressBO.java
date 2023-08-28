/**
*Project name: ShopBanHang
*Version : 1.0
*Created date : 14 thg 3, 2019
*Description: Create by MyPC
*Copyright (c) 2019 by TeddyShoes. All rights reserved.
*/
package BO;

import java.util.ArrayList;

import dao.AddressDAO;
import model.District;
import model.Citys;
import model.Ward;

/**
 * @author MyPC
 *
 */
public class AddressBO {
	//
	AddressDAO s = new AddressDAO();

	// Lấy toàn bộ tỉnh thành phố
	public ArrayList<Citys> getTinhThanhPho(){
		return s.getTinhThanhPho();
	}
	// Lấy toàn bộ quận/ huyện theo id tỉnh
	public ArrayList<District> getQuanHuyenById(long idTinhTP) {
		return s.getQuanHuyenById(idTinhTP);
	}

	// Lấy toàn bộ xã phường theo id huyện
	public ArrayList<Ward> getXaPhuongById(long idQuanHuyen){
		return s.getXaPhuongById(idQuanHuyen);
	}

}
