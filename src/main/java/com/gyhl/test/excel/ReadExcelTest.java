package com.gyhl.test.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

//读取Excel
public class ReadExcelTest {

    public static void main(String[] args) {

        ReadExcelTest excelTest=new ReadExcelTest();

        Workbook wb = excelTest.getExcel("C:\\Users\\wangna\\Desktop\\观点管线数据\\北京化一//SCL.xlsx");

        if(wb==null)
            System.out.println("文件读入出错");
        else {
            excelTest.analyzeExcel(wb);
        }

    }

    public Workbook getExcel(String filePath){
        Workbook wb=null;
        File file=new File(filePath);
        if(!file.exists()){
            System.out.println("文件不存在");
            wb=null;
        }
        else {
            String fileType=filePath.substring(filePath.lastIndexOf("."));//获得后缀名
            try {
                InputStream is = new FileInputStream(filePath);
                if(".xls".equals(fileType)){
                    wb = new HSSFWorkbook(is);
                }else if(".xlsx".equals(fileType)){
                    wb = new XSSFWorkbook(is);
                }else{
                    System.out.println("格式不正确");
                    wb=null;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return wb;
    }

    public void analyzeExcel(Workbook wb){
        Sheet sheet=wb.getSheetAt(0);//读取sheet(从0计数)
        int rowNum=sheet.getLastRowNum();//读取行数(从0计数)
        for(int i=0;i<=rowNum;i++){
            Row row=sheet.getRow(i);//获得行
            System.out.println("rowNum-----="+rowNum+"当前行-----="+i);
            int colNum=row.getLastCellNum();//获得当前行的列数
            for(int j=0;j<colNum;j++){
            	System.out.println("rowNum-----="+colNum+"当前列-----="+j);
                Cell cell=row.getCell(j);//获取单元格
                if(cell==null)
                    System.out.print("null     ");
                else
                    System.out.print(cell.toString()+"     ");
            }
            System.out.println();
        }
    }

}
