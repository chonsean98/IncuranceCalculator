package com.example.incurance_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        /*Toast.makeText(this, "Position = $position", Toast.LENGTH_SHORT).show()*/
        Toast.makeText(this, "Item = ${spinnerAge.getItemAtPosition(position)}", Toast.LENGTH_SHORT).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerAge.onItemSelectedListener = this

        buttonCalculate.setOnClickListener {
            calculatePremium()
        }

    }

    private fun calculatePremium() {
        //TODO calculate insurance premium

        var premium = 0

        //position = index of an item selected by user
        val age: Int = spinnerAge.selectedItemPosition
        premium = when(age){
            0 -> 60
            1 -> 70
            3 -> 90
            4 -> 120
            else ->150
        }

        //ID of a radioButton checked by user
        val gender: Int = radioGroupGender.checkedRadioButtonId
        //if(gender == radioButtonMale.id)
        if(gender == R.id.radioButtonMale){
            if(age == 0) {
                premium += 0
            }
            else if(age == 1){
                premium += 50
            }
            else if(age == 2){
                premium += 150
            }
            else{
                premium += 200
            }
        }
        else{
            premium += 0
        }

        //Boolean value
        val smoker: Boolean = checkBoxSmoker.isChecked
        if(smoker){
            if(age == 0)
                premium += 0
            else if(age == 1)
                premium += 100
            else if(age == 2)
                premium += 150
            else if(age == 3)
                premium += 200
            else if(age == 4)
                premium += 250
            else
                premium += 300
        }else{
            premium += 0
        }
        textViewPremium.text = getString(R.string.premium) + " RM" + premium.toString()
    }

    fun resetInput(view: View?){
        //TODO clear all inputs and outputs
        spinnerAge.setSelection(0)
        textViewPremium.text = getString(R.string.premium)
        checkBoxSmoker.isChecked = false
        radioGroupGender.clearCheck()
    }
}
