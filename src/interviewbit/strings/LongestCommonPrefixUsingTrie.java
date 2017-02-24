package interviewbit.strings;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import other.Trie;
import other.TrieNode;

public class LongestCommonPrefixUsingTrie {

    public String longestCommonPrefix(ArrayList<String> a) {
        if(a.size() == 0) {
            return "";
        }
        if(a.size() == 1) {
            return a.get(0);
        }
                
        Trie trie = new Trie();
        for(String s : a) {
            trie.insert(s);
        }
        
        StringBuffer sb = new StringBuffer();
        
        TrieNode node = trie.getRoot();
        boolean foundLeafNode = false;
        
        while(node.getChildCount() == 1 && foundLeafNode == false) {
            System.out.println("child count: " + node.getChildCount());
            TrieNode [] children = node.getChildren();
            int childIndex = -1;
            for(int i = 0; i < children.length; i++) {
                if(children[i] != null) {
                    if(children[i].isLeaf) foundLeafNode = true;

                    childIndex = i;
                    sb.append(node.getCharacter(i));
                    System.out.println("Append: " + node.getCharacter(i));
                    break;
                }
            }
            node = node.getChildren()[childIndex];
        }
        
        return sb.toString();
    }

    @Test
    public void test() {
        ArrayList<String> a = new ArrayList<>(Arrays.asList("abc", "ae", "ab"));
        assertEquals("a", longestCommonPrefix(a));
        
        a = new ArrayList<>(Arrays.asList("abc", "ab", "a"));
        assertEquals("a", longestCommonPrefix(a));
        
        a = new ArrayList<>(Arrays.asList("a", "aa", "aaa"));
        assertEquals("a", longestCommonPrefix(a));
        
        a = new ArrayList<>(Arrays.asList("banana", "banana"));
        assertEquals("banana", longestCommonPrefix(a));

        a = new ArrayList<>(Arrays.asList("banana"));
        assertEquals("banana", longestCommonPrefix(a));

    }
}
