package server_side;

import java.util.List;

public interface Searcher<T> {
	List<State<T>> search(Searchable<T> s);
	// get how many nodes were evaluated by the algorithm
	public int getNumberOfNodesEvaluated(); // NEED TO CHECK WHETHER TO CHECK THIS
}
