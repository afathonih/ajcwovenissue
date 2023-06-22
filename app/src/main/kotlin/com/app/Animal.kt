package com.app

import com.processor.AutoFactory

@AutoFactory
interface Animal { // Can be abstract class too
    fun sound(): String
}