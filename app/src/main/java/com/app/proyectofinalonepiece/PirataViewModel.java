package com.app.proyectofinalonepiece;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.app.proyectofinalonepiece.models.Pirata;
import com.app.proyectofinalonepiece.onepieceapi.OnePieceApiClient;

import java.util.ArrayList;

public class PirataViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Pirata>> listPiratasMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Pirata> pirataMutableLiveData = new MutableLiveData<>();

    public PirataViewModel(@NonNull Application application) {
        super(application);
        OnePieceApiClient.getPirataList(listPiratasMutableLiveData);
    }

    public void seleccionar(Pirata pirata) {
        OnePieceApiClient.getPirataById(pirataMutableLiveData, pirata.getId());
        pirataMutableLiveData.setValue(pirata);
    }

    public MutableLiveData<Pirata> getPirata() {
        return pirataMutableLiveData;
    }

    public MutableLiveData<ArrayList<Pirata>> getListPiratas() {
        return listPiratasMutableLiveData;
    }
}
