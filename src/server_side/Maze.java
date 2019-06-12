package server_side;

import java.util.ArrayList;

public class Maze implements Searchable<Matrix> {

	State<Matrix> matrixPosition;
	public Maze(State<Matrix> matrixPosition) {
		this.matrixPosition = matrixPosition;
		}

	@Override
	public State<Matrix> getInitialState() {
		return matrixPosition;
	}

	@Override
	public State<Matrix> getGoalState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<State<Matrix>> getAllPossibleStates(State s) {
		// TODO Auto-generated method stub
		return null;
	}

}
