package com.example.kebunbinatang


class Binatang {
    var nama : String? = null
    var deskripsi : String? = null
    var gambar : Int? = null
    var binatangBuas : Boolean? = null
    constructor(name : String, des: String, gambar: Int, buas: Boolean){
        this.nama = name
        this.deskripsi = des
        this.gambar = gambar
        this.binatangBuas = buas
    }
}