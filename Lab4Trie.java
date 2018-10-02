
package lab3trie;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Lab4Trie 
{
    // public int counter = 0;
    /*
    public static void main (String[] args)
    {
        
        java.util.Scanner in = new java.util.Scanner (System.in);
       //int counter = 1;
        
        TrieNode[] insertNode = new TrieNode[27];
        int[] save = new int[27];
        String test = "ab";
       
        String test2 = "cd";
        String test3 = "abd";
        String test4 = "abe";
        String test5 = "abf";
                
        TrieNode x = new TrieNode();
        put(test);
        //System.out.println("--------------------");
        
        put(test2);
        //System.out.println("--------------------");
        
        put(test3);
        //System.out.println("--------------------");
        
        put(test4);
        put(test5);
        // 第二个全新的单词不行
       // for (int i = 0; i < save.length; i++)
         //   System.out.print(save[i] + " ");
         // 一个字母两个或者多个next,同一个字母开头的不同单词
        //char m = 'b';
        System.out.println("get = " + get(test));
        System.out.println("count = " + count(test));
        System.out.println("distinct = " + distinct(test));
        //String[] a = newWord(x, test);
        //newWord(x,test);
        //for (int i = 0; i < a.length; i++)
          // System.out.println(a[0] + " ");
        //traversal(x, "ab");
        Iterator iter = Iterator("ab");
        while (iter.hasNext())
            System.out.print(iter.next() + " ");
        
        
        
        
    }*/

    private TrieNode root;
    
    
    
    public Lab4Trie()
    {
        root = new TrieNode();
    }
    
    public int index (char key)
    {
        int index = 0;
        if ((int)key > 91)
            index = (int)key - 32;
        index = index - 64;
        //System.out.println( "\nindex = " + index);
        return index;
    }
    
    public void put (String word)
    {
        int i = 0;
        int j = 0;
        while (i < word.length())
        {
            //System.out.println("i = " + i);
            
            // search miss?
            if (root.linksTo[index(word.charAt(i))] == null)
            {
                root.linksTo[index(word.charAt(i))] = new TrieNode();
               //System.out.println("i = " + i + ", " + word.charAt(i));    
            }
            else
            {
                root = root.linksTo[index(word.charAt(i))];
                //System.out.println("already exist");
                //System.out.println("i = " + i + ", " + word.charAt(i));
                if (i == word.length() - 1)
                {
                    
                    root.value++;
                    root.word = word;
                    //System.out.println("exist value = " + x.value);
                }
                i++;
                continue;
            }
            
            root = root.linksTo[index(word.charAt(i))];
            if (i == word.length() - 1)
            {
                root.word = word;
                root.value = 1;
               //System.out.println("value = " + x.value);
            }
            //x = x.linksTo[index(word.charAt(i))];
            i++;            
        }
    }
    
    public int get (String word)
    {
        int value = 0;
        int i = 0;
        while (i < word.length())
        {
            //System.out.println("i = " + i + ", letter = " + word.charAt(i));
            if (root.linksTo[index(word.charAt(i))] !=null)
            {
                root = root.linksTo[index(word.charAt(i))];
                if (i == word.length() - 1)
                    value = root.value;
                i++;
                continue;
            }
            
        }
        return value;
    }
    
    public int count(String word)
    {
       // String a = word;
       // System.out.println(a);
        int sum = 0;
        if (get(word) == 0)
            return sum;
        
        int i = 0;
        sum = get(word);
        while (i < word.length())
        {
            if (root.linksTo[index(word.charAt(i))] !=null)
            {
                root = root.linksTo[index(word.charAt(i))];
               //System.out.println("i = " + i + ", word length = " + word.length());
                if (i == word.length() - 1)
                {
                    //System.out.println("last letter " + word.charAt(i));
                    //System.out.println("before while - " + x.value);
                    
                    int k = 1;
                    while (k < root.linksTo.length)
                    {
                        if (root.linksTo[k] == null)
                        {
                            //System.out.println("k = " + k + " is null");
                            k++;
                            continue;
                        }
                        else
                        {
                           // a += (char) k;
                            //System.out.println("k = " + k + ",x.value = " + x.linksTo[k].value);
                            sum += root.linksTo[k].value; 
                            sum = help (sum);
                            //System.out.println("--------------need helper");
                            k++;
                        }
                        
                    }        
                }
                i++;
            }
        }
        return sum;
    }
    
    public int help (int sum)
    {
        
        int k = 0;
        while (k < 27)
        {
            if (root.linksTo[k] == null)
            {
                k++;
                continue;
            }
            else
            {
                sum += root.linksTo[k].value;
               // a += (char) k;
               k++;
                
                //System.out.println("helper linksTo[k]" + x.linksTo[k]. value);
            }
            
        }
        return sum;
    }
    
    public int distinct (String word)
    {
        int sum = 0;
        if (get(word) == 0)
            return sum;
        
        int i = 0;
        while (i < word.length())
        {
            if (root.linksTo[index(word.charAt(i))] !=null)
            {
                root = root.linksTo[index(word.charAt(i))];
               //System.out.println("i = " + i + ", word length = " + word.length());
                if (i == word.length() - 1)
                {
                    //System.out.println("last letter " + word.charAt(i));
                    //System.out.println("before while - " + x.value);
                    
                    int k = 1;
                    while (k < root.linksTo.length)
                    {
                        if (root.linksTo[k] == null)
                        {
                            //System.out.println("k = " + k + " is null");
                            k++;
                            continue;
                        }
                        else
                        {
                            //System.out.println("k = " + k + ",x.value = " + x.linksTo[k].value);
                            
                            if (root.linksTo[k].value == 1)
                                sum++;
                            //System.out.println("before helper " + sum);
                            sum = helper (sum);
                            //System.out.println("after helper" + sum);
                            //System.out.println("--------------need helper");
                            k++;
                        }
                        
                    }        
                } 
                i++;
            }
        }
        return sum;
    }
    
    public int helper (int sum)
    {
        
        int k = 0;
        while (k < 27)
        {
            if (root.linksTo[k] == null)
            {
                k++;
                continue;
            }
            else
            {
               
                sum++;
                
                //System.out.println("in helper " + sum);
                //System.out.println("helper linksTo[k]" + x.linksTo[k]. value);
            }
            k++;
        }
        return sum;
    }
    
    public Iterator<Map.Entry<String, Integer>> Iterator (String word)
    {
        
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        TrieNode  x = root;
       // String a = word;
       //Node current = new Node();
        //int i = 1;
       
        for (int k = 0; k < word.length(); k++)
        {
            int m = index(word.charAt(k));
            x = x.linksTo[m];
        }
        //System.out.println(x.word);
        if (x.word != null)
        {
          //  System.out.println("call help method");
            convertNodeToMap(x, map);
        }
        else
            System.out.println("No such word");
        
        Iterator<Map. Entry<String, Integer>> iter = map.entrySet().iterator();
        return iter;
    }
    
    public void convertNodeToMap (TrieNode current, Map<String, Integer> map)
    {
        //System.out.println("in help method");
        TrieNode x = current;
        for (int i = 1; i < 27; i++)
        {
            
            if (current.linksTo[i] != null)
            {
                if (current.linksTo[i].word != null)
                {
                    //System.out.println(current.linksTo[i].word);
                    x = current.linksTo[i];
                    map.put(x.word, x.value);
                }
                convertNodeToMap(current.linksTo[i], map);
            }   
        }    
    }   
}
