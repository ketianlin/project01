<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%@include file="/pages/common/head.jsp"%>

<script type="text/javascript">
	$(function(){
		$("#sub_btn").click(function(){

// 			验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
			//1 先获取用户名输入框中的内容
			var usernameText = $("#username").val();
			//2 创建正则表达式对象
			var usernamePatt = /^\w{5,12}$/;
			//3 调用test方法验证结果
			if ( !usernamePatt.test(usernameText) ) {
				//4 如果不合法，要提示用户，并阻止提交。
				$("span.errorMsg").text("用户名不合法!");
				return false;
			}
			

// 			验证密码：必须由字母，数字下划线组成，并且长度为5到12位
			//1 先获取密码输入框中的内容
			var passwordText = $("#password").val();
			//2 创建正则表达式对象
			var passwodPatt = /^\w{5,12}$/;
			//3 调用test方法验证结果
			if ( !passwodPatt.test(passwordText) ) {
				//4 如果不合法，要提示用户，并阻止提交。
				$("span.errorMsg").text("密码不合法!");
				return false;
			}


// 			验证确认密码：和密码相同
			// 1 获取确认密码内容
			var repwdText = $("#repwd").val();
			// 2 比较确认密码和密码是否一致
			if ( repwdText != passwordText ) {
				// 3 不一致就要提示用户，并阻止提交
				$("span.errorMsg").text("确认密码和密码不一致!");
				return false;
			}


// 			邮箱验证：xxxxx@xxx.com
			// 1 先获取邮箱内容
			var emailText = $("#email").val();
			// 2 创建邮箱正则表达式
			var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
			// 3 使用test方法验证结果
			if ( !emailPatt.test(emailText) ) {
				// 4 不合法时提示用户，阻止提交
				$("span.errorMsg").text("邮箱格式不合法!");
				return false;
			}

// 			验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
			var codeText = $("#code").val();

			// alert("去空格前：[" + codeText + "]");
			codeText = $.trim( codeText );
			// alert("去空格后：[" + codeText + "]");

			if ( codeText == "" ) {
				$("span.errorMsg").text("验证码不能为空!");
				return false;
			}
			
			$("span.errorMsg").text("");
			// return false 可以阻止元素的默认行为。
			return true;
		});
		$("#username").on('blur', function () {
			var username = this.value
			$.getJSON("${path}user", "action=ajaxExistsUsername&username="+username, function (data) {
				if (data.existsUsername){
					$("span.errorMsg").text("用户名已存在!");
				}else{
					$("span.errorMsg").text("用户名可用!");
				}
			})
		})
	});
</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}

</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">${msg}</span>
							</div>
							<div class="form">
								<form action="user" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input value="${username}" class="itxt" type="text" placeholder="请输入用户名"
										autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" 
										autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" 
										autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input value="${email}" class="itxt" type="text" placeholder="请输入邮箱地址"
										autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input value="${code}" class="itxt" type="text" style="width: 100px;" name="code" id="code"/>
									<img alt="验证码" title="看不清，点一下" id="btn_img" src="kaptcha.jpg" style="float: right;margin-right: 40px;width: 135px;height: 40px;">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/footer.jsp"%>
</body>
<script>
	$(function () {
		$('#btn_img').on('click', function () {
			this.src = '${path}kaptcha.jpg?t='+new Date()
		})
	})
</script>
</html>