package com.imooc.o2o.enums;

/**
 * Created by jason on 2019/9/10.
 */
public enum  ShopStateEnum {
    CHECK(0, "审核中"),
    OFFLINE(-1, "非法操作"),
    SUCCESS(1, "操作成功"),
    PASS(2, "通过认证"),
    INNER_ERROR(-1001, "操作失败"),
    NULL_SHOPID(-1002, "shopId为空"),
    NULL_SHOP(-1003, "shop信息为空");
    private int state;
    private String stateInfo;
    private ShopStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    /**
     * 依据传入的state返回相应的enum值
     * @param state
     * @return
     */
    public static ShopStateEnum stateOf(int state){
        for (ShopStateEnum shopStateEnum: values()) {
            if(shopStateEnum.getState() == state) {
                return shopStateEnum;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
