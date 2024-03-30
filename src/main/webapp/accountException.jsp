<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="css/filter_use.css">
	</head>
	<body>
		<div class="error">
			${ message }
		</div>
		
		<form action="">
			<table>
				<tr>
					<td>帳號</td>
					<td><input type="text" name="account"></td>
				</tr>
				<tr>
					<td>密碼</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value=" 登入 "></td>
				</tr>
			</table>
		</form>
		
	</body>
</html>