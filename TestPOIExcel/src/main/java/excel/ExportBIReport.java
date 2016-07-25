package excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:测试BI分组导出报表Excel数据
 * Created by lvhw on 2016/7/25 11:31.
 */
public class ExportBIReport {
    
    private List<Map<String, Object>> dataList = new ArrayList<>();
    private int groupFieldsCount = 1;
    private List<String> headList = new ArrayList<>();

    private List<String> groupFields = new ArrayList<>();

    private List<String> aggregationFields = new ArrayList<>();

    public ExportBIReport() {
        headList.add("员工姓名");
        headList.add("客户名称");
        headList.add("客户级别");
        headList.add("成交状态");

        groupFields.add("员工姓名");
        aggregationFields.add("客户名称");

        Map<String, Object> leomap1 = new HashMap<>();
        leomap1.put("员工姓名", "LEO");
        leomap1.put("客户名称", "google");
        leomap1.put("客户级别", "VIP");
        leomap1.put("成交状态", "未成交");

        Map<String, Object> leomap2 = new HashMap<>();
        leomap2.put("员工姓名", "LEO");
        leomap2.put("客户名称", "百度");
        leomap2.put("客户级别", "重要");
        leomap2.put("成交状态", "多次成交");

        Map<String, Object> leomap3 = new HashMap<>();
        leomap3.put("员工姓名", "LEO");
        leomap3.put("客户名称", "小米");
        leomap3.put("客户级别", "重要");
        leomap3.put("成交状态", "多次成交");

        Map<String, Object> leomapSum = new HashMap<>();
        leomapSum.put("员工姓名", "LEO");
        leomapSum.put("客户名称", "COUNT:2");
        leomapSum.put("客户级别", "");
        leomapSum.put("成交状态", "");

        Map<String, Object> linxlmap1 = new HashMap<>();
        linxlmap1.put("员工姓名", "linxl");
        linxlmap1.put("客户名称", "娃哈哈");
        linxlmap1.put("客户级别", "重要");
        linxlmap1.put("成交状态", "已成交");

        Map<String, Object> linxlmap2 = new HashMap<>();
        linxlmap2.put("员工姓名", "linxl");
        linxlmap2.put("客户名称", "农夫山泉");
        linxlmap2.put("客户级别", "重要");
        linxlmap2.put("成交状态", "多次成交");

        Map<String, Object> linxlmap3 = new HashMap<>();
        linxlmap3.put("员工姓名", "linxl");
        linxlmap3.put("客户名称", "百事");
        linxlmap3.put("客户级别", "一般");
        linxlmap3.put("成交状态", "未成交");

        Map<String, Object> linxlmapSum = new HashMap<>();
        linxlmapSum.put("员工姓名", "linxl");
        linxlmapSum.put("客户名称", "COUNT:3");
        linxlmapSum.put("客户级别", "");
        linxlmapSum.put("成交状态", "");

        dataList.add(leomap1);
        dataList.add(leomap2);
        dataList.add(leomap3);
        dataList.add(leomapSum);

        dataList.add(linxlmap1);
        dataList.add(linxlmap2);
        dataList.add(linxlmap3);
        dataList.add(linxlmapSum);
    }

    public void exportExcelDataSet(){

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("导出分组报表数据");
        this.initSheetColumnWidth(sheet);

        HSSFCellStyle centerStyle = wb.createCellStyle();
        centerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        centerStyle.setAlignment(CellStyle.ALIGN_CENTER);
        this.initHeader(sheet, centerStyle);

        int rowCount = 0;

        int grpItemStartIdx = 0;
        int groupItemCount = 0;

        /*HSSFCellStyle rightStyle = wb.createCellStyle();
        rightStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        rightStyle.setAlignment(CellStyle.ALIGN_RIGHT);*/

        HSSFCellStyle leftStyle = wb.createCellStyle();
        leftStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        leftStyle.setAlignment(CellStyle.ALIGN_LEFT);

        // 1.如果结果集有分组字段，分组字段按照0,1,2...的顺序存放于groupFields
        // 取第一个


        // 考虑只有一个分组的情况

        String groupFieldName = groupFields.get(0);
        String groupFieldValue = dataList.get(0).get(groupFieldName).toString();
        grpItemStartIdx = 1;
        for (int i=0, recordSize=dataList.size(); i<recordSize; i++){
            Map<String, Object> oneRecord = dataList.get(i);

            int rowIndex = i + 1;
            // 创建表格的一行，并设置各列的值
            HSSFRow row = sheet.createRow(rowIndex);
            for (int k=0, size=headList.size(); k<size; k++){
                this.createCell(row, k, oneRecord.get(headList.get(k)), 0 == k ? centerStyle : leftStyle);
            }

            // 分组计数
            String recordGrpFieldValue = oneRecord.get(groupFieldName).toString();
            if (groupFieldValue.equals(recordGrpFieldValue)){
                groupItemCount++;
            }else {
                sheet.addMergedRegion(new CellRangeAddress(grpItemStartIdx, grpItemStartIdx + groupItemCount - 1, 0, 0));
                sheet.addMergedRegion(new CellRangeAddress(grpItemStartIdx + groupItemCount - 1, grpItemStartIdx + groupItemCount -1 , 1, headList.size() - 1));


                grpItemStartIdx = rowIndex;
                groupItemCount = 1;

                groupFieldValue = dataList.get(i).get(groupFieldName).toString();
            }
        }

        sheet.addMergedRegion(new CellRangeAddress(grpItemStartIdx, grpItemStartIdx + groupItemCount - 1, 0, 0));
        sheet.addMergedRegion(new CellRangeAddress(grpItemStartIdx + groupItemCount - 1, grpItemStartIdx + groupItemCount - 1, 1, headList.size() - 1));

        try {
            OutputStream os = new FileOutputStream(new File("E:/bi_export.xls"));
            wb.write(os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mergeRows(){

    }

    public void mergeColumns(){

    }

    //初始化sheet，每列宽度
    private void initSheetColumnWidth(HSSFSheet sheet) {
        for (int j=0, size=headList.size(); j<size; j++){
            sheet.setColumnWidth((short) j, (short) (35.7 * 100));
        }
    }


    private void initHeader(HSSFSheet sheet, HSSFCellStyle style) {
        HSSFRow row0 = sheet.createRow((short) 0);
        for (int i=0, size=headList.size(); i<size; i++) {
            createCell(row0, i, headList.get(i), style);
        }
    }

    private void createCell(HSSFRow row, int column, Object value, HSSFCellStyle style) {
        HSSFCell cell = row.createCell((short) column);
        cell.setCellValue(String.valueOf(value));
        cell.setCellStyle(style);
    }

    public static void main(String[] args) {
        ExportBIReport biReport = new ExportBIReport();
        biReport.exportExcelDataSet();
    }
}
