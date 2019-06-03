package com.deepak.calculatorapp.Poko

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id


@Entity
data class User (@Id var id: Long = 0, val name: String? = null)