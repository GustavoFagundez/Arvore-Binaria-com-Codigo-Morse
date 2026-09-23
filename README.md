# Árvore Binária — Código Morse

Implementação em Java de uma **árvore binária** em que cada nó representa um símbolo do código Morse. Cada caminho da raiz até um nó descreve a sequência de pontos e traços de um caractere:

- **Ponto (`.`)** → vai para o filho da **esquerda**
- **Traço (`-`)** → vai para o filho da **direita**

A árvore contém todas as letras de **A a Z** e os números de **0 a 9**.

## Integrantes

- Carlos Eduardo Aguiar Sacerdote
- Gustavo Fagundes de Amorim

## Índice

- [Estrutura do código](#estrutura-do-código)
- [Como compilar e executar](#como-compilar-e-executar)
- [Exemplo de uso](#exemplo-de-uso)
- [Exemplo de saída](#exemplo-de-saída)
- [Tabela Morse utilizada](#tabela-morse-utilizada)
- [Complexidade](#complexidade)

## Estrutura do código

O projeto está em um único arquivo, `ArvoreMorse.java`, com três classes.

### `Nodo`

Representa cada nó da árvore.

| Atributo        | Descrição                                        |
|------------------|--------------------------------------------------|
| `caractere`      | Letra ou número guardado no nó (`'\0'` se vazio) |
| `filhoEsquerdo`  | Próximo nó quando o símbolo é ponto (`.`)        |
| `filhoDireito`   | Próximo nó quando o símbolo é traço (`-`)        |

### `ArvoreBinariaMorse`

Contém a raiz da árvore e os métodos de manipulação.

| Método                              | O que faz                                                                                       |
|--------------------------------------|--------------------------------------------------------------------------------------------------|
| `inicializar()`                      | Cria a raiz vazia da árvore.                                                                     |
| `inserir(codigoMorse, caractere)`    | Percorre o código (ponto → esquerda, traço → direita), cria os nós que faltarem e grava o caractere no último nó. |
| `buscar(codigoMorse)`                | Separa a mensagem pelos espaços, percorre a árvore para cada código e retorna o texto. Retorna `null` se algum código for inválido. |
| `exibir()`                           | Mostra a árvore de forma hierárquica (pré-ordem), com recuo por nível.                           |

### `ArvoreMorse` (classe principal)

- Cria a árvore e chama `inicializar()`.
- Insere os 36 caracteres com `inserir()`.
- Executa os testes do enunciado.
- Exibe a árvore.
- Lê uma mensagem em Morse digitada pelo usuário e mostra a tradução.

## Como compilar e executar

```bash
# compilar
javac ArvoreMorse.java

# executar
java ArvoreMorse
```

Ao rodar, o programa primeiro imprime os testes fixos e a árvore inteira, depois pede uma mensagem em Morse pelo teclado.

## Exemplo de uso

```java
ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
arvore.inicializar();
arvore.inserir("...", 'S');
arvore.inserir("---", 'O');

System.out.println(arvore.buscar("..."));          // S
System.out.println(arvore.buscar("---"));          // O
System.out.println(arvore.buscar("... --- ..."));  // SOS
```

## Exemplo de saída

Trecho da exibição da árvore:

```
RAIZ
    (.) E
        (.) I
            (.) S
                (.) H
                    (.) 5
                    (-) 4
                (-) V
                    (-) 3
            (-) U
    ...
    (-) T
        (.) N
        (-) M
            (-) O
    ...
```

Entrada do usuário:

```
Digite uma mensagem em Morse (letras separadas por espaco): .... . .-.. .-.. ---
HELLO
```

> Os caracteres devem ser separados por espaço. Se algum código não existir na árvore, o programa mostra `Codigo invalido`.

## Tabela Morse utilizada

| Char | Código | Char | Código | Char | Código |
|------|--------|------|--------|------|--------|
| A    | `.-`   | M    | `--`   | Y    | `-.--` |
| B    | `-...` | N    | `-.`   | Z    | `--..` |
| C    | `-.-.` | O    | `---`  | 0    | `-----`|
| D    | `-..`  | P    | `.--.` | 1    | `.----`|
| E    | `.`    | Q    | `--.-` | 2    | `..---`|
| F    | `..-.` | R    | `.-.`  | 3    | `...--`|
| G    | `--.`  | S    | `...`  | 4    | `....-`|
| H    | `....` | T    | `-`    | 5    | `.....`|
| I    | `..`   | U    | `..-`  | 6    | `-....`|
| J    | `.---` | V    | `...-` | 7    | `--...`|
| K    | `-.-`  | W    | `.--`  | 8    | `---..`|
| L    | `.-..` | X    | `-..-` | 9    | `----.`|

## Complexidade

- **Inserção e busca de um caractere:** `O(h)`, em que `h` é a altura da árvore (no máximo 5 níveis).
- **Decodificação de uma mensagem:** `O(n · h)`, em que `n` é o número de caracteres da mensagem.
