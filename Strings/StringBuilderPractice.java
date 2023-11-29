package Strings;

public class StringBuilderPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder s=new StringBuilder("hello");
		s.append("prats");
		System.out.println(s);
		s.replace(0,5,"java");
		System.out.println(s+" "+s.length());
		s.delete(0, 4);
		System.out.println(s+" "+s.length()+" "+s.reverse());
		char ch='f';
		String str=Character.toString(ch);
		Integer.parseInt("45");
		System.out.println(str);
		str=str.replaceAll("cat", "");
		String h="cat"+'o';
		System.out.println(h);

		System.out.println(str);
		//use strings only dont go for string builders, just use + for concat and use replaceAll
		
		
		

	}

}
