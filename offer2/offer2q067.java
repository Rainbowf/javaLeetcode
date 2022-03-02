package offer2;

import java.util.*;

class Solution067 {

    public static void main(String[] args) {
        int[] nums1 = {3, 10, 5, 25, 2, 8};
        int k1 = 2;

        int[] nums2 = {1, 2, 3, 4};
        int k2 = 1;

        System.out.println(findMaximumXOR(nums1));
    }

    //定义前缀树
    static class TrieNode {
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[2];
        }
    }

    public static int findMaximumXOR(int[] nums) {
        //build TrieTree
        TrieNode root = buildTrie(nums);
        //
        int max = 0;
        for (int num : nums) {
            TrieNode node = root;
            int xor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[1 - bit] != null) {
                    xor = (xor << 1) + 1;
                    node = node.children[1 - bit];
                } else {
                    xor = xor << 1;
                    node = node.children[bit];
                }
            }
            max = Math.max(max, xor);
        }
        return max;
    }

    private static TrieNode buildTrie(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }
        return root;
    }
}