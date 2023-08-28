<%@page import="model.Category"%>
<%@page import="model.ProductsDetail"%>
<%@page import="model.Products"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title></title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<jsp:include page="layout/head.jsp"></jsp:include>

</head>

<body>
	<%
	Products product = (Products) request.getAttribute("product");
	ArrayList<ProductsDetail> listproduct = (ArrayList<ProductsDetail>) request.getAttribute("listDetails");
	%>
	<!-- Thêm phần tiêu đề trang -->
	<jsp:include page="layout/header.jsp"></jsp:include>
	<!-- Xong phần tiêu đề trang -->
	<!-- Hero Section Begin -->
	<jsp:include page="layout/hero-nomar.jsp"></jsp:include>

	<!-- Hero Section End -->

	<!-- Breadcrumb Section Begin -->
	<section class="breadcrumb-section set-bg"
		data-setbg="viewroot/img/breadcrumb.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>Sản Phẩm</h2>
						<div class="breadcrumb__option">
							<a href="Home">Home</a> <a href="#"><%=product.getTenSanPham()%></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Product Details Section Begin -->
	<section class="product-details spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="product__details__pic">
						<div class="product__details__pic__item">
							<img class="product__details__pic__item--large"
								src="viewroot/img/shop/product/<%=product.getAnhChinh()%>"
								alt="">
						</div>
						<div class="product__details__pic__slider owl-carousel">
							<%
							for (ProductsDetail pd : listproduct) {
							%>
							<img data-imgbigurl="img/product/details/product-details-2.jpg"
								src="viewroot/img/shop/DetailProduct/<%=pd.getAnhChiTiet()%>"
								alt="">
							<%
							}
							%>
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="product__details__text">
						<h3><%=product.getTenSanPham()%></h3>
						<div class="product__details__rating">
							<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star-half-o"></i> <span>(18 Đánh giá)</span>
						</div>
						<div class="product__details__price"><%=product.getGiaGoc()%>VND
						</div>
						<p>Nguyên liệu làm bánh ngọt không thể thiếu bột mì hoặc các
							loại bột khác, trứng, đường, sữa, các loại đậu,...cùng các nguyên
							liệu tạo hương vị thơm ngon như bơ, phô mai, matcha, vani,
							socola,...Đây đều là những thành phần dinh dưỡng rất tốt cho sức
							khỏe chứa nhiều protein, carbohydrate, vitamin và chất béo. Bánh
							ngọt thường được làm chín bằng phương pháp nướng hoặc hấp nên hạn
							chế được dầu mỡ</p>
						<div class="product__details__quantity">
							<div class="quantity">
								<div class="pro-qty">
									<input type="text" value="1">
								</div>
							</div>
						</div>
						<a href="#" onclick="addProductToCart(<%=product.getId()%>)"
							class="primary-btn">Thêm Sản Phẩm</a> <a href="#"
							class="heart-icon"><span class="icon_heart_alt"></span></a>
						<ul>
							<li><b>Trình Trạng</b> <%
 if (product.getTinhTrang() == 1) {
 %> <span>Còn Hàng </span> <%} else {%> <span>hết Hàng</span> <%
 }
 %></li>

							<li><b>Giao Hàng</b> <span>Trong vòng 24h <samp>Miễn
										phí Nội Thành </samp></span></li>
							<li><b>Giảm Giá</b> <span><%=product.getKhuyenMai()%></span></li>
							<li><b>Chịa sẻ</b>
								<div class="share">
									<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
										class="fa fa-twitter"></i></a> <a href="#"><i
										class="fa fa-instagram"></i></a> <a href="#"><i
										class="fa fa-pinterest"></i></a>
								</div></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="product__details__tab">
						<ul class="nav nav-tabs" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								data-toggle="tab" href="#tabs-1" role="tab" aria-selected="true">Mô
									Tả</a></li>
							<li class="nav-item"><a class="nav-link" data-toggle="tab"
								href="#tabs-2" role="tab" aria-selected="false">Phòng cách</a></li>
							<li class="nav-item"><a class="nav-link" data-toggle="tab"
								href="#tabs-3" role="tab" aria-selected="false">Phương pháp
									Bảo quản <span>(1)</span>
							</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="tabs-1" role="tabpanel">
								<div class="product__details__tab__desc">
									<h6>Mô Tả sản phẩm</h6>
									<p>
										<%=product.getMoTa()%>
									</p>
								</div>
							</div>
							<div class="tab-pane" id="tabs-2" role="tabpanel">
								<div class="product__details__tab__desc">
									<h6>Chưa cập nhâp</h6>

								</div>
							</div>
							<div class="tab-pane" id="tabs-3" role="tabpanel">
								<div class="product__details__tab__desc">
									<h6>Phương Pháp Bảo Quản</h6>
									<p>Sấy khô Sấy khô là phương pháp bảo quản được sử dụng từ
										thời xa xưa. Bạn có thể áp dụng sấy khô để lưu trữ nhiều thực
										phẩm từ cá, thịt cho đến rau củ hoặc trái cây. Nguyên lý hoạt
										động của sấy khô là làm giảm lượng nước có trong thực phẩm để
										ngăn chặn vi khuẩn làm hỏng thức ăn. Nhắc đến sấy khô, phải
										nhắc đến các loại trái cây sấy như mít, táo, nho, xoài, chuối
										rất được yêu thích. Bên cạnh đó, các loại ngũ cốc như yến
										mạch, hạt kê, lúa mì cũng có thể sử dụng phương pháp này.


										phương pháp sấy khô thực phẩm Trái cây sấy khô ngon miệng, hấp
										dẫn là món ăn yêu thích của rất nhiều người (Ảnh: Internet)

										Phương pháp sấy khô có nhiều ưu điểm như: Kéo dài thời gian
										bảo quản, tiết kiệm không gian lưu trữ, áp dụng với nhiều loại
										thực phẩm, không tốn nhiều công sức… Tuy nhiên, phương pháp
										này cũng có nhược điểm chính là làm mất đi các Vitamin quan
										trọng do tác dụng của nhiệt độ cao. Muối chua Muối chua là
										hình thức chuyển hóa đường thành acid lactic, có lợi cho hệ
										tiêu hóa và được sử dụng từ lâu đời. Phương pháp này rất dễ
										thực hiện và thường áp dụng cho các loại rau, củ như cà rốt,
										củ cải, dưa leo, cà pháo… Tuy nhiên, các thực phẩm muối chua
										không nên để quá lâu vì chúng sẽ chứa hàm lượng muối cao,
										khiến bạn dễ mắc các chứng bệnh thận, tim mạch, huyết áp. Hơn
										nữa, khi dùng thực phẩm quá chua sẽ ảnh hưởng đến dạ dày và
										sức khỏe. Đóng hộp phương pháp đóng hộp thực phẩm Bảo quản
										thực phẩm bằng cách sơ chế và đống hộp (Ảnh: Internet) Cách
										bảo quản đóng hộp thường dùng cho rau, củ quả. Trước khi cho
										vào chai, lọ, hộp để bảo quản các thức phẩm cần được tiệt
										trùng và sơ chế sạch sẽ. Tuy nhiên, phương pháp này không đạt
										hiệu quả cao và ít được sử dụng hơn các phương pháp còn lạo
										bởi các vi khuẩn vẫn có thể tấn công và làm hư hỏng thức ăn.
										Đồng thời, các hộp đựng thực phẩm sau khi mở ra sử dụng sẽ rất
										nhanh hư nếu không được chế biến kịp thời. Bên cạnh đó, phương
										pháp này đòi hỏi bạn phải tốn nhiều công sức trong khâu tiệt
										trùng và sơ chế vì nếu kém vệ sinh, không đạt chuẩn sẽ ảnh
										hưởng rất lớn tới sức khỏe như các bệnh về hệ tiêu hóa, đường
										ruột hay ngộ độc thực phẩm. Đông lạnh Phương pháp đông lạnh
										được sử dụng phổ biến hơn cả nhờ vào các thiết bị bảo quản như
										tủ lạnh, tủ đông… Đông lạnh sử dụng nhiệt độ thấp khiến cho vi
										khuẩn, vi sinh vật không thể phát triển hay hoạt động. Với
										phương pháp này bạn có thể bảo quản các loại thực phẩm có
										nguồn gốc động vật như cá, thịt, hải sản… trong thời gian dài
										và giữ được hương vị đặc trưng. Tuy nhiên, khi kết thúc quá
										trình bảo quản trong tủ lạnh bạn phải sử dụng ngay để thực
										phẩm đông không tiếp xúc lâu ở nhiệt độ thường và cần có
										phương pháp rã đông khoa học để không làm mất dưỡng chất của
										thực phẩm. phương pháp đông lạnh thực phẩm Phương pháp đông
										lạnh có thể bảo quản các loại thực phẩm là thịt, cá trong thời
										gian dài (Ảnh: Internet) Hun khói Hun khói được dùng để bảo
										quản các loại thịt, cá và các chế phẩm từ thịt. Hun khói sử
										dụng nhiệt độ để làm khô thức ăn, giúp thức ăn có hương vị
										thơm ngon hơn và lâu bị hỏng. Tuy nhiên, phương pháp này không
										nên sử dụng thường xuyên bởi nó có thể gây bệnh ung thư cho
										con người. Hút khí chân không Phương pháp hút chân không không
										thể sử dụng tại nhà như muối chua hay đông lạnh, đóng hộp mà
										nó cần sự hỗ trợ của máy móc. Để bảo quản, bạn cho thực phẩm
										vào chai, hộp hoặc túi nilon và tiến hành hút chân không, tạo
										môi trường yếm khí để vi sinh vật không thể phát triển</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Product Details Section End -->

	<!-- Related Product Section Begin -->
	<section class="related-product">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title related__product__title">
						<h2>Sản phẩm gần giống</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<%
				ArrayList<Products> list = (ArrayList<Products>) request.getAttribute("listp");
				for (int i=0;i<4;i++) {
				%>
				<div class="col-lg-3 col-md-4 col-sm-6">
					<div class="product__item">
						<div class="product__item__pic set-bg"
							data-setbg="viewroot/img/shop/product/<%=list.get(i).getAnhChinh()%>">
							<ul class="product__item__pic__hover">
								<li><a href="#"><i class="fa fa-heart"></i></a></li>
								<li><a href="#"><i class="fa fa-retweet"></i></a></li>
								<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<div class="product__item__text">
							<h6>
								<a href="#"><%=list.get(i).getTenSanPham()%></a>
							</h6>
							<h5><%=list.get(i).getGiaGoc()%></h5>
						</div>
					</div>
				</div>
				<%
				}
				%>
			</div>
		</div>
	</section>
	<!-- Related Product Section End -->

	<!-- Footer Section Begin -->
	<!-- Thêm chân trang -->
	<jsp:include page="layout/footer.jsp"></jsp:include>
	<!-- Xong thêm chân trang -->

</body>

</html>