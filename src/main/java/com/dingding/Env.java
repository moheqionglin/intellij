package com.dingding;


/**
 * 企业应用接入时的常量定义
 */
public class Env {

    /**
     * 企业应用接入秘钥相关
     */
    public static final String CORP_ID = "dingab9b087097af008735c2f4657eb6378f";
    public static final String CORP_SECRET = "OqpK08Fh2mN0YQFzSFnuAmh1HO4R6vDIuXfNIJR82LMshu2guYFyWRlgck3fksFi";
    public static final String SSO_Secret = "vGUAz6afQ7BlPZFOgOh2qspiELrr7IEjR-dy7hf_2ePQ4ljc2HMX_KcrNPwwODZc";

    /**
     * DING API地址
     */
	public static final String OAPI_HOST = "https://oapi.dingtalk.com";
    /**
     * 企业应用后台地址，用户管理后台免登使用
     */
	public static final String OA_BACKGROUND_URL = "";


    /**
     * 企业通讯回调加密Token，注册事件回调接口时需要传递给钉钉服务器
     */
	public static final String TOKEN = "";
	public static final String ENCODING_AES_KEY = "";

}
