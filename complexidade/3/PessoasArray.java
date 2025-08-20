public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes =new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    // implementar o método de buscaBinaria
    public void buscaBinaria(String nome){
        boolean encontrado = false;
        int start = 0;
        int end = nomes.length - 1;
        int size = nomes.length;
        System.out.printf("Procurando o nome: \"%s\"\n", nome);
        while (size > 0) {
            int ptr = start + (end - start) / 2;
            System.out.printf("Passando pelo indice: %d\n", ptr);
            int cmp = nomes[ptr].compareTo(nome);
            if (cmp == 0) {
                System.out.printf("Nome %s encontrado na posição %d\n", nome, ptr);
                encontrado = true;
                break;
            } else if (cmp < 0) {
                start = ptr + 1;
            } else {
                end = ptr - 1;
            }
            size = end - start + 1;
        }
        if (!encontrado) throw new IllegalArgumentException(String.format("O nome %s não se encontra no array de nomes", nome));
    }
}
