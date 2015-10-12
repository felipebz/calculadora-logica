Esse foi um exercício realizado durante a disciplina de Lógica Aplicada à Computação, ministrada pelo professor Fabio Alexandre Spanhol na Faculdade Sul Brasil (FASUL) no segundo semestre de 2008.

São aceitos os símbolos como entrada:

- T - Verdadeiro
- F - Falso
- ^ - [Conjunção](https://pt.wikipedia.org/wiki/Conjun%C3%A7%C3%A3o_l%C3%B3gica) (operador AND)
- v - [Disjunção](https://pt.wikipedia.org/wiki/Disjun%C3%A7%C3%A3o_l%C3%B3gica) (operador OR)
- ~ - [Negação](https://pt.wikipedia.org/wiki/Negação_lógica) (operador NOT)
- -> - [Implicação](https://pt.wikipedia.org/wiki/Implica%C3%A7%C3%A3o)
- <-> - [Bicondicional](https://pt.wikipedia.org/wiki/Conectivo_l%C3%B3gico_bicondicional)
- ( ) - Parentização

Essa calculadora considera a precedência dos operadores e os parêntes durante o cálculo da expressão.

Então, uma entrada como `t->f^fvt` retornará o resultado `T`.

O algoritmo utilizado é o [Shunting-yard algorithm](https://en.wikipedia.org/wiki/Shunting-yard_algorithm), que está implementado no método [ExpressaoLogica.separa](https://github.com/felipebz/calculadora-logica/blob/master/src/main/java/br/edu/fasul/lac/ExpressaoLogica.java#L95). Com ele, é produzida uma lista com os tokens na forma de [notação polonesa reversa](https://pt.wikipedia.org/wiki/Nota%C3%A7%C3%A3o_polonesa_inversa), que então é processada no método [ExpressaoLogica.resolve](https://github.com/felipebz/calculadora-logica/blob/master/src/main/java/br/edu/fasul/lac/ExpressaoLogica.java#L128).
