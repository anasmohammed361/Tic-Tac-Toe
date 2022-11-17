package com.example.tictactoe

object SingletonClass {
    private var sound:Boolean=true
    public fun toggleSound(){
        sound= !sound
    }
    public fun getSoundStatus():Boolean{
        return sound
    }
}