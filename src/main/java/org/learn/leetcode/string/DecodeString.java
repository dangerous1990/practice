package org.learn.leetcode.string;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/9/29.
 */
public class DecodeString {
    Pattern p = Pattern.compile("\\[[a-z]*\\]");

    public String decodeString(String s) {
        Matcher m = p.matcher(s);
        String sub = "";
        if (!m.find()) {
            return s;
        } else {
            sub = m.group();
        }
        String content = sub.substring(1, sub.length() - 1);
        String pattern = "\\d*(?=\\[" + content + "\\])";
        Pattern numberCompile = Pattern.compile(pattern);
        Matcher numberMatcher = numberCompile.matcher(s);
        int count = 0;
        if (numberMatcher.find()) {
            count = Integer.valueOf(numberMatcher.group());
        }
        String instend = "";
        for (int i = 0; i < count; i++) {
            instend += content;
        }
        return decodeString(s.replace(count + sub, instend));
    }

    @Test
    public void test() {
        decodeString("100[leetcode]");
    }
}
