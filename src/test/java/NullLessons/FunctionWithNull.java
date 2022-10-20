package NullLessons;

public class FunctionWithNull {

	public static void main(String[] args) {
		int a = 80, b = 100;
		int area = getArea(a, b);
		System.out.println(area);
//		b=(Integer) null;
//		System.out.println(getArea(a, b));
//		getAns(null);
//		 Compile time error
//		"The method getAns(int) in the type FunctionWithNull is not applicable for the arguments (null)"
	}

	public static int getArea(int a, int b) {
		return a * b;
	}

	public static void getAns(int c) {
		c++;
	}

}
