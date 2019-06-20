package server_side;
import java.util.List;

public class SearcherAdapt<T> implements Solver<Searchable<T>, List<State<T>>>{
    private Searcher<T> searcher;

    public SearcherAdapt(Searcher<T> searcher){
        this.searcher = searcher;
    }

    @Override
    public List<State<T>> solve(Searchable<T> prob){
        return searcher.search(prob);
    }
}
