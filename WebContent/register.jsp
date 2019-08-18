<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel ="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
	<h1 class="alert-info text-center">ToDo List</h1>
	<form action="loginregister" method="post">
		<div class='form-group'>
			<label>UserId</label>
			<input class='form-control' type='text' name='userid' placeholder='Enter the User ID'>
		</div>
		<div class='form-group'>
			<label>Password</label>
			<input class='form-control' type='password' name='pwd' placeholder='Enter the Password'>		
		</div>
		
		<div class='form-group'>
			<button type="submit" name="register" value="register" class='btn btn-primary'>Register</button>
		</div>
	</form>
</div>
</body>
</html>