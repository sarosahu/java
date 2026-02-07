package com.algo.lc.trie.addsearch;

public class WordDictionary2 {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
    private TrieNode root;
    public WordDictionary2() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word.toCharArray(), 0, root);
    }

    private boolean dfs(char[] word, int startIdx, TrieNode node) {
        if (startIdx == word.length) {
            return node.isEnd;
        }
        char c = word[startIdx];
        if (c != '.') {
            TrieNode child = node.children[c - 'a'];
            return child != null && dfs(word, startIdx + 1, child);
        }
        // Char is '.'
        for (TrieNode child : node.children) {
            if (child == null) {
                continue;
            }
            if (dfs(word, startIdx + 1, child)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary2 wd = new WordDictionary2();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println(wd.search("pad"));
        System.out.println(wd.search("bad"));
        System.out.println(wd.search(".ad"));
        System.out.println(wd.search("b.."));
    }
}
