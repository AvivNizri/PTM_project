package server_side;

import java.util.ArrayList;

public class Maze implements Searchable<Pair<Integer,Integer>> {

	private ArrayList<ArrayList<Integer>> matrixPosition; 
	private State<Pair<Integer,Integer>> initiateState;
	private State<Pair<Integer,Integer>> goalState;

	public Maze(ArrayList<ArrayList<Integer>> matrixPosition, Pair<Integer,Integer> init, Pair<Integer,Integer> goal) {
		this.matrixPosition = matrixPosition;
		this.initiateState = new State<>(init, getMatrixValue(init));
        this.goalState = new State<>(goal, getMatrixValue(goal));
		}

	@Override
	public State<Pair<Integer,Integer>> getInitialState() {
		return this.initiateState;
	}

	@Override
	public State<Pair<Integer,Integer>> getGoalState() {
		return this.goalState;
	}

	@Override
	public ArrayList<State<Pair<Integer, Integer>>> getAllPossibleStates(State<Pair<Integer, Integer>> xy) {
		int x = xy.getState().getLeft();
		int y = xy.getState().getRight();

		Pair<Integer, Integer> right = new Pair<>(x + 1, y);
        Pair<Integer, Integer> left = new Pair<>(x - 1, y);
        Pair<Integer, Integer> above = new Pair<>(x, y + 1);
        Pair<Integer, Integer> below = new Pair<>(x, y - 1);

		ArrayList<State<Pair<Integer, Integer>>> around = new ArrayList<>();
		around.add(new State<>(right, getMatrixValue(right)));
		around.add(new State<>(left, getMatrixValue(left)));
		around.add(new State<>(above, getMatrixValue(above)));
		around.add(new State<>(below, getMatrixValue(below)));
		return around;
	}

	private int getMatrixValue(Pair<Integer, Integer> p){
		return this.matrixPosition.get(p.getLeft()).get(p.getRight());
	}

}
