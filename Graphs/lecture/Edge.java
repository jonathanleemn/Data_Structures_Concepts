package lecture;

class Edge
{
	Vertex source, destination;
	Object weight;

	Edge(Vertex source, Vertex destination, Object weight)
	{
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
}
