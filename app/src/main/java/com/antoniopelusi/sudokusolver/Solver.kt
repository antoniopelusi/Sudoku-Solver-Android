package com.antoniopelusi.sudokusolver

class Solver {

    fun write_board(board: Array<IntArray>)
    {
        for(x in 0 until 9)
        {
            for(y in 0 until 9)
            {
                print(board[x][y])
                print("  ")
            }
            println()
        }
    }

    fun return_board(board: Array<IntArray>)
    {
        var out = String()

        for(x in 0 until 9)
        {
            for(y in 0 until 9)
            {
                out += board[x][y]
                out += "  "
            }
            out += "\n"
        }
    }

    fun check(board: Array<IntArray>, row: Int, column: Int, num: Int): Boolean
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

        var startRow: Int = row - row % 3
        var startCol: Int = column - column % 3

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
}