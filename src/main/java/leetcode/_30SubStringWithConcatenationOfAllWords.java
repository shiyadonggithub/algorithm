package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _30SubStringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("test", 1);

        System.out.println("test".substring(1, 2));
        _30SubStringWithConcatenationOfAllWords subStringWithConcatenationOfAllWords = new _30SubStringWithConcatenationOfAllWords();
        System.out.println(subStringWithConcatenationOfAllWords.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if(s.length()==0)return new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        int wordLength = 0;
        for (int i = 0; i < words.length; i++) {
            wordLength = words[i].length();
            hashMap.put(words[i], hashMap.getOrDefault(words[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        for (int i = 0; i < s.length() - words.length * wordLength+1; i++) {
            for (int j = i; j < i + wordLength * words.length; j++) {
                String word = s.substring(j, j + wordLength);
                if (hashMap.containsKey(word)) {
                    hashMap2.put(word, hashMap2.getOrDefault(word, 0) + 1);
                } else{
                    break;
                }
                hashMap.put(word, hashMap.get(word) - 1);
                if (hashMap.get(word) == 0)
                    hashMap.remove(word);
                j += wordLength - 1;
            }
            if(hashMap.isEmpty()){
                list.add(i);
            }
            for(String key:hashMap2.keySet()){
                hashMap.put(key, hashMap.getOrDefault(key,0)+hashMap2.get(key));
            }
            hashMap2.clear();
        }
        return list;
    }
}