<%@ page language="java" pageEncoding="UTF-8" %>
<script>
    var center_tabs = $("#center_tabs");       //tab面板
    var center_tabsMenu = $("#center_tabsMenu");    //tab右键菜单
    $(function () {
        center_tabs.tabs({
            fit: true,
            border: false,
            tabPosition: 'top',
            onContextMenu: function (e, title, index) {
                e.preventDefault();
                center_tabsMenu.menu('show', {
                    left: e.pageX,
                    top: e.pageY
                }).data('tabIndex', index);
            },
            tools: [
                {
                    text:"刷新",
                    iconCls: 'icon-standard-arrow-refresh',
                    handler: function () {
                        var currTab =  center_tabs.tabs('getSelected');
                        updateTab(currTab);
                    }
                },
                {
                    text:"关闭",
                    iconCls: 'icon-standard-cross',
                    handler: function () {
                        //获取当前选中的tab
                        var tab = center_tabs.tabs('getSelected');
                        //获取当前选中tab的index
                        var index = center_tabs.tabs('getTabIndex', tab);
                        //获取当前选中面板的参数
                        var opt = center_tabs.tabs("getTab", index).panel("options");
                        //判断当前面板是否可以关闭
                        if (opt.closable) {
                            center_tabs.tabs("close", index);
                        } else {
                            $.messager.show({
                                title: '提示信息',
                                msg: '当前面板不能关闭... ^_^',
                                timeout: 2000,
                                showType: 'slide'
                            });
                        }
                    }
                }
            ]
        });

        function updateTab(currTab){
            var content=currTab.panel('options').content;
            center_tabs.tabs('update',{
                tab : currTab,
                options : {
                    content : content
                }
            });
        }


        //tab右键菜单
        center_tabsMenu.menu({
            onClick: function (item) {
                //获得当前点击的tab的标题
                var currentTabIndex = $(this).data('tabIndex');
                //获得点击的选项
                var type = item.text;
                switch (type) {
                    case "刷新":{
                        var currTab =  center_tabs.tabs("getTab", currentTabIndex);
                        updateTab(currTab);
                    }
                        break;
                    case "关闭":{
                        center_tabs.tabs("close", currentTabIndex);
                    }
                        break;
                    default:
                        //获得当前所有tab
                        var allTabs = center_tabs.tabs("tabs");
                        var closeTabIndex = [];
                        $.each(allTabs, function () {
                            var tabIndex = center_tabs.tabs("getTabIndex", $(this));
                            //console.debug(tabIndex);
                            var closable = $(this).panel("options").closable;
                            //console.debug(closable);
                            if (type === "关闭其它" && closable && currentTabIndex !== tabIndex) {
                                closeTabIndex.push(tabIndex);
                            } else if (type === "关闭所有" && closable) {
                                closeTabIndex.push(tabIndex);
                            }
                        });
                        for (var i = closeTabIndex.length; i > 0; i--) {
                            center_tabs.tabs("close", closeTabIndex[i - 1]);
                        }
                        center_tabs.tabs("select", currentTabIndex);
                }
            }
        });
        /*center_tabs.tabs("add", {
         fit: true,			    //自适应宽高
         closable: false,	    //是否可以关闭
         border: false,		    //是否显示边框
         selected: true,	        //是否选中
         title: '欢迎页面',	    //tab的标题
         href: 'admin/hello.jsp'	//tab地址
         });*/
    });
</script>

<div id="center_tabs">
    <div title="欢迎页面" data-options="closable:false">
        <iframe src='${web}layout/hello.jsp' allowTransparency='true' style='border:0;width:100%;height:99%;' frameBorder='0'></iframe>
    </div>
</div>
<div id="center_tabsMenu" style="width: 120px; display: none;">
    <div title="close" data-options="iconCls:'delete'">关闭</div>
    <div title="refresh" data-options="iconCls:'transmit'">刷新</div>
    <div class="menu-sep"></div>
    <div title="closeOther" data-options="iconCls:'delete'">关闭其它</div>
    <div title="closeAll" data-options="iconCls:'delete'">关闭所有</div>
</div>
