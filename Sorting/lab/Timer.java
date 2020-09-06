package lab;

/*
 * Timing class. Gets a start time and end time when called with appropriate calls, then prints out
 * total time in milliseconds.
 */
public class Timer
{
	long startTime, endTime;

	void start()
	{
		startTime = System.nanoTime();
	}

	void end()
	{
		endTime = System.nanoTime();
	}

	long getResult()
	{
		return (endTime - startTime) / 1000000;
	}

	void printResult()
	{
		System.out.printf("Subroutine took %d milliseconds to complete. %n",
				getResult());
	}
}
