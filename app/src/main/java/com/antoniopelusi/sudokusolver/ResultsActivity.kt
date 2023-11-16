package com.antoniopelusi.sudokusolver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.antoniopelusi.sudokusolver.count

class ResultsActivity : AppCompatActivity() {

    private lateinit var board: Array<IntArray>

    private lateinit var cells: Array<Array<TextView?>>

    private val solver = Solver()

    private fun initBoard()
    {
        val c11: TextView? = findViewById(R.id.c11)
        val c12: TextView? = findViewById(R.id.c12)
        val c13: TextView? = findViewById(R.id.c13)
        val c14: TextView? = findViewById(R.id.c14)
        val c15: TextView? = findViewById(R.id.c15)
        val c16: TextView? = findViewById(R.id.c16)
        val c17: TextView? = findViewById(R.id.c17)
        val c18: TextView? = findViewById(R.id.c18)
        val c19: TextView? = findViewById(R.id.c19)
        val c21: TextView? = findViewById(R.id.c21)
        val c22: TextView? = findViewById(R.id.c22)
        val c23: TextView? = findViewById(R.id.c23)
        val c24: TextView? = findViewById(R.id.c24)
        val c25: TextView? = findViewById(R.id.c25)
        val c26: TextView? = findViewById(R.id.c26)
        val c27: TextView? = findViewById(R.id.c27)
        val c28: TextView? = findViewById(R.id.c28)
        val c29: TextView? = findViewById(R.id.c29)
        val c31: TextView? = findViewById(R.id.c31)
        val c32: TextView? = findViewById(R.id.c32)
        val c33: TextView? = findViewById(R.id.c33)
        val c34: TextView? = findViewById(R.id.c34)
        val c35: TextView? = findViewById(R.id.c35)
        val c36: TextView? = findViewById(R.id.c36)
        val c37: TextView? = findViewById(R.id.c37)
        val c38: TextView? = findViewById(R.id.c38)
        val c39: TextView? = findViewById(R.id.c39)
        val c41: TextView? = findViewById(R.id.c41)
        val c42: TextView? = findViewById(R.id.c42)
        val c43: TextView? = findViewById(R.id.c43)
        val c44: TextView? = findViewById(R.id.c44)
        val c45: TextView? = findViewById(R.id.c45)
        val c46: TextView? = findViewById(R.id.c46)
        val c47: TextView? = findViewById(R.id.c47)
        val c48: TextView? = findViewById(R.id.c48)
        val c49: TextView? = findViewById(R.id.c49)
        val c51: TextView? = findViewById(R.id.c51)
        val c52: TextView? = findViewById(R.id.c52)
        val c53: TextView? = findViewById(R.id.c53)
        val c54: TextView? = findViewById(R.id.c54)
        val c55: TextView? = findViewById(R.id.c55)
        val c56: TextView? = findViewById(R.id.c56)
        val c57: TextView? = findViewById(R.id.c57)
        val c58: TextView? = findViewById(R.id.c58)
        val c59: TextView? = findViewById(R.id.c59)
        val c61: TextView? = findViewById(R.id.c61)
        val c62: TextView? = findViewById(R.id.c62)
        val c63: TextView? = findViewById(R.id.c63)
        val c64: TextView? = findViewById(R.id.c64)
        val c65: TextView? = findViewById(R.id.c65)
        val c66: TextView? = findViewById(R.id.c66)
        val c67: TextView? = findViewById(R.id.c67)
        val c68: TextView? = findViewById(R.id.c68)
        val c69: TextView? = findViewById(R.id.c69)
        val c71: TextView? = findViewById(R.id.c71)
        val c72: TextView? = findViewById(R.id.c72)
        val c73: TextView? = findViewById(R.id.c73)
        val c74: TextView? = findViewById(R.id.c74)
        val c75: TextView? = findViewById(R.id.c75)
        val c76: TextView? = findViewById(R.id.c76)
        val c77: TextView? = findViewById(R.id.c77)
        val c78: TextView? = findViewById(R.id.c78)
        val c79: TextView? = findViewById(R.id.c79)
        val c81: TextView? = findViewById(R.id.c81)
        val c82: TextView? = findViewById(R.id.c82)
        val c83: TextView? = findViewById(R.id.c83)
        val c84: TextView? = findViewById(R.id.c84)
        val c85: TextView? = findViewById(R.id.c85)
        val c86: TextView? = findViewById(R.id.c86)
        val c87: TextView? = findViewById(R.id.c87)
        val c88: TextView? = findViewById(R.id.c88)
        val c89: TextView? = findViewById(R.id.c89)
        val c91: TextView? = findViewById(R.id.c91)
        val c92: TextView? = findViewById(R.id.c92)
        val c93: TextView? = findViewById(R.id.c93)
        val c94: TextView? = findViewById(R.id.c94)
        val c95: TextView? = findViewById(R.id.c95)
        val c96: TextView? = findViewById(R.id.c96)
        val c97: TextView? = findViewById(R.id.c97)
        val c98: TextView? = findViewById(R.id.c98)
        val c99: TextView? = findViewById(R.id.c99)

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

    private fun writeBoard(board: Array<IntArray>)
    {
        for(i in 0 until 9)
        {
            for(j in 0 until 9)
            {
                if(board[i][j] == 0)
                {
                    cells[i][j]?.text = ""
                }
                else
                {
                    cells[i][j]?.text = board[i][j].toString()
                }
            }
        }
    }

    private fun rawToBoard(rawValue: String): Array<IntArray>
    {
        var k = 0
        val board = Array(9) { IntArray(9) }

        for(i in 0 until 9)
        {
            for (j in 0 until 9)
            {
                board[i][j] = rawValue[k].toString().toInt()

                k++
            }
        }
        return board
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.fragment_results)

        val rawValue = intent.getStringExtra("rawValue").toString()

        board = rawToBoard(rawValue)

        initBoard()

        writeBoard(board)

        findViewById<Button>(R.id.solve_button_results).setOnClickListener()
        {
            if(solver.checkBoard(board)) {
                count = 0

                solver.solve(board, 0, 0)

                if (!solver.checkForZeros(board)) {
                    writeBoard(board)
                } else {
                    Toast.makeText(this, R.string.malformed_sudoku, Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(this, R.string.empty_sudoku, Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.exit_button_results).setOnClickListener()
        {
            finish()
        }
    }
}