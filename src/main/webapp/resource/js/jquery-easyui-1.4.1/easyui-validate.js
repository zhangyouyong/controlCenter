//扩展easyui表单的验证
$.extend($.fn.validatebox.defaults.rules, {
	//验证汉子
	CHS: {
		validator: function (value) {
			return /^[\u0391-\uFFE5]+$/.test(value);
		},
		message: '只能输入汉字'
	},
	//移动手机号码验证
	mobile: {//value值为文本框中的值
		validator: function (value) {
			var reg = /^1[3|4|5|7|8|9]\d{9}$/;
			return reg.test(value);
		},
		message: '输入手机号码格式不准确.'
	},
	//国内邮编验证
	zipcode: {
		validator: function (value) {
			var reg = /^[1-9]\d{5}$/;
			return reg.test(value);
		},
		message: '邮编必须是非0开始的6位数字.'
	},
	//用户账号验证(只能包括 _ 数字 字母)
	account: {//param的值为[]中值
		validator: function (value, param) {
			if (value.length < param[0] || value.length > param[1]) {
				$.fn.validatebox.defaults.rules.account.message = '长度必须在' + param[0] + '至' + param[1] + '范围!';
				return false;
			} else {
				if (!/^[\w]+$/.test(value)) {
					$.fn.validatebox.defaults.rules.account.message = '只能输入数字、字母、下划线组成!';
					return false;
				} else {
					return true;
				}
			}
		}, message: ''
	},
	loginName: {
		validator: function (value, param) {
			if (value.length < param[0] || value.length > param[1]) {
				$.fn.validatebox.defaults.rules.account.message = '长度必须在' + param[0] + '至' + param[1] + '范围!';
				return false;
			}
			return /^[\u0391-\uFFE5\w]+$/.test(value);
		},
		message: '只能输入汉字、英文字母、数字及下划线。'
	},
	version:{
		validator:function(value,param){
			return /^\d+(\.\d+)+$/.test(value);
		},
		message:'只能输入版本号'
	},
	apiCode:{
		validator:function(value,param){
			return /^[A-Za-z]+\d+$/.test(value);
		},
		message:'输入正确的code码;如ABC123'
	}
}) 