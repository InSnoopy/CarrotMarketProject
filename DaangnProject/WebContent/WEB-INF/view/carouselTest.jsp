<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">    
<style>
.carousel-inner > .item > img {
	display: block;
	max-width: 100%;
	height: auto;
}
</style>
<body>

	<section class="bg-light">
            <div class="container px-4 ">
<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active" data-bs-interval="3000">
      <img src="/DaangnProject/imgs/bbb1.png" class="d-block w-100" height="430px" alt="이미지1">
    </div>
    <div class="carousel-item" data-bs-interval="3000">
      <img src="/DaangnProject/imgs/bbb3.jpg" class="d-block w-100" height="430px" alt="이미지2">
    </div>
    <div class="carousel-item" data-bs-interval="3000">
      <img src="/DaangnProject/imgs/sakel.jpg" class="d-block w-100" height="430px" alt="이미지3">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
</div>
</section>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>    
</body>
</html>