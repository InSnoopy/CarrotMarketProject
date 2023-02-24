<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="UTF-8">
  <head>
    <title>중고거래 글쓰기</title>
  </head>

  <script>

    $(document).on('click', '#btnSave', function(e){
      e.preventDefault();
      $("#form").submit();
      location.href="${pageContext.request.contextPath}/board/getBoardList";
    });
  
    $(document).on('click', '#btnCancel', function(e){
      e.preventDefault();
    });
  
  </script>
  
  <style>
  body {
    padding-top: 70px;
    padding-bottom: 30px;
  }

  .content {
    padding-top: 50px;
  }

  .mb-3 {
    padding: 10px 0;
  }

  </style>
  </head>
  
  <body>
    <article>
      <div class="container" role="main">
        <h2>중고거래 글쓰기</h2>
        <form name="form" id="form" role="form" method="post" action="${pageContext.request.contextPath}/board/saveBoard">
          

          <div class="content">
          <!-- 사진 첨부 -->
          <div class="mb-3">
            <label for="exampleFormControlFile1">상품 사진</label>
            <input type="file" class="form-control-file" id="exampleFormControlFile1" accept="image/jpg, image/jpeg, image/png" multiple>
            <!-- <label for="picture">사진</label>
            <input type="file" name="picture" id="" accept="image/jpg, image/jpeg, image,png" multiple> -->
          </div>

          <!-- 글 제목 -->
          <div class="mb-3">
            <label for="title">글 제목</label>
            <input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력해 주세요">
          </div>
  
          <!-- 카테고리 선택 -->
          <div class="mb-3">
            <label for="reg_id">중고거래 카테고리</label>

            <select class="form-control">
              <option>카테고리 선택</option>
              <!-- 반복문 돌려서 카테고리 이름 가져오기 -->
              <option>1</option>
            </select>
          </div>

          <!-- 가격 -->
          <div class="mb-3">
            <label for="title">가격</label>
            <input type="text" class="form-control" name="title" id="title" placeholder="&#8361 가격을 입력해 주세요">
          </div>

  
          <div class="mb-3">
            <label for="content">내용</label>
            <textarea class="form-control" rows="5" name="content" id="content" 
            placeholder="게시글 내용을 작성해 주세요. (판매 금지 물품은 게시가 제한될 수 있어요.)" ></textarea>
          </div>
          
          <div class="mb-3">
            <label for="tag">거래 희망 장소</label>
            <input type="text" class="form-control" name="tag" id="tag" placeholder="장소를 입력해 주세요">
          </div>
        
        </div>
        </form>
  
        <div>
          <button type="button" class="btn btn-sm btn-primary" id="btnSave">완료</button>
          <button type="button" class="btn btn-sm btn-outline-primary" id="btnCancel">취소</button>
        </div>
      </div>
    </article>
  </body>
</html>
    