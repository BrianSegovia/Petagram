package com.example.mascotasrecyclerviewyactionview;

import java.io.Serializable;

public class Mascota implements Serializable {

    private int fotoCachorro;
    private int tipoDeHueso = R.drawable.icons8_dog_bone_401;
    private String nombreDelCachorro;
    private  String cantidadDeLikes;
    private int fotoHuesoDorado  = R.drawable.icons8_dog_bone_400;
    private int tipoDeHuesolikes = 0;
    private int id;


    public Mascota (){}


    public Mascota (int fotoCachorro,String cantidadDeLikes){

        this.fotoCachorro = fotoCachorro;
        this.cantidadDeLikes = cantidadDeLikes;

    }

    public Mascota (int fotoCachorro, int tipoDeHueso, String nombreDelCachorro, String cantidadDeLikes, int huesoDorado){

        this.fotoCachorro        = fotoCachorro;
        this.tipoDeHueso         = tipoDeHueso;
        this.nombreDelCachorro   = nombreDelCachorro;
        this.cantidadDeLikes     = cantidadDeLikes;
        this.fotoHuesoDorado     = huesoDorado;

    }

    public int getFotoCachorro() {
        return fotoCachorro;
    }

    public void setFotoCachorro(int fotoCachorro) {
        this.fotoCachorro = fotoCachorro;
    }

    public int getTipoDeHueso() {
        return tipoDeHueso;
    }

    public void setTipoDeHueso(int tipoDeHueso) {
        this.tipoDeHueso = tipoDeHueso;
    }

    public String getNombreDelCachorro() {
        return nombreDelCachorro;
    }

    public void setNombreDelCachorro(String nombreDelCachorro) {
        this.nombreDelCachorro = nombreDelCachorro;
    }



    public int getFotoHuesoDorado() {
        return fotoHuesoDorado;
    }

    public void setFotoHuesoDorado(int fotoHuesoDorado) {
        this.fotoHuesoDorado = fotoHuesoDorado;
    }

    public String getCantidadDeLikes() {
        return cantidadDeLikes;
    }

    public void setCantidadDeLikes(String cantidadDeLikes) {
        this.cantidadDeLikes = cantidadDeLikes;
    }

    public int getTipoDeHuesolikes() {
        return tipoDeHuesolikes;
    }

    public void setTipoDeHuesolikes(int tipoDeHuesolikes) {
        this.tipoDeHuesolikes = tipoDeHuesolikes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
