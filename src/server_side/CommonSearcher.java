package server_side;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.List;

public abstract class CommonSearcher<T> implements Searcher<T> {
	protected PriorityQueue<State<T>> openList;
	protected int evaluatedNodes;
	
	public CommonSearcher(){
        Comparator<State<T>> stateComparator = Comparator.comparingDouble(State::getCost);
        this.openList = new PriorityQueue<>(stateComparator);
        this.evaluatedNodes = 0;
    }

    protected State<T> popOpenList(){
        this.evaluatedNodes++;
        return this.openList.poll();
    }

    @Override
    public int getNumberOfNodesEvaluated(){
        return this.evaluatedNodes;
    }

    @Override
    public abstract List<State<T>> search(Searchable<T> s);
}
