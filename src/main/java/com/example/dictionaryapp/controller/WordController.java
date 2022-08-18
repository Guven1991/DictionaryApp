package com.example.dictionaryapp.controller;

import com.example.dictionaryapp.Word;
import com.example.dictionaryapp.repository.WordRepository;
import com.example.dictionaryapp.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        return ResponseEntity.ok(wordService.turkishWordById(id));
    }

    @GetMapping("english/{id}")
    public ResponseEntity<String> englishWordById(@PathVariable Long id) {

        return ResponseEntity.ok(wordService.englishWordById(id));
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
            return ResponseEntity.ok(wordService.englishToTurkish(englishWord));
    }

    @GetMapping("turkishtoenglish/{turkishWord}")
    public ResponseEntity<String> turkishToEnglish(@PathVariable String turkishWord) {
        return ResponseEntity.ok(wordService.turkishToEnglish(turkishWord));
    }

    @PostMapping("add-word")
    public ResponseEntity<Word> addWord(@RequestBody Word word){

        return ResponseEntity.ok(wordService.addWord(word));
    }

    @DeleteMapping("{id}")
    public void deleteWordById(@PathVariable Long id){
        wordService.deleteWordById(id);
    }

}
