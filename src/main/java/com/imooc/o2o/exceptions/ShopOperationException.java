package com.imooc.o2o.exceptions;

/**
 * Created by jason on 2019/9/10.
 */
public class ShopOperationException extends RuntimeException {
    private static final long serialVersionUID = 0L;
    public ShopOperationException(String msg) {
        super(msg);
    }
}
