package br.edu.fatecpg.appcompose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import java.util.Locale

@Composable
fun CalculadoraDescontoScreen() {
    var precoTexto by remember {
        mutableStateOf("")
    }
    var percentualTexto by remember {
        mutableStateOf("")
    }
    var resultado by remember {
        mutableStateOf("Informe o preço e o desconto e toque em calcular.")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(24.dp)
    ) {
        Text(
            text = "Calculadora de Desconto",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = precoTexto,
            onValueChange = { novoTexto ->
                precoTexto = novoTexto
            },
            label = { Text("Preço do produto") },
            placeholder = { Text("Ex: 500,00") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = percentualTexto,
            onValueChange = { novoTexto ->
                percentualTexto = novoTexto
            },
            label = { Text("Percentual de desconto") },
            placeholder = { Text("Ex: 15") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val preco = precoTexto
                    .trim()
                    .replace(",", ".")
                    .toDoubleOrNull()

                val percentual = percentualTexto
                    .trim()
                    .replace(",", ".")
                    .toDoubleOrNull()

                if (preco == null || preco < 0) {
                    resultado = "Digite um preço válido."
                } else if (percentual == null || percentual < 0 || percentual > 100) {
                    resultado = "Digite um percentual de desconto válido (0 a 100)."
                } else {
                    val precoFinal = calcularPrecoComDesconto(preco, percentual)
                    resultado = String.format(
                        Locale.forLanguageTag("pt-BR"),
                        "Preço final: R$ %.2f",
                        precoFinal
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("CALCULAR")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = resultado,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
