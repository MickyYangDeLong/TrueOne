<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <!-- 防止中文乱码 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script language="JavaScript" src="./js/jquery-3.3.1.min.js"></script>

    <title>Head</title>
    <script type="text/javascript">
        function  init(){
                     var person = {username: "小李", password: "123"};
                     $.ajax({
                            url: "http://localhost:80/DiaryServlet.do",
                            type: "post",
                            dataType: "json",
                            data: person,
                             success: function(msg){
                                     alert(msg);
                                    showData(msg);
                                 },
                             error: function(msg){
                                     alert("ajax连接异常："+msg);
                                }
                    });
                 }

         function showData(msg) {
                      var str = "";//定义用于拼接的字符串
                      for (var i = 0; i < msg.length; i++) {
                              //拼接表格的行和列
                              str = "<tr><td>" +msg[i].id+ "</td><td>" + msg[i].content+ "</td><td>" + msg[i].topic + "</td><td>" + msg[i].authorName + "</td></tr>";
                              //追加到table中
                              $("#tab").append(str);         }
                  }

    </script>
</head>
<body onload='init()'  style="background-image:url(./image/7d9ff89e-fee2-11e8-88ee-44032cbabfd9.jpg)">
<h1 style="text-align: center ; color: blueviolet; background-color: darkkhaki">mydiary</h1>
<table id="tab">
    <tr>
        <th>全选</th>
        <th>标题</th>
        <th>内容</th>
        <th>时间</th>
    </tr>
</table>
</body>
</html>
