import java.util.Scanner;

class Nodo {
    char caractere;
    Nodo filhoEsquerdo;
    Nodo filhoDireito;
}

class ArvoreBinariaMorse {
    Nodo raiz;

    void inicializar() {
        raiz = new Nodo();
    }

    void inserir(String codigoMorse, char caractere) {
        Nodo noAtual = raiz;
        for (int i = 0; i < codigoMorse.length(); i++) {
            char simbolo = codigoMorse.charAt(i);
            if (simbolo == '.') {
                if (noAtual.filhoEsquerdo == null) {
                    noAtual.filhoEsquerdo = new Nodo();
                }
                noAtual = noAtual.filhoEsquerdo;
            } else if (simbolo == '-') {
                if (noAtual.filhoDireito == null) {
                    noAtual.filhoDireito = new Nodo();
                }
                noAtual = noAtual.filhoDireito;
            }
        }
        noAtual.caractere = caractere;
    }

    String buscar(String codigoMorse) {
        String resultado = "";
        String[] codigos = codigoMorse.trim().split(" +");
        for (int i = 0; i < codigos.length; i++) {
            Nodo noAtual = raiz;
            String codigo = codigos[i];
            for (int j = 0; j < codigo.length(); j++) {
                char simbolo = codigo.charAt(j);
                if (simbolo == '.') {
                    noAtual = noAtual.filhoEsquerdo;
                } else if (simbolo == '-') {
                    noAtual = noAtual.filhoDireito;
                } else {
                    return null;
                }
                if (noAtual == null) {
                    return null;
                }
            }
            if (noAtual.caractere == '\0') {
                return null;
            }
            resultado = resultado + noAtual.caractere;
        }
        return resultado;
    }

    void exibir() {
        exibir(raiz, 0, "RAIZ");
    }

    void exibir(Nodo no, int nivel, String lado) {
        if (no == null) {
            return;
        }
        String espacos = "";
        for (int i = 0; i < nivel; i++) {
            espacos = espacos + "    ";
        }
        if (no.caractere == '\0') {
            System.out.println(espacos + lado);
        } else {
            System.out.println(espacos + lado + " " + no.caractere);
        }
        exibir(no.filhoEsquerdo, nivel + 1, "(.)");
        exibir(no.filhoDireito, nivel + 1, "(-)");
    }
}

public class ArvoreMorse {
    public static void main(String[] args) {
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        arvore.inicializar();

        arvore.inserir(".-", 'A');
        arvore.inserir("-...", 'B');
        arvore.inserir("-.-.", 'C');
        arvore.inserir("-..", 'D');
        arvore.inserir(".", 'E');
        arvore.inserir("..-.", 'F');
        arvore.inserir("--.", 'G');
        arvore.inserir("....", 'H');
        arvore.inserir("..", 'I');
        arvore.inserir(".---", 'J');
        arvore.inserir("-.-", 'K');
        arvore.inserir(".-..", 'L');
        arvore.inserir("--", 'M');
        arvore.inserir("-.", 'N');
        arvore.inserir("---", 'O');
        arvore.inserir(".--.", 'P');
        arvore.inserir("--.-", 'Q');
        arvore.inserir(".-.", 'R');
        arvore.inserir("...", 'S');
        arvore.inserir("-", 'T');
        arvore.inserir("..-", 'U');
        arvore.inserir("...-", 'V');
        arvore.inserir(".--", 'W');
        arvore.inserir("-..-", 'X');
        arvore.inserir("-.--", 'Y');
        arvore.inserir("--..", 'Z');
        arvore.inserir("-----", '0');
        arvore.inserir(".----", '1');
        arvore.inserir("..---", '2');
        arvore.inserir("...--", '3');
        arvore.inserir("....-", '4');
        arvore.inserir(".....", '5');
        arvore.inserir("-....", '6');
        arvore.inserir("--...", '7');
        arvore.inserir("---..", '8');
        arvore.inserir("----.", '9');

        System.out.println(arvore.buscar("..."));
        System.out.println(arvore.buscar("---"));
        System.out.println(arvore.buscar("... --- ..."));

        arvore.exibir();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma mensagem em Morse (letras separadas por espaco): ");
        String mensagem = scanner.nextLine();
        String resultado = arvore.buscar(mensagem);
        
        if (resultado == null) {
            System.out.println("Codigo invalido");
        } else {
            System.out.println(resultado);
        }
        scanner.close();
    }
}
