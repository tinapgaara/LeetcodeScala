package nestedListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by yingtan on 4/17/16.
 *
 *
 * 341. Flatten Nested List Iterator   My Submissions QuestionEditorial Solution
 Total Accepted: 1441 Total Submissions: 8313 Difficulty: Medium
 Given a nested list of integers, implement an iterator to flatten it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Example 1:
 Given the list [[1,1],2,[1,1]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

 Example 2:
 Given the list [1,[4,[6]]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].


 */
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */


/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack;
    private NestedInteger cur;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        if (nestedList != null) {
            int listSize = nestedList.size();
            for (int i = listSize -1 ; i >= 0 ; i --) {
                stack.push(nestedList.get(i));
            }
        }
    }

    @Override
    public Integer next() {
        return cur.getInteger();
    }

    @Override
    public boolean hasNext() {
        while ( ! stack.isEmpty()) {
            NestedInteger topNestedInteger = stack.pop();
            if (topNestedInteger.isInteger() && topNestedInteger.getList() == null) {
                cur = topNestedInteger;
                return true;
            }
            else if (topNestedInteger.getList() != null) {
                List<NestedInteger> list = topNestedInteger.getList();
                int listSize = list.size();
                for (int i = listSize -1 ; i >= 0 ; i --) {
                    stack.push(list.get(i));
                }
            }
        }
        return false;
    }

    @Override
    public void remove() {

    }

    public static void main(String[] args) {
        List<NestedInteger> nestedList = new ArrayList<>();

    }
}


