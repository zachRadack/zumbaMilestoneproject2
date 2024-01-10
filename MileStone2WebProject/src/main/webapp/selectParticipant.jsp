<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="MileStone2WebProject.src.main.java.Participant" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select a Participant</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<link href="Style.css" rel="stylesheet"/>
<body>
    <a href="index.html" class="btn btn-primary mb-2">Home</a><br/>
    <h2>Select a Participant</h2>

    <form action="ParticipantServerlet" method="get">
        <input type="hidden" name="operation" value="getParticipant"><br/>
        <label>Participant Id</label>
        <input type="number" name="participantId"/><br/>
        <input type="submit" value="Get Participant"/>
    </form>

</body>
</html>