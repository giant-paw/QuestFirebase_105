package com.example.a08januari2025.model

data class Mahasiswa(
    val nim: String,
    val nama: String,
    val alamat: String,
    val jenisKelamin: String,
    val kelas: String,
    val angkatan: String
) {
    constructor(

    ):this("","","","","","")
}