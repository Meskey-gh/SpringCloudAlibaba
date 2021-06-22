package com.study.user.Listener;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.google.common.collect.Lists;
import com.study.user.pojo.vo.UserVo;

import java.util.Date;
import java.util.List;

/**
 * @author 刘祖鸿
 */
public class ExcelHandleListener extends AnalysisEventListener {


    List list = Lists.newArrayList();

    /**
     * 每解析一行，回调该方法
     * @param data
     * @param context
     */
    @Override
    public void invoke(Object data, AnalysisContext context) {
        String userName = ((UserVo) data).getUserName();
        if (StringUtils.isEmpty(userName)) {
            throw new RuntimeException(String.format("第%s行MIS编码为空，请核实", context.readRowHolder().getRowIndex() + 1));
        }
        if (list.contains(userName)) {
            throw new RuntimeException(String.format("第%s行MIS编码已重复，请核实", context.readRowHolder().getRowIndex() + 1));
        } else {
            list.add(userName);
        }

        Date date = ((UserVo) data).getUpdateTime();
        Date nowDate = new Date();
        // 为1时  updateTime小于当前时间   为-1时updateTime大于当前时间
        if (nowDate.compareTo(date) == -1) {
            throw new RuntimeException(String.format("第%s行修改时间必须在当前时间之前，请核实", context.readRowHolder().getRowIndex() + 1));
        }
    }

    /**
     * 出现异常回调
     * @param exception
     * @param context
     * @throws Exception
     */
    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        // ExcelDataConvertException:当数据转换异常的时候，会抛出该异常，此处可以得知第几行，第几列的数据
        if (exception instanceof ExcelDataConvertException) {
            Integer columnIndex = ((ExcelDataConvertException) exception).getColumnIndex() + 1;
            Integer rowIndex = ((ExcelDataConvertException) exception).getRowIndex() + 1;
            String message = "第" + rowIndex + "行，第" + columnIndex + "列" + "数据格式有误，请核实";
            throw new RuntimeException(message);
        } else if (exception instanceof RuntimeException) {
            throw exception;
        } else {
            super.onException(exception, context);
        }
    }

    /**
     * 解析完全部回调
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        list.clear();
    }
}
