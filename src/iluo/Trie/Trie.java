package iluo.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class Trie {
    private Character character;
    private HashMap<Character,Trie> hashMap;
    private boolean isWord;

    /** Initialize your data structure here. */
    public Trie() {
        this.character = '0';
        this.hashMap = new HashMap<>();
        this.isWord = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insertCore(this.hashMap,word);
    }


    private void insertCore(HashMap<Character,Trie> hashMap,String word){
        if(hashMap.containsKey(word.charAt(0))){
            if(word.length() == 1){
                Trie trie = hashMap.get(word.charAt(0));
                trie.isWord = true;
                hashMap.put(word.charAt(0),trie);
                return;
            }
            insertCore(hashMap.get(word.charAt(0)).hashMap,word.substring(1));
        }else{
            Trie trie = new Trie();
            trie.character = word.charAt(0);
            hashMap.put(trie.character,trie);
            if(word.length() > 1){
                insertCore(trie.hashMap,word.substring(1));
            }else{
                trie.isWord = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return searchCore(this.hashMap,word);
    }


    private boolean searchCore(HashMap<Character,Trie> hashMap,String word){
        if(hashMap.containsKey(word.charAt(0))){
            if(word.length() == 1){
                if(hashMap.get(word.charAt(0)).isWord) return true;
                else return false;
            }else{
                return searchCore(hashMap.get(word.charAt(0)).hashMap,word.substring(1));
            }
        }else return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startWithCore(this.hashMap,prefix);
    }

    private boolean startWithCore(HashMap<Character,Trie> hashMap,String word){
        if(hashMap.containsKey(word.charAt(0))){
            if(word.length() == 1){
                return true;
            }else{
                return startWithCore(hashMap.get(word.charAt(0)).hashMap,word.substring(1));
            }
        }else return false;
    }


    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
