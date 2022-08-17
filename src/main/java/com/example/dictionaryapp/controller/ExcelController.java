package com.example.dictionaryapp.controller;

import com.example.dictionaryapp.Word;
import com.example.dictionaryapp.repository.WordRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping
public class ExcelController {

    @Autowired
    WordRepository wordRepository;

    @PostMapping("import-excel")
    public ResponseEntity<List<Word>> importExcelFile(@RequestParam("file") MultipartFile files) throws IOException {

        List<Word> wordList = new ArrayList<>();

//        FileInputStream fis = new FileInputStream("C:\\Users\\guven\\Downloads\\İNG KELİME.xlsx");
        Workbook wb = new XSSFWorkbook(files.getInputStream());
        Sheet worksheet = wb.getSheetAt(2);
        for (int i = 0; i < worksheet.getPhysicalNumberOfRows(); i++) {
            if (i > 0) {
                Word word = new Word();
                Row row = worksheet.getRow(i);
                word.setId((long) row.getCell(0).getNumericCellValue());
                word.setEnglish(row.getCell(1).getStringCellValue().toUpperCase(Locale.ROOT).trim());
                word.setTurkish(row.getCell(2).getStringCellValue().toUpperCase().trim());
                word.setCorrectNumber((int) row.getCell(3).getNumericCellValue());
                wordList.add(word);
                wordRepository.save(word);
            }
        }
        return ResponseEntity.ok(wordList);
    }
}
