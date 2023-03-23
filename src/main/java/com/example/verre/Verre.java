package com.example.verre;

public class Verre {
    public final static  double MAX = 10;
    private double capacite;
    private double volume;
    public Verre(double cap){
        capacite = cap;
    }
    public Verre(){
        capacite = MAX;
    }

    public boolean estPlein(){
        if (capacite <= volume){
            return true;
        }else{
            return false;
        }
    }
    public double glou(){
        synchronized (this) {
            if (!estPlein()) {
                volume += 1.0;
            }
        }
        return volume;

    }

    public double getVolume(){
        return volume;
    }
    public void setVolume(double vol){
        volume = vol;
    }
}
