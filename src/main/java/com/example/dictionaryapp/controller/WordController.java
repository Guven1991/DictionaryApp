package com.example.dictionaryapp.controller;

import com.example.dictionaryapp.Word;
import com.example.dictionaryapp.repository.WordRepository;
import com.example.dictionaryapp.service.WordService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping
public class WordController {

    @Autowired
    WordRepository wordRepository;

    @Autowired
    WordService wordService;


    @GetMapping("all-word")
    public ResponseEntity<List<Word>> getAllWord() {
        return ResponseEntity.ok(wordService.getAllWord());
    }

    @GetMapping("turkish/{id}")
    public ResponseEntity<String> turkishWordById(@PathVariable Long id) {

        Word word = wordRepository.findById(id).orElse(null);
        return ResponseEntity.ok(word.getTurkish());
    }

    @GetMapping("english/{id}")
    public ResponseEntity<String> englishWordById(@PathVariable Long id) {

        Word word = wordRepository.findById(id).orElse(null);


        return ResponseEntity.ok(word.getEnglish());
    }


    @GetMapping("random-word")
    public ResponseEntity<Word> randomWord(){
        return ResponseEntity.ok(wordService.randomWord());
    }

    @GetMapping("word-pack")
    public ResponseEntity<List<Word>> getWordPack(){
        return ResponseEntity.ok(wordService.getWordPack());
    }

    @GetMapping("englishtoturkish/{englishWord}")
    public ResponseEntity<String> englishToTurkish(@PathVariable String englishWord) {
        String bulunanWord = null;
        List<Word> wordList = wordRepository.findAll();

        for (Word word : wordList) {
            if ((Objects.equals(englishWord, word.getEnglish()))) {
                bulunanWord = word.getTurkish();
                System.out.println(bulunanWord);
            }
        }
            return ResponseEntity.ok(bulunanWord);
    }

    @GetMapping("turkishtoenglish/{turkishWord}")
    public ResponseEntity<String> turkishToEnglish(@PathVariable String turkishWord) {
        String bulunanWord = null;
        List<Word> wordList = wordRepository.findAll();

        for (Word word : wordList) {
            if ((Objects.equals(turkishWord, word.getTurkish()))) {
                bulunanWord = word.getEnglish();
                System.out.println(bulunanWord);
            }
        }
        return ResponseEntity.ok(bulunanWord);
    }

    @PostMapping("add-word")
    public ResponseEntity<Word> addWord(@RequestBody Word word){
        return ResponseEntity.ok(wordRepository.save(word));
    }

    @DeleteMapping("{id}")
    public void deleteWordById(@PathVariable Long id){
        wordRepository.deleteById(id);
    }

}
