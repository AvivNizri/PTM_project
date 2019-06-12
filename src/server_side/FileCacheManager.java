package server_side;

import java.util.HashMap;

public class FileCacheManager<Problem,Solution> implements CacheManager<Problem,Solution> {

	HashMap<Problem,Solution> hm = new HashMap<Problem,Solution>();
	
	@Override
	public boolean exist(Problem problem) {
		if (hm.containsKey(problem)) {
			return true;
		}
		return false;
	}

	@Override
	public Solution pull(Problem problem) {
		return hm.get(problem);
		}

	@Override
	public void save(Problem problem, Solution solution) {
		hm.put(problem, solution);
	}

	
}
