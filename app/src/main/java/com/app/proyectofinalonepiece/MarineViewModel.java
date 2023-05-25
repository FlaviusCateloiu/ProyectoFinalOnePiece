package com.app.proyectofinalonepiece;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.app.proyectofinalonepiece.models.Marine;
import com.app.proyectofinalonepiece.onepieceapi.OnePieceApiClient;

import java.util.ArrayList;

public class MarineViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Marine>> listMarineMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Marine> marineMutableLiveData = new MutableLiveData<>();

    public MarineViewModel(@NonNull Application application) {
        super(application);
        OnePieceApiClient.getMarineList(listMarineMutableLiveData);
    }

    public void seleccionar(Marine marine) {
        OnePieceApiClient.getMarineById(marineMutableLiveData, marine.getId());
        marineMutableLiveData.setValue(marine);
    }

    public MutableLiveData<Marine> getMarine() {
        return marineMutableLiveData;
    }

    public MutableLiveData<ArrayList<Marine>> getListMarine() {
        return listMarineMutableLiveData;
    }
}
