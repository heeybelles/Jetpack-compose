# Calculadora de Desconto - Jetpack Compose 📱🏷️

Aplicativo Android desenvolvido em **Kotlin** utilizando **Jetpack Compose** para cálculo de preço final com desconto percentual.

---

## 🚀 Sobre a Aplicação

A aplicação permite ao usuário informar o preço original de um produto e o percentual de desconto desejado, efetuando o cálculo e exibindo o preço final formatado em moeda brasileira (`R$`).

### 🧪 Exemplo de Teste
* **Preço do produto:** R$ 500,00
* **Percentual de desconto:** 15%
* **Resultado esperado:** R$ 425,00

---

## 🛠️ Estrutura do Projeto

* **`MainActivity.kt`**: Ponto de entrada do aplicativo Android, responsável pela inicialização do ciclo de vida e definição do conteúdo Compose (`setContent`).
* **`CalculadoraDescontoScreen.kt`**: Camada de interface (UI), responsável pelos componentes visuais (`TextField`, `Button`, `Text`), controle dos estados (`remember`, `mutableStateOf`) e captura de eventos.
* **`CalculadoraDesconto.kt`**: Regra de negócio pura que implementa a função `calcularPrecoComDesconto(preco: Double, percentual: Double): Double`.

---

## 📝 Respostas do Questionário Teórico

### 1. O que é entrada em um sistema computacional? Dê dois exemplos.
Entrada (*input*) é todo dado, informação ou sinal enviado externamente ao sistema computacional para ser recebido, processado ou armazenado. As entradas são fornecidas por usuários, sensores ou outros sistemas e convertidas em dados compreensíveis pela aplicação.
* **Exemplo 1:** O valor numérico ou textual digitado pelo usuário nos campos de texto (`TextField`), como o preço `"500,00"` ou o desconto `"15"`.
* **Exemplo 2:** O toque/clique físico realizado pelo usuário sobre o botão `"CALCULAR"` na tela sensível ao toque do dispositivo móvel.

---

### 2. Qual é a diferença entre processamento e saída?
* **Processamento:** É a fase intermediária na qual os dados brutos de entrada são manipulados, convertidos, validados e submetidos a cálculos lógicos ou matemáticos. Na aplicação, é a etapa onde as strings `"500,00"` e `"15"` são validadas, convertidas para `Double` e submetidas à fórmula matemática de desconto na função `calcularPrecoComDesconto`.
* **Saída (*output*):** É a apresentação ou entrega do resultado obtido após o processamento, tornando-o compreensível e útil ao usuário. Na aplicação, a saída é o texto final formatado e exibido na tela: `"Preço final: R$ 425,00"`.
* **Em síntese:** O processamento opera internamente a transformação dos dados; a saída é a manifestação visível ou perceptível do resultado processado.

---

### 3. Por que o valor digitado em um TextField é inicialmente tratado como texto?
O componente `TextField` captura caracteres diretamente do teclado (físico ou virtual), recebendo sequências de símbolos Unicode. O usuário pode digitar números, letras, espaços, pontos, vírgulas ou símbolos monetários. Além disso, durante a digitação intermediária (por exemplo, ao digitar apenas `"500,"`), o conteúdo temporário não representa um número matematicamente completo ou válido. Por isso, a interface trata a entrada como `String`, cabendo à lógica do aplicativo efetuar a sanitização (ex: substituir vírgula por ponto), validação e conversão segura para tipos numéricos (como `toDoubleOrNull()`).

---

### 4. Qual é a finalidade de remember e mutableStateOf?
* **`mutableStateOf`:** Cria um estado reativo observável pelo Compose (`MutableState<T>`). Quando o seu valor é alterado, o framework é notificado automaticamente para agendar e executar a atualização visual da interface.
* **`remember`:** Instrução que retém e preserva o valor de uma variável na memória ao longo das recomposições da função composable. Sem o `remember`, toda vez que a tela fosse redesenhada, a variável seria recriada com o seu valor inicial padrão, descartando o que o usuário já havia digitado.
* **Juntos (`remember { mutableStateOf("") }`):** Garantem que a tela armazene valores mutáveis ao longo do tempo sem perdê-los quando a interface for recomposta.

---

### 5. O que é um evento? Cite os eventos utilizados nesta aplicação.
Um evento é um sinal ou notificação disparada em resposta a uma ação externa (interação do usuário) ou interna (do sistema operacional), indicando que um determinado fato ocorreu e permitindo que o programa execute uma ação de resposta.
* **`onValueChange` (nos `TextField`):** Evento disparado a cada caractere digitado, apagado ou colado nos campos de Preço e Desconto, atualizando as variáveis de estado correspondentes (`precoTexto` e `percentualTexto`).
* **`onClick` (no `Button`):** Evento disparado quando o usuário pressiona o botão `"CALCULAR"`, executando a rotina de validação dos dados, chamada da função de cálculo e atualização do estado `resultado`.

---

### 6. O que significa recomposição no Jetpack Compose?
Recomposição é o mecanismo central do Jetpack Compose pelo qual o framework re-executa de forma inteligente apenas as funções composables cujos estados observados sofreram modificação. Ao contrário da abordagem tradicional com Views em XML (onde cada elemento precisava ser buscado e alterado manualmente via código imperativo), no Compose a interface é declarativa: `UI = f(Estado)`. Ao atualizar o estado `resultado`, o Compose identifica a dependência e redesenha exclusivamente os componentes afetados, garantindo eficiência e consistência visual.

---

### 7. Qual é a responsabilidade da MainActivity neste projeto?
A `MainActivity` herda de `ComponentActivity` e atua como o ponto de entrada principal do aplicativo no ecossistema Android. Suas responsabilidades são:
1. Gerenciar o ciclo de vida inicial da Activity através do método `onCreate`.
2. Configurar o layout de ponta a ponta na tela do aparelho (`enableEdgeToEdge()`).
3. Inicializar a hierarquia de composição do Jetpack Compose através da função `setContent { ... }`, invocando a tela principal `CalculadoraDescontoScreen()`.

---

### 8. Qual é a responsabilidade de CalculadoraDescontoScreen?
A função composable `CalculadoraDescontoScreen` é responsável pela **camada de interface de usuário (UI)** e gerenciamento de estados locais da tela:
1. Declarar e armazenar os estados observáveis (`precoTexto`, `percentualTexto` e `resultado`).
2. Definir a estrutura visual e os componentes de tela (`Column`, `Text`, `TextField`, `Button`, `Spacer`).
3. Escutar e tratar os eventos de interação (`onValueChange` e `onClick`).
4. Realizar a sanitização e validação das entradas, converter os valores, acionar a regra de negócio e atualizar o estado de saída exibido na tela.

---

### 9. Por que calcularPrecoComDesconto foi colocada em outro arquivo?
A função foi separada no arquivo `CalculadoraDesconto.kt` para respeitar o princípio de **Separação de Preocupações (Separation of Concerns)** e a divisão de camadas de software:
* A camada de apresentação (`CalculadoraDescontoScreen.kt`) deve cuidar unicamente da exibição, estados visuais e interação com o usuário.
* A camada de regras de negócio (`CalculadoraDesconto.kt`) deve conter estritamente a lógica matemática pura da aplicação.
Essa divisão torna o projeto modular, limpo, de fácil manutenção e leitura.

---

### 10. Qual é a vantagem de uma função de regra de negócio não depender do Compose?
Manter a regra de negócio como uma função pura em Kotlin (que recebe e retorna tipos primitivos padrão como `Double`), sem nenhuma dependência de bibliotecas do Compose ou do Android, traz vantagens cruciais:
1. **Facilidade de Testes Unitários:** Pode ser testada diretamente na JVM com JUnit em milissegundos, sem precisar carregar emulador, ciclo de vida de telas ou bibliotecas de UI.
2. **Alta Reutilização:** Pode ser reutilizada em qualquer parte da aplicação (em ViewModels, em telas legadas com XML/Views, em serviços de background ou até em outros módulos e plataformas compartilhadas via Kotlin Multiplatform).
3. **Baixo Acoplamento e Manutenibilidade:** Alterações futuras na interface gráfica não afetam ou quebram a lógica de cálculo, e vice-versa.

---

Feito com 💙 para fins de estudo e prática com Jetpack Compose.
# Jetpack-compose
