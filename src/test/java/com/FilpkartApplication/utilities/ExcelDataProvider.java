package com.FilpkartApplication.utilities;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;

public class ExcelDataProvider {

    public static Workbook book;
    public static Sheet sheet;

    public static Object[][] requiredData(String sheetName, String path) {

        FileInputStream file=null;
        try
        {
            file=new FileInputStream(path);
        }catch (FileNotFoundException e)
        {
            e.getMessage();
        }
        try
        {
            book=WorkbookFactory.create(file);
        }catch (InvalidFormatException i)
        {
            i.getMessage();
        }catch (IOException e)
        {
            e.getMessage();
        }
        sheet=book.getSheet(sheetName);
        Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i=0; i <sheet.getLastRowNum(); i++)
        {
            for (int j=0; j <sheet.getRow(0).getLastCellNum(); j++)
            {
                data[i][j]=sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }

}
