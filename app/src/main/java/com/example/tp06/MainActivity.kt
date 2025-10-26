package com.example.tp06

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: AdapterLivres
    private val listeLivres = ArrayList<Livre>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etTitre = findViewById<EditText>(R.id.etTitre)
        val etPrix = findViewById<EditText>(R.id.etPrix)
        val etImage = findViewById<EditText>(R.id.etImage)
        val chkDispoAdd = findViewById<CheckBox>(R.id.chkDispoAdd)
        val btnAjouter = findViewById<Button>(R.id.btnAjouter)
        val switchDarkMode = findViewById<SwitchCompat>(R.id.switchDarkMode)
        val recycler = findViewById<RecyclerView>(R.id.recyclerLivres)

        adapter = AdapterLivres(this, listeLivres)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        btnAjouter.setOnClickListener {
            val titre = etTitre.text.toString().trim()
            val prixText = etPrix.text.toString().trim()
            val imageUrl = etImage.text.toString().trim()
            val dispo = chkDispoAdd.isChecked

            if (titre.isEmpty() || prixText.isEmpty() || imageUrl.isEmpty()) {
                Toast.makeText(this, "Tous les champs sont obligatoires", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val prix = prixText.toDoubleOrNull()
            if (prix == null || prix <= 0) {
                Toast.makeText(this, "Le prix doit être supérieur à 0", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val nouveauLivre = Livre(titre, prix, imageUrl, dispo)
            listeLivres.add(nouveauLivre)
            adapter.notifyItemInserted(listeLivres.size - 1)

            etTitre.text.clear()
            etPrix.text.clear()
            etImage.text.clear()
            chkDispoAdd.isChecked = false
        }

        // Livres par défaut
        listeLivres.addAll(
            listOf(
                Livre("L'Étranger", 150.0, "https://m.media-amazon.com/images/I/61+ZC5H6k3L.jpg", true),
                Livre("1984", 180.0, "https://m.media-amazon.com/images/I/71kxa1-0mfL.jpg", true),
                Livre("Le Petit Prince", 120.0, "https://m.media-amazon.com/images/I/81t2CVWEsUL.jpg", false)
            )
        )
        adapter.notifyDataSetChanged()
    }
}
