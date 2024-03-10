package com.example.heartdiseasedetetectionapp.View.HomeScreen.HomeScreenFinal

import android.annotation.SuppressLint
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.heartdiseasedetetectionapp.R
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CardHeading
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomCheckBoxExang
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomCheckBoxFbs
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomDropDownMenuCa
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomDropDownMenuCp
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomDropDownMenuRestecg
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomDropDownMenuSlope
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomDropDownMenuThal
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomLabel
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomTextFieldAge
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomTextFieldChol
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomTextFieldOldpeak
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomTextFieldThalach
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomTextFieldTrestbps
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.GenerateResult
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.SexCardFemale
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.SexCardMale
import com.example.heartdiseasedetetectionapp.ViewModel.HeartDiseaseViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun HomeScreen(navController: NavHostController){

    val viewModel: HeartDiseaseViewModel = viewModel()
    val response by viewModel.responseValue.collectAsState()
    val server by viewModel.serverCode.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.primary))
        .padding(10.dp)) {

        Spacer(modifier = Modifier.height(30.dp))
        CardHeading()
        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn(){
            item {

                // Row 1
                CustomLabel(heading = "Gender", 20)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                )
                {
                    SexCardMale("Male", painterResource(id = R.drawable.male), viewModel)
                    Spacer(modifier = Modifier.width(4.dp))
                    SexCardFemale("Female", painterResource(id = R.drawable.female), viewModel)
                }
                Spacer(modifier = Modifier.height(12.dp))

                // Row 2
                CustomLabel(heading = "Age", 20)
                CustomTextFieldAge(placeholder = "Enter your Age", viewModel = viewModel)
                Spacer(modifier = Modifier.height(12.dp))

                // Row 3
                Row(modifier = Modifier.fillMaxWidth()) {
                    CustomLabel(heading = "FBS > 120 mg/dl", 20)
                    Spacer(modifier = Modifier.width(35.dp))
                    CustomLabel(heading = "Exang", 20)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    CustomCheckBoxFbs(text1 = "Yes", text2 = "No", viewModel)
                    CustomCheckBoxExang(text1 = "Yes", text2 = "No", viewModel)

                }
                Spacer(modifier = Modifier.height(12.dp))

                // Row 4
                CustomLabel(heading = "Trestbps", 20)
                CustomTextFieldTrestbps("Enter your resting blood pressure", viewModel)
                Spacer(modifier = Modifier.height(12.dp))

                // Row 5
                CustomLabel(heading = "Chol", 20)
                CustomTextFieldChol("Enter your cholesterol measurement in mg/dl", viewModel)
                Spacer(modifier = Modifier.height(12.dp))

                // Row 6
                CustomLabel(heading = "Thalach", 20)
                CustomTextFieldThalach("Enter your maximum heart rate achieved", viewModel)
                Spacer(modifier = Modifier.height(12.dp))

                // Row 7
                CustomLabel(heading = "Chest Pain Type", 20)
                CustomDropDownMenuCp(items = listOf("Angina", "Atypical angina", "Non-anginal", "Asymptomatic"), viewModel)
                Spacer(modifier = Modifier.height(12.dp))

                // Row 8
                CustomLabel(heading = "Thalassemia Value", 20)
                CustomDropDownMenuThal(items = listOf("Fixed defect", "Normal blood flow", "Reversible defect"), viewModel)
                Spacer(modifier = Modifier.height(12.dp))

                // Row 9
                CustomLabel(heading = "Resting Electrocardiograph", 20)
                CustomDropDownMenuRestecg(items = listOf("Normal", "Probable or definite left ventricular hypertrophy", "Having ST-T wave abnormality"), viewModel)
                Spacer(modifier = Modifier.height(12.dp))

                // Row 10
                CustomLabel(heading = "OldPeak", 20)
                CustomTextFieldOldpeak("ST depression induced by exercise relative to rest", viewModel)
                Spacer(modifier = Modifier.height(12.dp))

                // Row 11
                CustomLabel(heading = "Slope", 20)
                CustomDropDownMenuSlope(items = listOf("Upsloping", "Flat", "Downsloping"), viewModel)
                Spacer(modifier = Modifier.height(20.dp))

                // Row 12
                CustomLabel(heading = " Number of major vessels(ca)", 20)
                CustomDropDownMenuCa(items = listOf("0", "1", "2", "3"), viewModel)
                Spacer(modifier = Modifier.height(20.dp))

                // Row 13
                GenerateResult(navController = navController, viewModel)
                Spacer(modifier = Modifier.height(10.dp))



                Text("Result")
                Text(response, fontSize = 32.sp, color = Color.Black)
                Text("Server")
                Text(server, fontSize = 32.sp, color = Color.Black)
            }
        }
    }
}
