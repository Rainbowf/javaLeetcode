package offer2;

import java.util.*;

//构造前缀树
class TrieNode {
    public TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
    }
}

class Solution065 {
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = buildTrie(words);

        int total[] = {0};
        //从1开始加，把#提前算进来
        dfs(root, 1, total);
        return total[0];

    }

    private void dfs(TrieNode root, int length, int[] total) {
        boolean isLeaf = true;
        for (TrieNode child : root.children) {
            if (child != null) {
                isLeaf = false;
                dfs(child, length + 1, total);
            }
        }
        if (isLeaf) {
            total[0] += length;
        }
    }

    //构造前缀树，注意从每个单词的最后一个字符倒过来往前存储
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
        }
        return root;
    }


}