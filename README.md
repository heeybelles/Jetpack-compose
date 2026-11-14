## 📌 Questionário e Conceitos do Projeto

*Feito por: Eduarda e Ellen

### 1. O que é entrada em um sistema computacional? Dê dois exemplos.
Entrada (*Input*) refere-se a qualquer dado, sinal ou instrução fornecida pelo usuário ou por um dispositivo externo para que o sistema computacional possa processá-la.
* **Exemplos:** 
  1. O valor numérico ou texto digitado por um usuário em um campo de texto (`TextField`).
  2. O toque ou clique em um botão de ação (`Button`) na interface.

---

### 2. Qual é a diferença entre processamento e saída?
* **Processamento:** É a etapa lógica onde os dados de entrada são manipulados, calculados ou transformados por algoritmos (ex: aplicar a fórmula matemática de cálculo de desconto sobre o valor informado).
* **Saída (*Output*):** É a exibição ou entrega do resultado obtido após o processamento para o usuário ou para outro sistema (ex: mostrar o preço final com o desconto aplicado em um componente de texto na tela).

---

### 3. Por que o valor digitado em um TextField é inicialmente tratado como texto?
Porque os campos de texto interagem diretamente com o usuário recebendo caracteres brutos (`String`). O framework de interface não assume automaticamente se uma sequência de dígitos deve ser tratada como número inteiro, decimal ou string, exigindo que o desenvolvedor realize a conversão explícita (ex: `.toDoubleOrNull()`) antes de realizar operações matemáticas.

---

### 4. Qual é a finalidade de `remember` e `mutableStateOf`?
* **`mutableStateOf`:** Cria um estado observável. Sempre que o seu valor é alterado, ele notifica o Compose para atualizar os elementos da interface que dependem dele.
* **`remember`:** Armazena o valor desse estado na memória durante as recomposições. Sem o `remember`, o valor seria reinicializado ou perdido toda vez que a tela fosse redesenhada.

---

### 5. O que é um evento? Cite os eventos utilizados nesta aplicação.
Um evento é qualquer ação gerada pelo usuário ou pelo sistema (como interrupções, toques ou mudanças de estado) que desencadeia uma reação no software.
* **Eventos utilizados:** 
  1. A alteração do texto inserido pelo usuário (`onValueChange`).
  2. O clique disparado ao acionar o botão de cálculo (`onClick`).

---

### 6. O que significa recomposição no Jetpack Compose?
Recomposição é o processo inteligente em que o Jetpack Compose executa novamente as funções `@Composable` cujos estados mudaram, atualizando apenas os componentes visuais necessários na árvore de interface de usuário (UI), sem precisar recarregar a tela inteira.

---

### 7. Qual é a responsabilidade da `MainActivity` neste projeto?
A `MainActivity` atua como o ponto de entrada (*entry point*) nativo da aplicação Android. Sua principal responsabilidade é hospedar o ciclo de vida da tela e definir o conteúdo visual raiz da aplicação através da função `setContent { ... }`, onde o tema e o composable principal são inicializados.

---

### 8. Qual é a responsabilidade de `CalculadoraDescontoScreen`?
É o componente visual principal (`@Composable`) responsável por estruturar a interface gráfica da calculadora (organizando os campos de entrada, botões e textos de resultado) e gerenciar o estado local da tela.

---

### 9. Por que `calcularPrecoComDesconto` foi colocada em outro arquivo?
Para manter o princípio da separação de responsabilidades (*Separation of Concerns*). Isolar a lógica matemática em um arquivo separado mantém a camada de interface gráfica limpa, melhora a legibilidade do código e facilita a manutenção.

---

### 10. Qual é a vantagem de uma função de regra de negócio não depender do Compose?
A principal vantagem é a **testabilidade e portabilidade**. Como a função contém apenas lógica pura em Kotlin (sem dependências de UI), é possível criar testes unitários rápidos e isolados sem precisar instanciar o framework do Android ou o ambiente do Compose, além de poder reutilizar essa mesma regra em outras plataformas (como back-end ou apps desktop/web).
