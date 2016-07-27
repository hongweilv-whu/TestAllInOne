package excel;

import com.google.common.base.Joiner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.sun.glass.ui.Size;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:测试BI分组导出复杂（多个分组多个聚合）报表Excel数据
 * Created by lvhw on 2016/7/25 11:31.
 */
public class ExportBIComplexReport {

    private List<Map<String, Object>> dataList = new ArrayList<>();
    private int groupFieldsCount = 1;
    private List<String> headList = new ArrayList<>();

    private List<String> groupFields = new ArrayList<>();
    private int groupFieldSize = 0;

    private List<String> aggregationFields = new ArrayList<>();

    // 聚合字段，及其在所有字段中的索引位置
    private Map<String, Integer> aggregationFieldIndex = new HashMap<>();

    public ExportBIComplexReport() {
        String field1 = "员工姓名";
        //String field2 = "商机状态";
        String field2 = "商机类型";
        String field3 = "商机名称";
        String field4 = "客户名称";

        headList.add(field1);
        headList.add(field2);
        headList.add(field3);
        headList.add(field4);

        // 分组字段
        groupFields.add(field1);
        groupFields.add(field2);
        //groupFields.add(field3);
        //groupFields.add(field4);

        // 聚合字段
        aggregationFields.add(field3);
        aggregationFields.add(field4);

        for (String aggregationField : aggregationFields) {
            int idx = headList.indexOf(aggregationField);
            if (-1 != idx) {
                aggregationFieldIndex.put(aggregationField, idx);
            }
        }

        groupFieldSize = groupFields.size();

        Map<String, Object> leomap1 = new HashMap<>();
        leomap1.put(field1, "LEO");
        leomap1.put(field2, "赢单");
        leomap1.put(field3, "111");
        leomap1.put(field4, "google");

        Map<String, Object> leomap1Sum1 = new HashMap<>();
        leomap1Sum1.put(field1, "");
        leomap1Sum1.put(field2, "");
        leomap1Sum1.put(field3, "COUNT:1");
        leomap1Sum1.put(field4, "");

        Map<String, Object> leomap1Sum2 = new HashMap<>();
        leomap1Sum2.put(field1, "");
        leomap1Sum2.put(field2, "");
        leomap1Sum2.put(field3, "");
        leomap1Sum2.put(field4, "COUNT:1");

        Map<String, Object> leomap2 = new HashMap<>();
        leomap2.put(field1, "LEO");
        leomap2.put(field2, "输单");
        leomap2.put(field3, "112");
        leomap2.put(field4, "百度");

        /*Map<String, Object> leomap3 = new HashMap<>();
        leomap3.put(field1, "LEO");
        leomap3.put(field2, "输单");
        leomap3.put(field3, "112");
        leomap3.put(field4, "小米");*/

        Map<String, Object> leomap2Sum1 = new HashMap<>();
        leomap2Sum1.put(field1, "");
        leomap2Sum1.put(field2, "");
        leomap2Sum1.put(field3, "COUNT:1");
        leomap2Sum1.put(field4, "");

        Map<String, Object> leomap2Sum2 = new HashMap<>();
        leomap2Sum2.put(field1, "");
        leomap2Sum2.put(field2, "");
        leomap2Sum2.put(field3, "");
        leomap2Sum2.put(field4, "COUNT:1");


        Map<String, Object> linxlmap1 = new HashMap<>();
        linxlmap1.put(field1, "linxl");
        linxlmap1.put(field2, "赢单");
        linxlmap1.put(field3, "113");
        linxlmap1.put(field4, "娃哈哈");

        Map<String, Object> linxlmap2 = new HashMap<>();
        linxlmap2.put(field1, "linxl");
        linxlmap2.put(field2, "赢单");
        linxlmap2.put(field3, "114");
        linxlmap2.put(field4, "农夫山泉");

        Map<String, Object> linxlmap12Sum1 = new HashMap<>();
        linxlmap12Sum1.put(field1, "");
        linxlmap12Sum1.put(field2, "");
        linxlmap12Sum1.put(field3, "COUNT:2");
        linxlmap12Sum1.put(field4, "");

        Map<String, Object> linxlmap12Sum2 = new HashMap<>();
        linxlmap12Sum2.put(field1, "");
        linxlmap12Sum2.put(field2, "");
        linxlmap12Sum2.put(field3, "");
        linxlmap12Sum2.put(field4, "COUNT:2");

        Map<String, Object> linxlmap3 = new HashMap<>();
        linxlmap3.put(field1, "linxl");
        linxlmap3.put(field2, "输单");
        linxlmap3.put(field3, "115");
        linxlmap3.put(field4, "百事");

        Map<String, Object> linxlmap3Sum1 = new HashMap<>();
        linxlmap3Sum1.put(field1, "");
        linxlmap3Sum1.put(field2, "");
        linxlmap3Sum1.put(field3, "COUNT:1");
        linxlmap3Sum1.put(field4, "");

        Map<String, Object> linxlmap3Sum2 = new HashMap<>();
        linxlmap3Sum2.put(field1, "");
        linxlmap3Sum2.put(field2, "");
        linxlmap3Sum2.put(field3, "");
        linxlmap3Sum2.put(field4, "COUNT:1");

        dataList.add(leomap1);
        dataList.add(leomap1Sum1);
        dataList.add(leomap1Sum2);
        dataList.add(leomap2);
        ////dataList.add(leomap3);
        dataList.add(leomap2Sum1);
        dataList.add(leomap2Sum2);

        dataList.add(linxlmap1);
        dataList.add(linxlmap2);
        dataList.add(linxlmap12Sum1);
        dataList.add(linxlmap12Sum2);

        dataList.add(linxlmap3);
        dataList.add(linxlmap3Sum1);
        dataList.add(linxlmap3Sum2);
    }

    public void exportExcelDataSet() {

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("导出复杂分组报表数据");
        this.initSheetColumnWidth(sheet);

        HSSFCellStyle centerStyle = wb.createCellStyle();
        centerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        centerStyle.setAlignment(CellStyle.ALIGN_CENTER);
        this.initHeader(sheet, centerStyle);

        /*HSSFCellStyle rightStyle = wb.createCellStyle();
        rightStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        rightStyle.setAlignment(CellStyle.ALIGN_RIGHT);*/

        HSSFCellStyle leftStyle = wb.createCellStyle();
        leftStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        leftStyle.setAlignment(CellStyle.ALIGN_LEFT);


        HSSFCellStyle sumStyle = wb.createCellStyle();
        sumStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        sumStyle.setAlignment(CellStyle.ALIGN_LEFT);
        sumStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex()); // 设置用于填充的前景颜色
        sumStyle.setFillPattern(CellStyle.SOLID_FOREGROUND); // 用前景色实色填充

        //List<String> groupFieldNames = groupFields;

        // 记录各分组字段，合并单元格的起始位置
        int[] grpItemStartIdxs = new int[groupFieldSize];
        // 记录各分组字段，需要合并的单元格的数量
        int[] grpItemCounts = new int[groupFieldSize];

        Map<String, Object> firstRecord = dataList.get(0);
        List<String> firstValues = new ArrayList<>();
        for (int m = 0; m < groupFieldSize; m++) {
            firstValues.add(firstRecord.get(groupFields.get(m)).toString());
            // 初始化合并单元格的起始位置为1
            grpItemStartIdxs[m] = 1;
        }
        // 待比较字段，由第一行各分组字段的值拼接而成
        // 从第1行开始，每一行都会计算出一个值，与该参考值对比
        // 如果相等，表明该行与第一行是同一个分组；
        // 如果不相等，表明该行是一个新的分组，此时需要对前面各行中的最后一个分组字段所在列合并单元格，
        // 最后一个分组字段之前的字段合并单元格，并做其他内容的更新
        String groupFieldValues = Joiner.on(",").join(firstValues);

        // 遍历记录集
        for (int i = 0, recordSize = dataList.size(); i < recordSize; i++) {
            Map<String, Object> oneRecord = dataList.get(i);

            // 从第1行开始创建内容Row，第0行为表头Row
            int rowIndex = i + 1;

            // 创建表格的一行，并设置各列的值、样式
            HSSFRow row = sheet.createRow(rowIndex);
            for (int k = 0, size = headList.size(); k < size; k++) {
                this.createCell(row, k, oneRecord.get(headList.get(k)), 0 == k ? centerStyle : leftStyle);
            }

            // 计算每一行，各分组字段列的值，拼接结果
            List<String> v = new ArrayList<>();
            for (int m = 0; m < groupFieldSize; m++) {
                v.add(oneRecord.get(groupFields.get(m)).toString());
            }
            String rowGrpFieldsValues = Joiner.on(",").join(v);

            // 同一组
            if (groupFieldValues.equals(rowGrpFieldsValues)) {
                for (int k = 0; k < groupFieldSize; k++) {
                    // 各个分组字段计数增1
                    grpItemCounts[k] = (++grpItemCounts[k]);
                }
            } else {

                // 另起一组的记录
                for (int tt = groupFieldSize - 1; 0 <= tt; tt--) {

                    List<String> lessOneValues = new ArrayList<>();
                    for (int mm = tt; 0 <= mm; mm--) {
                        lessOneValues.add(0, oneRecord.get(groupFields.get(mm)).toString());
                    }
                    String lessValues = Joiner.on(",").join(lessOneValues);

                    // 不等，表明该字段另起分组
                    if (!StringUtils.contains(groupFieldValues, lessValues)) {
                        int startIdx = grpItemStartIdxs[tt];
                        int itemCount = grpItemCounts[tt];
                        this.addOneGroupFieldMergedRegion(sheet, startIdx, itemCount, tt);

                        // 合并总计类单元格，从分组字段往后全部合并
                        // 无法克服的缺点：对单行多列合并单元格后，现在中间某列设置，无法实现
                        /*int columnStartIndex = aggregationFieldIndex.get(aggregationFields.get(0));
                        sheet.addMergedRegion(new CellRangeAddress(startIdx + itemCount - 1,
                                startIdx + itemCount - 1, columnStartIndex, headList.size() - 1));*/


                        //this.addAllAggregationFieldMergedRegion(sheet, startIdx, itemCount, sumStyle);
                       /* HSSFRow rowSum = sheet.createRow(rowIndex - 1);
                        Map<String, Object> sumRecord = dataList.get(rowIndex - 2);
                        this.createCell(rowSum, columnStartIndex, sumRecord.get(aggregationFields.get(0)), leftStyle);*/

                        /*for (int g = 0, size = aggregationFields.size(); g < size; g++) {
                            int columnStartIndex = aggregationFieldIndex.get(aggregationFields.get(g));
                            int columnEndIndex = headList.size() - 1;
                            //int curRowIndex = startIndex + rowCount - (size - g);
                            int columnStartIndex = startIdx + itemCount - (size - g);
                            this.createCell(rowSum, columnStartIndex, sumRecord.get(aggregationFields.get(0)), leftStyle);
                        }*/


                        grpItemStartIdxs[tt] = rowIndex;
                        grpItemCounts[tt] = 1;
                    } else {
                        // 分组字段合并个数增1
                        grpItemCounts[tt] = (++grpItemCounts[tt]);
                    }
                }

                // 赋予新的值，即新的分组，继续后续比较
                List<String> newValues = new ArrayList<>();
                for (int t = 0; t < groupFieldSize; t++) {
                    newValues.add(oneRecord.get(groupFields.get(t)).toString());
                }
                groupFieldValues = Joiner.on(",").join(newValues);
            }
        }

        // 最后的合并
        for (int tt = groupFieldSize - 1; 0 <= tt; tt--) {
            int startIdx = grpItemStartIdxs[tt];
            int itemCount = grpItemCounts[tt];
            this.addOneGroupFieldMergedRegion(sheet, startIdx, itemCount, tt);
            //this.addOneGroupFieldMergedRegion(sheet, grpItemStartIdxs[tt], grpItemCounts[tt], tt);


            //this.addAllAggregationFieldMergedRegion(sheet, startIdx, itemCount, sumStyle);
        }

        try {
            OutputStream os = new FileOutputStream(new File("E:/bi_export_complex.xls"));
            wb.write(os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对一个分组字段就行合并单元格
     *
     * @param sheet      Excel表单
     * @param startIndex 合并区域的起始位置
     * @param rowCount   合并的行数
     * @param column     列的位置，第一列和最后一列是同一列
     */
    private void addOneGroupFieldMergedRegion(HSSFSheet sheet, int startIndex, int rowCount, int column) {
        int fr = startIndex;
        int lr = startIndex + rowCount - 1;
        if (fr < lr) {
            sheet.addMergedRegion(new CellRangeAddress(fr, lr, column, column));
        }
    }

    /**
     * 合并所有的聚合字段的单元格
     *
     * @param sheet      Excel表单
     * @param startIndex ?
     * @param rowCount   ?
     */
    private void addAllAggregationFieldMergedRegion(HSSFSheet sheet, int startIndex, int rowCount, HSSFCellStyle sumStyle) {
        for (int g = 0, size = aggregationFields.size(); g < size; g++) {
            int columnStartIndex = aggregationFieldIndex.get(aggregationFields.get(g));
            int columnEndIndex = headList.size() - 1;
            int curRowIndex = startIndex + rowCount - (size - g);
            // 合并该聚合字段及其之后的单元格
            /*if (columnStartIndex < columnEndIndex)
                sheet.addMergedRegion(new CellRangeAddress(curRowIndex, curRowIndex,
                        columnStartIndex, columnEndIndex));*/

            HSSFRow sumRow = sheet.getRow(curRowIndex);
            for (int i=groupFieldSize; i<headList.size(); i++){
                sumRow.getCell(i).setCellStyle(sumStyle);
            }
            /*// 合并该聚合字段之前，分组字段之后的单元格
            int preStart = groupFields.size();
            int preEnd = */
        }
    }

    // 初始化sheet，每列宽度
    private void initSheetColumnWidth(HSSFSheet sheet) {
        for (int j = 0, size = headList.size(); j < size; j++) {
            sheet.setColumnWidth((short) j, (short) (35.7 * 100));
        }
    }

    // 初始化表头
    private void initHeader(HSSFSheet sheet, HSSFCellStyle style) {
        HSSFRow row0 = sheet.createRow((short) 0);
        for (int i = 0, size = headList.size(); i < size; i++) {
            createCell(row0, i, headList.get(i), style);
        }
    }

    private void createCell(HSSFRow row, int column, Object value, HSSFCellStyle style) {
        HSSFCell cell = row.createCell((short) column);
        cell.setCellValue(String.valueOf(value));
        cell.setCellStyle(style);
    }

    public static void main(String[] args) {
        ExportBIComplexReport biReport = new ExportBIComplexReport();
        biReport.exportExcelDataSet();
    }
}
