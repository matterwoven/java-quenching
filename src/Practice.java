import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Practice {
    /**
     * Returns the sum of the odd numbers in the array.
     * 
     * Returns 0 if the array is null or has no odd numbers.
     * 
     * @param nums an array of numbers
     * @return the sum of the odd numbers in the array
     */
    public static int oddSum(int[] nums) {
        if (nums == null) return 0;
        int count = 0;
        for(int n : nums){
            if (n % 2 != 0) count += n;
        }
        return count;
    }

    /**
     * Returns the shortest word in the Set.
     * 
     * If multiple words are tied for shortest, returns the one that is smallest
     * lexicographically.
     * 
     * @param words a set of words
     * @return the shortest word in the set with a lexicographic tiebreaker
     * @throws IllegalArgumentException if words is empty
     * @throws NullPointerException if words is null
     */
    public static String shortestWord(Set<String> words) {
        if(words == null) throw new NullPointerException("Words is null, ending task");
        if(words.isEmpty()) throw new IllegalArgumentException("Words are empty, ending task");
        Boolean flag = true;
        String shortestWord = "";
        for(String n : words)  {
            if(n.length() < shortestWord.length() || flag == true || shortestWord.compareTo(n) > 0){
                shortestWord = n;
            }
            if(flag) flag = false;
        }
        return shortestWord;
    }

    /**
     * Returns a set of all the names of people that are 18 years of age or older.
     * 
     * The input maps name to age in years.
     * 
     * @param ages mapping of name to age
     * @return the set of all names of people >= 18 years old
     * @throws NullPointerException if ages is null
     */
    public static Set<String> adults(Map<String, Integer> ages) {
        if(ages == null) throw new NullPointerException("ages is null, aborting");
        Set<String> names = new HashSet<>();
        for(String n : ages.keySet()){
             if(ages.get(n) >= 18){
                names.add(n);
             }
        }
        return names;
    }

    /**
     * Returns the biggest number in a linked list.
     * 
     * @param head the head of the linked list
     * @return the biggest number in the list
     * @throws IllegalArgumentException if head is null
     */
    public static int biggestNumber(ListNode<Integer> head) {
        if(head == null) throw new IllegalArgumentException("head is null, aborting");
        int highest = head.data;
        Boolean flag = true;
        ListNode<Integer> current = head;
        while(flag == true){
            if(current.data > highest){
                highest = current.data;
            }
            if(current.next == null){
                flag = false;
            }
            current = current.next;
        }
        return highest;
    }

    /**
     * Returns a frequency map counting how frequently items appear in a linked list.
     * 
     * Example:
     *   Input: a -> x -> a -> a -> x -> y
     *   Output: {a:3, x:2, y:1}
     * 
     * Returns an empty map if head is null
     * 
     * @param <T> the type of data held by the list
     * @param head the head of the list
     * @return a frequency map of values in the list
     */
    public static <T> Map<T, Integer> frequencies(ListNode<T> head) {
        Map<T, Integer> theFrequencyMap = new HashMap<>(); 
        ListNode<T> current = head;

        while(current != null){
            theFrequencyMap.put(
                current.data, 
                theFrequencyMap.getOrDefault(current.data, 0) + 1
            );
            current = current.next;
        }
        return theFrequencyMap;
    }


    /**
     * Returns the number of levels in the tree.
     * 
     * An empty tree has 0 levels, a tree with only a root has 1 level.
     * 
     * @param root the root of the tree
     * @return the number of levels in the tree
     */
    public static int levelCount(BinaryTreeNode<?> root) {
        if(root == null) return 0;
        int leftLevels = levelCount(root.left);
        int rightLevels = levelCount(root.right);
        if(leftLevels > rightLevels) return 1 + leftLevels;
        return 1 + rightLevels;
    }


    /**
     * Returns the sum at a specified level in a binary tree.
     * 
     * For example, if the given level was 3:
     *       5
     *     /   \
     *    8     4
     *   / \   / 
     *  7  9  2
     *    /
     *   1
     * 
     * Nodes at level 3: 7, 9, and 2
     * Sum of nodes at level 3: 18 
     * 
     * The root is considered to be at level 1.
     * 
     * Returns 0 if the tree is empty or if the level is not present in the tree.
     * 
     * @param root the root of the binary tree
     * @param level the level to sum
     * @return the sum of the nodes at the given level
     */
    public static int sumAtLevel(BinaryTreeNode<Integer> root, int level) {
        if(root == null) return 0;
        int leftLevels = sumAtLevel(root.left, level - 1);
        int rightLevels = sumAtLevel(root.right, level - 1);
        if(level == 1){
            return root.data;
        }
        else{
            return leftLevels + rightLevels;
        }
    }


    /**
     * Returns true if the sum of the values in a given tree is equal to the sum
     * of the values in the given list. 
     * 
     * An empty tree or list is considered to have a sum of 0.
     * 
     * @param root The root of the binary tree
     * @param head The head of the linked list
     * @return true if the sums are equal, false otherwise
     */
    public static boolean sumMatch(BinaryTreeNode<Integer> root, ListNode<Integer> head) {
        return treeSum(root) == listSum(head);
    }

    public static int listSum(ListNode<Integer> head)   {
        if (head == null)   {
            return 0;
        }
        int total = 0;
        ListNode<Integer> current = head;
        while (current != null) {
            total += current.data;
            current = current.next;
        }
        return total;
    }

    public static int treeSum(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;
        return root.data + treeSum(root.left) + treeSum(root.right);
    }

}