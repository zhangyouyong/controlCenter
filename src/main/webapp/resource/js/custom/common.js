/**
 * Created by Famiover on 16/3/8.
 */
(function($) {
    $.common = {};
    _initFunction();
    //-- 浏览器工具 --//
    $.common.browser = {
        // 检测是否是IE浏览器
        isIE: function() {
            var _uaMatch = $.uaMatch(navigator.userAgent);
            var _browser = _uaMatch.browser;
            if (_browser == 'msie') {
                return true;
            } else {
                return false;
            }
        },
        // 检测是否是chrome浏览器
        isChrome: function() {
            var _uaMatch = $.uaMatch(navigator.userAgent);
            var _browser = _uaMatch.browser;
            if (_browser == 'webkit') {
                return true;
            } else {
                return false;
            }
        },
        // 检测是否是Firefox浏览器
        isMozila: function() {
            var _uaMatch = $.uaMatch(navigator.userAgent);
            var _browser = _uaMatch.browser;
            if (_browser == 'mozilla') {
                return true;
            } else {
                return false;
            }
        },
        // 检测是否是Firefox浏览器
        isOpera: function() {
            var _uaMatch = $.uaMatch(navigator.userAgent);
            var _browser = _uaMatch.browser;
            if (_browser == 'opera') {
                return true;
            } else {
                return false;
            }
        }
    };

    $.common.sleep =function (numberMillis) {
        var now = new Date();
        var exitTime = now.getTime() + numberMillis;
        while (true) {
            now = new Date();
            if (now.getTime() > exitTime)
                return;
        }
    }


    $.common.alert ={
        success:function(alertMsg,callback){
            layer.alert(alertMsg, 1, '系统提示',callback);
        },
        error:function(alertMsg,callback){
            layer.alert(alertMsg, 2, '系统提示',callback);
        },
        choose:function(msg,yesCallback,noCallback,closeCallback){
            $.layer({
                shade: [0],
                area: ['auto','auto'],
                dialog: {
                    msg: msg,
                    btns: 2,
                    type: 4,
                    btn: ['确定','取消'],
                    yes: yesCallback,
                    no: noCallback
                },
                close:closeCallback
            });
        },
        //guide: 指引方向（0：上，1：右，2：下，3：左）。
        tips:function(html, follow, parme){
            layer.tips(html, follow, parme);
        },
        dom:function(context,closeCallback){
            $.layer({
                type: 1,
                shade: [0.1, '#000',19900322],
                closeBtn: [0],
                title: false,
                border: false,
                shadeClose: true,
                page: {dom : context},
                close: closeCallback
            })
        }
    };

    //////////////////////////////jquery公用方法
    $.getAjaxHtmlData = function(url, data) {
        var htmlData =null;
        $.ajax({
            type : "post",
            url : url,
            async : false,
            data : arguments[1] || {},
            success : function(result) {
                htmlData = result;
            }
        });
        return htmlData;
    };

    $.event.special.inputchange = {
        setup: function() {
            var self = this, val;
            $.data(this, 'timer', window.setInterval(function() {
                val = self.value;
                if ( $.data( self, 'cache') != val ) {
                    $.data( self, 'cache', val );
                    $( self ).trigger( 'inputchange' );
                }
            }, 20));
        },
        teardown: function() {
            window.clearInterval( $.data(this, 'timer') );
        },
        add: function() {
            $.data(this, 'cache', this.value);
        }
    };

    //select初始化
    $.fn.selectInit = function(options) {

        var that = this;
        $(this).empty();
        if (options.defaults) {
            $(this).append(
                "<option value=" + options.defaults.key + ">" + options.defaults.value
                + "</option>");
        }

        var key = "id", value = "text";
        if (options.mapping) {
            key = options.mapping.key;
            value = options.mapping.value;
        }

        $(options.data).each(function(num, item) {
            var $d1 = $("<option value='" + item[key] + "'>" + item[value] + "</option>");
            $d1.data("optionData", item);
            $(that).append($d1);
        });
        $(this).bind("change", options.onChange);
        return this;
    };
    $.fn.addressCommon=function(options){
        var type="address",title="地址";
        if(options.type){
            type=options.type
        }
        if(options.title){
            title=options.title;
        }
        var initData=$.getAjaxHtmlData("addressGanged/initAddress.htm");
        //var checkData=$.getAjaxHtmlData("addressGanged/datailAddress.htm?addressId="+$(obj).val());
        $(this).prepend("<span tag=''>"+title+":</span>");
        $(this).append("<select tag='province' onchange='checkAddress(this)' name='"+isNotEmpty(options.nodeName.provinceName)+"'><option value=''>--请选择--</option></select>省 ");
        $(this).append("<select tag='city' onchange='checkAddress(this)' name='"+isNotEmpty(options.nodeName.cityName)+"'><option value=''>--请选择--</option></select>市 ");
        $(this).append("<select tag='district' name='"+isNotEmpty(options.nodeName.districtName)+"'><option value=''>--请选择--</option></select>区 ");
        if(type="addressAndShop"){
            $(this).append("<select tag='shop' name='"+isNotEmpty(options.nodeName.shopName)+"'><option>--请选择--</option></select>");
            $(this).next().prepend("<option value=''></option>");
            $(this).find("select[tag='district']").change(function(){
                $(this).next().empty().prepend("<option value=''>--请选择--</option>");
                var dataMarket=$.getAjaxHtmlData("rafflesShop/getMarketData.htm?id="+$(this).val());
                for(var i=0;i<dataMarket.rows.length;i++){
                    $(this).next().append("<option value="+dataMarket.rows[i].id+">"+dataMarket.rows[i].name+"</option>");
                }
            });
        }
        for(var i=0;i<initData.rows.length;i++){
            $(this).find("select[tag='province']").append("<option value='"+initData.rows[i].id+"'>"+initData.rows[i].name+"</option>");
        }
        $(this).find("select[tag='shop']").on("change",function(){
            options.shopChange(this);
        });

    };

    //弹出框
    $.fn.showbox = function(options){
        // var $height = window.screen.availHeight ;
        // var $width = window.screen.availWidth;
        var $height = $(window).height();
        var $width = $(window).width();
        var $w = parseInt($width - $(this).width() ) / 2;
        var $h = parseInt($height - $(this).height() ) / 2;
        var data = {};
        data.zindex = 8000;
        data.top = $h;
        data.left = $w;
        data = $.extend(data,options);
        var $htmls = "<div class='showbox' style='position:fixed;top:0;left:0;background:rgba(0,0,0,0.1)!important;z-index:"+data.zindex+";background-color:#000; filter:alpha(opacity=70);";
        $htmls += "width:" + $width + "px;height:" + $height + "px;'></div>";
        $('body').append($htmls);
        $(this).css({ "top":data.top + "px", "left":data.left + "px" });
        $(this).show();
    }

    //弹出新窗口
    $.newTabWindow = function(url){
        var linking = $("<a href='" + url + "' target='_blank'>Hiaas</a>").get(0);
        if (/firefox/.test(navigator.userAgent.toLowerCase())) {
            var ev = document.createEvent('MouseEvents');
            ev.initEvent('click', true, true);
            linking.dispatchEvent(ev);
        } else if (/opera/.test(navigator.userAgent.toLowerCase())) {
            //FOR CHROM 默认
            var ev = document.createEvent('HTMLEvents');
            ev.initEvent('click', true, true);
            linking.dispatchEvent(ev);
        }
    };

    $.newWindow = function(url){
        return window.open(url);
    };


    //初始化校验控件
    $("form").validationEngine({
        validationEventTrigger:"",
        inlineValidation: true,
        scroll : true,
        focusFirstField : true,
        promptPosition : "topRight"
    });


    //非阻断式弹出框
    var messagebox_timer;
    $.fn.Ynotify = function messagebox(message, type, delay) {
        var message = message;
        var type = type;
        var delay = delay;

        var Box = {
            init : function(){
                this.notify();
            },
            notify : function(){
                clearTimeout(messagebox_timer);
                $("#y_notify").remove();
                var m_body = $(this);
                delay = (typeof delay == "undefined" ? 5000 : delay);
                var box_style = 'z-index:1000;';
                var box_class = 'y_notify '
                switch (type) {
                    case 1: box_class+= 'y_msg_1' ; break;
                    case 0: box_class+= 'y_msg_0' ; break;
                    default: box_class+= 'y_msg_2' ; break;
                }
                var str = "<div id=\"y_notify\" class=\""+box_class+"\" style=\"" + box_style + "\">" + message + "</div>"; $("body").append(str);
                var ext_width = $("#y_notify").width();

                $("#y_notify").stop().animate( {top:2});

                messagebox_timer = setTimeout(function(){
                    Box.message_out();
                }, 2000);
            },
            message_out : function(){
                $("#y_notify").stop().animate({ top:-50});
                $("#y_notify").fadeOut(1000);
            }
        }

        Box.init();
    };


})(jQuery);

function _initFunction() {
    $.extend({
        jsonToString: function(object) {
            if (object == null) {
                return 'null';
            }
            var type = typeof object;
            if ('object' == type) {
                if (Array == object.constructor) {
                    type = 'array';
                } else if (RegExp == object.constructor) {
                    type = 'regexp';
                } else {
                    type = 'object';
                }
            }
            switch (type) {
                case 'undefined':
                case 'unknown':{
                    return;
                    break;
                }
                case 'function':{
                    return '"' + object() + '"';
                    break;
                }
                case 'boolean':
                case 'regexp':{
                    return object.toString();
                    break;
                }
                case 'number':{
                    return isFinite(object) ? object.toString() : 'null';
                    break;
                }
                case 'string':{
                    return '"' +
                        object.replace(/(\\|\")/g, "\\$1").replace(/\n|\r|\t/g, function() {
                            var a = arguments[0];
                            return (a == '\n') ? '\\n' : (a == '\r') ? '\\r' : (a == '\t') ? '\\t' : ""
                        }) +
                        '"';
                    break;
                }
                case 'object':{
                    if (object === null)
                        return 'null';
                    var results = [];
                    for (var property in object) {
                        var value = jquery.jsonToString(object[property]);
                        if (value !== undefined)
                            results.push(jquery.jsonToString(property) + ':' + value);
                    }
                    return '{' + results.join(',') + '}';
                    break;

                }
                case 'array':{
                    var results = [];
                    for (var i = 0; i < object.length; i++) {
                        var value = jquery.jsonToString(object[i]);
                        if (value !== undefined)
                            results.push(value);
                    }
                    return '[' + results.join(',') + ']';
                    break;

                }
            }
        }
    });

    // jquery validator
    if ($.validator) {
        // 银行卡号
        $.validator.addMethod("bankcard", function(value, element, params) {
            var regPex = /(^\d{16}|^\d{17}|^\d{18}|^\d{19}|^\d{20})$/;
            return this.optional(element) || regPex.exec(value);
        }, jQuery.format("请输入合法的银行卡号(长度：16~20)"));

        // 不能大于当天
        $.validator.addMethod("canNotMoreThanToday", function(value, element, params) {
            var values = value.split('-');
            return this.optional(element) || new Date(values[0], values[1], values[2]).getMilliseconds() <= new Date().getMilliseconds();
        }, jQuery.format("日期不能大于今天！"));
    }
};

//////////////////////////////////////////js方法扩展区

String.prototype.trim = function() {
    return this.replace(/(^\s+)|\s+$/g, "");
};

/**
 * 转换字符串为json对象
 */
String.prototype.toJson = function() {
    return eval('(' + this + ')');
};

String.prototype.endsWithIgnoreCase = function(str) {
    return (this.toUpperCase().match(str.toUpperCase() + "$") == str.toUpperCase()) ||
        (this.toLowerCase().match(str.toLowerCase() + "$") == str.toLowerCase());
}

/**
 * 输出2010-02-05格式的日期字符串
 *
 * @return {}
 */
Date.prototype.toDateStr = function() {
    return ($.common.browser.isMozila() || $.common.browser.isChrome() ? (this.getYear() + 1900) : this.getYear()) + "-" +
        (this.getMonth() < 10 ? "0" + this.getMonth() : this.getMonth()) +
        "-" +
        (this.getDate() < 10 ? "0" + this.getDate() : this.getDate());
};

/**
 * 日期格式化
 * @param {Object} format
 */
Date.prototype.format = function(format) {
    var o = {
        "M+": this.getMonth() + 1, //month
        "d+": this.getDate(), //day
        "h+": this.getHours(), //hour
        "m+": this.getMinutes(), //minute
        "s+": this.getSeconds(), //second
        "q+": Math.floor((this.getMonth() + 3) / 3), //quarter
        "S": this.getMilliseconds() //millisecond
    }
    if (/(y+)/.test(format))
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(format))
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
    return format;
}


/**
 * 将字符串格式的日期转换为日期类型对象
 * @param {Object} strDate
 */
Date.toDate = function(strDate) {
    var strDs = strDate.split('-');
    var year = parseInt(strDs[0]);
    var month = parseInt(strDs[1]);
    var date = parseInt(strDs[2]);
    return new Date(year, month, date);
};

/**
 * 通过当前时间计算当前周数
 */
Date.prototype.getWeekNumber = function() {
    var d = new Date(this.getFullYear(), this.getMonth(), this.getDate(), 0, 0, 0);
    var DoW = d.getDay();
    d.setDate(d.getDate() - (DoW + 6) % 7 + 3); // Nearest Thu
    var ms = d.valueOf(); // GMT
    d.setMonth(0);
    d.setDate(4); // Thu in Week 1
    return Math.round((ms - d.valueOf()) / (7 * 864e5)) + 1;
}


//+---------------------------------------------------
//| 日期计算
//+---------------------------------------------------
Date.prototype.DateAdd = function(strInterval, Number) {
    var dtTmp = this;
    switch (strInterval) {
        case 's':
            return new Date(Date.parse(dtTmp) + (1000 * Number));
        case 'n':
            return new Date(Date.parse(dtTmp) + (60000 * Number));
        case 'h':
            return new Date(Date.parse(dtTmp) + (3600000 * Number));
        case 'd':
            return new Date(Date.parse(dtTmp) + (86400000 * Number));
        case 'w':
            return new Date(Date.parse(dtTmp) + ((86400000 * 7) * Number));
        case 'q':
            return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number * 3, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
        case 'm':
            return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
        case 'y':
            return new Date((dtTmp.getFullYear() + Number), dtTmp.getMonth(), dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
    }
};

//-- Javascript对象扩展--结束 -//

//-- 自定义类-开始 --/
function StringBuffer() {
    this._strings_ = new Array();
}

StringBuffer.prototype.append = function(str) {
    this._strings_.push(str);
    return this;
};

StringBuffer.prototype.toString = function() {
    return this._strings_.join("").trim();
};

/**
 * 以键值对存储
 */
function Map() {
    var struct = function(key, value) {
        this.key = key;
        this.value = value;
    };

    var put = function(key, value) {
        for (var i = 0; i < this.arr.length; i++) {
            if (this.arr[i].key === key) {
                this.arr[i].value = value;
                return;
            }
        }
        this.arr[this.arr.length] = new struct(key, value);
        this._keys[this._keys.length] = key;
    };

    var get = function(key) {
        for (var i = 0; i < this.arr.length; i++) {
            if (this.arr[i].key === key) {
                return this.arr[i].value;
            }
        }
        return null;
    };

    var remove = function(key) {
        var v;
        for (var i = 0; i < this.arr.length; i++) {
            v = this.arr.pop();
            if (v.key === key) {
                continue;
            }
            this.arr.unshift(v);
            this._keys.unshift(v);
        }
    };

    var size = function() {
        return this.arr.length;
    };

    var keys = function() {
        return this._keys;
    };

    var isEmpty = function() {
        return this.arr.length <= 0;
    };

    this.arr = new Array();
    this._keys = new Array();
    this.keys = keys;
    this.get = get;
    this.put = put;
    this.remove = remove;
    this.size = size;
    this.isEmpty = isEmpty;
}


Array.prototype.remove=function(dx)
{
    if(isNaN(dx)||dx>this.length){return false;}
    for(var i=0,n=0;i<this.length;i++)
    {
        if(this[i]!=this[dx])
        {
            this[n++]=this[i];
        }
    }
    this.length-=1;
};

function getAjaxData(fromId){
    var formArray = $("#"+fromId).serializeArray();
    var data = {};
    for(var i =0;i<formArray.length;i++){
        data[formArray[i].name] = formArray[i].value;
    }
    return data;
}

/////////////////////////////////////////全局包装的方法区

function openXheditor(id) {
    var winwd = window.screen.width;
    var winhg = window.screen.height;
    var htmls = "<div class=\"showEdit\">"
        +"<textarea class=\"showEditUp\"></textarea>"
        +"<div class=\"showEditDown\"><input class=\"showEidtBtn\" type=\"button\" value=\"关闭\" /></div></div>"
        +"<div class='showboxs' style='position:fixed;top:0;left:0; background:rgba(0,0,0,0.3)!important;z-index:8000;background-color:#000; filter:alpha(opacity=70);"
        +"width:" + winwd + "px;height:" + winhg + "px;'></div>";
    $("body").append(htmls);

    var xheditor = $('.showEditUp').xheditor({
        tools:'Cut,Copy,Paste,Pastetext,Blocktag,Fontface,FontSize,Bold,Italic,Underline,Strikethrough,FontColor,BackColor,SelectAll,Removeformat,Align,List,Link,Unlink,Anchor,Img,Hr,Table,Source,Preview,Fullscreen',
        skin:'nostyle',
        height:500,
        upMultiple:true,
        upImgUrl: "upload/xheditorImage",
        upImgExt: "jpg,jpeg,gif,bmp,png",
        html5Upload: false
    });

    $('.showEditUp').val($(id).text());

    var wd = $(".showEdit").width();
    var hg = $(".showEdit").height();
    var lfs = (winwd - wd)/2;
    var tps = (winhg - hg-100)/2;
    $(".showEdit").css({"left":lfs+"px","top":tps+"px","z-index":"10000"});
    $(".showEidtBtn").click(function (){
        $(id).html(xheditor.getSource);
        $(".showEdit").remove();
        $(".showboxs").remove();
    });
}

/**
 * 引入css、script文件
 * @param {Object} file
 */
function include(file) {
    var files = typeof file == "string" ? [file] : file;
    for (var i = 0; i < files.length; i++) {
        var name = files[i].replace(/^\s|\s$/g, "");
        var att = name.split('.');
        var ext = att[att.length - 1].toLowerCase();
        var isCSS = ext == "css";
        var tag = isCSS ? "link" : "script";
        var attr = isCSS ? " type='text/css' rel='stylesheet' " : " language='javascript' type='text/javascript' ";
        var link = (isCSS ? "href" : "src") + "='" + '' + name + "'";
        if ($(tag + "[" + link + "]").length == 0) {
            $("<" + tag + attr + link + "></" + tag + ">").appendTo('head');
        }
    }
}

function checkAddress(obj){
    var data=$.getAjaxHtmlData("addressGanged/datailAddress.htm?addressId="+$(obj).val());
    var nextNode=$(obj).nextAll().empty().prepend("<option value=''>--请选择--</optio>");
    if(data.rows.length>0){
        for(var i=0;i<data.rows.length;i++){
            $(obj).next().append("<option value='"+data.rows[i].id+"'>"+data.rows[i].name+"</option>");
        }
    }
};

function isNotEmpty(val){
    if(val){
        return val;
    }
    return "";
}
