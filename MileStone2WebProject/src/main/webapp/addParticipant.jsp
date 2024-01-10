<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add Participant</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<link href="Style.css" rel="stylesheet"/>
<body>
    <a href="index.html" class="btn btn-primary mb-2">Home</a><br/>

<h2>Add Participant</h2>
<form action="ParticipantServerlet" method="post">
    <input type="hidden" name="operation" value="add"><br/>
    <label>Participant Id</label>
    <input type="number" name="participantId"/><br/>
    <label>Participant Name</label>
    <input type="text" name="participantName"/><br/>
    <label>Participant Age</label>
    <input type="number" name="participantAge"/><br/>
    <label>Phone Number</label>
    <input type="number" name="phoneNumber"/><br/>
    <label for="batchId">Choose a Batch:</label>
    <select name="batchId" id="batchId">
        <% 
        List<Integer> listOfBatches = (List<Integer>) request.getAttribute("batchList");
        System.out.println("LE TOOOOOOTs");
        System.out.println(listOfBatches);
        if (listOfBatches != null) {
        	System.out.println("we in bois");
            for (Integer batchid : listOfBatches) {
                out.println("<option value=" + batchid +">" + batchid + "</option>");
            }
        }else {
            out.println("<option value='' disabled>No batches available</option>");
        }    
        %>
    </select><br/>
    <input type="submit" value="Add Participants"/>
    <input type="reset" value="reset"/>

       
</form>
</body>