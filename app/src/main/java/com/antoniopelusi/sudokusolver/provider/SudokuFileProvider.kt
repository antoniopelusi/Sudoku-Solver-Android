package com.antoniopelusi.sudokusolver.provider

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.app.ShareCompat
import androidx.core.content.FileProvider
import com.antoniopelusi.sudokusolver.R
import java.io.File
import java.security.AccessController
import java.security.AccessController.getContext


class SudokuFileProvider : FileProvider(R.xml.sudoku_file_provider)
