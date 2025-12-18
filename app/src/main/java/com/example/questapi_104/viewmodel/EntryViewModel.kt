package com.example.questapi_104.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.questapi_104.modeldata.DetailSiswa
import com.example.questapi_104.modeldata.UIStateSiswa
import com.example.questapi_104.modeldata.toDataSiswa
import com.example.questapi_104.modeldata.toDetailSiswa
import com.example.questapi_104.repositori.RepositoryDataSiswa
import retrofit2.Response

class EntryViewModel(private val repositoryDataSiswa: RepositoryDataSiswa) :
    ViewModel() {

    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    /* Fungsi untuk memvalidasi input */
    private fun validasiInput(
        uiState: DetailSiswa = uiStateSiswa.detailSiswa
    ): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    //Fungsi untuk menangani saat ada perubahan pada text input
    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa =
            UIStateSiswa(
                detailSiswa = detailSiswa,
                isEntryValid = validasiInput(detailSiswa)
            )
    }

    /* Fungsi untuk menyimpan data yang di-entry */
    suspend fun addSiswa() {
        if (!validasiInput()) return

        try {
            val response = repositoryDataSiswa.postDataSiswa(
                uiStateSiswa.detailSiswa.toDataSiswa()
            )

            if (response.isSuccessful) {
                println("✅ Sukses Tambah Data")
            } else {
                println("❌ Gagal tambah data: ${response.code()}")
            }

        } catch (e: Exception) {
            e.printStackTrace()
            println("🔥 ERROR addSiswa: ${e.message}")
        }
    }

}
