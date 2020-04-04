<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <!-- 防止中文乱码 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Head</title>
    <script type="text/javascript">

    </script>
</head>
<body style="background-image:url(./image/7d7d074f-fee2-11e8-a603-44032cbabfd9.jpg)">
<h1 style="text-align: center ; color: blueviolet; background-color: darkkhaki">家族树</h1>
<form action="/servlet/ServletDemo" method="post">
    用户名：<input type="text" title="请输入用户名" name="user" size="20px"><br>
    密码：<input type="password" title="请输入密码" name="pswd" size="20px"><br>
    <input type="submit" value="确定">
    <input type="reset" value="重置">
    <div id="errorMessage" >
        <br/>
        <%String msg =Objects.toString(request.getAttribute("message"),""); %>
        <p style="color: blue;background-color: #ff0d42"> <%=msg%></p>

    </div>
</form>
</body>
</html>
