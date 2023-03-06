package org.example.util;

import org.example.model.Word;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileOperation {
    public static Map<String, String> wordMap = new HashMap<String, String>();
    public List<Word> wordList = new ArrayList<>();
    public void readFileOperation(String filePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line = bufferedReader.readLine();
        while (line != null) {
            String[] parsedLine = line.split("/");
            String wordName = parsedLine[0];
            String wordMeaning = parsedLine[1];

            //wordMap.put(wordName, wordMeaning);

            Word word = new Word(wordName, wordMeaning);
            wordList.add(word);
            //System.out.println(wordList);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
    }

    public String getWordMeaining(String wordName) {
        Collections.shuffle(wordList);
        return wordList.stream().filter(w -> wordName.equals(w.getWordName())).map(Word::getWordMeaning).findFirst().orElse(null);
    }
/*

    public String getWordMeaning(String wordname) {
        String wordMeaning = "Oops, this word not found!";
        Set<String> keySet = wordMap.keySet();
        System.out.println(keySet.size());
        for (String key : keySet) {
            if (wordname.equals(key)){
                wordMeaning = wordMap.get(key);
                break;
            }
        }
        return wordMeaning;
    }
*/


}
