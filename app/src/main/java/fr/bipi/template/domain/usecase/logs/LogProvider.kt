package fr.bipi.template.domain.usecase.logs

import android.content.Context
import java.io.File

interface LogProvider {
    fun getLogFiles(): Collection<File>
    fun clearFileLog()
    fun plant(context: Context)
}
