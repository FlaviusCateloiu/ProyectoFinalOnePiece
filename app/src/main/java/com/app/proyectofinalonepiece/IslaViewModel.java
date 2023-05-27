package com.app.proyectofinalonepiece;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.app.proyectofinalonepiece.models.Isla;
import com.app.proyectofinalonepiece.onepieceapi.OnePieceApiClient;

import java.util.ArrayList;

public class IslaViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Isla>> listIslaMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Isla> islaMutableLiveData = new MutableLiveData<>();

    public IslaViewModel(@NonNull Application application) {
        super(application);
        OnePieceApiClient.getIslaList(listIslaMutableLiveData);
    }

    public void seleccionar(Isla isla) {
        OnePieceApiClient.getIslaById(islaMutableLiveData, isla.getId());
        islaMutableLiveData.setValue(isla);
    }

    public MutableLiveData<Isla> getIsla() {
        return islaMutableLiveData;
    }

    public MutableLiveData<ArrayList<Isla>> getListIsla() {
        return listIslaMutableLiveData;
    }
}
