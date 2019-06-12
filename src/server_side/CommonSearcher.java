package server_side;

import java.util.PriorityQueue;

public abstract class CommonSearcher implements Searcher {

	protected PriorityQueue<State> openList;
	private int evaluatedNodes;
	
	public CommonSearcher() {
	openList=new PriorityQueue<State>();
	evaluatedNodes=0;
	}
	
	protected State popOpenList() {
	evaluatedNodes++;
	return openList.poll();
	}
	
	@Override
	public abstract List<State> search(Searchable s);
	@Override
	
	public int getNumberOfNodesEvaluated() {
	return evaluatedNodes;
	}


}
