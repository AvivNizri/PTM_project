package server_side;

import java.util.HashMap;

public class FileCacheManager implements CacheManager<String,String> {
	HashMap<String, String> hm = new HashMap<String,String>();  
	
	@Override
	public boolean exist(String p) {
		if(hm.containsKey(p)) {
			return true;
		}
		return false;
	}

	@Override
	public String pull(String p) {
		return hm.get(p);
	}

	@Override
	public void save(String p, String s) {
		String prev = hm.put(p,s);
	}
	
}
