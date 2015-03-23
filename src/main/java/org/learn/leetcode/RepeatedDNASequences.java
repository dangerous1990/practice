package org.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 找出dna中重复的串
 * 
 * @author admin
 *
 */
public class RepeatedDNASequences {

	/**
	 * 超时
	 * 
	 * @param s
	 * @return
	 */
	public List<String> findRepeatedDnaSequences(String s) {
		

		List<String> list = new ArrayList<String>();
		for (int i = 0; i < s.length() - 10; i++) {
			int end = i + 10;
			if (end > s.length()) {
				break;
			} else {
				list.add(s.substring(i, i + 10));
			}
		}
		Set<String> set = new HashSet<String>();

		for (String n : list) {
			if (Collections.frequency(list, n) > 1) {
				set.add(n);
			}
		}
		return Arrays.asList(set.toArray(new String[0]));

	}

	/**
	 * 通过
	 * 
	 * @param s
	 * @return
	 */
	public List<String> findRepeatedDnaSequences2(String s) {
		List<String> list = new ArrayList<String>();
		Set<Integer> set = new HashSet<Integer>();
		String temp = null;
		for (int i = 0; i < s.length() - 9; i++) {
			temp = s.substring(i, i + 10);
			int hashCode = getHashCode(temp);
			if (set.contains(hashCode) && !list.contains(temp)) {
				list.add(temp);
			} else {
				set.add(hashCode);
			}
		}
		return list;
	}

    Integer getHashCode(String str) {
        int hash = 0;
        for (int i = 0; i <= str.length() - 1; i++) {
            hash = hash << 2 | getCode(str.charAt(i));
        }

        return hash;
    }

    int getCode(char c) {
        if (c == 'A') {
            return 0;
        } else if (c == 'C') {
            return 1;
        } else if (c == 'G') {
            return 2;
        }
        return 3;
    }
}
