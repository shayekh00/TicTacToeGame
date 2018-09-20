package com.example.user.tictactoy

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    public fun buClick(view: View){
        var selectedBut: Button = view as Button
        var cellID=0;
        when(selectedBut.id)
        {
            R.id.button -> cellID=1
            R.id.button2 -> cellID=2
            R.id.button3 -> cellID=3
            R.id.button4 -> cellID=4
            R.id.button5 -> cellID=5
            R.id.button6 -> cellID=6
            R.id.button7 -> cellID=7
            R.id.button8 -> cellID=8
            R.id.button9 -> cellID=9
        }
//        Toast.makeText(this,"ID : "+cellID ,Toast.LENGTH_SHORT).show()
        PlayGame(cellID,selectedBut);
        CheckWinner();
    }

    var Player1=ArrayList<Int>()
    var Player2=ArrayList<Int>()
    var ActivePlayer=1

    fun PlayGame(cellID:Int,buSelected:Button){
        if(ActivePlayer==1){
            buSelected.text="X"
            buSelected.setBackgroundColor(Color.GREEN)
            Player1.add(cellID)
            ActivePlayer=2
        }else{
            buSelected.text="0"
            buSelected.setBackgroundColor(Color.BLUE)
            Player2.add(cellID)
            ActivePlayer=1
        }
        buSelected.isEnabled=false
    }

    fun CheckWinner(){
        var Winner=-1;

        //row1
        if(Player1.contains(1) && Player1.contains(2) && Player1.contains(3)){Winner=1}
        if(Player2.contains(1) && Player2.contains(2) && Player2.contains(3)){Winner=2}

        //row2
        if(Player1.contains(4) && Player1.contains(5) && Player1.contains(6)){Winner=1}
        if(Player2.contains(4) && Player2.contains(5) && Player2.contains(6)){Winner=2}

        //row3
        if(Player1.contains(4) && Player1.contains(5) && Player1.contains(6)){Winner=1}
        if(Player2.contains(4) && Player2.contains(5) && Player2.contains(6)){Winner=2}

        //coloum1
        if(Player1.contains(1) && Player1.contains(4) && Player1.contains(7)){Winner=1}
        if(Player2.contains(1) && Player2.contains(4) && Player2.contains(7)){Winner=2}

        //coloum2
        if(Player1.contains(2) && Player1.contains(5) && Player1.contains(8)){Winner=1}
        if(Player2.contains(2) && Player2.contains(5) && Player2.contains(8)){Winner=2}

        //coloum3
        if(Player1.contains(3) && Player1.contains(6) && Player1.contains(9)){Winner=1}
        if(Player2.contains(3) && Player2.contains(6) && Player2.contains(9)){Winner=2}

        //hypotenous1
        if(Player1.contains(1) && Player1.contains(5) && Player1.contains(9)){Winner=1}
        if(Player2.contains(1) && Player2.contains(5) && Player2.contains(9)){Winner=2}

        //hypotenous2
        if(Player1.contains(1) && Player1.contains(5) && Player1.contains(9)){Winner=1}
        if(Player2.contains(1) && Player2.contains(5) && Player2.contains(9)){Winner=2}

        if(Winner !=-1){
            if(Winner==1){Toast.makeText(this,"Winner : Player "+Winner ,Toast.LENGTH_SHORT).show()}
            else{Toast.makeText(this,"Winner : Player "+Winner ,Toast.LENGTH_SHORT).show()}
        }
    }
}
