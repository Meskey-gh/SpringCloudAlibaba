
package com.study.core.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 * @author 刘祖鸿
 */
@Data
public class PageUtils<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "总记录数", required = true, notes = "总记录数")
    private long totalCount;
    @ApiModelProperty(value = "每页记录数", required = true, notes = "每页记录数")
    private long pageSize;
    @ApiModelProperty(value = "总页数", required = true, notes = "总页数")
    private long totalPage;
    @ApiModelProperty(value = "当前页数", required = true, notes = "当前页数")
    private long currPage;
    @ApiModelProperty(value = "列表数据", notes = "列表数据")
    private List<T> list;

    /**
     * 分页
     *
     * @param list       列表数据
     * @param totalCount 总记录数
     * @param pageSize   每页记录数
     * @param currPage   当前页数
     */
    public PageUtils(List<T> list, long totalCount, long pageSize, long currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
    }

    /**
     * 分页
     */
    public PageUtils(Page<T> page) {
        this.list = page.getRecords();
        this.totalCount = page.getTotal();
        this.pageSize = page.getSize();
        this.currPage = page.getCurrent();
        this.totalPage = page.getPages();
    }


}
