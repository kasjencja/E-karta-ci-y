package com.example.kmrad.e_kartaciazy;

/**
 * Created by kmrad on 21.12.2018.
 */

public class ListaBadan {
    private int idBadania;
    private String dataBadania;

    public ListaBadan(int idBadania, String dataBadania) {
        this.idBadania = idBadania;
        this.dataBadania = dataBadania;
    }

    public int getIdBadania() {
        return idBadania;
    }

    public void setIdBadania(int idBadania) {
        this.idBadania = idBadania;
    }

    public String getDataBadania() {
        return dataBadania;
    }

    public void setDataBadania(String dataBadania) {
        this.dataBadania = dataBadania;
    }
}
