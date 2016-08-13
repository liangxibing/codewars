package org.fudan.university.liangxibing.kyu_6;

import java.util.*;

/**
 * Created by liangxibing on 2016/8/13.
 */
public class Groups{

    public static boolean groupCheck(String s){
        Map<Character, Integer> characterMap = new HashMap<Character, Integer>();
        characterMap.put('(', 1);
        characterMap.put('{', 2);
        characterMap.put('[', 3);
        characterMap.put(')', -1);
        characterMap.put('}', -2);
        characterMap.put(']', -3);
        Stack<Integer> resultStack = new Stack<Integer>();
        Integer temp = 0;
        for (int i = 0; i < s.length(); ++i) {
            temp =  characterMap.get(s.charAt(i));
            if (null == temp)
                return false;
            if (temp > 0)
            {
                resultStack.push(temp);
            }
            else if (temp < 0)
            {
                if (resultStack.empty() || 0 != resultStack.pop() + temp)
                    return false;
            }
        }
        return resultStack.empty();
    }

}
