package com.algo.lc.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 140. Word Break II
 *
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
*
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
*
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []
*
* Constraints:

1 <= s.length <= 20
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 10
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
Input is generated in a way that the length of the answer doesn't exceed 10^5.
 */
class TrieNode {
    boolean isEnd;
    Map<Character, TrieNode> children = new HashMap<>();
    TrieNode() {
        this.isEnd = false;
    }
}

class Trie {
    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }
}
public class WordBreakTwo {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakTrie(s, wordDict);
    }

    private List<String> wordBreakTrie(String s, List<String> wordDict) {
        // Build the trie from word dictionary
        Trie trie = new Trie();
        for (String word :wordDict) {
            trie.insert(word);
        }

        // Map to store results of subproblems
        Map<Integer, List<String>> dp = new HashMap<>();
        int n = s.length();

        // Iterate from end of the string to the beginning
        for (int startIdx = n; startIdx >= 0; --startIdx) {
            List<String> validSentences = new ArrayList<>();

            // Initialize curr node to the root of the trie
            TrieNode curr = trie.root;

            // Iterate from startIdx to the end of the string
            for (int endIdx = startIdx; endIdx < n; ++endIdx) {
                char c = s.charAt(endIdx);
                if (!curr.children.containsKey(c)) {
                    break;
                }

                // Move to the next node in the trie
                curr = curr.children.get(c);

                // Check if we found a valid word
                if (curr.isEnd) {
                    String currWord = s.substring(startIdx, endIdx + 1);

                    if (endIdx == n - 1) {
                        validSentences.add(currWord);
                    } else {
                        // If it's not the last word, append it to each sentence
                        // formed by the remaining substring
                        List<String> sentencesFromNextIdx = dp.get(endIdx + 1);
                        for (String sentence : sentencesFromNextIdx) {
                            validSentences.add(currWord + " " + sentence);
                        }
                    }
                }
            }
            // Store the valid sentences in dp
            dp.put(startIdx, validSentences);
        }

        // Return the sentences formed from the entire string
        return dp.getOrDefault(0, new ArrayList<>());
    }
}
