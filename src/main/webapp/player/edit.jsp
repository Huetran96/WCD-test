<%@ page import="com.servlet.test.entity.Indexer" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.persistence.criteria.CriteriaBuilder" %>
<%@ page import="com.servlet.test.entity.Player" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<div class="container-fluid">
    <h1>Player information</h1>
    <form method="post" action="?action=edit">
        <div class="mb-3 col-4">
            <label for="name" class="form-label">Player Name:</label>
            <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
        </div>
        <div class="mb-3 col-4">
            <label for="fullName" class="form-label">Player Name:</label>
            <input type="text" class="form-control" id="fullName" placeholder="Enter full name" name="fullName">
        </div>
        <div class="mb-3 mt-3 col-4">
            <label for="age" class="form-label">Player age:</label>
            <input type="text" class="form-control" id="age" placeholder="Enter email" name="age">
        </div>
        <div class="mb-3 col-4">
            <label for="indexer">Index name</label> <br/>
            <select class="form-select" id="indexer" name="indexerId">
            <% for (Indexer i: (List<Indexer>) request.getAttribute("indexers")) { %>
                <option value="<%= i.getIndexId()%>"> <%= i.getName()%> </option> <br/>
            <% } %>
            </select>
        </div>
        <div class="mb-3 col-4">
            <div class="mb-3 mt-3 col-4">
                <label for="value" class="form-label">Indexer value : </label>
                <input type="text" class="form-control" id="value"  name="value">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>

    </form>
</div>


</body>
</html>