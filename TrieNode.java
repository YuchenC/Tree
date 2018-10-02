/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3trie;

/**
 *
 * @author yuchen
 */
public class TrieNode
{
    int value;
        String word;
        TrieNode[] linksTo = new TrieNode[27];
    
    
    public TrieNode()
    {
        
    }
}
