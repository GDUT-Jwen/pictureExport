<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/11 0011
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript">
    var msg = "${msg}";
    if(msg=="success" || msg==""){
        alert("保存成功");
        parent.success();
    }else{
        parent.failed();
    }
</script>
</body>

</html>
