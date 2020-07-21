package com.hangyu.platform.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.hangyu.platform.global.ExcelExportMyStylerImpl;
import com.hangyu.platform.global.PlatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;


/**
 * @ClassName: ExcelExportUtil
 * @Description: Excel导出工具类
 * @Author: 刘轩
 * @Date: 2019/12/17 14:49
 **/
public class MyExcelExportUtil {

    private static Logger logger = LoggerFactory.getLogger(MyExcelExportUtil.class);

    /**
     * Excel文件导出,导出的文件名默认为:headTitle+当前系统时间
     * @param listData 要导出的list数据
     * @param pojoClass 定义excel属性信息
     * @param headTitle Excel文件头信息
     * @param sheetName Excel文件sheet名称
     * @param response
     */
    public static void exportExcel(Collection<?> listData,Class<?> pojoClass, String headTitle, String sheetName, HttpServletResponse response) {
        ExportParams params = new ExportParams(headTitle, sheetName);
        params.setHeight((short) 8);
        params.setStyle(ExcelExportMyStylerImpl.class);
        try {
            Workbook workbook = ExcelExportUtil.exportExcel(params, pojoClass, listData);
            String fileName = headTitle + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            fileName = URLEncoder.encode(fileName, "UTF8");
            //清空response
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+fileName + ".xls");
            ServletOutputStream out=response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();
            logger.info("success export {}",fileName);
        } catch (Exception e) {
            throw new PlatException("导出失败!");
        }
    }
}