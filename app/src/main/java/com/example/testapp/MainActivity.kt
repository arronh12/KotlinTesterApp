package com.example.testapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

/************************************************************************************************
 * @Author - Arron Hoare
 * @Ver - 01
 *
 * DESCRIPTION OF APP
 * App used to  help user decide what food to eat by randomly generating an option from a list of
 * choices.
 * The user can add new options that are added to list to be randomly generated.
 ***********************************************************************************************/
class MainActivity : AppCompatActivity() {

    //list of foods to be randomly displayed. can be added too with listener
    val foodlist = arrayListOf("Chinese", "Indian", "Thi", "burger king")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /****************************************************************************************
            onClick Listeners for buttons on main activity.
            -Decide btn makes random number between zero and foodlist count then sets
             selected food display text to the foodlist at position of random number.
         ***************************************************************************************/
        decideBtn.setOnClickListener {
            val random = Random
            val randomFood = random.nextInt(foodlist.count())
            selectedFoodText.text = foodlist[randomFood]

        }

        /*****************************************************************************************
            btn takes text from addFoodText and adds it to foodsList as new food that can be
            randomly brought up in decideBtn Listener
        *****************************************************************************************/
        addFoodBtn.setOnClickListener {
            if(addFoodText.text.isEmpty()){
                println("Food text is empty")
            }
            else {
                val newFood = addFoodText.text.toString()
                foodlist.add(newFood)
            }
            addFoodText.text.clear()
        }

    }
}
