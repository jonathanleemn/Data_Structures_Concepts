package enums;

public class DaysTester
{

	public static void main(String[] args)
	{
		DaysOfTheWeek days;
		
		days = DaysOfTheWeek.WED;
		
		switch(days)
		{
		case MON:
			System.out.println("It's Monday");
			break;
			
		case TUES:
			System.out.println("It's Tuesday");
			break;
			
		case WED:
			System.out.println("It's Wednesday");
			break;
			
		case THURS: 
			System.out.println("It's Thursday");
			break;
			
		case FRI: 
			System.out.println("It's Fridayday");
			break;
			
		case SAT: 
			System.out.println("It's Saturday");
			break;
			
		case SUN: 
			System.out.println("It's Sunday");
			break;
		}

	}

}
