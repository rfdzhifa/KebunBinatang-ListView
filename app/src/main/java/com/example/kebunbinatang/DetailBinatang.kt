package com.example.kebunbinatang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_binatang.*

class DetailBinatang : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_binatang)

        val bundle = intent.extras

        ivBinatang.setImageResource(bundle!!.getInt("gambar"))
        tvNama.text = bundle.getString("nama")
        tvDeskripsi.text = bundle.getString("deskripsi")
    }
}