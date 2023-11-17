package com.example.ucp2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2.data.DataClass
import com.example.ucp2.data.DataSource.Dosbing1
import com.example.ucp2.data.DataSource.Dosbing2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstPage(goToNextPage: (MutableList<String>) -> Unit,
              onNextButtonClicked: () -> Unit,pilihDosbing1: List<String>,
              onSelectionChanged1: (String) -> Unit,
              onSelectionChanged2: (String) -> Unit,
              pilihDosbing2: List<String>) {

    var txtnama by remember { mutableStateOf("") }
    var txtnim by remember { mutableStateOf("") }
    var txtkonsentrasi by remember { mutableStateOf("") }
    var txtjudul by remember { mutableStateOf("") }

    var selectedDosbing1 by rememberSaveable {
        mutableStateOf("")
    }

    var selectedDosbing2 by rememberSaveable {
        mutableStateOf("")
    }

    val listData = mutableListOf<String>(txtnama, txtnim, txtkonsentrasi, txtjudul)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = txtnama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Username")
            },
            onValueChange = {
                txtnama = it
            }
        )
        OutlinedTextField(
            value = txtnim,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Telephone")
            },
            onValueChange = { txtnim = it }
        )
        OutlinedTextField(
            value = txtkonsentrasi,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Email")
            },
            onValueChange = { txtkonsentrasi = it }
        )
        OutlinedTextField(
            value = txtjudul,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Email")
            },
            onValueChange = { txtjudul = it }
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Dosbing 1")
            Text(text = "Dosbing 1")

        }
        Row() {
            pilihDosbing1.forEach { item ->
                Row(modifier = Modifier.selectable(
                    selected = selectedDosbing1 == item,
                    onClick = {
                        selectedDosbing1 = item
                        onSelectionChanged1(item)
                    }
                ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = selectedDosbing1 == item,
                        onClick = {
                            selectedDosbing1 = item
                            onSelectionChanged1(item)
                        }
                    )
                }
            }
            pilihDosbing1.forEach { item ->
                Row(modifier = Modifier.selectable(
                    selected = selectedDosbing2 == item,
                    onClick = {
                        selectedDosbing2 = item
                        onSelectionChanged2(item)
                    }
                ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = selectedDosbing2 == item,
                        onClick = {
                            selectedDosbing2 = item
                            onSelectionChanged2(item)
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding())
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            onClick = onNextButtonClicked,
        ) {
            Text(text = stringResource(R.string.submit), fontSize = 16.sp)
        }
    }
}

@Composable
fun SelectDosbing1(
    options: List<String>,
    onSelectionChanged: (String) -> Unit = {},
) {
    var selectedValue by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        options.forEach { item ->
            Row(
                modifier = Modifier
                    .selectable(
                        selected = selectedValue == item,
                        onClick = {
                            selectedValue = item
                            onSelectionChanged(item)
                        }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(selected = selectedValue == item,
                    onClick = {
                        selectedValue = item
                        onSelectionChanged(item)
                    }
                )
                Text(item)
            }
        }
    }
}

@Composable
fun SelectDosbing2(
    options: List<String>,
    onSelectionChanged: (String) -> Unit = {},
) {
    var selectedValue by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        options.forEach { item ->
            Row(
                modifier = Modifier
                    .selectable(
                        selected = selectedValue == item,
                        onClick = {
                            selectedValue = item
                            onSelectionChanged(item)
                        }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(selected = selectedValue == item,
                    onClick = {
                        selectedValue = item
                        onSelectionChanged(item)
                    }
                )
                Text(item)
            }
        }
    }
}
