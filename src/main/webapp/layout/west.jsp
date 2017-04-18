<%@ page language="java" pageEncoding="UTF-8" %>
<script>
$('#west_accordion').accordion({
	   animate:true
	});
	
    $(function () {
        var west_accordion_ul_li = $("#west_accordion").find('ul li a');
        west_accordion_ul_li.on("click", clickTab);
    });

    var center_tabs = $("#center_tabs");

    //点击列表的事件
    function clickTab() {
//        location.replace();
        //获得点击的文字，作为新tab的标题
        var tabTitle = $(this).text();
        //获得点击选项的url属性值，作为新tab的href
        var url = $(this).attr("url");
        //如果tab面板已存在就选中，否则创建新tab。
        if (center_tabs.tabs("exists", tabTitle)) {
            center_tabs.tabs("select", tabTitle);
        } else{
            addTab(tabTitle, url);//新建tab
        }
    }
    //新建tab
    function addTab(tabTitle, url) {
        center_tabs.tabs("add",{
            fit: true,
            closable: true,
            border: false,
            selected: true,
            title: tabTitle,
            content : "<iframe src='"+url+"' style='border:0;width:100%;height:99%;' frameBorder='0'></iframe>"
        });
    }

</script>
<style>
    #west_accordion div ul{
        list-style: none;
        margin: 0px;
        padding: 0px 0px 0px 0px;
    }
    #west_accordion div ul li{
        line-height: 25px;
        font-size: 14px;
        padding-left: 30px;
        border-bottom: 1px dotted;
    }
    #west_accordion ul li:hover {
        cursor: pointer;
    }
</style>

<div id="west_accordion" class="easyui-accordion" data-options="border:false,fit:true">
	
	<div id="content">
		<ul id="ul">
			<li><div>
					<a url="<%=request.getContextPath()%>/api/sysApiInit.do"> <span class="nav">接口管理</span>
					</a>
				</div></li>
			<li><div>
					<a url="<%=request.getContextPath()%>/sysApplication/initApplication.do"> <span class="nav">应用管理</span>
					</a>
				</div></li>
			<li><div>
					<!-- <a url="<%=request.getContextPath()%>/auth/initAuth.do"> <span class="nav">认证</span> -->
					</a>
				</div></li>
			<!--<li><div>
					<a url="<%=request.getContextPath()%>/temp/initTemp.do"> <span class="nav">验证</span>
					</a>
				</div></li>
			 <li><div>
					<a url="index/index.do"> <span class="nav">Token管理</span>
					</a>
				</div></li> -->
		</ul>
	</div>

	<%----%>
</div>

