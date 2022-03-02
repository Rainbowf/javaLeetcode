package offer2;

import java.util.*;

class MagicDictionary {
    static class TrieNode{
        public TrieNode[] children;
        public boolean isWord;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public MagicDictionary(){
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for(String word: dictionary){
            TrieNode node = root;
            for(char ch: word.toCharArray()){
                if(node.children[ch - 'a'] == null){
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(root, searchWord, 0, 0);
    }

    private boolean dfs(TrieNode root, String word, int i, int edit){
        if(root == null) return false;
        if(root.isWord && i == word.length() && edit == 1) return true;
        if(i < word.length() && edit <= 1){
            boolean found = false;
            for(int j = 0; j < 26 && !found; j++){
                int next = (j == word.charAt(i) - 'a') ? edit : edit + 1;
                found = dfs(root.children[j], word, i + 1, next);
            }
            return found;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */