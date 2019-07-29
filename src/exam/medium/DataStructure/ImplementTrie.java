package exam.medium.DataStructure;

import java.util.LinkedList;

public class ImplementTrie {
    /**
     * 208. Implement Trie (Prefix Tree)
     * 设计前缀匹配树
     *
     * 需要首先考虑子结构怎么设计，需要包含哪些属性  助理利用数组下标来表示元素信息
     *
     */
}

class TrieNode {
    // Initialize your data structure here.
    char content; // the character in the node
    boolean isEnd; // whether the end of the words
    int count; // the number of words sharing this character
    LinkedList<TrieNode> childList; // the child list
    // todo:这里对子节点的存取使用的是链表，还可以使用26位的数组，下标代表子节点的值，数组内存储的是子节点

    public TrieNode(char c) {
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        content = c;
        count = 0;
    }

    public TrieNode subNode(char c) {
        if (childList != null) {
            for (TrieNode eachChild : childList) {
                if (eachChild.content == c) {
                    return eachChild;
                }
            }
        }
        return null;
    }

    public TrieNode() {
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        content = ' ';
        count = 0;
    }
}
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (search(word) == true) return;

        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode child = current.subNode(word.charAt(i));
            if (child != null) {
                current = child;
            } else {
                current.childList.add(new TrieNode(word.charAt(i)));
                current = current.subNode(word.charAt(i));
            }
            current.count++;
        }
        // Set isEnd to indicate end of the word
        current.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            if (current.subNode(word.charAt(i)) == null)
                return false;
            else
                current = current.subNode(word.charAt(i)); // 非常巧妙
        }
        /*
         * This means that a string exists, but make sure its a word by checking
         * its 'isEnd' flag
         */
        if (current.isEnd == true) return true;
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            if (current.subNode(word.charAt(i)) == null)
                return false;
            else
                current = current.subNode(word.charAt(i));
        }
        return true;
    }

    public void deleteWord(String word){
        if(search(word) == false) return;

        TrieNode current = root;
        for(char c : word.toCharArray()) {
            TrieNode child = current.subNode(c);
            if(child.count == 1) {
                current.childList.remove(child);
                return;
            } else {
                child.count--;
                current = child;
            }
        }
        current.isEnd = false;
    }
}

//-------------------------todo:优化时间复杂度

class Trie2 {
    Node root;

    /** Initialize your data structure here. */
    public Trie2() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Node();
            }
            node = node.children[c - 'a'];
        }
        if (node != root) {
            node.isEndOfWord = true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                return false;
            } else {
                node = node.children[c - 'a'];
            }
        }
        return node.isEndOfWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.children[c - 'a'] == null) {
                return false;
            } else {
                node = node.children[c - 'a'];
            }
        }
        return true;
    }

    class Node {
        boolean isEndOfWord;
        Node[] children = new Node[26];
        //缺少了子元素个数统计，所以没有删除方法，
    }
}


