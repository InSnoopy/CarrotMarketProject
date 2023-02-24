<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<nav class="navbar fixed-top">
   <div class="container-fluid"></div>
</nav>



<!-- Start Header Area -->
<div class="header navbar-area sticky">
   <!-- Start Header Middle -->
   <div class="header-middle">
      <div class="container">
         <div class="row align-items-center">
            <div class="col-lg-3 col-md-3 col-7">
               <!-- Start Header Logo -->
               <a class="navbar-brand" href="/DaangnProject/manager/Main.do">
                  <img src="<%=request.getContextPath() %>/assets/carrot_logo.png" alt="Logo"> 
               </a>
               <!-- End Header Logo -->
            </div>
            <div class="col-lg-5 col-md-7 d-xs-none">
               <!-- Start Main Menu Search -->
               <div class="main-menu-search">
                  <!-- navbar search start -->
                  <div class="navbar-search search-style-5">
                     <div class="search-input">
                        <input type="text" placeholder="근처에서 검색">
                     </div>
                     <div class="search-btn">
                        <button type="submit">
                           <i class="bi bi-search"></i>
                        </button>
                     </div>
                  </div>
                  <!-- navbar search Ends -->
               </div>
               <!-- End Main Menu Search -->
            </div>
            <div class="col-lg-4 col-md-2 col-5">
               <div class="middle-right-area">
                  <div class="nav-hotline"></div>
                  <div class="navbar-cart">
<!--                      <div class="wishlist"> -->
<!--                         <a href="/DaangnProject/MyBoard.do"> <i -->
<!--                            class="fa-regular fa-pen-to-square"></i> -->
<!--                         </a> -->
<!--                      </div> -->
                     <div class="wishlist">
                        <a href="javascript:void(0)"> <!-- <i class="lni lni-heart"></i> -->
                           <i class="fa-regular fa-bell"></i> <span class="total-items">0</span>
                        </a>
                     </div>
                     <div class="cart-items">
<!--                         <a href="/DaangnProject/mypage.do" class="main-btn"> <i class="lni lni-cart"></i> -->
<%--                         <a href="<%=request.getContextPath() %>/manager/adminpage.do" class="main-btn"> <!-- <i class="lni lni-cart"></i> --> --%>
                        <a href="<%=request.getContextPath() %>/notice/list.do" class="main-btn"> <!-- <i class="lni lni-cart"></i> -->
                           <i class="fa-regular fa-user"></i> 
<!--                            <span class="total-items">2</span> -->
                        </a>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
   <!-- End Header Middle -->
 <!-- Start Header Bottom -->
   <div class="container">
      <div class="row align-items-center">
         <div class="col-lg-8 col-md-6 col-12">
            <div class="nav-inner">
               <!-- Start Mega Category Menu -->
               <div class="mega-category-menu">
                  <span class="cat-button">
<!--                   <i class="bi bi-collection-fill"></i> -->
                  <i class="bi bi-collection"></i>
<!--                   <i class="bi bi-archive"></i> -->
<!--                   <i class="lni lni-menu"></i> -->
					중고거래 카테고리</span>
                  <ul class="sub-category">
                     <li><a href="/DaangnProject/myDeal.do">인기매물</a>
<!--                         <ul class="inner-sub-category"> -->
<!--                            <li><a href="/DaangnProject/myDeal.do">인기매물</a></li> -->
<!--                            <li><a href="product-grids.html">디지털기기</a></li> -->
<!--                            <li><a href="product-grids.html">Camera Drones</a></li> -->
<!--                            <li><a href="product-grids.html">Smart Watches</a></li> -->
<!--                            <li><a href="product-grids.html">Headphones</a></li> -->
<!--                            <li><a href="product-grids.html">MP3 Players</a></li> -->
<!--                            <li><a href="product-grids.html">Microphones</a></li> -->
<!--                            <li><a href="product-grids.html">Chargers</a></li> -->
<!--                            <li><a href="product-grids.html">Batteries</a></li> -->
<!--                            <li><a href="product-grids.html">Cables & Adapters</a></li> -->
<!--                         </ul></li> -->
                     <li><a href="/DaangnProject/boardCategory.do?category=C001">디지털기기</a></li>
                     <li><a href="/DaangnProject/boardCategory.do?category=C002">생활가전</a></li>
                     <li><a href="/DaangnProject/boardCategory.do?category=C003">가구/인테리어</a></li>
                     <li><a href="/DaangnProject/boardCategory.do?category=C004">생활/주방</a></li>
                     <li><a href="/DaangnProject/boardCategory.do?category=C005">유아용품</a></li>
                     <li><a href="/DaangnProject/boardCategory.do?category=C006">의류</a></li>
                     <li><a href="/DaangnProject/boardCategory.do?category=C007">패션/잡화</a></li>
                     <li><a href="/DaangnProject/boardCategory.do?category=C008">뷰티/미용</a></li>
                     <li><a href="/DaangnProject/boardCategory.do?category=C009">취미/게임/음반</a></li>
                     <li><a href="/DaangnProject/boardCategory.do?category=C010">도서</a></li>
                     <li><a href="/DaangnProject/boardCategory.do?category=C011">반려동물용품</a></li>
                     <li><a href="/DaangnProject/boardCategory.do?category=C012">기타 중고물품</a></li>
                  </ul>
               </div>
               <!-- End Mega Category Menu -->
            </div>
         </div>
         <div class="col-lg-4 col-md-6 col-12"></div>
      </div>
   </div>
   <!-- End Header Bottom -->
</div>
<!-- End Header Area -->