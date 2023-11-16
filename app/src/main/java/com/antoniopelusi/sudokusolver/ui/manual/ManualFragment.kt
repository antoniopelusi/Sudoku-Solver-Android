package com.antoniopelusi.sudokusolver.ui.manual

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.antoniopelusi.sudokusolver.R
import com.antoniopelusi.sudokusolver.Solver
import com.antoniopelusi.sudokusolver.databinding.FragmentManualBinding
import java.io.File

class ManualFragment : Fragment() {

    private var _binding: FragmentManualBinding? = null
    
    private val binding get() = _binding!!

    private val emptyBoard = Array(9) { IntArray(9) }

    private var board = Array(9) { IntArray(9) }

    private lateinit var cells: Array<Array<EditText?>>

    private val solver = Solver()

    private var arraySavedBoard = Array(9) { IntArray(9) }

    private var savedBoard: String = ""

    private lateinit var filepath: String
    private lateinit var file: File
    private lateinit var uri: Uri

    private fun initBoard()
    {
        val c11: EditText? = view?.findViewById(R.id.c11)
        val c12: EditText? = view?.findViewById(R.id.c12)
        val c13: EditText? = view?.findViewById(R.id.c13)
        val c14: EditText? = view?.findViewById(R.id.c14)
        val c15: EditText? = view?.findViewById(R.id.c15)
        val c16: EditText? = view?.findViewById(R.id.c16)
        val c17: EditText? = view?.findViewById(R.id.c17)
        val c18: EditText? = view?.findViewById(R.id.c18)
        val c19: EditText? = view?.findViewById(R.id.c19)
        val c21: EditText? = view?.findViewById(R.id.c21)
        val c22: EditText? = view?.findViewById(R.id.c22)
        val c23: EditText? = view?.findViewById(R.id.c23)
        val c24: EditText? = view?.findViewById(R.id.c24)
        val c25: EditText? = view?.findViewById(R.id.c25)
        val c26: EditText? = view?.findViewById(R.id.c26)
        val c27: EditText? = view?.findViewById(R.id.c27)
        val c28: EditText? = view?.findViewById(R.id.c28)
        val c29: EditText? = view?.findViewById(R.id.c29)
        val c31: EditText? = view?.findViewById(R.id.c31)
        val c32: EditText? = view?.findViewById(R.id.c32)
        val c33: EditText? = view?.findViewById(R.id.c33)
        val c34: EditText? = view?.findViewById(R.id.c34)
        val c35: EditText? = view?.findViewById(R.id.c35)
        val c36: EditText? = view?.findViewById(R.id.c36)
        val c37: EditText? = view?.findViewById(R.id.c37)
        val c38: EditText? = view?.findViewById(R.id.c38)
        val c39: EditText? = view?.findViewById(R.id.c39)
        val c41: EditText? = view?.findViewById(R.id.c41)
        val c42: EditText? = view?.findViewById(R.id.c42)
        val c43: EditText? = view?.findViewById(R.id.c43)
        val c44: EditText? = view?.findViewById(R.id.c44)
        val c45: EditText? = view?.findViewById(R.id.c45)
        val c46: EditText? = view?.findViewById(R.id.c46)
        val c47: EditText? = view?.findViewById(R.id.c47)
        val c48: EditText? = view?.findViewById(R.id.c48)
        val c49: EditText? = view?.findViewById(R.id.c49)
        val c51: EditText? = view?.findViewById(R.id.c51)
        val c52: EditText? = view?.findViewById(R.id.c52)
        val c53: EditText? = view?.findViewById(R.id.c53)
        val c54: EditText? = view?.findViewById(R.id.c54)
        val c55: EditText? = view?.findViewById(R.id.c55)
        val c56: EditText? = view?.findViewById(R.id.c56)
        val c57: EditText? = view?.findViewById(R.id.c57)
        val c58: EditText? = view?.findViewById(R.id.c58)
        val c59: EditText? = view?.findViewById(R.id.c59)
        val c61: EditText? = view?.findViewById(R.id.c61)
        val c62: EditText? = view?.findViewById(R.id.c62)
        val c63: EditText? = view?.findViewById(R.id.c63)
        val c64: EditText? = view?.findViewById(R.id.c64)
        val c65: EditText? = view?.findViewById(R.id.c65)
        val c66: EditText? = view?.findViewById(R.id.c66)
        val c67: EditText? = view?.findViewById(R.id.c67)
        val c68: EditText? = view?.findViewById(R.id.c68)
        val c69: EditText? = view?.findViewById(R.id.c69)
        val c71: EditText? = view?.findViewById(R.id.c71)
        val c72: EditText? = view?.findViewById(R.id.c72)
        val c73: EditText? = view?.findViewById(R.id.c73)
        val c74: EditText? = view?.findViewById(R.id.c74)
        val c75: EditText? = view?.findViewById(R.id.c75)
        val c76: EditText? = view?.findViewById(R.id.c76)
        val c77: EditText? = view?.findViewById(R.id.c77)
        val c78: EditText? = view?.findViewById(R.id.c78)
        val c79: EditText? = view?.findViewById(R.id.c79)
        val c81: EditText? = view?.findViewById(R.id.c81)
        val c82: EditText? = view?.findViewById(R.id.c82)
        val c83: EditText? = view?.findViewById(R.id.c83)
        val c84: EditText? = view?.findViewById(R.id.c84)
        val c85: EditText? = view?.findViewById(R.id.c85)
        val c86: EditText? = view?.findViewById(R.id.c86)
        val c87: EditText? = view?.findViewById(R.id.c87)
        val c88: EditText? = view?.findViewById(R.id.c88)
        val c89: EditText? = view?.findViewById(R.id.c89)
        val c91: EditText? = view?.findViewById(R.id.c91)
        val c92: EditText? = view?.findViewById(R.id.c92)
        val c93: EditText? = view?.findViewById(R.id.c93)
        val c94: EditText? = view?.findViewById(R.id.c94)
        val c95: EditText? = view?.findViewById(R.id.c95)
        val c96: EditText? = view?.findViewById(R.id.c96)
        val c97: EditText? = view?.findViewById(R.id.c97)
        val c98: EditText? = view?.findViewById(R.id.c98)
        val c99: EditText? = view?.findViewById(R.id.c99)

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

        filepath = requireContext().filesDir.toString() + File.separator + "sudoku.txt"
        file = File(filepath)

        if(!file.exists())
        {
            val str: String = "0".repeat(81)
            file.writeText(str)
        }

        uri = FileProvider.getUriForFile(requireContext(), "com.antoniopelusi.fileprovider", file)
        val inputStream = context?.contentResolver?.openInputStream(uri)
        savedBoard = inputStream?.bufferedReader()?.readText().toString()

        arraySavedBoard = Array(9) { IntArray(9) }
        var c = 0
        for (i in 0 until 9)
        {
            for (j in 0 until 9)
            {
                arraySavedBoard[i][j] = savedBoard[c].toString().toInt()
                c++
            }
        }
        writeBoard(arraySavedBoard)
        inputStream?.close()
    }

    private fun writeBoard(board: Array<IntArray>)
    {
        for (i in 0 until 9)
        {
            for (j in 0 until 9)
            {
                if (board[i][j] == 0)
                {
                    cells[i][j]?.setText("")
                }
                else
                {
                    cells[i][j]?.setText(board[i][j].toString())
                }
            }
        }
    }

    private fun readBoard(cells: Array<Array<EditText?>>): Array<IntArray>
    {
        val newBoard = Array(9) { IntArray(9) }

        for(i in 0 until 9)
        {
            for(j in 0 until 9)
            {
                if(cells[i][j]?.text.toString() == "")
                {
                    newBoard[i][j] = 0
                }
                else
                {
                    newBoard[i][j] = cells[i][j]?.text.toString().toInt()
                }
            }
        }

        return newBoard
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        _binding = FragmentManualBinding.inflate(inflater, container, false)

        val solveButton = binding.solveButtonManual
        solveButton.setOnClickListener()
        {
            board = readBoard(cells)

            if(solver.checkBoard(board))
            {
                solver.solve(board, 0, 0)
                writeBoard(board)
            }
            else
            {
                Toast.makeText(context, R.string.malformed_sudoku, Toast.LENGTH_SHORT).show()
            }

        }
        val resetButton = binding.resetButtonManual
        resetButton.setOnClickListener()
        {
            writeBoard(emptyBoard)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Thread {
            initBoard()
        //}.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onResume() {
        super.onResume()
        if(file.exists())
            writeBoard(arraySavedBoard)
        //lock screen to portrait
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    override fun onPause() {
        super.onPause()
        saveSudoku(readBoard(cells))
        //set rotation to sensor dependent
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_USER
    }

    private fun getBoardsValues(board: Array<IntArray>): String
    {
        var strBoard = ""
        for(i in board)
        {
            for(j in i)
            {
                strBoard += j.toString()
            }
        }
        return strBoard
    }

    private fun saveSudoku(board: Array<IntArray>)
    {
        file.createNewFile()

        file.writeText(getBoardsValues(board))
    }
}