package com.antoniopelusi.sudokusolver

var count = 0

class Solver {

    private fun check(board: Array<IntArray>, row: Int, column: Int, num: Int): Boolean
    {
        for(y in 0 until 9)
        {
            if(board[row][y] == num)
            {
                return false
            }
        }

        for(x in 0 until 9)
        {
            if(board[x][column] == num)
            {
                return false
            }
        }

        val startRow: Int = row - row % 3
        val startCol: Int = column - column % 3

        for(x in 0 until 3)
        {
            for(y in 0 until 3)
            {
                if(board[x + startRow][y + startCol] == num)
                {
                    return false
                }
            }
        }
        return true
    }

    fun solve(board: Array<IntArray>, _row: Int, _column: Int): Boolean
    {
        count++

        //automatically stop itself when can't find a solution
        if(count>100000)
        {
            return true
        }

        var row = _row
        var column = _column

        if((row == 9 - 1) && (column == 9))
        {
            return true
        }

        if(column == 9)
        {
            row += 1
            column = 0
        }

        if(board[row][column] > 0)
        {
            return solve(board, row, column + 1)
        }

        for(num in 1 until 9 + 1)
        {
            if(check(board, row, column, num))
            {
                board[row][column] = num

                if(solve(board, row, column + 1))
                {
                    return true
                }
            }

            board[row][column] = 0
        }

        return false
    }

    fun checkBoard(board: Array<IntArray>): Boolean
    {
        //check for empty board
        var countZeros = 0
        for(i in 0 until 9)
        {
            for (j in 0 until 9)
            {
                if(board[i][j] == 0)
                {
                    countZeros++
                }
            }
        }
        if(countZeros == 81)
        {
            return false
        }

        return true
    }

    fun checkForZeros(board: Array<IntArray>): Boolean
    {
        for(i in 0 until 9)
        {
            for (j in 0 until 9)
            {
                if(board[i][j] == 0)
                {
                    return true
                }
            }
        }
        return false
    }
}