<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<div class="snippet-container">
    <h1>Player information</h1>
    <form>
        <div class="mb-3 col-4">
            <label for="name" class="form-label">Player Name:</label>
            <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
        </div>
        <div class="mb-3 mt-3 col-4">
            <label for="email" class="form-label">Player age:</label>
            <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
        </div>
        <div class="mb-3 col-4">
            <label for="class">Index name</label> <br/>
            <select class="form-select" id="class" name="classId">
                <option value=""> </option> <br/>
            </select>
        </div>
        <div class="mb-3 col-4">
            <label for="class"> Value </label> <br/>
            <select class="form-select" id="value" name="classId">
                <option value=""> 1</option> <br/>
                <option value=""> 2</option> <br/>
            </select>
        </div>


    </form>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col"> Player Name</th>
            <th scope="col">Player age</th>
            <th scope="col">Index name/th>
            <th scope="col">value</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row"></th>
            <td ></td>
            <td></td>
            <td></td>
            <td></td>
            <td> delete</td>
            <td> <a href="#">edit</a></td>

        </tr>
        </tbody>
    </table>
</div>


</body>
</html>