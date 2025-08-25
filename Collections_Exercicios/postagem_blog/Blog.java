import java.util.*;

public class Blog {
    private List<Post> posts;

    public Blog() {
        this.posts = new ArrayList<>();
    }

    public void adicionarPostagem(Post post) {
        for (var p : posts) {
            if (p.getAutor().compareTo(post.getAutor()) == 0 && p.getTitulo().equals(post.getTitulo()))
                throw new IllegalArgumentException("Postagem jah existente");
        }
        posts.add(post);
    }

    public Set<Autor> obterTodosAutores() {
        var autores = new TreeSet<Autor>();
        for (var p : posts) {
            autores.add(p.getAutor());
        }
        return autores;
    }

    public Map<Categorias,Integer> obterContagemPorCategoria() {
        var counter = new TreeMap<Categorias,Integer>();
        for (var p : posts) {
            var c = p.getCategoria();
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        return counter;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        var postsAutor = new TreeSet<Post>();
        for (var p : posts) {
            if (p.getAutor().compareTo(autor) == 0)
                postsAutor.add(p);
        }
        return postsAutor;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        var postsCategoria = new TreeSet<Post>();
        for (var p : posts) {
            if (p.getCategoria() == categoria)
                postsCategoria.add(p);
        }
        return postsCategoria;
    }

    public Map<Categorias,Set<Post>> obterTodosPostsPorCategorias() {
        var postTodos = new TreeMap<Categorias,Set<Post>>();
        for (var p : posts) {
            var c  = p.getCategoria();
            var s = postTodos.getOrDefault(c, new TreeSet<Post>());
            s.add(p);
            postTodos.put(c, s);
        }
        return postTodos;
    }

    public Map<Autor,Set<Post>> obterTodosPostsPorAutor() {
        var postTodos = new TreeMap<Autor,Set<Post>>();
        for (var p : posts) {
            var a  = p.getAutor();
            var s = postTodos.getOrDefault(a, new TreeSet<Post>());
            s.add(p);
            postTodos.put(a, s);
        }
        return postTodos;
    }
}
