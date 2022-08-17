package com.example.dictionaryapp.service;

import com.example.dictionaryapp.Word;
import com.example.dictionaryapp.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class WordService {


    @Autowired
    WordRepository wordRepository;


    public List<Word> getAllWord(){
        return wordRepository.findAll();
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

}
