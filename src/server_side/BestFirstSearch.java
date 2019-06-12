package server_side;

public class BestFirstSearch extends CommonSearcher {

	public Solution search(Searchable s) {
		addToOpenList(s.getInitialState());
		HashSet<State> closedSet=new HashSet<State>();
		while(openList.size()>0){
			State n=popOpenList();// dequeue
			closedSet.add(n);
			if(n.equals(s.getGoalState()))
				return backTrace(s.getGoalState(), s.getStartState());
			// private method, back traces through the parents
			ArrayList<State> successors=s.getAllPossibleStates(n) //however it is implemented
					for(State state : successors){
						if(!closedSet.contains(state) && ! openListContains(state)){
							state.setCameFrom(n);
							addToOpenList(state);
						} 
						else{
							//...
						}
					}
		}}
}