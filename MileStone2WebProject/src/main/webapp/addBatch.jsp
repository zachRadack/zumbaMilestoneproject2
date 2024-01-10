<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a New batch</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<link href="Style.css" rel="stylesheet"/>
<body>
<h2>Add Batch</h2>
<a href="index.html" class="btn btn-primary mb-2">Home</a><br/>
<form action="BatchServlet" method="post">
<input type="hidden" name="operation" value="add"><br/>
<label>Batch Id</label>
<input type="number" name="batchid"/><br/>
 <label>batch Type</label>
 <input type="radio" name="typeofbatch" value="morning">Morning
<input type="radio" name="typeofbatch" value="afternoon">Afternoon<br/>
 <label>Time</label>
 <select name="time">
 	<option value="7am">7am</option>
 	<option value="8am">8am</option>
 	<option value="9am">9am</option>
 	<option value="10am">10am</option>
 	<option value="11am">11am</option>
 	<option value="12pm">12pm</option>
 </select><br/>
 <input type="submit" value="Create Batch"/>
<input type="reset" value="reset"/>
 
</form>
</body>
</html>