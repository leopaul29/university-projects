import java.util.Date;


public abstract class Temps {
	
	
	public static String dateCourante()
	{
		Date date= new Date();

		return date.getYear()+ "/"+date.getMonth()+"/"+date.getDay();
		
	}
	
	
	public static void main ()
	{
		System.out.println(Temps.dateCourante());
	}

}
