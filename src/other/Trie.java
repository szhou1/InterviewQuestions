package other;

public class Trie {

    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode TrieNode = root;
        for(int i = 0; i < word.length(); i++) {
            if(TrieNode.containsKey(word.charAt(i)) == false) {
                System.out.println("putting: " + word.charAt(i));
                TrieNode.put(word.charAt(i), new TrieNode());
            } 
            TrieNode = TrieNode.get(word.charAt(i));
        }
        TrieNode.isLeaf = true;
    }
    
    public boolean searchWord(String word) {
        TrieNode TrieNode = searchPrefix(word);
        return TrieNode != null && TrieNode.isLeaf == true;
    }
    
    public TrieNode searchPrefix(String prefix) {
        TrieNode TrieNode = root;
        for(int i = 0; i < prefix.length(); i++) {
            if(TrieNode.containsKey(prefix.charAt(i)) == false) {
                return null;
            }
            TrieNode = TrieNode.get(prefix.charAt(i));
        }
        return TrieNode;
    }
    
    public TrieNode getRoot() {
        return this.root;
    }
}
