package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.jni.Time;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gyhl.test.entity.User;
import com.gyhl.test.mapper.UserMapper;


@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SpringBoot01Test2ApplicationTests {

	/*
	 * @Autowired private UserMapper um;
	 */
	@Test
	void operExecl() throws IOException {
		Workbook wb=null;
		String filePath="C:\\Users\\wangna\\Desktop\\观点管线数据\\北京化一//完成表.xlsx";
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
        
        //创建execl
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet2 = workbook.createSheet("信息表");
//        Row row2=sheet2.createRow(0);
//        row2.createCell(0).setCellValue("a");
              
    
        
        Sheet sheet=wb.getSheetAt(0);//读取sheet(从0计数)
        int rowNum=sheet.getLastRowNum();//读取行数(从0计数)
        int jishujun=0;
        for(int i=1;i<=rowNum;i++) {    //从第二行开始读
        	 Row row=sheet.getRow(i);//获得行
        	 int colNum=row.getLastCellNum();
        	 Row rowWrite=sheet2.createRow(jishujun);
        	 jishujun++;
        	 Row rowWritetwo=sheet2.createRow(jishujun);
        	 jishujun++;
        	 rowWrite.createCell(26).setCellValue("第"+i+"条线");
        	 rowWrite.createCell(27).setCellValue(1);
        	 rowWritetwo.createCell(26).setCellValue("第"+i+"条线");
        	 rowWritetwo.createCell(27).setCellValue(2);
        	 for (int j=0;j<colNum;j++) {
        		 Cell cell=row.getCell(j);
        		 if(j<24) {
        			 
            		 if(cell==null) {
                  	   System.out.print("null     ");
                  	   //row2.createCell(j).setCellValue();
                  	 }
                   else {
                  	 System.out.print(cell.toString()+"     ");
                  	 rowWrite.createCell(j).setCellValue(cell.toString());
                  	 rowWritetwo.createCell(j).setCellValue(cell.toString());
                   }
        		 }else {
                     if(j<26) {
                    	
                    	 rowWrite.createCell(j).setCellValue(cell.toString());
                     }else {
                    	 if(j==26) {
                    		 rowWritetwo.createCell(24).setCellValue(cell.toString());
                    	 }else {
                    		 rowWritetwo.createCell(25).setCellValue(cell.toString());
                    	 }
                    	 
                     }
        			 
        		 }
        		
        		 
        	 }
        	 
//             int colNum=row.getLastCellNum();//获得当前行的列数
//             Row rowWrite=sheet2.createRow(i);
//             Row rowWriteTwo=sheet2.createRow((i-1)*2);
//             for(int j=0;j<colNum;j++){
//                 Cell cell=row.getCell(j);//获取单元格，从O开始计数
//                
//                 if(cell==null) {
//                	   System.out.print("null     ");
//                	   //row2.createCell(j).setCellValue();
//                	 }
//                 else {
//                	 System.out.print(cell.toString()+"     ");
//                	 rowWrite.createCell(j).setCellValue(cell.toString());
//                	 rowWrite.createCell(j).setCellValue(cell.toString());
//                 }
//                
//             }
//             System.out.println();  
        }
       
        
        //设置文件名
        String savePath ="E:\\碑林区.gdb//完成表输出.xls";
        OutputStream fileOut = new FileOutputStream(savePath);
        workbook.write(fileOut);
        fileOut.close();

	}
	
	@Test
	void operExecl2() throws IOException {
		Workbook wb=null;
		String filePath="E:\\\\碑林区.gdb//完成表输出.xls";
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
        
        //创建execl
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet2 = workbook.createSheet("信息表");
//        Row row2=sheet2.createRow(0);
//        row2.createCell(0).setCellValue("a");
              
    
        
        Sheet sheet=wb.getSheetAt(0);//读取sheet(从0计数)
        int rowNum=sheet.getLastRowNum();//读取行数(从0计数)
        int jishujun=0;
        for(int i=1;i<=rowNum;i++) {    //从第二行开始读
        	 Row row=sheet.getRow(i);//获得行
        	 int colNum=row.getLastCellNum();
        	 Row rowWrite=sheet2.createRow(jishujun);
        	 jishujun++;
        	 Row rowWritetwo=sheet2.createRow(jishujun);
        	 jishujun++;
        	 rowWrite.createCell(26).setCellValue("第"+i+"条线");
        	 rowWrite.createCell(27).setCellValue(1);
        	 rowWritetwo.createCell(26).setCellValue("第"+i+"条线");
        	 rowWritetwo.createCell(27).setCellValue(2);
        	 for (int j=0;j<colNum;j++) {
        		 Cell cell=row.getCell(j);
        		 if(j<24) {
        			 
            		 if(cell==null) {
                  	   System.out.print("null     ");
                  	   //row2.createCell(j).setCellValue();
                  	 }
                   else {
                  	 System.out.print(cell.toString()+"     ");
                  	 rowWrite.createCell(j).setCellValue(cell.toString());
                  	 rowWritetwo.createCell(j).setCellValue(cell.toString());
                   }
        		 }else {
                     if(j<26) {
                    	
                    	 rowWrite.createCell(j).setCellValue(cell.toString());
                     }else {
                    	 if(j==26) {
                    		 rowWritetwo.createCell(24).setCellValue(cell.toString());
                    	 }else {
                    		 rowWritetwo.createCell(25).setCellValue(cell.toString());
                    	 }
                    	 
                     }
        			 
        		 }
        		
        		 
        	 }
        	 
//             int colNum=row.getLastCellNum();//获得当前行的列数
//             Row rowWrite=sheet2.createRow(i);
//             Row rowWriteTwo=sheet2.createRow((i-1)*2);
//             for(int j=0;j<colNum;j++){
//                 Cell cell=row.getCell(j);//获取单元格，从O开始计数
//                
//                 if(cell==null) {
//                	   System.out.print("null     ");
//                	   //row2.createCell(j).setCellValue();
//                	 }
//                 else {
//                	 System.out.print(cell.toString()+"     ");
//                	 rowWrite.createCell(j).setCellValue(cell.toString());
//                	 rowWrite.createCell(j).setCellValue(cell.toString());
//                 }
//                
//             }
//             System.out.println();  
        }
       
        
        //设置文件名
        String savePath ="E:\\碑林区.gdb//完成表输出.xls";
        OutputStream fileOut = new FileOutputStream(savePath);
        workbook.write(fileOut);
        fileOut.close();

	}
	
	
	
	
	@Test
	void contextLoads() {
	 Date ddDate=new Date();
	 System.out.println(ddDate.getTime());
	 
	 String aaString="asdas-aeadg-xxx-zz-x-xxxx";
	 String[] argStrings=aaString.split("-");
	 System.out.println(argStrings.length);
	}

	@Autowired
	private UserMapper um;

	@Test
	 void contextLodaads() {

		User u1 = new User();
		u1.setId(1);
		u1.setName("zzz");

		try {
			um.insert(u1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	
	
	@Test
	void excel() {
		
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		System.out.println(a.size());
	}
}
