package com.antoniopelusi.sudokusolver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ResultsActivity : AppCompatActivity() {

    private val emptyBoard = Array(9) { IntArray(9) }

    private lateinit var newBoard: Array<IntArray>

    private lateinit var cells: Array<Array<EditText?>>

    private val solver = Solver()

    private fun initBoard()
    {
        val c11: EditText? = findViewById(R.id.c11)
        val c12: EditText? = findViewById(R.id.c12)
        val c13: EditText? = findViewById(R.id.c13)
        val c14: EditText? = findViewById(R.id.c14)
        val c15: EditText? = findViewById(R.id.c15)
        val c16: EditText? = findViewById(R.id.c16)
        val c17: EditText? = findViewById(R.id.c17)
        val c18: EditText? = findViewById(R.id.c18)
        val c19: EditText? = findViewById(R.id.c19)
        val c21: EditText? = findViewById(R.id.c21)
        val c22: EditText? = findViewById(R.id.c22)
        val c23: EditText? = findViewById(R.id.c23)
        val c24: EditText? = findViewById(R.id.c24)
        val c25: EditText? = findViewById(R.id.c25)
        val c26: EditText? = findViewById(R.id.c26)
        val c27: EditText? = findViewById(R.id.c27)
        val c28: EditText? = findViewById(R.id.c28)
        val c29: EditText? = findViewById(R.id.c29)
        val c31: EditText? = findViewById(R.id.c31)
        val c32: EditText? = findViewById(R.id.c32)
        val c33: EditText? = findViewById(R.id.c33)
        val c34: EditText? = findViewById(R.id.c34)
        val c35: EditText? = findViewById(R.id.c35)
        val c36: EditText? = findViewById(R.id.c36)
        val c37: EditText? = findViewById(R.id.c37)
        val c38: EditText? = findViewById(R.id.c38)
        val c39: EditText? = findViewById(R.id.c39)
        val c41: EditText? = findViewById(R.id.c41)
        val c42: EditText? = findViewById(R.id.c42)
        val c43: EditText? = findViewById(R.id.c43)
        val c44: EditText? = findViewById(R.id.c44)
        val c45: EditText? = findViewById(R.id.c45)
        val c46: EditText? = findViewById(R.id.c46)
        val c47: EditText? = findViewById(R.id.c47)
        val c48: EditText? = findViewById(R.id.c48)
        val c49: EditText? = findViewById(R.id.c49)
        val c51: EditText? = findViewById(R.id.c51)
        val c52: EditText? = findViewById(R.id.c52)
        val c53: EditText? = findViewById(R.id.c53)
        val c54: EditText? = findViewById(R.id.c54)
        val c55: EditText? = findViewById(R.id.c55)
        val c56: EditText? = findViewById(R.id.c56)
        val c57: EditText? = findViewById(R.id.c57)
        val c58: EditText? = findViewById(R.id.c58)
        val c59: EditText? = findViewById(R.id.c59)
        val c61: EditText? = findViewById(R.id.c61)
        val c62: EditText? = findViewById(R.id.c62)
        val c63: EditText? = findViewById(R.id.c63)
        val c64: EditText? = findViewById(R.id.c64)
        val c65: EditText? = findViewById(R.id.c65)
        val c66: EditText? = findViewById(R.id.c66)
        val c67: EditText? = findViewById(R.id.c67)
        val c68: EditText? = findViewById(R.id.c68)
        val c69: EditText? = findViewById(R.id.c69)
        val c71: EditText? = findViewById(R.id.c71)
        val c72: EditText? = findViewById(R.id.c72)
        val c73: EditText? = findViewById(R.id.c73)
        val c74: EditText? = findViewById(R.id.c74)
        val c75: EditText? = findViewById(R.id.c75)
        val c76: EditText? = findViewById(R.id.c76)
        val c77: EditText? = findViewById(R.id.c77)
        val c78: EditText? = findViewById(R.id.c78)
        val c79: EditText? = findViewById(R.id.c79)
        val c81: EditText? = findViewById(R.id.c81)
        val c82: EditText? = findViewById(R.id.c82)
        val c83: EditText? = findViewById(R.id.c83)
        val c84: EditText? = findViewById(R.id.c84)
        val c85: EditText? = findViewById(R.id.c85)
        val c86: EditText? = findViewById(R.id.c86)
        val c87: EditText? = findViewById(R.id.c87)
        val c88: EditText? = findViewById(R.id.c88)
        val c89: EditText? = findViewById(R.id.c89)
        val c91: EditText? = findViewById(R.id.c91)
        val c92: EditText? = findViewById(R.id.c92)
        val c93: EditText? = findViewById(R.id.c93)
        val c94: EditText? = findViewById(R.id.c94)
        val c95: EditText? = findViewById(R.id.c95)
        val c96: EditText? = findViewById(R.id.c96)
        val c97: EditText? = findViewById(R.id.c97)
        val c98: EditText? = findViewById(R.id.c98)
        val c99: EditText? = findViewById(R.id.c99)

        cells =
            arrayOf(
                arrayOf(c11, c12, c13, c14, c15, c16, c17, c18, c19),
                arrayOf(c21, c22, c23, c24, c25, c26, c27, c28, c29),
                arrayOf(c31, c32, c33, c34, c35, c36, c37, c38, c39),
                arrayOf(c41, c42, c43, c44, c45, c46, c47, c48, c49),
                arrayOf(c51, c52, c53, c54, c55, c56, c57, c58, c59),
                arrayOf(c61, c62, c63, c64, c65, c66, c67, c68, c69),
                arrayOf(c71, c72, c73, c74, c75, c76, c77, c78, c79),
                arrayOf(c81, c82, c83, c84, c85, c86, c87, c88, c89),
                arrayOf(c91, c92, c93, c94, c95, c96, c97, c98, c99)
            )
    }

    private fun writeBoard(rawValue: String)
    {
        var k = 0

        for(i in 0 until 9)
        {
            for(j in 0 until 9)
            {
                if(rawValue[k] == '0')
                {
                    cells[i][j]?.setText("")
                }
                else
                {
                    cells[i][j]?.setText(rawValue[k].toString())
                }
                k++
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.fragment_results)

        val rawValue = intent.getStringExtra("rawValue").toString()
        //Toast.makeText(this, rawValue, Toast.LENGTH_SHORT).show()

        initBoard()

        findViewById<Button>(R.id.solve_button_results).setOnClickListener()
        {
            //solver.solve(board, 0, 0)
            writeBoard(rawValue)
        }

        findViewById<Button>(R.id.exit_button_results).setOnClickListener()
        {
            finish()
        }
    }
}