package com.imooc.o2o.enums;

public enum ProductCategoryStateEnum {
    SUCCESS(1, "操作成功"),
    INNER_ERROR(-1001, "操作失败"),
    EMPTY_LIST(-1002, "添加失败");
    private int state;
    private String stateInfo;

    private ProductCategoryStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }
    /**
     * 依据传入的state返回相应的enum值
     * @param state
     * @return
     */
    public static ProductCategoryStateEnum stateOf(int state){
        for (ProductCategoryStateEnum productCategoryStateEnum: values()) {
            if(productCategoryStateEnum.getState() == state) {
                return productCategoryStateEnum;
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
