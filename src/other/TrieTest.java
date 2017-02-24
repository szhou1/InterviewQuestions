package other;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrieTest {
    
    @Test
    public void test() {
        Trie t = new Trie();
        t.insert("steve");
        
        assertFalse(t.searchPrefix("s").isLeaf);
        assertFalse(t.searchPrefix("st").isLeaf);
        assertTrue(t.searchPrefix("steve").isLeaf);
        assertTrue(t.searchPrefix("steve").isLeaf);
        assertTrue(t.getRoot().getChildCount() == 1);

        
        t.insert("stevenson");
        assertTrue(t.searchWord("stevenson"));
        assertTrue(t.searchPrefix("stevenson").isLeaf);
        assertTrue(t.searchPrefix("steve").isLeaf);
        assertTrue(t.searchWord("steve"));
        
        
    }
    
    
    public void testwhitespace() {
        Trie t = new Trie();
        t.insert(" ");
        
        assertTrue(t.searchPrefix(" ").isLeaf);

    }

}
