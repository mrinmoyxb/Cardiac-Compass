package com.example.heartdiseasedetetectionapp.View.HomeScreen.HomeScreenFinal

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.heartdiseasedetetectionapp.R
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CardHeading
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomCheckBoxExang
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomCheckBoxFbs
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomDropDownMenu
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomLabel
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomTextField
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.GenerateResult
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.SexCard
import com.example.heartdiseasedetetectionapp.ViewModel.HeartDiseaseViewModel

@Composable
fun HomeScreen(navController: NavHostController){

    val viewModel: HeartDiseaseViewModel = viewModel()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.primary))
        .padding(10.dp)) {

        Spacer(modifier = Modifier.height(30.dp))
        CardHeading()
        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn() {
            item {

                // Row 1
                CustomLabel(heading = "Gender", 20)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                )
                {
                    SexCard("Male", painterResource(id = R.drawable.male))
                    Spacer(modifier = Modifier.width(4.dp))
                    SexCard("Female", painterResource(id = R.drawable.female))
                }
                Spacer(modifier = Modifier.height(12.dp))

                // Row 2
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

                // Row 3
                CustomLabel(heading = "Trestbps", 20)
                CustomTextField("Enter your resting blood pressure")
                Spacer(modifier = Modifier.height(12.dp))

                // Row 4
                CustomLabel(heading = "Chol", 20)
                CustomTextField("Enter your cholesterol measurement in mg/dl")
                Spacer(modifier = Modifier.height(12.dp))

                // Row 5
                CustomLabel(heading = "Thalach", 20)
                CustomTextField("Enter your maximum heart rate achieved")
                Spacer(modifier = Modifier.height(12.dp))

                // Row 6
                CustomLabel(heading = "Chest Pain Type", 20)
                CustomDropDownMenu(items = listOf("Angina", "Atypical angina", "Non-anginal", "Asymptomatic"))
                Spacer(modifier = Modifier.height(12.dp))

                // Row 7
                CustomLabel(heading = "Thalassemia Value", 20)
                CustomDropDownMenu(items = listOf("Null", "Fixed defect", "normal blood flow", "reversible defect"))
                Spacer(modifier = Modifier.height(12.dp))

                // Row 8
                CustomLabel(heading = "Resting Electrocardiograph", 20)
                CustomDropDownMenu(items = listOf("Probable or definite left ventricular hypertrophy", "Normal", "Having ST-T wave abnormality"))
                Spacer(modifier = Modifier.height(12.dp))

                // Row 9
                CustomLabel(heading = "OldPeak", 20)
                CustomTextField("ST depression induced by exercise relative to rest")
                Spacer(modifier = Modifier.height(12.dp))

                // Row 10
                CustomLabel(heading = "Slope", 20)
                CustomDropDownMenu(items = listOf("Downsloping", "Flat", "Upsloping"))
                Spacer(modifier = Modifier.height(20.dp))

                GenerateResult(navController = navController)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}
