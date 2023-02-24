<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../css/login/login.css">
  <title>Document</title>
</head>
<body>
    <div id="container" class="container">
      <!-- FORM SECTION -->
      <div class="row">
        <!-- SIGN UP -->
        <div class="col align-items-center flex-col sign-up" method="post">
          <div class="form-wrapper align-items-center">
            <div class="form sign-up">
              <div class="input-group">
                <i class='bx bxs-user'></i>
                <input type="text" id="memId" placeholder="I D" value="">
              </div>
              <div class="input-group">
                <i class='bx bxs-lock-alt'></i>
                <input type="password" id="memPw"placeholder="Password" value="">
              </div>
              <div class="input-group">
                <i class='bx bx-mail-send'></i>
                <input type="text" id="memNic" placeholder="Nic" value="">
              </div>
              <div class="input-group">
                <i class='bx bx-mail-send'></i>
                <input type="text" id="memName" placeholder="Name" value="">
              </div>
              <div class="input-group">
                <i class='bx bx-mail-send'></i>
                <input type="text" id="memTel" placeholder="Tel" value="">
              </div>
              
              <div class="input-group">
              	<!-- map -->
              <jsp:include page="./map.jsp" />
<!--                 <i class='bx bx-mail-send'></i> -->
<!--                 <input type="text" id="memAddr1" placeholder="Addr"> -->
              </div>
              <div class="input-group">
                <i class='bx bx-mail-send'></i>
                <input type="text" id="memMail" placeholder="Email">
              </div>

              

              <button onclick="toggle()" id="signUpBtn">
                Sign up
              </button>
              <p>
                <span>
                  Already have an account?
                </span>
                <b onclick="toggle()" class="pointer">
                  Sign in here
                </b>
              </p>
            </div>
          </div>
        
        </div>
        <!-- END SIGN UP -->
        <!-- SIGN IN -->
        <div class="col align-items-center flex-col sign-in">
          <div class="form-wrapper align-items-center">
            <div class="form sign-in">
            
            
            
            	<!-- 로그인로그인로그인 -->
				<form action="/DaangnProject/Login.do" method="post">
	              <div class="input-group">
	                <i class='bx bxs-user'></i>
	                <input type="text" name="memId" placeholder="Username" id="loginMemId" value="" >
	              </div>
	              <div class="input-group">
	                <i class='bx bxs-lock-alt'></i>
	                <input type="password" name="memPw" placeholder="Password" id="loginMemPw" value="" >
	              </div>
	              <button id="signInBtn" type="submit"> 
	                Sign in
	              </button>
				</form>
              <p>
                <b>
                  Forgot password?
                </b>
              </p>
              <p>
                <span>
                  Don't have an account?
                </span>
                <b onclick="toggle()" class="pointer">
                  Sign up here
                </b>
              </p>
            </div>
          </div>
          <div class="form-wrapper">
      
          </div>
        </>
        <!-- END SIGN IN -->
      </div>
      <!-- END FORM SECTION -->
      <!-- CONTENT SECTION -->
      <div class="row content-row">
        <!-- SIGN IN CONTENT -->
        <div class="col align-items-center flex-col">
          <div class="text sign-in">
            <h2>
              Welcome
            </h2>
    
          </div>
          <div class="img sign-in">
      
          </div>
        </div>
        <!-- END SIGN IN CONTENT -->
        <!-- SIGN UP CONTENT -->
        <div class="col align-items-center flex-col">
          <div class="img sign-up">
          
          </div>
          <div class="text sign-up">
            <h2>
              Join with us
            </h2>
    
          </div>
        </div>
        <!-- END SIGN UP CONTENT -->
      </div>
      <!-- END CONTENT SECTION -->
      
    <script>
    
	let container = document.getElementById('container')

	function toggle(){
	  container.classList.toggle('sign-in')
	  container.classList.toggle('sign-up')		
	}
	
	setTimeout(function(){
		container.classList.add('sign-in')
	},200);
    
    
    
		var v_signUpBtn = document.querySelector('#signUpBtn');
    
    	v_signUpBtn.addEventListener('click',function(){
    	
    	var v_uId = document.querySelector('#memId').value;
    	var v_uPw = document.querySelector('#memPw').value;
    	var v_uNic = document.querySelector('#memNic').value;
    	var v_uName = document.querySelector('#memName').value;
    	var v_uTel = document.querySelector('#memTel').value;
    	var v_uAddr1 = document.querySelector('#memAddr1').value;
    	var v_uMail = document.querySelector('#memMail').value;
     	// JSP에서 백틱을 사용해서 변수처리기호 사용시 적용안됌! 주석에서도 쓰면 안된다.
    	var data = "userId=" + v_uId + "&userPw=" + v_uPw + "&userNic=" + v_uNic + "&userName=" + v_uName + "&userTel=" + v_uTel + "&userAddr1=" + v_uAddr1 + "&userMail=" + v_uMail;
    	

    	console.log(data);
		
    	var req = new XMLHttpRequest();
    	req.open('post','./signUp.jsp',true);
    	req.onreadystatechange = function(){
    		if(req.readyState == 4 && req.status == 200){
    			var jsObj = JSON.parse(req.responseText);
    			if(jsObj.rst == "ok"){
    				// 성공시 페이지 이동
    				console.log('hi');
    				location.replace();
    			}else{
    				console.log('bye');
    				// 실패시 현재페이지 머무르기..
    				location.reload();
    			}
    		}
    	}
    	req.setRequestHeader('content-type','application/x-www-form-urlencoded');
    	req.send(data);
    	
    	});
    
  
    	

     	
	var v_signIn = document.querySelector('#signInBtn2');
    
    	v_signIn.addEventListener('click',function(){
    	
    	var v_uId = document.querySelector('#loginMemId').value;
    	var v_uPw = document.querySelector('#loginMemPw').value;
     	// JSP에서 백틱을 사용해서 변수처리기호 사용시 적용안됌! 주석에서도 쓰면 안된다.
    	var data = "userId=" + v_uId + "&userPw=" + v_uPw;
		
    	var req = new XMLHttpRequest();
    	req.open('post','./signIn.jsp',true);
    	req.onreadystatechange = function(){
    		if(req.readyState == 4 && req.status == 200){
    			var jsObj = JSON.parse(req.responseText);
    			if(jsObj.rst == "ok"){
    				// 성공시 페이지 이동
    				console.log('hi');
    				x(v_uId, v_uPw);
    			}else{
    				console.log('bye');
    				// 실패시 현재페이지 머무르기..
    				location.replace("");
    			}
    		}
    	}
    	req.setRequestHeader('content-type','application/x-www-form-urlencoded');
    	req.send(data);
    	
    });
    
    function x(arg1, arg2){
    	var req = new XMLHttpRequest();
    	req.open('post','/DaangnProject/Main.do',true);
    	req.setRequestHeader('content-type','application/x-www-form-urlencoded');
    	req.send('memId='+arg1+'&memPw='+arg2);
    }
    
    </script>
    </div>

</body>
</html>
