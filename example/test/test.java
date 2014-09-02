package test;


public class test{
public static void main(String[] args) {
	char c = 'a';
	;
	for(int i=0;i<26;i++){
		int i_value = Character.getNumericValue(c);
		String h_value = Integer.toHexString(i_value);
		String b_value = Integer.toBinaryString(i_value);
		/*
		System.out.println("character: "+c
				+ ", "+"integer: "+i_value
				+ ", "+"hex: "+h_value
				+ ", "+"binary: "+b_value
				);
		System.out.println("hello world");
		c++;
		*/
		char[] hello = {'h','e','l','l','o'};
		//Byte.valueOf(s)
		//Byte.valueOf("d");
		//System.out.println(Byte.valueOf("hello"));
	}
	
}
}