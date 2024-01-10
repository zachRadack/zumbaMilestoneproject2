<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="MileStone2WebProject.src.main.java.Batch" %> 

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Batches</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<link href="Style.css" rel="stylesheet"/>
<body onload="submitForm()">
    <a href="index.html" class="btn btn-primary mb-2">Home</a><br/>
    <% 
    System.err.println("seeAllBatches.jsp: batchList = " + request.getAttribute("batchList"));
    List<Batch> batchList = (List<Batch>) request.getAttribute("batchList");
    if (batchList != null && !batchList.isEmpty()) {
        out.println("<table border='1'><tr><th>Batch ID</th><th>Batch Type</th><th>Batch Time</th></tr>");
        for (Batch batch : batchList) {
            out.println("<tr><td>" + batch.getBatchID() + "</td><td>" + batch.getBatchType() + "</td><td>" + batch.getBatchTime() + "</td></tr>");
        }
        out.println("</table>");
    } else {
        out.println("<p>No batches found.</p>");
    }
    %>
</body>
</html>
