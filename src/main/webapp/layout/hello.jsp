<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<jsp:include page="/common/common-js-1.4.jsp"/>
<style>
    .container{
        margin: 20px;
    }
    .section{
        width: 100%;
        margin: 10px auto;
    }
    .sys_info{
        width: 100%;
        font-size: 14px;
    }
    .sys_info tr{
        line-height: 30px;
    }
</style>
<!--  
<div class="container">
    <div></div>
    <div class="section">
        <h1>系统信息</h1>
        <div>
            <table class="sys_info">
                <tr>
                    <td>站点名称：北航接口管理系统</td>
                    <td>网站域名：<%=basePath%></td>
                    <td>服务器名称：<%=request.getServerName() %></td>
                </tr>
                <tr>
                    <td>服务器IP：<%=request.getRemoteAddr()%></td>
                    <td>JDK版本：<%=System.getProperty("java.version")%></td>
                    <td>操作系统：<%= System.getProperty("os.name")%></td>
                </tr>
                <tr>
                    <td>Tomcat环境：<%= application.getServerInfo() %></td>
                    <td>服务器端口：<%=request.getServerPort() %></td>
                    <td>目录物理路径：<%=application.getRealPath("/")%></td>
                </tr>
            </table>
        </div>
    </div>
</div>
-->

<div>
欢迎使用北航接口后台管理
</div>

