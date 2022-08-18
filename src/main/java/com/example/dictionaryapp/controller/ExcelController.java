package com.example.dictionaryapp.controller;

import com.example.dictionaryapp.Word;
import com.example.dictionaryapp.repository.WordRepository;
import com.example.dictionaryapp.service.ExcelService;
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
import java.util.List;


@RestController
@RequestMapping
public class ExcelController {

    @Autowired
    WordRepository wordRepository;

    @Autowired
    ExcelService excelService;

    @PostMapping("import-excel")
    public ResponseEntity<List<Word>> importExcelFile(@RequestParam("file") MultipartFile files) throws IOException {

        return ResponseEntity.ok(excelService.importExcel(files));
    }
}
