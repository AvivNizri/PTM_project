package server_side;

import java.util.List;

public interface Searcher {
	public List<State> search(Searchable s);
	// get how many nodes were evaluated by the algorithm
	public int getNumberOfNodesEvaluated(); // NEED TO CHECK WHETHER TO CHECK THIS
}
