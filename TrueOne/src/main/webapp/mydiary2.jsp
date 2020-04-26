<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<input type="text" name="ceshi">
<input type="submit" value="获取名单"/>
<table id="table">

</table>
</form>
<script type="text/javascript">
    $(function(){
        $("input[type=submit]").click(function(){
            $.post("DiaryServlet.do",
                {"ceshi":$("input[name=ceshi]").val()},
                function(data,textStatus){
                    console.log(data);
                    for(var i = 0;i<data.length; i++)
                    {
                        $("#table").append( $("<tr></tr>")
                            .append($("<td></td>").html(data[i].id))
                            .append($("<td></td>").html(data[i].content))
                            .append($("<td></td>").html(data[i].topic))
                            .append($("<td></td>").html(data[i].authorName)));
                    }
                },
                "json"
            );
        });

    })
</script>
</body>
</html>