class TriesNode{
    TriesNode children[];
    boolean eow;
    TriesNode(){
      children =  new TriesNode[26];
      eow = false;    
    }
} 
class Trie {
    TriesNode root;
    public Trie() {
       root = new TriesNode();
    }
    
    public void insert(String word) {
        TriesNode curr = root;
        for(char ch:word.toCharArray()){
            if(curr.children[ch - 'a']==null){
                curr.children[ch - 'a'] = new TriesNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.eow = true;
    }
    
    public boolean search(String word) {
        TriesNode curr = root;
        for(char ch:word.toCharArray()){
            if(curr.children[ch-'a'] == null){
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return curr.eow;
    }
    
    public boolean startsWith(String prefix) {
        TriesNode curr = root;
        for(char ch:prefix.toCharArray()){
            if(curr.children[ch-'a'] == null){
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */