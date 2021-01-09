<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product store application</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-sm-6">

 

    <table class="table table-striped">
        <thead>
            <tr>
                <th>eventId</th>
                 <th>event_name</th>
                 <th>event_location</th>
                   <th>event_price</th>
                <th>event_date</th>
                <th>event_discount</th>
                <th>noOfTicket</th>
              
                
               
                <th>update</th>
                <th>delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${events}" var="event">
                <tr>
                    <td>${event.id }</td>
                    <td>${event.name }</td>
                    <td>${event.lcation }</td>
                    <td>${event.price }</td>
                   <fmt:parseDate value="${event.date }" pattern="yyyy-MM-dd" var="prodExp" type="date"/>
                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${date}"/></td>
                     <td>${event.discount }</td>
                      <td>${event.noOfTicket }</td>
                    
                    <td><a href="update?id=${event.id }">update</a></td>
                    <td><a href="delete?id=${event.id}">delete</a></td>
                        
                    

 

                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</div>
</div>

 

</body>
</html>