package com.imooc.o2o.exceptions;

/**
 * Created by jason on 2019/9/10.
 */
public class ProductCategoryOperationException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public ProductCategoryOperationException(String msg) {
        super(msg);
    }
}
