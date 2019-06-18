package server_side;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BestFirstSearch<T> extends CommonSearcher<T>{
    @Override
    public List<State<T>> search(Searchable<T> prob){
    	this.openList.add(prob.getInitialState());
        this.evaluatedNodes++;

        HashSet<State<T>> closedSet = new HashSet<State<T>>();
        double currentCost;

        while(this.openList.size() > 0){
            State<T> currentState = openList.poll();
            closedSet.add(currentState);

            if(currentState.equals(prob.getGoalState())){
            	this.openList.clear();	//optional
                this.evaluatedNodes = 0;//optional
                return backTrace(currentState);
            }

            ArrayList<State<T>> possibleStates = prob.getAllPossibleStates(currentState);
            possibleStates.removeIf(temp -> closedSet.contains(temp));

            for(State state : possibleStates){
                currentCost = currentState.getCost() + state.getFCost();
                if(!closedSet.contains(state) && !this.openList.contains(state)){
                    this.evaluatedNodes++;
                    state.setCost(currentCost);

                    state.setCameFrom(currentState);
                    this.openList.add(state);
                }
                else{
                    if(state.getCost() > currentCost){
                        if(!this.openList.contains(state)){
                        	this.openList.add(state);
                        }
                        else{
                            this.openList.remove(state);
                            state.setCost(currentCost);
                            state.setCameFrom(currentState);
                            this.openList.add(state);
                        }
                    }
                }
            }
        }

        return null;
    }

    private ArrayList<State<T>> backTrace(State<T> goalState){
        State<T> phiState = goalState;
        ArrayList<State<T>> routeList = new ArrayList<State<T>>();

        while(phiState.getCameFrom() != null)
        {
            routeList.add(phiState);
            phiState = phiState.getCameFrom();
        }
        routeList.add(phiState);

        return routeList;
    }
}
