
public class UseGraph {

	public static void main(String[] args) {
		Graph g = new Graph(9);
		
		g.addDirectedEdge(0,2);
		g.addDirectedEdge(1,0);
		g.addDirectedEdge(1,4);
		g.addDirectedEdge(1,7);
		g.addDirectedEdge(2,1);
		g.addDirectedEdge(2,3);
		g.addDirectedEdge(2,7);
		g.addDirectedEdge(3,4);
		g.addDirectedEdge(3,5);
		g.addDirectedEdge(4,6);
		g.addDirectedEdge(5,6);
		g.addDirectedEdge(5,7);
		g.addDirectedEdge(6,3);
		g.addDirectedEdge(7,5);
		g.addDirectedEdge(8,6);

		for (int sV = 0; sV < 9; sV++)
		{
			String bfs = g.BFS(sV);
			System.out.println("BFS starting at " + sV + " is " + bfs);
		}
		
		for (int sV = 0; sV < 9; sV++)
		{
			String dfs = g.DFS(sV);
			System.out.println("DFS starting at " + sV + " is " + dfs);
		}

	}

}