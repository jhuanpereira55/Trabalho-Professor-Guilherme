# Trabalho - Sistemas em Java

## Exercício 1 - Controle de Aluguel de Quadra Society

### Tabelas identificadas

#### Cliente
- nome (String)
- telefone (String)

#### Horario
- horario (String)
- valor (double)
- ocupado (boolean)

#### Aluguel
- cliente (Cliente)
- horario (Horario)
- data (String)
- valorTotal (double)

### Regras identificadas
- Nome do cliente não pode ser vazio
- Horário não pode ter valor negativo
- Não é possível reservar um horário já ocupado
- Consulta de aluguéis filtra por data

---

## Exercício 2 - Controle de Biblioteca Escolar

### Tabelas identificadas

#### Livro
- titulo (String)
- autor (String)
- quantidadeEstoque (int)

#### Aluno
- nome (String)
- telefone (String)

#### Emprestimo
- livro (Livro)
- aluno (Aluno)
- devolvido (boolean)

### Regras identificadas
- Título do livro não pode ser vazio
- Quantidade em estoque não pode ser negativa
- Não é possível emprestar livro sem estoque
- Ao emprestar, estoque diminui 1
- Ao devolver, estoque aumenta 1
- Não é possível devolver um livro já devolvido
- Consulta mostra livros emprestados e alunos com empréstimos em aberto

---

## Exercício 3 - Controle de Pedidos em Lanchonete

### Tabelas identificadas

#### Produto
- nome (String)
- descricao (String)
- preco (double)

#### Pedido
- data (String)
- produtos (List<Produto>)
- finalizado (boolean)

### Regras identificadas
- Produto não pode ter nome vazio
- Produto não pode ter preço negativo
- Pedido só pode ser finalizado com pelo menos um produto
- Não é possível adicionar produto a pedido já finalizado
- Consulta de faturamento considera apenas pedidos finalizados
- Consulta filtra pedidos por data