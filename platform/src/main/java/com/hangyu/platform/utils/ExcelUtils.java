package com.hangyu.platform.utils;

import com.hangyu.platform.global.PlatException;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * excel工具类
 */
public class ExcelUtils {

    /**
     * Excel表格导出
     *
     * @param response    HttpServletResponse对象
     * @param excelData   Excel表格的数据，封装为List<List<String>>
     * @param sheetName   sheet的名字
     * @param fileName    导出Excel的文件名
     * @param columnWidth Excel表格的宽度，建议为15
     * @throws IOException 抛IO异常
     */
    public static void exportExcel(HttpServletResponse response,
                                   List<List<String>> excelData,
                                   String sheetName,
                                   String fileName,
                                   int columnWidth) throws IOException {

        //声明一个工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        //生成一个表格，设置表格名称
        HSSFSheet sheet = workbook.createSheet(sheetName);

        //设置表格列宽度
        sheet.setDefaultColumnWidth(columnWidth);

        //写入List<List<String>>中的数据
        int rowIndex = 0;
        for (List<String> data : excelData) {
            //创建一个row行，然后自增1
            HSSFRow row = sheet.createRow(rowIndex++);

            //遍历添加本行数据
            for (int i = 0; i < data.size(); i++) {
                //创建一个单元格
                HSSFCell cell = row.createCell(i);

                //创建一个内容对象
                HSSFRichTextString text = new HSSFRichTextString(data.get(i));

                //将内容对象的文字内容写入到单元格中
                cell.setCellValue(text);
            }
        }

        //准备将Excel的输出流通过response输出到页面下载
        //八进制输出流
        response.setContentType("application/octet-stream");

        //设置导出Excel的名称
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);

        //刷新缓冲
        response.flushBuffer();

        //workbook将Excel写入到response的输出流中，供页面下载该Excel文件
        workbook.write(response.getOutputStream());

        //关闭workbook
        workbook.close();
    }


    /**
     * 方法名：importExcel
     * 功能：导入
     */
    public static List<Object[]> importExcel(MultipartFile file) {
        try {
            List<Object[]> list = new ArrayList<>();
            InputStream inputStream = file.getInputStream();
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            //获取sheet的行数
            int r = sheet.getPhysicalNumberOfRows();
            //王建伟：添加for循环，判断行是否为空
            int rows = 0;
            for (int j = 0; j < r; j++) {
                if (j == 0) {
                    continue;
                } else {
                    if (sheet.getRow(j) != null) {
                        rows++;
                    }
                }
            }
            //王建伟：修改i = 1；i<=，为了能够添加最后一条数据
            for (int i = 0; i <= rows; i++) {
                //过滤表头行
                if (i == 0) {
                    continue;
                }
                //获取当前行的数据
                Row row = sheet.getRow(i);
                Object[] objects = new Object[row.getPhysicalNumberOfCells()];
                int index = 0;
                for (Cell cell : row) {
                    if (null == cell){
                        objects[index] = null;
                    }
                    //数值型判断
                    if (cell.getCellType().equals(CellType.NUMERIC)) {
                        //日期类型
                        if (HSSFDateUtil.isCellDateFormatted(cell)) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            objects[index] = sdf.format(cell.getDateCellValue());
                        } else {
                            //数字
                            objects[index] = cell.getNumericCellValue();
                        }
                    }
                    if (cell.getCellType().equals(CellType.STRING)) {
                        objects[index] = cell.getStringCellValue();
                    }
                    index++;
                }
                list.add(objects);
            }
            return list;
        } catch (Exception e) {
            throw new PlatException("导入失败");
        }
    }


    /**
     * 日期格式转化类
     *
     * @param cell
     * @return
     */
    private static String getDateFormate(Cell cell) {
        int dformat = cell.getCellStyle().getDataFormat();
        SimpleDateFormat sdf = null;
        if (Arrays.asList(14, 178, 192, 194, 208, 196, 210).contains(dformat)) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        } else if (Arrays.asList(190, 191).contains(dformat)) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        } else if (Arrays.asList(177, 182, 185).contains(dformat)) {
            sdf = new SimpleDateFormat("yyyy年MM月dd日");
        } else if (Arrays.asList(183, 186).contains(dformat)) {
            sdf = new SimpleDateFormat("yyyy年MM月");
        } else if (Arrays.asList(183, 200, 201, 202, 203).contains(dformat)) {
            sdf = new SimpleDateFormat("HH:mm");
        } else if (Arrays.asList(204, 205, 206, 207, 208).contains(dformat)) {
            sdf = new SimpleDateFormat("HH时mm分");
        } else if (Arrays.asList(184, 187).contains(dformat)) {
            sdf = new SimpleDateFormat("MM月dd日");
        } else {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }
        return sdf.format(cell.getDateCellValue());

    }

}
