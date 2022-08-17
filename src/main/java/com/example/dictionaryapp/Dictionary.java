//package com.example.dictionaryapp;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class Dictionary {
//
//    public static void main(String[] args)
//    {
//        Dictionary dic = new Dictionary();   //object of the class
////reading the value of 2nd row and 2nd column
//        List<String> ingWordList = new ArrayList<>();
//        List<String> trWordList = new ArrayList<>();
//        for (int i = 1; i <50; i++) {
//            String vOutput=dic.ReadCellData(i, 0);
//            ingWordList.add(vOutput);
//        }
//        System.out.println(ingWordList);
//        for (int i = 1; i < 50; i++) {
//            String vOutput=dic.ReadCellData(i, 1);
//            trWordList.add(vOutput);
//
//        }
//        System.out.println(trWordList);
//
//        HashMap<List<String>,List<String>> hashMap = new HashMap<>();
//        hashMap.put(ingWordList,trWordList);
//        System.out.println(hashMap.keySet());
//        System.out.println(hashMap.get("kullanım dışı"));
//    }
//
//
//    public String ReadCellData(int vRow, int vColumn)
//    {
//        String value=null;          //variable for storing the cell value
//        Workbook wb=null;           //initialize Workbook null
//        try
//        {
////reading data from a file in the form of bytes
//            FileInputStream fis=new FileInputStream("C:\\Users\\guven\\Downloads\\İNG KELİME.xlsx");
////constructs an XSSFWorkbook object, by buffering the whole stream into the memory
//            wb=new XSSFWorkbook(fis);
//        }
//        catch(FileNotFoundException e)
//        {
//            e.printStackTrace();
//        }
//        catch(IOException e1)
//        {
//            e1.printStackTrace();
//        }
//        Sheet sheet=wb.getSheetAt(0);   //getting the XSSFSheet object at given index
//        Row row=sheet.getRow(vRow);
//        Cell cell=row.getCell(vColumn); //getting the cell representing the given column
//        value=cell.getStringCellValue();    //getting cell value
//        return value;               //returns the cell value
//    }
//
//}
