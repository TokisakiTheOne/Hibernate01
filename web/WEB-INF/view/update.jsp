<%--
  Created by IntelliJ IDEA.
  User: YanYuHang
  Date: 2019/11/22
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form action="update" method="post">
    <div class="form-group">
        <label>编号</label>
        <input type="text" class="form-control" value="${stu.stuId}" name="stuId" readonly>
    </div>
    <div class="form-group">
        <label>姓名</label>
        <input type="text" class="form-control" value="${stu.stuName}" name="stuName">
    </div>
    <button type="submit" class="btn btn-primary">新增</button>
</form>
</body>
</html>
