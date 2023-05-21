package com.app.proyectofinalonepiece.onepieceapi;

import com.app.proyectofinalonepiece.models.*;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OnePieceApiService {
    String BASE_URL = "http://localhost:8080/api/";

    //PIRATAS
    @GET("personajes/piratas")
    Call<PirataList> getPirataList();

    @GET("personajes/piratas/{id}")
    Call<Pirata> getPirataById(@Path("id") String id);

    //MARINES
    @GET("personajes/marines")
    Call<MarineList> getMarineList();

    @GET("personajes/marines/{id}")
    Call<Marine> getMarineById(@Path("id") String id);

    //ARMAS
    @GET("armas")
    Call<ArmaList> getArmaList();

    @GET("armas/{id}")
    Call<Arma> getArmaById(@Path("id") String id);

    //ISLAS
    @GET("islas")
    Call<IslaList> getIslaList();

    @GET("islas/{id}")
    Call<Isla> getIslaById(@Path("id") String id);

    //FRUTAS DEL DIABLO
    @GET("frutas_del_diablo")
    Call<FrutaDelDiabloList> getFrutaDelDiabloList();

    @GET("frutas_del_diablo/{id}")
    Call<FrutaDelDiablo> getFrutaDelDiabloById(@Path("id") String id);
}
