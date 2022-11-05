public class Main {
    public static void main(String[] args) {
        ArvoreBinaria a = new ArvoreBinaria(); // cria a árvore binária

        a.insere(555,"A - ROOT");
        a.insere(333,"B - ESQUERDA");
        a.insere(888,"C - DIREITA");
        a.insere(111,"D - ESQUERDA");
        a.insere(444,"E - DIREITA");
        a.insere(999,"F - DIREITA");

//        a.insere(100, "A - Root");
//        a.insere(50, "B - esquerda");
//        a.insere(40, "C - esquerda");
//        a.insere(60, "D - direita");
//        a.insere(55, "E - esquerda");
//        a.insere(56, "F - direita");
//        a.insere(200, "G - direita");
//        a.insere(150, "H - esquerda");
//        a.insere(125, "I - esquerda");
//        a.insere(175, "J - direita");
//        a.insere(300, "K - direita");
//        a.insere(350, "L - direita");

//        a.imprimeElementosArvore();
//        System.out.println(a.imprimeEsquerdaFestiva());
        a.imprimeNivelNo();
//        System.out.println("Altura: "+a.alturaArvore());
    }
}
