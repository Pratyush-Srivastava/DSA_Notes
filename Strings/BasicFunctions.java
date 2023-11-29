package Strings;

import java.util.Arrays;

class BasicFunctions {
	public static void main(String[] args) {
		String input = "pratyush";
		System.out.println(input.length());
		System.out.println(input.charAt(5));
		System.out.println(input.substring(1,3));
		System.out.println(input.compareTo("pratyushabc"));
		System.out.println("Index is " + input.indexOf("z"));
		System.out.println("contains: " + input.contains("tyush"));
		String a1 = new String("prats");
		String a2 = "prats";
		System.out.println("Are they equal? " + a1.equals(a2));
		System.out.println("Are they equal address wise? " + (a1 == a2));
		//dont use == for strings. use .equals instead


		char[] arr = new char[] {'p','r','a','t','y','u','s','h'};
		System.out.println((int)arr[0] - (int) 'a');
		System.out.println(arr.length);

		StringBuilder sb = new StringBuilder(input);
		sb.reverse();
		System.out.println(input);
		System.out.println(sb);

		//thread safe
		StringBuffer str = new StringBuffer(input);
		System.out.println("Inserted z to "+str.insert(5, 'z'));
		System.out.println("Deleted z "+str.deleteCharAt(5));

		int[] utf16 = new int[256];
		for (char i = 'a'; i <= 'z'; i++) {
			utf16[i] = i;
		}
		System.out.println(Arrays.toString(utf16));
		System.out.println((int)'a');
	}
}