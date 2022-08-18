package com.example.dictionaryapp.service;

import com.example.dictionaryapp.Word;
import com.example.dictionaryapp.repository.WordRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ExcelService {

    @Autowired
    WordRepository wordRepository;

    public List<Word> importExcel(MultipartFile files) throws IOException {
        List<Word> wordList = new ArrayList<>();

//        FileInputStream fis = new FileInputStream("C:\\Users\\guven\\Downloads\\İNG KELİME.xlsx");
        Workbook wb = new XSSFWorkbook(files.getInputStream());
        Sheet worksheet = wb.getSheetAt(2);
        for (int i = 0; i < worksheet.getPhysicalNumberOfRows(); i++) {
            if (i > 0) {
                Word word = new Word();
                Row row = worksheet.getRow(i);
                word.setId((long) row.getCell(0).getNumericCellValue());
                word.setEnglish(row.getCell(1).getStringCellValue().toUpperCase().trim());
                word.setTurkish(row.getCell(2).getStringCellValue().toUpperCase().trim());
                word.setCorrectNumber((int) row.getCell(3).getNumericCellValue());
                wordList.add(word);
                wordRepository.save(word);
            }
        }
        return wordList;
    }
}
