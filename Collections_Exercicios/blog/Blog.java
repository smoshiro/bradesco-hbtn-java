import java.util.*;

public class Blog {
    private final List<Post> posts;

    public Blog() {
        this.posts = new ArrayList<>();
    }

    public void adicionarPostagem(Post post) {
        posts.add(post);
    }

    public Set<String> obterTodosAutores() {
        var autores = new TreeSet<String>();
        for (var p : posts) {
            autores.add(p.getAutor());
        }
        return autores;
    }

    public Map<String,Integer> obterContagemPorCategoria() {
        var counter = new TreeMap<String,Integer>();
        for (var p : posts) {
            var c = p.getCategoria();
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        return counter;
    }
}
