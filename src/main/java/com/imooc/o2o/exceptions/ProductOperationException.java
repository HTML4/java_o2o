package com.imooc.o2o.exceptions;

/**
 * Created by jason on 2019/9/10.
 */
public class ProductOperationException extends RuntimeException {
    private static final long serialVersionUID = 2L;
    public ProductOperationException(String msg) {
        super(msg);
    }
}
