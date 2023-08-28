<%@page import="java.util.Map"%>
<%@page import="model.Items"%>
<%@page import="dao.CartDAO"%>
<%@ page pageEncoding="utf-8"%>
<%@page import="java.util.Map.Entry"%>
<%@ page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
<jsp:include page="layout/head.jsp"></jsp:include>


<body>
    <!-- Page Preloder -->
<!-- Thêm phần tiêu đề trang -->
	<jsp:include page="layout/header.jsp"></jsp:include>
	<!-- Xong phần tiêu đề trang -->
    <!-- Hero Section Begin -->
    		<jsp:include page="layout/hero-nomar.jsp"></jsp:include>
    
    <!-- Hero Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="viewroot/img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Giỏ hàng</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <span>Giỏ Hàng</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shoping Cart Section Begin -->
    <section class="shoping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                  <th class="product-price">Hình ảnh</th>
										<th class="product-name">Tên sản phẩm</th>
										<th class="product-price">Giá</th>
										<th class="product-quantity">Số lượng</th>
										<th class="product-subtotal">Thành tiền</th>
										<th class="product-name">Xóa bỏ</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<%
										CartDAO cart = (CartDAO) session.getAttribute("cart");
										if (cart.countItems() > 0) {
											for (Map.Entry<Long, Items> list : cart.getCartItems().entrySet()) {
									%>
						<tr>
										<td class="shoping__cart__item"><a href="#"><img style="width: 40%;"
												src="viewroot/img/shop/product/<%=list.getValue().getProducts().getAnhChinh()%>"
												alt=""></a></td>
										<td class="shoping__cart__item"><a href="#"><%=list.getValue().getProducts().getTenSanPham()%></a></td>
										<%
											//xử lý giá bán
													DecimalFormat numformat = new DecimalFormat("#,###,###");
													double cost = list.getValue().getProducts().getGiaGoc();
													int discount = list.getValue().getProducts().getKhuyenMai();
													double total = cost - (cost * discount) / 100;
													double sum_price = total * (int) list.getValue().getQuantity();
													String price_nb = numformat.format(total);
													String sum_price_nb = numformat.format(sum_price);
										%>
										<td class="shoping__cart__price"><span class="amount"><%=price_nb%>
												đ</span></td>
										<td class="shoping__cart__quantity"><input
											value="<%=list.getValue().getQuantity()%>" type="number"
											min="1" maxlength="4" id="quantity<%=list.getKey()%>" onkeypress="return keyPhone(event);"></td>

										<td class="shoping__cart__total"><%=sum_price_nb%> đ</td>
										<td class="shoping__cart__item__close"><a onclick="calleditcart(<%=list.getKey() %>);"
											title="Sửa đổi chọn hàng"><i class="fa fa-pencil"></i></a><a
											href="HomeCartServlet?status=remove&id_product=<%=list.getKey()%>" title="xóa bỏ chọn hàng"><i class="fa fa-times"></i></a>
										</td>
									</tr>
									<%
										}
										} else {
									%>
									<tr>
										<div class="alert alert-info">
											<center>
												<strong>Giỏ hàng trống!</strong>
											</center>
										</div>
									</tr>
									<%
										}
									%>
									<!-- in ra thông báo đặt hàng thành công -->
									<%if(session.getAttribute("paid")!=null){
										%>
									<tr>
										<div class="alert alert-success">
											<center>
												<%out.print(session.getAttribute("paid")); %>
												<!-- <strong>Đặt hàng thành công, mời bạn click vào <a href="HomeProductsServlet"><span style="color:blue">đây</span></a> để tiếp tục mua sắm!</strong> -->
											</center>
										</div>
									</tr><%session.removeAttribute("paid"); %>
									<!-- /in ra thông báo đặt hàng thành công -->
									<%}//session.removeAttribute("paid");x%>                            
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__btns">
                        <a href="Home" class="primary-btn cart-btn">Tiếp Tục Mua sắm</a>
                        <a href="#" class="primary-btn cart-btn cart-btn-right"><span class="icon_loading"></span>
                            Upadate Cart</a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__continue">
                        <div class="shoping__discount">
                            <h5>Mã Giảm Giá</h5>
                            <form action="#">
                                <input type="text" placeholder="Enter your coupon code">
                                <button type="submit" class="site-btn">Ap Dụng</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__checkout">
                        <h5>Cart Total</h5>
                        <ul>
                            <li>Số Lượng <span><%=cart.countItems()%></span></li>
                            <li>Tổng tiền <span><%=cart.totalCart()%>
									đ</span></li>
                        </ul>
                        <%
								if (cart.countItems() > 0) {
							%>
                        <a href="checkout.jsp" class="primary-btn">Xử lý Thành thành toán</a>
                        <%} %>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shoping Cart Section End -->

	<!-- Thêm chân trang -->
	<jsp:include page="layout/footer.jsp"></jsp:include>
	<!-- Xong thêm chân trang -->
</body>

</html>