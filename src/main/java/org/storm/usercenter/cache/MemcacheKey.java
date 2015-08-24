package org.storm.usercenter.cache;


public interface MemcacheKey {
	/**
	 * 楼层key
	 */
	public static final String FOOLER_CACHE = "FOOLER";

	/**
	 * 导航
	 */
	public static final String NAVIGATION_CODE_CACHE = "NAVIGATION_CODE";

	/**
	 * 商城文档
	 */
	public static final String DOCUMENT_CACHE = "DOCUMENT";

	/**
	 * 商品分类A
	 */
	public static final String GOODS_CLASS_CACHE_A = "GOOD_CLASS_CACHE_A";

	/**
	 * 商品分类B
	 */
	public static final String GOODS_CLASS_CACHE_B = "GOOD_CLASS_CACHE_B";

	/**
	 * 商品分类 导航位置
	 */
	public static final String GOODS_CLASS_CACHE_NAV = "GOODS_CLASS_CACHE_NAV";

	/**
	 * 商品分类 商城
	 */
	public static final String GOODS_CLASS_CACHE_MALL = "GOODS_CLASS_CACHE_MALL";

	/**
	 * 商品分类 猜你喜欢
	 */
	public static final String GOODS_CLASS_CACHE_RECOMMEN = "GOODS_CLASS_CACHE_RECOMMEN";

	/**
	 * 微信商城所有地址缓存
	 */
	public static final String WEI_XIN_ALL_AREA = "WEI_XIN_ALL_AREA";

	/**
	 * 微信商城商品分类
	 */
	public static final String WEI_XIN_ALL_GOODS_CLASS = "WEI_XIN_ALL_GOODS_CLASS";

	/**
	 * 用户中心userToken
	 */
	public static final String USER_ACCESS_TOKEN = "user_access_token";

	/**
	 * 微信商城用户
	 */
	public static final String CURRENT_WXSHOP_USER = "current_wxshop_user";

	/**
	 * 用户中心用户
	 */
	public static final String CURRENT_USERCENTER_USER = "current_usercenter_user";
	/**
	 * 考试中心
	 */
	public static final String CURRENT_TESTCENTER_USER = "current_testcenter_user";
}
