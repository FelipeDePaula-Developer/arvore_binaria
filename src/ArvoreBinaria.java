public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() // construtor da classe Arvore Binaria
    {
        this.raiz = null; // inicia a árvore vazia
    }

    public void insere(long id, Object elemento) // método para inserção de elemento
    {
        No novoNo = new No(id, elemento, null, null);
        if (raiz == null) {
            raiz = novoNo;
        } else {
            No atual = raiz;
            No pai;
            while (true) {
                pai = atual;
                if (id < atual.getId()) { // vai inserir à esquerda
                    atual = atual.getEsq();
                    if (atual == null) { // pode inserir à esquerda
                        pai.setEsq(novoNo);
                        return;
                    } // se não é nulo, vai tentar o próximo filho
                } else { // vai inserir à direita
                    atual = atual.getDir();
                    if (atual == null) { // pode inserir à direita
                        pai.setDir(novoNo);
                        return;
                    }
                }
            }
        }
    }
    private void preFixado(No atual) // caminhamento pré-fixado da árvore binária
    {
        if (atual != null) {
            System.out.println("Id: " + atual.getId() + " Elemento: " + atual.getElemento());
            preFixado(atual.getEsq());
            preFixado(atual.getDir());
        }
    } // final método preFixado


    private void getEsquerdaFestiva(No atual) // caminhamento pré-fixado da árvore binária
    {
        if (atual != null) {
            preFixado(atual.getEsq());
            System.out.println("Id: " + atual.getId() + " Elemento: " + atual.getElemento());
        }
    } // final método preFixado

    private void posFixado(No atual) // caminhamento pós-fixado da árvore binária
    {
        if (atual != null) {
            posFixado(atual.getEsq());
            posFixado(atual.getDir());
            System.out.println("Id: " + atual.getId() + " Elemento: " + atual.getElemento());
        }
    } // final método posFixado

    private void simFixado(No atual) // caminhamento simétrico fixado da árvore binária
    {
        if (atual != null) {
            simFixado(atual.getEsq());
            System.out.println("Id: " + atual.getId() + " Elemento: " + atual.getElemento());
            simFixado(atual.getDir());
        }
    }

    public void imprimeElementosArvore() // impressão dos elementos da árvore
    {
        preFixado(raiz);
    }

    public void imprimeEsquerdaFestiva() // impressão dos elementos da árvore
    {
        getEsquerdaFestiva(raiz);
    }
    // final método insere

    private long calcAltura(No atual, long a) // calcula a altura da árvore
    {
        if (atual != null) {
            long e, d;
            e = calcAltura(atual.getEsq(), a) + 1;
            d = calcAltura(atual.getDir(), a) + 1;
            if (e > d) {
                return a + e;
            } else {
                return a + d;
            }
        }
        return a;
    } // final método calcAltura

    public long alturaArvore() {
        long a = 0;
        return calcAltura(raiz, a);
    } // final do método alturaArvore
} // Final da classe ArvoreBinaria