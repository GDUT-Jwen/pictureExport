<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf8">
    <script type="text/javascript" src="./js/jquery-1.8.2.min.js"></script>
    <title>My JSP 'index.jsp' starting page</title>
    <script type="text/javascript">
        //ajax 方式上传文件操作

            function upload() {
                var form = new FormData(document.getElementById("upload"));
                var pic = $('#pic').val();
                debugger;
                if (checkData()) {
                    $.ajax({
                        url: "uploadFile",
                        type: "post",
                        data: form,
                        processData: false,
                        contentType: false,
                        success: function (data) {
                            debugger;
                            if (data == 'success') {
                                //关闭自身
                                parent.layer.closeAll('iframe'); //再执行关闭，强制关闭弹窗
                            }

                        }
                    });
                }
            }


        //JS校验form表单信息
        function checkData(){
            var fileDir = $("#file").val();
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
    </script>
</head>

<body>
<!-- <div>1.通过简单的form表单提交方式，进行文件的上</br> 2.通过jquery.form.js插件提供的form表单一步提交功能 </div></br>  -->
<h1>上传excel</h1>
<form  id="upload">
    <input name="pic" id="pic" type="hidden" value="${picName}"/>
      <div class="form-group">
        <label for="file">上传文件</label>
        <input type="file" id="file" name="file">
      </div>
      <button type="submit" class="btn btn-default" onclick="upload()">提交</button>
</form>

</body>
</html>
</html>