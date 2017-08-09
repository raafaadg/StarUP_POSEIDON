
package com.poseidon.poseidon.GetLeitura;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;



public interface GetLeituraInterface {
    @GET("poseidon/{codigo}")
    Call<GetLeituraResponse> getLeitura(@Path("codigo") String codigo);
}

