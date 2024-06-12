package com.serein.wordbook.entity;

import lombok.Data;

import java.util.List;

/**
 * 切分单词结构
 *
 * @author 王强
 * @since 2024/6/8 09:01
 */
@Data
public class Words {
    private List<Word> wordList;
}

@Data
class Word {

    private String originWord;
    private List<WordClassAndChineseMean> wordClassAndChineseMeanListByOriginWord;

}

@Data
class WordClassAndChineseMean {
    private String wordClassByWordEN;
    private List<String> oneWordChineseMeans;
}