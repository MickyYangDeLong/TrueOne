<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<html>
<head>
    <!-- 防止中文乱码 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <h1 style="color: #ff0394;width: 100%; text-align: center; height: 70px;">My Web</h1>
    <style type="text/css">
        .top {
            height: 70px;
            width: 100%;
            background-color: aquamarine;
            position: fixed;
        }

        ul { /*设置导航栏的框框*/

            margin: 30px auto; /*框框整体的位置，30px是指离网页的顶部和下部的距离，auto控制的是左右距离为自动调节*/

            width: 600px; /*框框的宽度*/

            height: 350px; /*框框的长度*/

            padding: 0px; /*将框框的padding设置为零，不然会导致框框里的内容与框边缘有间隔*/

            border: 1px solid #000; /*添加边框*/

        }

        li {

            list-style-type: none; /* 去掉li前的点 */

            float: left; /*将li设置成做浮动，变为联动*/

        }

        a {

            display: block; /*将a变成块状*/

            width: 245px; /*设置块的宽度*/

            height: 70px; /*设置块的长度*/

            font-family: Microsoft Yahei;

            line-height: 70px; /*设置字体在块中的高度*/

            background-color: #2f4f4f;

            margin: 0px 0px; /*块里的高宽通过margin设置*/

            color: #fff;

            text-align: center; /*字体居中*/

            text-decoration: none; /*去掉下划线*/

            font-size: 15px;

        }

        a:hover {

            background-color: #2f6f4f;

        }
    </style>

</head>
<body style="background-color: aquamarine" style="background-image:url(./image/7d7d074f-fee2-11e8-a603-44032cbabfd9.jpg)">
<script>


</script>
<nav>
    <div class="top">
        <li><a href="mydiary.jsp">我的日记</a></li>
        <li><a href="selfmanager.jsp">本机管理</a></li>
        <li><a href="selfmanager.jsp">家族树</a></li>
        <li><a href="selfmanager.jsp">那年今日</a></li>
        <li><a href="selfmanager.jsp">诗词歌赋</a></li>
        <li><a href="selfmanager.jsp">我爱功夫</a></li>
        <li><a href="selfmanager.jsp">动物天使</a></li>
        <li><a href="WebSnake.html">web贪吃蛇</a></li>
       <%-- <li><a href="javascript:;" onclick="javascript:location.href='/servlet/ServletDemo4Snake'"> 本机版贪吃蛇</a></li>--%>
        <li><a href="javascript:;" onclick="javascript:location.href='/DisplayHeader'"> httphead</a></li>
        <li><a href="javascript:;" onclick="javascript:location.href='/TomcatTest/Refresh'">Refresh</a></li>
        <li><a href="cook.html">form</a></li>
        <li><a href="javascript:;" onclick="javascript:location.href='/ReadCookies'">ReadCookies</a></li>
        <li><a href="javascript:;" onclick="javascript:location.href='/DeleteCookies'">DeleteCookies</a></li>
        <li><a href="javascript:;" onclick="javascript:location.href='/SessionTrack'">SessionTrack</a></li>
        <li><a href="javascript:;" onclick="javascript:location.href='/DiaryServlet.do'">DiaryServlet.do</a></li>
        <li><a href="upload.jsp">upload</a></li>
    </div>
</nav>
</body>
</html>
