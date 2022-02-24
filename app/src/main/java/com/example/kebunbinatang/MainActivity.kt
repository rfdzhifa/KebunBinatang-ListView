package com.example.kebunbinatang

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list_binatang.view.*
import kotlinx.android.synthetic.main.list_binatang_buas.view.*

class MainActivity : AppCompatActivity() {

    var listBinatang = ArrayList<Binatang>()
    var adapter: AdapterBinatang? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listBinatang.add(
            Binatang("Gajah", "", R.drawable.gajah, false)
        )
        listBinatang.add(
            Binatang("Harimau", "", R.drawable.harimau, true)
        )
        listBinatang.add(
            Binatang("Jerapah", "", R.drawable.jerapah, false)
        )
        listBinatang.add(
            Binatang("Kucing", "", R.drawable.kucing, false)
        )
        listBinatang.add(
            Binatang("Monyet", "", R.drawable.monyet, false)
        )
        listBinatang.add(
            Binatang("Sapi", "", R.drawable.sapi, false)
        )
        listBinatang.add(
            Binatang("Singa", "", R.drawable.singa, true)
        )

        adapter = AdapterBinatang(this, listBinatang)
        lvBintang.adapter = adapter
    }

    inner class AdapterBinatang: BaseAdapter {
        var listBinatang = ArrayList<Binatang>()
        var context: Context?=null

        constructor(context: Context, listOfAnimals: ArrayList<Binatang>):super(){
            this.listBinatang = listOfAnimals
            this.context = context
        }

        override fun getView(p0: Int, p1: View?, p3: ViewGroup?): View {
            val binatang = listBinatang[p0]
            if (binatang.binatangBuas == true) {
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.list_binatang_buas, null)
                myView.txtNamaBuas.text = binatang.nama!!
                myView.txtDescBuas.text = binatang.deskripsi!!
                myView.imgGambarBinatangBuas.setImageResource(binatang.gambar!!)
                myView.imgGambarBinatangBuas.setOnClickListener{
                    val intent = Intent(context, DetailBinatang::class.java)
                    intent.putExtra("nama", binatang.nama!!)
                    intent.putExtra("deskripsi", binatang.deskripsi!!)
                    intent.putExtra("gambar", binatang.gambar!!)
                    context!!.startActivity(intent)
                }
                return myView
            }else{
                val binatang = listBinatang[p0]
                val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.item_list_binatang, null)
                myView.txtNama.text = binatang.nama!!
                myView.txtDesc.text = binatang.deskripsi!!
                myView.imgGambarBinatang.setImageResource(binatang.gambar!!)
                myView.imgGambarBinatang.setOnClickListener{
                    val intent = Intent(context, DetailBinatang::class.java)
                    intent.putExtra("nama", binatang.nama!!)
                    intent.putExtra("deskripsi", binatang.deskripsi!!)
                    intent.putExtra("gambar", binatang.gambar!!)
                    context!!.startActivity(intent)
                }
                return  myView
            }
        }

        override fun getItem(p0: Int): Any {
            return listBinatang[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listBinatang.size
        }
    }
}