<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="MileStone2WebProject.src.main.java.Participant" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<link href="Style.css" rel="stylesheet"/>
<body>
    <a href="selectParticipant.jsp" class="btn btn-primary mb-2">Select Participant</a><br/>

    <h2>Update Participant</h2>

    <form action="ParticipantServerlet" method="post">
        <input type="hidden" name="operation" value="update"><br/>
        <label>Participant Id</label>
        <input type="number" name="participantId" value="<%= request.getAttribute("participantId") %>"/><br/>
        <label>Participant Name</label>
        <input type="text" name="participantName" value="<%= request.getAttribute("participantName") %>"/><br/>
        <label>Participant Age</label>
        <input type="number" name="participantAge" value="<%= request.getAttribute("participantAge") %>"/><br/>
        <label>Phone Number</label>
        <input type="number" name="phoneNumber" value="<%= request.getAttribute("phoneNumber") %>"/><br/>
        <label for="batchId">Choose a Batch:</label>
        <select name="batchId" id="batchId">
            <% 
            List<Integer> listOfBatches = (List<Integer>) request.getAttribute("batchList");
            if (listOfBatches != null) {
                for (Integer batchid : listOfBatches) {
                    out.println("<option value=" + batchid +">" + batchid + "</option>");
                }
            }else {
                out.println("<option value='' disabled>No batches available</option>");
            }    
            %>
        </select><br/>
        <input type="submit" value="Update Participant"/>
        <input type="reset" value="reset"/>
    </form>
</body>
</html>
