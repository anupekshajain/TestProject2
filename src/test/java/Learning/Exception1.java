package Learning;

public class Exception1 extends Exception{	
	
	public static void main(String[] args){
		
		try{
			
			System.out.println("My Custom Exception test");
			throw new Exception1();
			
		}catch(Exception e){
			System.out.println("Test Exception");
		}
	}
	
}
