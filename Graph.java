
public class Graph 
{
	private Vertex v[];
  private DLL<Integer> e[];
  
  @SuppressWarnings("unchecked")
	public Graph(int numberOfVertices)
	{
		v = new Vertex[numberOfVertices];
		for (int i=0; i<v.length; i++)
		{
			v[i] = new Vertex(String.valueOf(i));
		}
		
		e = new DLL[numberOfVertices];
		for (int i=0; i<e.length; i++)
		{
			e[i] = new DLL<Integer>();
		}
	}

	// trust that the user will call this method and never call
	// add undirected only on unique edges
	public void addDirectedEdge(int fromV, int toV)
	{
		e[fromV].addToBeginning(toV);
	}

	// trust that the user will call this method and never call
	// add directed only on unique edges
	public void addUndirectedEdge(int v1, int v2)
	{
		e[v1].addToBeginning(v2);
		e[v2].addToBeginning(v1);
	}

	private void setAllUnvisited()
	{
		for (int i=0; i<v.length; i++)
		{
			v[i].setUnvisited();
		}
	}
	
	public String DFS(int startV)
	{
		String dfsOrder = "";
		setAllUnvisited();
		// Create stack for DFS
		StackOfInts stack = new StackOfInts();
		// Push current source node
		stack.push(startV);
		//dfsOrder += v[startV].getName() + ", ";
		//v[startV].setVisited();
		
		while (!stack.empty())
		{
			int peekedV = stack.peek();
			stack.pop();
			
			if(v[peekedV].isUnvisited()) {
				dfsOrder += v[peekedV].getName() + ", ";
				v[peekedV].setVisited();
			}
			DLLNode<Integer> curr = e[peekedV].getHead();
			
			while(curr != null) {
				int data = curr.getData();
				if(v[data].isUnvisited()) {
					stack.push(data);
				}
				curr = curr.next;
			}
			
		}
		
		return dfsOrder;
	}
	
	
	
	public String BFS(int startV)
	{
		String bfsOrder = "";
		setAllUnvisited();
		// Queue
		Queue myQ = new Queue();
		myQ.enqueue(startV);
		v[startV].setWaiting();
		while (!myQ.empty())
		{
			int dqV = myQ.dequeue();
			bfsOrder += v[dqV].getName() + ", ";
			v[dqV].setVisited();
			DLLNode<Integer> adjVNode = e[dqV].getHead();
			while (adjVNode != null)
			{
				// get integer out of adjVNode and see if he's unvisited
				// if unvisited, then enqueue him and mark as waiting
				int adjV = adjVNode.getData();
				if (v[adjV].isUnvisited())
				{
					v[adjV].setWaiting();
					myQ.enqueue(adjV);
				}
				
				adjVNode = adjVNode.next;
			}
			
		}
		
		return bfsOrder;
	}
	
}

