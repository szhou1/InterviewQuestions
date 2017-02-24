package other;

public class TrieNode {
    private TrieNode[] children;
    public boolean isLeaf;
    private int childCount;
    
    public TrieNode() {
        children = new TrieNode[26];
        isLeaf = false;
        childCount = 0;
    }

    public boolean containsKey(Character c) {
        return children[c - 'a'] != null;
    }
    
    public void put(Character c, TrieNode node) {
        children[c - 'a'] = node;
        childCount++;
    }
    
    public TrieNode get(Character c) {
        return children[c - 'a'];
    }
    
    public Character getCharacter(int i) {
        return (char) (i + 'a'); 
    }
    
    public TrieNode[] getChildren() {
        return this.children;
    }

    public int getChildCount() {
        return childCount;
    }

}
