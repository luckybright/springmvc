<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="site-utils" uri="/WEB-INF/tlds/site-utils.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>"${aJspValue}"</h1>
	<h2>
		<site-utils:lastModified />
	</h2>
	<site-utils:textInput />
	<div class="tableForm">
		<form action="demo/commonQuery.cmd" method="post">
			<input type="hidden" name="formType" value="commonForm">
			<input type="hidden" name="className" value="ming.bean.DemoQueryBean">
			<lable>用户ID</lable><input type="text" name="userId"><label>日期</label><input type="text" name="date"><br>
			<label>用户名</label><input type="text" name="userName">
			<input type="hidden" name="comment" value="支持的数据类型应该有字符串，数字，可格式化的小数，金额。输入形式有文本框，下拉选择框，日期，（复选框和单选框稍后加）">
			<input type="submit" value="提交">
		</form>
	</div>
</body>
</html>