package com.mulani.redis.springredisexample.model

import java.io.Serializable
import java.math.BigDecimal

data class User(val name:String, val age:Int, val salary:BigDecimal) : Serializable