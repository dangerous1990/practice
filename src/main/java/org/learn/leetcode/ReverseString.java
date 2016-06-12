package org.learn.leetcode;

public class ReverseString {
	public String reverseString(String s) {
		int length = s.length();
		StringBuilder sb = new StringBuilder();
		for (int i = length - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	String vowels = "aeiouAEIOU";

	public String reverseVowels(String s) {
		int length = s.length();
		StringBuilder sb = new StringBuilder();
		int position = length - 1;
		for (int i = 0; i <= length - 1; i++) {
			if (vowels.contains(String.valueOf(s.charAt(i)))) {
				for (int j = position; j >= 0; j--) {
					if (vowels.contains(String.valueOf(s.charAt(j)))) {
						sb.append(s.charAt(j));
						position = j - 1;
						break;
					}
				}
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ReverseString rs = new ReverseString();
		System.out.println(rs.reverseString("hello"));
		System.out.println(rs.reverseVowels("leetcode"));

	}
}
