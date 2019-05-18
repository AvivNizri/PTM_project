package server_side;

public interface CacheManager <Problem,Solution> {
	public boolean exist(Problem p);	//checker
	public Solution pull(Problem p);				//pull the solution if exist
	public boolean save(Problem p, Solution s);		//in-order to let me know if succeeded
}
