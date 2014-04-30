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
		<form action="product/tableform.cmd" method="post">
			<input type="hidden" name="formType" value="tableForm">
			<input type="hidden" name="className" value="ming.bean.FormBean">
			<table>
				<thead>
					<tr>
						<td>值1</td>
						<td>值2</td>
						<td>值3</td>
						<td>值4</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input name="value1" value="值1"></td>
						<td><input name="value2" value="值2"></td>
						<td><input name="value3" value="值3"></td>
						<td><input name="value4" value="值4"></td>
					</tr>
					<tr>
						<td><input name="value1" value="A值1"></td>
						<td><input name="value2" value="A值2"></td>
						<td><input name="value3" value="A值3"></td>
						<td><input name="value4" value="A值4"></td>
					</tr>
					<tr>
						<td><input name="value1" value=""></td>
						<td><input name="value2" value=""></td>
						<td><input name="value3" value=""></td>
						<td><input name="value4" value="B值4"></td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="comment" value="支持的数据类型应该有字符串，数字，可格式化的小数，金额。输入形式有文本框，下拉选择框，日期，（复选框和单选框稍后加）">
			<input type="submit" value="提交">
		</form>
	</div>
</body>
</html>