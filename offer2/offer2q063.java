package offer2;

import java.util.*;

class Solution063 {
    static class TrieNode{
        TrieNode children[];
        boolean isWord;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    //创建前缀树
    private TrieNode buildTrie(List<String> dictionary){
        //创建根节点
        TrieNode root = new TrieNode();
        //遍历每一个单词
        for(String word : dictionary){
            TrieNode node = root;
            for(char ch : word.toCharArray()){//!!!!!!
                if(node.children[ch - 'a'] == null ){
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }
        return root;
    }

    //替换词
    private String findPrefix(TrieNode root, String word){
        TrieNode node = root;
        StringBuilder builder = new StringBuilder();
        for(char ch : word.toCharArray()){
            if(node.isWord || node.children[ch - 'a'] == null) break;
            builder.append(ch);
            node = node.children[ch - 'a'];
        }
        return node.isWord ? builder.toString() : "";
    }

    //主函数，逐个替换
    public String replaceWords(List<String> dictionary, String sentence) {
        //构成前缀树
        TrieNode root = buildTrie(dictionary);
        StringBuilder builder = new StringBuilder();

        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; i++){
            String prefix = findPrefix(root, words[i]);
            if(!prefix.isEmpty()){
                words[i] = prefix;
            }
        }
        return String.join(" ", words);
    }
}