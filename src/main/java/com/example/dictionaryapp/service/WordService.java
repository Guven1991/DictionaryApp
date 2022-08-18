package com.example.dictionaryapp.service;

import com.example.dictionaryapp.Word;
import com.example.dictionaryapp.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class WordService {


    @Autowired
    WordRepository wordRepository;


    public List<Word> getAllWord(){

        return wordRepository.findAll();
    }

    public String turkishWordById(Long id){
        Word word = wordRepository.findById(id).orElse(null);
        return word.getTurkish();
    }

    public String englishWordById(Long id){
        Word word = wordRepository.findById(id).orElse(null);
        return word.getEnglish();
    }

    public Word randomWord(){
        List<Word> wordList = wordRepository.findAll();
        Collections.shuffle(wordList);
        Word word = wordList.get(0);
        return word;
    }

    public List<Word> getWordPack(){
        List<Word> wordpack = new ArrayList<Word>();

        for (int i = 0; i <4 ; i++) {
            Word word = randomWord();
            wordpack.add(word);
        }

        return wordpack;
    }

    public String englishToTurkish(String englishWord){
        String bulunanWord = null;
        List<Word> wordList = wordRepository.findAll();

        for (Word word : wordList) {
            if ((Objects.equals(englishWord, word.getEnglish()))) {
                bulunanWord = word.getTurkish();
                System.out.println(bulunanWord);
            }
        }
        return bulunanWord;
    }

    public String turkishToEnglish(String turkishWord){
        String bulunanWord = null;
        List<Word> wordList = wordRepository.findAll();

        for (Word word : wordList) {
            if ((Objects.equals(turkishWord, word.getTurkish()))) {
                bulunanWord = word.getEnglish();
                System.out.println(bulunanWord);
            }
        }
        return bulunanWord;
    }

    public Word addWord(Word word){
        return wordRepository.save(word);
    }

    public void deleteWordById(Long id){
        wordRepository.deleteById(id);
    }
}
