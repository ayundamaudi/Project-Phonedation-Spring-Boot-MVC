package com.bca.models.cost;

/**
 * Created by Robby Dianputra on 2/14/2018.
 */

public class ItemCost {

    private Rajaongkir rajaongkir;

    public Rajaongkir getRajaongkir() {
        return rajaongkir;
    }

    public void setRajaongkir(Rajaongkir rajaongkir) {
        this.rajaongkir = rajaongkir;
    }

    @Override
    public String toString() {
        return "ItemCost [rajaongkir=" + rajaongkir + "]";
    }

}
