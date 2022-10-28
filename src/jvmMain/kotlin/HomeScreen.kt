import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Sorteio", color = MaterialTheme.colors.primary, style = MaterialTheme.typography.h1)
        val list = remember {
            mutableStateListOf<String>()
        }
        Row(
            horizontalArrangement = Arrangement.Center,
        ) {
            Column(modifier.padding(top = 60.dp)) {
                var text by remember { mutableStateOf("") }

                TextField(value = text, onValueChange = { newText ->
                    text = newText
                })
                Row {
                    Button(onClick = {
                        list.add(text)
                    }) {
                        Text("Add")
                    }

                    Spacer(modifier = Modifier.padding(8.dp))

                    Button(onClick = {
                        list.clear()
                    }, colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.error)) {
                        Text("Limpar")
                    }
                }

                // Lista dos elementos a sortear
                LazyColumn(
                    modifier = Modifier.padding(8.dp)
                ) {
                    items(list) {
                        Text(it)
                    }
                }
            }

            Spacer(modifier = Modifier.padding(8.dp))

            var text by remember { mutableStateOf("") }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxHeight().width(280.dp)
            ) {

                Button(onClick = {
                    if (list.isNotEmpty()) {
                        val index = (0 until list.size).random()
                        text = list[index]
                    }
                }) {
                    Text("Sortear")
                }

                Text(
                    text,
                    color = MaterialTheme.colors.secondary,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}
