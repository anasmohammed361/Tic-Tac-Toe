package com.example.tictactoe

object SingletonClass {
    private var sound:Boolean=true
    private var bgSound:Boolean=true
    public fun toggleSound(){
        sound= !sound
    }
    public fun getSoundStatus():Boolean{
        return sound
    }
    public fun getBg():Boolean{
        return bgSound
    }
    public fun toggleBg(){
        bgSound=!bgSound
    }
}