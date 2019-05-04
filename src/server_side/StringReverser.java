package server_side;

public class StringReverser implements Solver<String, String> {

	@Override
	public String solve(String p) {
		// TODO Get String and return it backwards
		StringBuilder str = new StringBuilder(p);
		return str.reverse().toString();
	}

}
