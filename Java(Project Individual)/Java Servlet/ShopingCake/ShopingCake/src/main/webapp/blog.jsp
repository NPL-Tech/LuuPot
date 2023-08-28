<%@ page pageEncoding="utf-8"%>


<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Blogs</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">
<jsp:include page="layout/head.jsp"></jsp:include>


</head>

<body>
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
						<h2>Blog</h2>
						<div class="breadcrumb__option">
							<a href="./index.html">Home</a> <span>Blog</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Blog Section Begin -->
	<section class="blog spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-5">
					<div class="blog__sidebar">
						<div class="blog__sidebar__search">
							<form action="#">
								<input type="text" placeholder="Search...">
								<button type="submit">
									<span class="icon_search"></span>
								</button>
							</form>
						</div>
						<div class="blog__sidebar__item">
							<h4>Categories</h4>
							<ul>
								<li><a href="#">Tất Cả</a></li>
								<li><a href="#">Sắc Đẹp(20)</a></li>
								<li><a href="#">Thức ăn(5)</a></li>
								<li><a href="#">Phong Cách Sống(9)</a></li>
								<li><a href="#">Du lịch(10)</a></li>
							</ul>
						</div>
						<div class="blog__sidebar__item">
							<h4>Tin Tức Gần Đây</h4>
							<div class="blog__sidebar__recent">
								<a href="#" class="blog__sidebar__recent__item">
									<div class="blog__sidebar__recent__item__pic">
										<img src="viewroot/img/blog/sidebar/sr-1.jpg" alt="">
									</div>
									<div class="blog__sidebar__recent__item__text">
										<h6>
											9 Loại Rau<br /> Bảo vệ Gan
										</h6>
										<span>20-21-2021</span>
									</div>
								</a> <a href="#" class="blog__sidebar__recent__item">
									<div class="blog__sidebar__recent__item__pic">
										<img src="viewroot/img/blog/sidebar/sr-2.jpg" alt="">
									</div>
									<div class="blog__sidebar__recent__item__text">
										<h6>
											Lời khuyên cho bạn để cân bằng<br /> dinh dưỡng trong bữa ăn ngày
										</h6>
										<span>20-21-2021</span>
									</div>
								</a> <a href="#" class="blog__sidebar__recent__item">
									<div class="blog__sidebar__recent__item__pic">
										<img src="viewroot/img/blog/sidebar/sr-3.jpg" alt="">
									</div>
									<div class="blog__sidebar__recent__item__text">
										<h6>
											4 nguyên tắc giúp bạn <br />Giảm Cân Với Rau Củ
										</h6>
										<span>20-21-2021</span>
									</div>
								</a>
							</div>
						</div>
						<div class="blog__sidebar__item">
							<h4>Search By</h4>
							<div class="blog__sidebar__item__tags">
								<a href="#">Tảo</a> <a href="#">Sắc Đẹp</a> <a href="#">rau</a>
								<a href="#">Rau</a> <a href="">Thức ăn </a> <a href="#">lành Mạnh</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-8 col-md-7">
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="blog__item">
								<div class="blog__item__pic">
									<img src="viewroot/img/blog/blog-2.jpg" alt="">
								</div>
								<div class="blog__item__text">
									<ul>
										<li><i class="fa fa-calendar-o"></i> 4 tháng 5 năm 2019</li>
										<li><i class="fa fa-comment-o"></i> 5</li>
									</ul>
									<h5>
										<a href="#">6 cách chuẩn bị bữa sáng cho 30</a>
									</h5>
									<p>Chế độ ăn uống lành mạnh là một loại chế độ ăn cung cấp
										lượng calo phù hợp với đầy đủ các chất dinh dưỡng thiết yếu,
										đảm bảo mục tiêu duy trì, phát triển của cơ thể và cải thiện
										sức khỏe tổng thể.</p>
									<a href="#" class="blog__btn">Đọc Thêm <span
										class="arrow_right"></span></a>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="blog__item">
								<div class="blog__item__pic">
									<img src="viewroot/img/blog/blog-3.jpg" alt="">
								</div>
								<div class="blog__item__text">
									<ul>
										<li><i class="fa fa-calendar-o"></i> 4 tháng 5 năm 2019</li>
										<li><i class="fa fa-comment-o"></i> 5</li>
									</ul>
									<h5>
										<a href="#">Tham quan trang trại sạch ở Mỹ</a>
									</h5>
									<p>Chế độ ăn uống lành mạnh là một loại chế độ ăn cung cấp
										lượng calo phù hợp với đầy đủ các chất dinh dưỡng thiết yếu,
										đảm bảo mục tiêu duy trì, phát triển của cơ thể và cải thiện
										sức khỏe tổng thể.</p>
									<a href="#" class="blog__btn">Đọc Thêm <span
										class="arrow_right"></span></a>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="blog__item">
								<div class="blog__item__pic">
									<img src="viewroot/img/blog/blog-1.jpg" alt="">
								</div>
								<div class="blog__item__text">
									<ul>
										<li><i class="fa fa-calendar-o"></i> 4 tháng 5 năm 2021</li>
										<li><i class="fa fa-comment-o"></i> 5</li>
									</ul>
									<h5>
										<a href="#">Mẹo nấu ăn giúp việc nấu ăn trở nên đơn giản</a>
									</h5>
									<p>Chế độ ăn uống lành mạnh là một loại chế độ ăn cung cấp
										lượng calo phù hợp với đầy đủ các chất dinh dưỡng thiết yếu,
										đảm bảo mục tiêu duy trì, phát triển của cơ thể và cải thiện
										sức khỏe tổng thể. quaerat</p>
									<a href="#" class="blog__btn">Đọc Thêm <span
										class="arrow_right"></span></a>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="blog__item">
								<div class="blog__item__pic">
									<img src="viewroot/img/blog/blog-4.jpg" alt="">
								</div>
								<div class="blog__item__text">
									<ul>
										<li><i class="fa fa-calendar-o"></i> 4 tháng 5 năm 2021</li>
										<li><i class="fa fa-comment-o"></i> 5</li>
									</ul>
									<h5>
										<a href="#">Mẹo nấu ăn giúp việc nấu ăn trở nên đơn giản</a>
									</h5>
									<p>Chế độ ăn uống lành mạnh là một loại chế độ ăn cung cấp
										lượng calo phù hợp với đầy đủ các chất dinh dưỡng thiết yếu,
										đảm bảo mục tiêu duy trì, phát triển của cơ thể và cải thiện
										sức khỏe tổng thể.</p>
									<a href="#" class="blog__btn">Đọc Thêm <span
										class="arrow_right"></span></a>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="blog__item">
								<div class="blog__item__pic">
									<img src="viewroot/img/blog/blog-4.jpg" alt="">
								</div>
								<div class="blog__item__text">
									<ul>
										<li><i class="fa fa-calendar-o"></i> 4 tháng 5 năm 2021</li>
										<li><i class="fa fa-comment-o"></i> 5</li>
									</ul>
									<h5>
										<a href="#">TKhoảnh khắc bạn cần loại bỏ tỏi khỏi thực đơn</a>
									</h5>
									<p>Chế độ ăn uống lành mạnh là một loại chế độ ăn cung cấp
										lượng calo phù hợp với đầy đủ các chất dinh dưỡng thiết yếu,
										đảm bảo mục tiêu duy trì, phát triển của cơ thể và cải thiện
										sức khỏe tổng thể.</p>
									<a href="#" class="blog__btn">Đọc Thêm <span
										class="arrow_right"></span></a>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="blog__item">
								<div class="blog__item__pic">
									<img src="viewroot/img/blog/blog-6.jpg" alt="">
								</div>
								<div class="blog__item__text">
									<ul>
										<li><i class="fa fa-calendar-o"></i> 4 tháng 5 năm 2021</li>
										<li><i class="fa fa-comment-o"></i> 5</li>
									</ul>
									<h5>
										<a href="#">Khoảnh khắc bạn cần loại bỏ tỏi khỏi thực đơn</a>
									</h5>
									<p>Chế độ ăn uống lành mạnh là một loại chế độ ăn cung cấp
										lượng calo phù hợp với đầy đủ các chất dinh dưỡng thiết yếu,
										đảm bảo mục tiêu duy trì, phát triển của cơ thể và cải thiện
										sức khỏe tổng thể.</p>
									<a href="#" class="blog__btn">Đọc Thêm <span
										class="arrow_right"></span></a>
								</div>
							</div>
						</div>
						<div class="col-lg-12">
							<div class="product__pagination blog__pagination">
								<a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a
									href="#"><i class="fa fa-long-arrow-right"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Blog Section End -->


	<!-- Thêm chân trang -->
	<jsp:include page="layout/footer.jsp"></jsp:include>
	<!-- Xong thêm chân trang -->


</body>
</html>