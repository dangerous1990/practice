package org.learn.leetcode.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/gray-code/
 *
 * Created by Administrator on 2016/9/20.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        if (n == 0) return ans;
        // ans.add(0); when n == 0 return [0]
        ans.add(1);
        for (int i = 1; i < n; i++) {
            int size = ans.size();
            int mark = 1 << i;
            for (int j = size - 1; j >= 0; j--) {
                int num = ans.get(j);
                num |= mark;
                ans.add(num);
            }
        }
        return ans;
    }


}
