public class Main {
    public static void main(String[] args) {
        ArvoreBinaria a = new ArvoreBinaria(); // cria a árvore binária
        a.insere(10,"A - ROOT");
        a.insere(9,"B - ESQUERDA");
        a.insere(15,"C - DIREITA");
        a.insere(2,"D - ESQUERDA");
        a.insere(7,"E - DIREITA");
        a.insere(14,"L - ESQUERDA");
        a.insere(16,"I - DIREITA");
//
        a.insere(5,"G - ESQUERDA");
        a.insere(6,"H - DIREITA");
        a.insere(12,"F - ESQUERDA");
        a.insere(13,"K - DIREITA");
        a.insere(17,"J - DIREITA");

//        a.imprimeElementosArvore();
        a.imprimeEsquerdaFestiva();
        System.out.println("Altura: "+a.alturaArvore());
    }
}
