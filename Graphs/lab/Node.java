package lab;

class Node<T>
{

	public T questionType, studentInitials; // the data

	/**
	 * Construct a new binary node.
	 */
	public Node(T questionType, T studentInitials)
	{
		this.questionType = questionType;
		this.studentInitials = studentInitials;
	}

	public T getQuestionType()
	{
		return questionType;
	}

	public void setQuestionType(T questionType)
	{
		this.questionType = questionType;
	}

	public T getStudentInitials()
	{
		return studentInitials;
	}

	public void setStudentInitials(T studentInitials)
	{
		this.studentInitials = studentInitials;
	}

}