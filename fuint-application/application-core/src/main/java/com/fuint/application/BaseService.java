package com.fuint.application;

/**
 * Created by FSQ
 * Contact wx fsq_better
 * Site https://www.fuint.cn
 */
public class BaseService {

    /**
     * 获取成功返回结果
     * @param data
     * @return
     */
    public ResponseObject getSuccessResult(Object data) {
        return new ResponseObject(FrameworkConstants.HTTP_RESPONSE_CODE_SUCCESS, "", data);
    }

    /**
     * 获取错返回结果(无参数替换)
     * @param errorCode
     * @return
     */
    public ResponseObject getFailureResult(int errorCode) {
        return new ResponseObject(errorCode, PropertiesUtil.getResponseErrorMessageByCode(errorCode), null);
    }

    /**
     * 获取错返回结果(带参数替换)
     * @param errorCode
     * @param params
     * @return
     */
    public ResponseObject getFailureResult(int errorCode, String... params) {
        return new ResponseObject(errorCode, PropertiesUtil.getResponseErrorMessageByCode(errorCode, params), null);
    }
}
