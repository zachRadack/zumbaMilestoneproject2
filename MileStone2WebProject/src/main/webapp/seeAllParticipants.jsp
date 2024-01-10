<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page import="java.util.List" %> <%@ page
import="MileStone2WebProject.src.main.java.Participant" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>All Participants</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<link href="Style.css" rel="stylesheet"/>
<body>
    <a href="index.html" class="btn btn-primary mb-2">Home</a><br/>

    <h2>All Participants</h2>
    <table border="1">
        <tr>
            <th>Participant Id</th>
            <th>Participant Name</th>
            <th>Participant Age</th>
            <th>Phone Number</th>
            <th>Batch Id</th>
            <th>Action</th>
        </tr>
        <%
            List<Participant> listOfParticipants = (List<Participant>) request.getAttribute("participantList");
            if (listOfParticipants != null) {
                for (Participant participant : listOfParticipants) {
                    out.println("<tr>");
                    out.println("<td>" + participant.getPartID() + "</td>");
                    out.println("<td>" + participant.getPartName() + "</td>");
                    out.println("<td>" + participant.getPartAge() + "</td>");
                    out.println("<td>" + participant.getPartPhoneNumber() + "</td>");
                    out.println("<td>" + participant.getBatchInt() + "</td>");

                    // Form for each participant
                    out.println("<td>");
                    out.println("<form action='ParticipantServerlet' method='post'>");
                    out.println("<input type='hidden' name='operation' value='delete'/>");
                    out.println("<input type='hidden' name='participantId' value='" + participant.getPartID() + "'/>");
                    out.println("<input type='hidden' name='remove' value='single'/>");
                    out.println("<input type='submit' value='Remove'/>");
                    out.println("</form>");
                    out.println("</td>");

                    out.println("</tr>");
                }
            } else {
                out.println("<tr><td colspan='6'>No Participants available</td></tr>");
            }
        %>

  </body>
</html>
