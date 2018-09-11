<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf8">
    <script type="text/javascript" src="./js/jquery-1.8.2.min.js"></script>
    <title>My JSP 'index.jsp' starting page</title>
    <%--<script type="text/javascript">
        //ajax 方式上传文件操作
        $(document).ready(function(){
            $('#btn').click(function(){
                if(checkData()){
                    $('#form1').ajax({
                        url:'uploadExcel/ajaxUpload.do',
                        dataType: 'text',
                        success: resutlMsg,
                        error: errorMsg
                    });
                    function resutlMsg(msg){

                        //document.write(msg.data);
                        var data = JSON.parse(msg.replace(/\\n/g,'</br>'))
                        $('body').append('<span>' + data.data + '</span>');
                        $("#upfile").val("");
                    }
                    function errorMsg(err){
                        alert("导入excel出错！");
                    }
                }
            });
        });

        //JS校验form表单信息
        function checkData(){
            var fileDir = $("#upfile").val();
            var suffix = fileDir.substr(fileDir.lastIndexOf("."));
            if("" == fileDir){
                alert("选择需要导入的Excel文件！");
                return false;
            }
            if(".xls" != suffix && ".xlsx" != suffix ){
                alert("选择Excel格式的文件导入！");
                return false;
            }
            return true;
        }
    </script>--%>
</head>

<body>
<!-- <div>1.通过简单的form表单提交方式，进行文件的上</br> 2.通过jquery.form.js插件提供的form表单一步提交功能 </div></br>  -->
<h1>上传excel</h1>
<form role="form" action="/mvc/uploadFile" method="POST" enctype="multipart/form-data">
      <div class="form-group">
        <label for="file">上传文件</label>
        <input type="file" id="file" name="file">
      </div>
      <button type="submit" class="btn btn-default">提交</button>
</form>

</body>
</html>
</html>