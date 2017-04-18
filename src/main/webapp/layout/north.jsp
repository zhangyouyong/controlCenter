<%@ page language="java" pageEncoding="UTF-8" %>
<style>
    #big{
        font-family: "微软雅黑";
        font-size:48px;
        text-shadow: 0px -1px 0px #555555,
        0px -2px 0px #666666,
        0px -3px 0px #777777,
        0px -4px 0px #888888,
        0px -5px 0px #999999,
        0px -5px 0px #AAAAAA;
        transition:all 500ms;
    }
    /*#big:hover{*/
        /*text-shadow: 0px 1px 0px #555555,*/
        /*0px 2px 0px #666666,*/
        /*0px 3px 0px #777777,*/
        /*0px 4px 0px #888888,*/
        /*0px 5px 0px #999999,*/
        /*0px 5px 0px #AAAAAA;*/
    /*}*/
    #admin_username{
        display: inline-block;
        transition:all 500ms;
    }
    #admin_username:hover{
        transform:rotate(360deg);
    }
</style>



<div style="height: 80px; overflow: hidden;">
    <div style="margin:-5px auto;">
        <h1 id="big" style="text-align: center" class="panel-title">${SESSION_MERCHANT_USER.merchantName}接口相关管理</h1>
    </div>
    <div style="float:right;font-size:14px;margin:-30px 10px 0px 0px">
       
        <div id="layout_north_pfMenu" style="width: 120px; display: none;">
            <div onclick="changeThemeFun('default');">默认</div>
            <div onclick="changeThemeFun('bootstrap');">推荐</div>
            <div onclick="changeThemeFun('ui-cupertino');">天蓝</div>
            <div onclick="changeThemeFun('black');">黑色</div>
            <div onclick="changeThemeFun('ui-pepper-grinder');">中国风</div>
            <div class="menu-sep"></div>
            <div onclick="changeThemeFun('metro');">扁平白</div>
            <div onclick="changeThemeFun('metro-blue');">扁平蓝</div>
            <div onclick="changeThemeFun('metro-gray');">扁平灰</div>
            <div onclick="changeThemeFun('metro-green');">扁平绿</div>
            <div onclick="changeThemeFun('metro-orange');">扁平橙</div>
            <div onclick="changeThemeFun('metro-red');">扁平红</div>
        </div>
     
    </div>



</div>