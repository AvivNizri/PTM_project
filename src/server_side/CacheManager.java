package server_side;

public interface CacheManager {
	public boolean exist();				//checker
	public Solution pull();				//pull the solution if exist
	public boolean save(Problem p);		//in-order to let me know if succeeded
}
