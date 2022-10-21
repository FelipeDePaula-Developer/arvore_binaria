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
            preFixado(atual.getEsq());
            preFixado(atual.getDir());
            System.out.println("Id: " + atual.getId() + " Elemento: " + atual.getElemento());
        }
    }

    private void posFixado(No atual)
    {
        if (atual != null) {
            posFixado(atual.getEsq());
            posFixado(atual.getDir());
            System.out.println("Id: " + atual.getId() + " Elemento: " + atual.getElemento());
        }
    }

    private void simFixado(No atual)
    {
        if (atual != null) {
            simFixado(atual.getEsq());
            System.out.println("Id: " + atual.getId() + " Elemento: " + atual.getElemento());
            simFixado(atual.getDir());
        }
    }

    public void imprimeElementosArvore()
    {
        preFixado(raiz);
    }

    private Integer countEsquerdaFestiva(No atual) {
        if (atual == null) {
            return 0;
        } else if (atual.getEsq() != null) {
            return 1 + countEsquerdaFestiva(atual.getEsq()) + countEsquerdaFestiva(atual.getDir());
        } else {
            return 0;
        }
    }

    public Integer imprimeEsquerdaFestiva()
    {
        return countEsquerdaFestiva(raiz);
    }

    private void countNivelNo(No atual, Integer count) {
        StringBuilder identacao = new StringBuilder();
        for (int i = 0; i <= count; i++) {
            identacao.append("    ");
        }
        if (atual == null) {
            identacao.append("-");
            System.out.println(identacao);
        } else {
            identacao.append(atual.getId());
            System.out.println(identacao);
            count += 1;
            countNivelNo(atual.getEsq(), count);
            countNivelNo(atual.getDir(), count);
        }
    }

    public void imprimeNivelNo() {
        countNivelNo(raiz, 0);
    }

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
    }

    public long alturaArvore() {
        long a = 0;
        return calcAltura(raiz, a);
    }
}