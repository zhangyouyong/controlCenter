<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/common/common-js-1.4.jsp"/>
<html>
<head>
<!-- 	<script>
		var data={"groupId":1,"userIds":[1,2,3]};
		$.ajax({url:'http://localhost:8080/Consoles/UsePermission/userGroupRelation.do',type:'post',
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify(data),success:function(result){
			
				//alert(result);
			}
		});
	</script> -->
</head>
<body>
	<form name="uploadForm" id="uploadForm" method="post" action="/Consoles/Account/fileUpload.do"
	      enctype="multipart/form-data">
	    <input type="file" name="image" /><br/>
	    <input type="submit" value="上传" class="btn4" />
	</form>
	
	
</body>
</html>