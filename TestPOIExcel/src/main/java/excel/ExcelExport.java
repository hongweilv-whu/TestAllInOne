package excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.*;

/**
 * 导出复杂的Excel表格
 * Created by lvhw on 2016/7/23.
 */
public class ExcelExport {
    //10种订单状态
    private final int[] status = new int[]{0, 1, 2, 3, 4, 5};
    List<OrderReportVo> list = new ArrayList<>();

    public void ExcelExport() {

        OrderReportVo r1 = new OrderReportVo();
        r1.setMerchantName("NIKE");
        r1.setMerchantCode(1);
        r1.setMonth("2010-11");
        r1.setOrderStatus(0);
        r1.setOrderCount(0);
        r1.setCashAmount(0.00);
        r1.setComplaintCount(0);

        OrderReportVo r2 = new OrderReportVo();
        r2.setMerchantName("NIKE");
        r2.setMerchantCode(1);
        r2.setMonth("2010-11");
        r2.setOrderStatus(1);
        r2.setOrderCount(0);
        r2.setCashAmount(0.00);
        r2.setComplaintCount(0);

        OrderReportVo r3 = new OrderReportVo();
        r3.setMerchantName("NIKE");
        r3.setMerchantCode(1);
        r3.setMonth("2010-11");
        r3.setOrderStatus(2);
        r3.setOrderCount(3);
        r3.setCashAmount(0.00);
        r3.setComplaintCount(0);

        OrderReportVo r4 = new OrderReportVo();
        r4.setMerchantName("NIKE");
        r4.setMerchantCode(1);
        r4.setMonth("2010-11");
        r4.setOrderStatus(3);
        r4.setOrderCount(0);
        r4.setCashAmount(0.00);
        r4.setComplaintCount(0);

        OrderReportVo r5 = new OrderReportVo();
        r5.setMerchantName("NIKE");
        r5.setMerchantCode(1);
        r5.setMonth("2010-11");
        r5.setOrderStatus(4);
        r5.setOrderCount(0);
        r5.setCashAmount(0.00);
        r5.setComplaintCount(0);

        OrderReportVo r6 = new OrderReportVo();
        r6.setMerchantName("NIKE");
        r6.setMerchantCode(1);
        r6.setMonth("2010-11");
        r6.setOrderStatus(5);
        r6.setOrderCount(0);
        r6.setCashAmount(0.00);
        r6.setComplaintCount(5);

        list.add(r1);
        list.add(r2);
        list.add(r3);
        list.add(r4);
        list.add(r5);
        list.add(r6);

        OrderReportVo h1 = new OrderReportVo();
        h1.setMerchantName("红双喜");
        h1.setMerchantCode(2);
        h1.setMonth("2010-11");
        h1.setOrderStatus(0);
        h1.setOrderCount(0);
        h1.setCashAmount(0.00);
        h1.setComplaintCount(0);

        OrderReportVo h2 = new OrderReportVo();
        h2.setMerchantName("红双喜");
        h2.setMerchantCode(2);
        h2.setMonth("2010-11");
        h2.setOrderStatus(1);
        h2.setOrderCount(2);
        h2.setCashAmount(5495.00);
        h2.setComplaintCount(0);

        OrderReportVo h3 = new OrderReportVo();
        h3.setMerchantName("红双喜");
        h3.setMerchantCode(2);
        h3.setMonth("2010-11");
        h3.setOrderStatus(2);
        h3.setOrderCount(0);
        h3.setCashAmount(0.00);
        h3.setComplaintCount(0);

        OrderReportVo h4 = new OrderReportVo();
        h4.setMerchantName("红双喜");
        h4.setMerchantCode(2);
        h4.setMonth("2010-11");
        h4.setOrderStatus(3);
        h4.setOrderCount(0);
        h4.setCashAmount(0.00);
        h4.setComplaintCount(5);

        OrderReportVo h5 = new OrderReportVo();
        h5.setMerchantName("红双喜");
        h5.setMerchantCode(2);
        h5.setMonth("2010-11");
        h5.setOrderStatus(4);
        h5.setOrderCount(2);
        h5.setCashAmount(3297.00);
        h5.setComplaintCount(0);

        OrderReportVo h6 = new OrderReportVo();
        h6.setMerchantName("红双喜");
        h6.setMerchantCode(2);
        h6.setMonth("2010-11");
        h6.setOrderStatus(5);
        h6.setOrderCount(0);
        h6.setCashAmount(0.00);
        h6.setComplaintCount(13);

        list.add(h1);
        list.add(h2);
        list.add(h3);
        list.add(h4);
        list.add(h5);
        list.add(h6);

    }

    public void export() throws IOException {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();
        this.initSheet(sheet);//初始化sheet，设置列数和每列宽度
        HSSFCellStyle centerStyle = wb.createCellStyle();//设置为水平居中
        centerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        centerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        this.initHeader(sheet, centerStyle);//初始化头部为水平居中
        //List list = list;
        int orderCount = 0;
        int INTEGRAL = 0;
        double cash = 0;
        int complaintCount = 0;
        //整理数据
        Map<String, Map<Integer, OrderReportVo>> map = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            OrderReportVo vo = list.get(i);
            orderCount += vo.getOrderCount();
            cash += vo.getCashAmount();
            complaintCount += vo.getComplaintCount();
            String key = vo.getMerchantCode() + vo.getMonth();
            Map<Integer, OrderReportVo> tempMap = map.get(key);
            if (tempMap == null) {
                tempMap = new HashMap<>();
                OrderReportVo tempVo = new OrderReportVo();
                tempVo.setMerchantName(vo.getMerchantName());
                tempVo.setCashAmount(0.0);
                tempVo.setOrderCount(0);
                tempVo.setMonth(vo.getMonth());
                tempVo.setComplaintCount(0);

                for (int j = 0; j < status.length; j++) {
                    tempMap.put(status[j], tempVo);
                }
                map.put(key, tempMap);
            }
            tempMap.put(vo.getOrderStatus(), vo);
        }
        int rowNumPerMerchant = 7;//每个商家一个月的统计记录占11个表格，10个订单状态+1个全部（统计）
        int rowNum = 0;
        int merchantCount = 0;//记录数

        HSSFCellStyle rightStyle = wb.createCellStyle();//水平靠右
        rightStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
        rightStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        //按要求创建各单元格
        for (Map<Integer, OrderReportVo> report : map.values()) {
            merchantCount++;
            HSSFRow row = sheet.createRow(++rowNum);
            OrderReportVo vo0 = report.get(0);
            int OrderCountPerMerchant = vo0.getOrderCount();
            int ComplaintCountPerMerchant = vo0.getComplaintCount();
            double CashAmountPerMerchant = vo0.getCashAmount();

            this.createCell(row, 0, vo0.getMerchantName(), centerStyle);
            this.createCell(row, 1, vo0.getMonth(), centerStyle);
            sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum + 6, 0, 0));
            sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum + 6, 1, 1));
            //sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum + 6, 5, 5));
            this.createCell(row, 2, orderStatusToString(0), centerStyle);
            this.createCell(row, 3, vo0.getOrderCount(), rightStyle);
            this.createCell(row, 4, nf.format(vo0.getCashAmount()), rightStyle);

            //循环按订单状态设置单元格，（i从1开始）
            for (int i = 1; i < status.length; i++) {
                OrderReportVo vo = report.get(status[i]);
                OrderCountPerMerchant += vo.getOrderCount();
                ComplaintCountPerMerchant += vo.getComplaintCount();
                CashAmountPerMerchant += vo.getCashAmount();

                HSSFRow row2 = sheet.createRow(++rowNum);
                this.createCell(row2, 2, orderStatusToString(status[i]), centerStyle);//订单状态
                this.createCell(row2, 3, vo.getOrderCount(), rightStyle);//订单数量
                //this.createCell(row2, 4, vo2.getIntegralAmount(), rightStyle);
                this.createCell(row2, 4, nf.format(vo.getCashAmount()), rightStyle);//现金总额
            }
            HSSFRow allrow = sheet.createRow(++rowNum);
            this.createCell(allrow, 2, "全部", centerStyle);
            this.createCell(allrow, 3, OrderCountPerMerchant, rightStyle);
            //this.createCell(row, 4, INTEGRAL, rightStyle);
            this.createCell(allrow, 4, nf.format(CashAmountPerMerchant), rightStyle);
            int rowIndex = (merchantCount - 1) * rowNumPerMerchant;//计算投诉件数单元格的行数位置
            HSSFRow row0 = sheet.createRow(rowIndex + 1);
            this.createCell(row0, 5, ComplaintCountPerMerchant, centerStyle);//投诉件数
            sheet.addMergedRegion(new CellRangeAddress(rowIndex + 1, rowIndex + 7, 5, 5));


            this.createCell(row0, 0, "lvhongwei", centerStyle);//投诉件数
            this.createCell(row0, 1, "2010-11", centerStyle);//投诉件数

        }
        //底部总结单元格
        HSSFRow row = sheet.createRow(++rowNum);
        this.createCell(row, 2, "总和", centerStyle);
        this.createCell(row, 3, orderCount, rightStyle);
        //this.createCell(row, 4, INTEGRAL, rightStyle);
        this.createCell(row, 4, nf.format(cash), rightStyle);
        this.createCell(row, 5, complaintCount, centerStyle);//投诉件数

        OutputStream os = new FileOutputStream(new File("E:/my.xls"));

        wb.write(os);
    }

    //初始化sheet，设置列数和每列宽度
    private void initSheet(HSSFSheet sheet) {
        sheet.setColumnWidth((short) 0, (short) (35.7 * 150));
        sheet.setColumnWidth((short) 1, (short) (35.7 * 100));
        sheet.setColumnWidth((short) 2, (short) (35.7 * 150));
        sheet.setColumnWidth((short) 3, (short) (35.7 * 60));
        sheet.setColumnWidth((short) 4, (short) (35.7 * 120));
        sheet.setColumnWidth((short) 5, (short) (35.7 * 120));
    }


    private void initHeader(HSSFSheet sheet, HSSFCellStyle style) {
        HSSFRow row1 = sheet.createRow((short) 0);
        createCell(row1, 0, "商户名称", style);
        createCell(row1, 1, "月份", style);
        createCell(row1, 2, "订单状态", style);
        createCell(row1, 3, "订单数量", style);
        createCell(row1, 4, "现金总额(元)", style);
        createCell(row1, 5, "投诉件数", style);
    }

    private void createCell(HSSFRow row, int column, Object value, HSSFCellStyle style) {
        HSSFCell cell = row.createCell((short) column);
        cell.setCellValue(String.valueOf(value));
        cell.setCellStyle(style);
    }

    private String orderStatusToString(int code) {
        switch (code) {
            case 0:
                return "未支付";
            case 1:
                return "支付中";
            case 2:
                return "待发货";
            case 3:
                return "已发货";
            case 4:
                return "已签收";
            case 5:
                return "已支付";
            case 6:
                return "已完结";
            case -1:
                return "已取消";
            case -2:
                return "已退费";
            case -3:
                return "未核实";
            default:
                return null;
        }

    }

    public static void main(String[] args) {
        ExcelExport ee = new ExcelExport();
        try {
            ee.export();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

