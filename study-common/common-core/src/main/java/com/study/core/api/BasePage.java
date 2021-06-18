package com.study.core.api;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * @author 刘祖鸿
 */
@Data
public class BasePage {
    /**
     * 页码
     */
    @Range(max = 10000, min = 0, message = "页码非法范围")
    private int page = 1;

    /**
     * 每页条数
     */
    @Range(max = 20000, min = 0, message = "单页条数非法范围")
    private int limit = 10;
}
