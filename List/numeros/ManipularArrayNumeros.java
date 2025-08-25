import java.util.List;

public class ManipularArrayNumeros {

    public static int buscarPosicaoNumero(List<Integer> numeros, int numero) {
        int pos = -1;
        for (int i=0; i < numeros.size(); i++) {
            if (numeros.get(i) == numero)
                return i;
        }
        return pos;
    }

    public static void adicionarNumero(List<Integer> numeros, int numero) throws Exception {
        int pos = buscarPosicaoNumero(numeros, numero);
        if (pos >= 0)
            throw new Exception("Numero jah contido na lista");
        numeros.add(numero);
    }

    public static void removerNumero(List<Integer> numeros, int numero) throws Exception {
        int pos = buscarPosicaoNumero(numeros, numero);
        if (pos < 0)
            throw new Exception("Numero nao encontrado na lista");
        numeros.remove(pos);
    }

    public static void substituirNumero(List<Integer> numeros, int numeroSubstituir, int numeroSubstituto) {
        int pos = buscarPosicaoNumero(numeros, numeroSubstituir);
        if (pos < 0) {
            numeros.add(numeroSubstituto);
        } else {
            numeros.remove(pos);
            numeros.add(pos, numeroSubstituto);
        }
    }
}
