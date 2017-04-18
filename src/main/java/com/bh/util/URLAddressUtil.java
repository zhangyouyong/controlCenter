package com.bh.util;
/**
 * 链接地址工具类
 * 存放所有调用接口的地址，该类存放所有测试和生产的调用地址、端口、商户号等
 * 根据发布的服务器选择常量。该类只创建常量
 * 写好每一条URL的作用与作用到哪个类中的哪个方法的注释
 * 
 * 如：
 * //AccountAssetManagementController -> DrawlogHandle: 提现操作异步通知
 * private final String BGRETURL = "http://192.168.20.118:4002/zhxt/ryf_deal";
 * 
 * 做添加或修改必须通知本人
 * @author TangZhiQiang
 * @date 2014-7-17
 */
public class URLAddressUtil {
	/**
	 * AccountAssetManagementController -> DrawlogHandle: 提现操作异步通知
	 */
	public static final String BGRETURL = "http://192.168.20.118:4002/zhxt/ryf_deal"; // 测试
//	private final String BGRETURL = "http://192.168.2.130:4002/zhxt/ryf_deal";	//生产
	
	/**
	 * AccountAssetManagementController -> DrawlogHandle: 融易付代付请求地址
	 */
	public static final String PAY_HOST = "112.65.46.59";	// 测试
//	private static final String PAY_HOST = "192.168.2.220"; // 生产
	
	
	/**
	 * AccountAssetManagementController -> DrawlogHandle: 融易付代付请求地址端口
	 */
	public static final int PAY_PORT = 18171;	// 测试
//	private static final int PAY_PORT = 80;		// 生产
	
	/**
	 * AccountAssetManagementController -> updateRate: ewp刷新内存表地址
	 */
	public static final String HTTP_HOST = "192.168.20.140";	// 测试
//	private static final String HTTP_HOST = "192.168.2.130";	// 生产
	
	/**
	 * AccountAssetManagementController -> updateRate: ewp刷新内存表地址端口
	 */
	public static final int HTTP_PORT = 9102;	// 测试
//	private static final int HTTP_PORT = 4002;	// 生产
	
	/**
	 * AccountAssetManagementController -> DrawlogHandle: 融易付代付请求参数，商户号
	 */
	public static final String MERID = "310621533"; 		// 商户编号	测试环境
//	private static final String MERID = "860020030210008"; 	// 商户编号	生产环境
	
	/**
	 * MinfosControl -> addMinfos: 同步商户请求
	 */
	public final static String POST_HOST = "192.168.20.140";
	
	/**
	 * MinfosControl -> addMinfos:端口
	 */
	public final static Integer POST_PORT = 8080;
	
	/**
	 * MinfosControl -> addMinfos:地址
	 */
	public final static String POST_ACTION="/dlxt_manager/addRYFMid_ingerface.action";
	
	/**
	 * TransCheckController -> aotoTransCheck: 自动对账调用链接
	 */
	public final static String URLSTR = "http://192.168.18.206:4002/zhxt/check";
	/**
	 * 刷新内存表错误邮件发送地址
	 */
	public final static String MAILADDRESS = "tang.zhiqiang@chinaebi.com"; // 测试
	public final static String MAILADDRESS_RATE_USERRATE = ""; // 测试
	public final static String MAILADDRESS_CONFIG_USERCONFIG_BWUSERLIST = ""; // 测试
	
//	public final static String MAILADDRESS = "xiao.hua@chinaebi.com,duan.yuhe@chinaebi.com,tang.zhiqiang@chinaebi.com";// 生产
//	public final static String MAILADDRESS_RATE_USERRATE = ",yao.zefang@chinaebi.com,yan.xianyan@chinaebi.com"; // 生产
//	public final static String MAILADDRESS_CONFIG_USERCONFIG_BWUSERLIST = ",zhu.wei@chinaebi.com,jiang.shuting@chinaebi.com,qiu.yifan@chinaebi.com"; // 生产
	
}
