package com.example.questapi_104.repositori

import com.example.questapi_104.apiservice.ServiceApiSiswa
import com.example.questapi_104.modeldata.DataSiswa


interface RepositoryDataSiswa {
    suspend fun getDataSiswa(): List<DataSiswa>
    suspend fun postDataSiswa(dataSiswa: DataSiswa):retrofit2.Response<Void>
}

class jaringanRepositoryDataSiswa (
    private val serviceApiSiswa: ServiceApiSiswa
): RepositoryDataSiswa{
    override suspend fun getDataSiswa(): List<DataSiswa> = serviceApiSiswa.getSiswa()
    override suspend fun postDataSiswa(dataSiswa: DataSiswa):retrofit2
        .Response<Void> = serviceApiSiswa.postSiswa(dataSiswa)
}

