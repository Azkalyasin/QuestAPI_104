package com.example.questapi_104.uicontroller.route

import com.example.questapi_104.R

object DestinasiEdit: DestinasiNavigasi {

    override val route = "edit_detail"
    override val titleRes = R.string.edit_siswa
    const val itemIdArg = "idsiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}