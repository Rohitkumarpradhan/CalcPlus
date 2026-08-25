package com.example.calcplus.presentation

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.lifecycle.ViewModel
import com.example.calcplus.logic.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
@Preview
@Composable
fun CalcScreen(
    viewModel: CalculatorViewModel = viewModel()
){



    Column(modifier = Modifier.fillMaxSize()
        .padding(top = 35.dp , bottom = 35.dp)
        .clip(RoundedCornerShape(50f))
        .background(color = Color.Gray),
        verticalArrangement = Arrangement.spacedBy(20.dp)

    ) {

        //display box
        Box(modifier = Modifier
            .padding(top = 0.dp)
            .fillMaxWidth()
            .height(350.dp)
            .clip(RoundedCornerShape(50f))
            .background(color = Color.LightGray)) {
            Text(
//                text = buildString {
//                    if (viewModel.state.firstnum != null) {
//                        append(formatRes(viewModel.state.firstnum!!))
//                        append(" ")
//                    }
//
//                    if (viewModel.state.operator != null) {
//                        append(viewModel.state.operator)
//                        append(" ")
//                    }
//
//                    if (viewModel.state.firstnum != null &&
//                        viewModel.state.operator != null &&
//                        viewModel.state.display != "0"
//                    ) {
//                        append(viewModel.state.display)
//                    }
//                },
                text= viewModel.state.expression,
                fontSize = 24.sp,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopEnd)
                    .padding(20.dp)
            )



                Text(text = viewModel.state.display,
                    fontSize = 60.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomEnd)
                        .padding(20.dp)
                )
        }
        Spacer(modifier = Modifier.height(20.dp))
        //row 01
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                modifier = Modifier.weight(1f).height(60.dp),
                onClick = {
                    viewModel.allclear()
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Green,
                    containerColor = Color.DarkGray)) {
                Text("AC" , fontSize = 25.sp)
            }
            Button(
                modifier = Modifier.weight(1f).height(60.dp),

                onClick = {
                    viewModel.percentage()
                },
                ) {
                Text("%" , fontSize = 25.sp)
            }

            Button(
                modifier = Modifier.weight(1f).height(60.dp),
                onClick = {
                    viewModel.deleteLast()
                }) {
                Text("⌫", fontSize =  25.sp)
            }

            Button(
                modifier = Modifier.weight(1f).height(60.dp),
                onClick = {
                   viewModel.setOperator("/")
                }) {
                Text("/", fontSize =  25.sp)
            }
        }

        //row 2
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                modifier = Modifier.weight(1f).height(60.dp),

                onClick = {
                    viewModel.addNum("7")

                }) {
                Text("7", fontSize =  25.sp)
            }

            Button(
                modifier = Modifier.weight(1f).height(60.dp),
                onClick = {
                    viewModel.addNum("8")
                }) {
                Text("8", fontSize = 25.sp)
            }
            Button(
                modifier = Modifier.weight(1f).height(60.dp),
                onClick = {
                    viewModel.addNum("9")
                }) {
                Text("9", fontSize = 25.sp)
            }
            Button(
                modifier = Modifier.weight(1f).height(60.dp),
                onClick = {
                    viewModel.setOperator("x")

                }) {
                Text("x", fontSize = 30.sp)
            }
        }

        //row 3
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                modifier = Modifier.weight(1f).height(60.dp),
                onClick = {
                    viewModel.addNum("4")
                }) {
                Text("4", fontSize = 25.sp)
            }

            Button(
                modifier = Modifier.weight(1f).height(60.dp),
                onClick = {
                    viewModel.addNum("5")
                }) {
                Text("5", fontSize = 25.sp)
            }
            Button(
                modifier = Modifier.weight(1f).height(60.dp),
                onClick = {
                    viewModel.addNum("6")
                }) {
                Text("6", fontSize = 25.sp)
            }

            Button(
                modifier = Modifier.weight(1f).height(60.dp),
                onClick = {
                   viewModel.setOperator("-")
                }) {
                Text("-", fontSize = 35.sp)
            }
        }

        //row 4
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                modifier = Modifier.weight(1f).height(60.dp),
                onClick = {
                    viewModel.addNum("1")
                }) {
                Text("1", fontSize = 25.sp)
            }

            Button(
                modifier = Modifier.weight(1f).height(60.dp),
                onClick = {
                    viewModel.addNum("2")
                }) {
                Text("2", fontSize = 25.sp)
            }
            Button(
                modifier = Modifier.weight(1f).height(60.dp),
                onClick = {
                    viewModel.addNum("3")
                }) {
                Text("3", fontSize = 25.sp)
            }


            Button(
                modifier = Modifier.weight(1f).height(60.dp),
                onClick = {
                    viewModel.setOperator("+")
                }) {
                Text("+", fontSize = 35.sp)
            }
        }

        //row 5
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                modifier = Modifier.weight(1f).height(60.dp),
                onClick = {
                    viewModel.addNum("0")
                }) {
                Text("0", fontSize = 25.sp)
            }

            Button(
                modifier = Modifier.weight(1f).height(60.dp),
                onClick = {
                    viewModel.addDecimal()
                }) {
                Text(".", fontSize = 40.sp)
            }
            Button(
                modifier = Modifier.weight(1f).height(60.dp),
                onClick = {
                   viewModel.toggleSign()
                }) {
                Text("+/-", fontSize = 40.sp)
            }
            Button(
                modifier = Modifier.weight(1f).height(60.dp),
                onClick = {
                   viewModel.calculateResult()

                }) {
                Text("=", fontSize = 35.sp)
            }



        }

    }
}

