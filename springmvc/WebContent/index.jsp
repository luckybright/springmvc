<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="./css/login.css" />
</head>
<body>
<div class="loginDiv">
<form action="login.cmd" method="post">
<div>
<label>用户名：</label><input type="text" id="username" name="username" value="">
</div>
<div>
<label>密码：</label><input type="password" id="password" name="pass" value="">
</div>
<input class="submit" type="submit" value="提交">
</form>
</div>
</body>
</html>