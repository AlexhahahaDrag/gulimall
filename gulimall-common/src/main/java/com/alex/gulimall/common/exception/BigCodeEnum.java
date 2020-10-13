package com.alex.gulimall.common.exception;

import com.alex.gulimall.common.constants.GulimallCode;

public enum  BigCodeEnum {
    UNKNOW_EXCEPTION(GulimallCode.SYS_CODE + GulimallCode.RESULT_CODE_SYSTEM_UNKNOWN_ERROR,"系统未知异常"),
    VAILD_EXCEPTION(GulimallCode.SYS_CODE + GulimallCode.RESULT_CODE_INVALID_INPUT,"参数格式校验失败"),
    TO_MANY_REQUEST(GulimallCode.SYS_CODE + GulimallCode.RESULT_CODE_INNER_ERROR,"请求流量过大，请稍后再试"),
    SMS_CODE_EXCEPTION(GulimallCode.SYS_CODE + GulimallCode.RESULT_CODE_FQS_LARGER_ERROR,"验证码获取频率太高，请稍后再试"),
    PRODUCT_UP_EXCEPTION(GulimallCode.PRODUCT_CODE + GulimallCode.RESULT_CODE_INVALID_BUSINESS,"商品上架异常"),
    USER_EXIST_EXCEPTION(GulimallCode.MEMBER_CODE + GulimallCode.RESULT_CODE_INVALID_BUSINESS,"存在相同的用户"),
    PHONE_EXIST_EXCEPTION(GulimallCode.MEMBER_CODE + GulimallCode.RESULT_CODE_INVALID_BUSINESS,"存在相同的手机号"),
    NO_STOCK_EXCEPTION(GulimallCode.PRODUCT_CODE + GulimallCode.RESULT_CODE_INVALID_BUSINESS,"商品库存不足"),
    LOGINACCT_PASSWORD_EXCEPTION(GulimallCode.MEMBER_CODE + GulimallCode.RESULT_CODE_INVALID_BUSINESS,"账号或密码错误"),;

    BigCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
