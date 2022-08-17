package com.example.dictionaryapp.repository;

import com.example.dictionaryapp.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word,Long> {
}
