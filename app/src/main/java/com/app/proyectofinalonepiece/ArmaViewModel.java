package com.app.proyectofinalonepiece;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.app.proyectofinalonepiece.models.Arma;
import com.app.proyectofinalonepiece.onepieceapi.OnePieceApiClient;

import java.util.ArrayList;

public class ArmaViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Arma>> listArmaMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Arma> armaMutableLiveData = new MutableLiveData<>();

    public ArmaViewModel(@NonNull Application application) {
        super(application);
        OnePieceApiClient.getArmaList(listArmaMutableLiveData);
    }

    public void seleccionar(Arma arma) {
        OnePieceApiClient.getArmaById(armaMutableLiveData, arma.getId());
        armaMutableLiveData.setValue(arma);
    }

    public MutableLiveData<Arma> getArma() {
        return armaMutableLiveData;
    }

    public MutableLiveData<ArrayList<Arma>> getListArma() {
        return listArmaMutableLiveData;
    }
}
