package com.app.proyectofinalonepiece.onepieceapi;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.app.proyectofinalonepiece.models.*;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OnePieceApiClient {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:8080/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static OnePieceApiService service = retrofit.create(OnePieceApiService.class);

    //PIRATAS
    public static void getPirataList(MutableLiveData<ArrayList<Pirata>> listPiratas) {
        Call<PirataList> piratasCall = service.getPirataList();

        piratasCall.enqueue(new Callback<PirataList>() {
            @Override
            public void onResponse(Call<PirataList> call, Response<PirataList> response) {
                if (response.isSuccessful()) {
                    PirataList foundPiratas = response.body();
                    if (foundPiratas != null) {
                        listPiratas.setValue(foundPiratas.getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<PirataList> call, Throwable t) {
                Log.d("ONE PIECE API", "onFailure=" + t.getMessage());
            }
        });
    }

    public static void getPirataById(MutableLiveData<Pirata> pirata, String id) {
        Call<Pirata> pirataCall = service.getPirataById(id);

        pirataCall.enqueue(new Callback<Pirata>() {
            @Override
            public void onResponse(Call<Pirata> call, Response<Pirata> response) {
                if (response.isSuccessful()) {
                    Pirata foundPirata = response.body();
                    if (foundPirata != null) {
                        pirata.setValue(foundPirata);
                    }
                }
            }

            @Override
            public void onFailure(Call<Pirata> call, Throwable t) {
                Log.d("ONE PIECE API", "onFailure=" + t.getMessage());
            }
        });
    }

    //MARINES
    public static void getMarineList(MutableLiveData<ArrayList<Marine>> listMarines) {
        Call<MarineList> marinesCall = service.getMarineList();

        marinesCall.enqueue(new Callback<MarineList>() {
            @Override
            public void onResponse(Call<MarineList> call, Response<MarineList> response) {
                if (response.isSuccessful()) {
                    MarineList foundMarines = response.body();
                    if (foundMarines != null) {
                        listMarines.setValue(foundMarines.getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<MarineList> call, Throwable t) {
                Log.d("ONE PIECE API", "onFailure=" + t.getMessage());
            }
        });
    }

    public static void getMarineById(MutableLiveData<Marine> marine, String id) {
        Call<Marine> marineCall = service.getMarineById(id);

        marineCall.enqueue(new Callback<Marine>() {
            @Override
            public void onResponse(Call<Marine> call, Response<Marine> response) {
                if (response.isSuccessful()) {
                    Marine foundMarine = response.body();
                    if (foundMarine != null) {
                        marine.setValue(foundMarine);
                    }
                }
            }

            @Override
            public void onFailure(Call<Marine> call, Throwable t) {
                Log.d("ONE PIECE API", "onFailure=" + t.getMessage());
            }
        });
    }

    //ARMAS
    public static void getArmaList(MutableLiveData<ArrayList<Arma>> listArmas) {
        Call<ArmaList> armasCall = service.getArmaList();

        armasCall.enqueue(new Callback<ArmaList>() {
            @Override
            public void onResponse(Call<ArmaList> call, Response<ArmaList> response) {
                if (response.isSuccessful()) {
                    ArmaList foundArmas = response.body();
                    if (foundArmas != null) {
                        listArmas.setValue(foundArmas.getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<ArmaList> call, Throwable t) {
                Log.d("ONE PIECE API", "onFailure=" + t.getMessage());
            }
        });
    }

    public static void getArmaById(MutableLiveData<Arma> arma, String id) {
        Call<Arma> armaCall = service.getArmaById(id);

        armaCall.enqueue(new Callback<Arma>() {
            @Override
            public void onResponse(Call<Arma> call, Response<Arma> response) {
                if (response.isSuccessful()) {
                    Arma foundArma = response.body();
                    if (foundArma != null) {
                        arma.setValue(foundArma);
                    }
                }
            }

            @Override
            public void onFailure(Call<Arma> call, Throwable t) {
                Log.d("ONE PIECE API", "onFailure=" + t.getMessage());
            }
        });
    }

    //ISLAS
    public static void getIslaList(MutableLiveData<ArrayList<Isla>> listIslas) {
        Call<IslaList> islasCall = service.getIslaList();

        islasCall.enqueue(new Callback<IslaList>() {
            @Override
            public void onResponse(Call<IslaList> call, Response<IslaList> response) {
                if (response.isSuccessful()) {
                    IslaList foundIslas = response.body();
                    if (foundIslas != null) {
                        listIslas.setValue(foundIslas.getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<IslaList> call, Throwable t) {
                Log.d("ONE PIECE API", "onFailure=" + t.getMessage());
            }
        });
    }

    public static void getIslaById(MutableLiveData<Isla> isla, String id) {
        Call<Isla> islaCall = service.getIslaById(id);

        islaCall.enqueue(new Callback<Isla>() {
            @Override
            public void onResponse(Call<Isla> call, Response<Isla> response) {
                if (response.isSuccessful()) {
                    Isla foundIsla = response.body();
                    if (foundIsla != null) {
                        isla.setValue(foundIsla);
                    }
                }
            }

            @Override
            public void onFailure(Call<Isla> call, Throwable t) {
                Log.d("ONE PIECE API", "onFailure=" + t.getMessage());
            }
        });
    }

    //FRUTAS_DEL_DIABLO
    public static void getFrutaDelDiabloList(MutableLiveData<ArrayList<FrutaDelDiablo>> listFrutasDelDiablo) {
        Call<FrutaDelDiabloList> frutasDelDiabloListCall = service.getFrutaDelDiabloList();

        frutasDelDiabloListCall.enqueue(new Callback<FrutaDelDiabloList>() {
            @Override
            public void onResponse(Call<FrutaDelDiabloList> call, Response<FrutaDelDiabloList> response) {
                if (response.isSuccessful()) {
                    FrutaDelDiabloList foundFrutasDelDiablo = response.body();
                    if (foundFrutasDelDiablo != null) {
                        listFrutasDelDiablo.setValue(foundFrutasDelDiablo.getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<FrutaDelDiabloList> call, Throwable t) {
                Log.d("ONE PIECE API", "onFailure=" + t.getMessage());
            }
        });
    }

    public static void getFrutaDelDiabloById(MutableLiveData<FrutaDelDiablo> frutaDelDiablo, String id) {
        Call<FrutaDelDiablo> frutaDelDiabloCall = service.getFrutaDelDiabloById(id);

        frutaDelDiabloCall.enqueue(new Callback<FrutaDelDiablo>() {
            @Override
            public void onResponse(Call<FrutaDelDiablo> call, Response<FrutaDelDiablo> response) {
                if (response.isSuccessful()) {
                    FrutaDelDiablo foundFrutaDelDiablo = response.body();
                    if (foundFrutaDelDiablo != null) {
                        frutaDelDiablo.setValue(foundFrutaDelDiablo);
                    }
                }
            }

            @Override
            public void onFailure(Call<FrutaDelDiablo> call, Throwable t) {
                Log.d("ONE PIECE API", "onFailure=" + t.getMessage());
            }
        });
    }
}
