package com.app.proyectofinalonepiece;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.app.proyectofinalonepiece.models.FrutaDelDiablo;
import com.app.proyectofinalonepiece.onepieceapi.OnePieceApiClient;

import java.util.ArrayList;

public class FrutasDelDiabloViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<FrutaDelDiablo>> listFrutasDelDiabloMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<FrutaDelDiablo> frutaDelDiabloMutableLiveData = new MutableLiveData<>();

    public FrutasDelDiabloViewModel(@NonNull Application application) {
        super(application);
        OnePieceApiClient.getFrutaDelDiabloList(listFrutasDelDiabloMutableLiveData);
    }

    public void seleccionar(FrutaDelDiablo frutaDelDiablo) {
        OnePieceApiClient.getFrutaDelDiabloById(frutaDelDiabloMutableLiveData, frutaDelDiablo.getId());
        frutaDelDiabloMutableLiveData.setValue(frutaDelDiablo);
    }

    public MutableLiveData<FrutaDelDiablo> getFrutaDelDiablo() {
        return frutaDelDiabloMutableLiveData;
    }

    public MutableLiveData<ArrayList<FrutaDelDiablo>> getListFrutasDelDiablo() {
        return listFrutasDelDiabloMutableLiveData;
    }
}
