<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	request.setAttribute("web", basePath);
	request.setAttribute("resource",basePath);
%>
<!-- JQuery -->
<script type="text/javascript" src="<%=basePath%>resource/js/custom/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/custom/jquery.cookie.js"></script>

<%--EasyUI图样式--%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>resource/js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>resource/js/jquery-easyui-1.4.1/themes/icons.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>resource/js/jquery-easyui-1.4.1/themes/icon-standard.css"/>

<!-- easyui 主题 -->
<link id="easyuiTheme" rel="stylesheet" type="text/css"  href="<%=basePath%>resource/js/jquery-easyui-1.4.1/themes/bootstrap/easyui.css">


<%--<script type="text/javascript" src="<%=basePath%>/resource/js/jquery-easyui-1.4.1/jquery.min.js"></script>--%>
<script type="text/javascript" src="<%=basePath%>resource/js/custom/changeEasyuiTheme.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/jquery-easyui-1.4.1/easyui-util.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/jquery-easyui-1.4.1/easyui-validate.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/My97DatePicker/WdatePicker.js"></script><!-- 时间控件 -->
<script src="<%=basePath%>resource/js/common/common.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>resource/css/custom.css" />

<script>
	var G_CTX_PATH = "${web}";
</script>

