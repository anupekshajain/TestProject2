package Constructors;

public class vehicle 
{
	int cap;
	String name;
	
	public vehicle(String name, int cap)
	{
		name=this.name;
		cap=this.cap;
		System.out.println("Inside the Vehicle class parametrised constructor");
	}
	
	public vehicle()
	{
		System.out.println("Inside the Vehicle class default constructor");
	}

}
