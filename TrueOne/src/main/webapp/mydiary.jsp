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
                     $.ajax({
                            url: "http://localhost:8080/servlet/MyDiary.action",
                            type: "get",
                            dataType: "json",
                             success: function(data){
                                showData(data);
                             },
                         error: function(msg){
                                 alert("ajax连接异常："+msg);
                            }
                    });
                 }

         function showData(data) {
                      var str = "";//定义用于拼接的字符串
                      for (var i = 0; i < data.length; i++) {
                              //拼接表格的行和列
                              str = "<tr><td>" +"O"+ "</td><td>" + data[i].title + "</td><td>" + data[i].context + "</td><td>" + data[i].date + "</td></tr>";
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
