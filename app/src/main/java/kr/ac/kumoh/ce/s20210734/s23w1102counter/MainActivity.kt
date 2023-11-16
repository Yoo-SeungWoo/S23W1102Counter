package kr.ac.kumoh.ce.s20210734.s23w1102counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.ce.s20210734.s23w1102counter.ui.theme.S23W1102CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*MyApp{
                Greeting("안녕하세요")
            }
            */
            MyApp {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Clicker()
                    Counter()
                    Counter()
                }
            }
        }
    }
}

@Composable
fun MyApp(content:@Composable () -> Unit) {
    S23W1102CounterTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}*/

//함수를 다시 호출 해야 바뀐다->이 과정을 Recomposition(재구성)이라고 한다->State 사용
@Composable
fun Clicker() {
    //var txtString = "눌러주세요"
    //var txtString by remember { mutableStateOf("눌러주세요") }
    val (txtString, setTxtString) = remember { mutableStateOf("눌러주세요") }

    /*Column {
        Text(txtString)
        //Button(onClick = { txtString = "눌렸습니다" } ) {
        Button(onClick = { setTxtString("눌렸습니다") } ) {
            Text("눌러봐")
        }
    }*/
    Column(
        modifier = Modifier
            //.fillMaxSize()
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = txtString,
            fontSize = 70.sp,
        )
        Button(modifier = Modifier
            .fillMaxWidth(),
            onClick = {
                setTxtString("눌렸습니다")
            }) {
            // Text(text = "눌러봐")
            Text("눌러봐")
        }
    }
}/**/

@Composable
fun Counter() {
    //var count = 0;
    val (count, setCount) = rememberSaveable{ mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$count",
            fontSize = 70.sp,
        )
        Row {
            Button(modifier = Modifier.weight(1f),
                onClick = {
                    //count++
                    setCount(count + 1)
                }) {
                Text("증가")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(modifier = Modifier.weight(1f),
                onClick = {
                    if(count >0 )
                        setCount(count - 1)
                }) {
                Text("감소")
            }
        }

    }
}
