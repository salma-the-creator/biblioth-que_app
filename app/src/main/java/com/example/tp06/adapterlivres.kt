package com.example.tp06

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterLivres(
    private val context: Context,
    private val livres: ArrayList<Livre>
) : RecyclerView.Adapter<AdapterLivres.LivreViewHolder>() {

    class LivreViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgLivre: ImageView = view.findViewById(R.id.imgLivre)
        val tvTitre: TextView = view.findViewById(R.id.tvTitre)
        val tvPrix: TextView = view.findViewById(R.id.tvPrix)
        val chkDispo: CheckBox = view.findViewById(R.id.chkDispo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivreViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.livre_item, parent, false)
        return LivreViewHolder(view)
    }

    override fun onBindViewHolder(holder: LivreViewHolder, position: Int) {
        val livre = livres[position]

        holder.tvTitre.text = livre.titre
        holder.tvPrix.text = "Prix: ${livre.prix} DH"
        holder.chkDispo.isChecked = livre.disponible

   
        Glide.with(holder.itemView.context)
            .load(livre.imageUrl)
            .into(holder.imgLivre)

       
        holder.chkDispo.setOnCheckedChangeListener { _, isChecked ->
            livre.disponible = isChecked
            val msg = if (isChecked) "✅ ${livre.titre} est maintenant disponible"
            else " ${livre.titre} est maintenant indisponible"
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }

       
        holder.itemView.setOnClickListener {
            val dispoText = if (livre.disponible) "Disponible" else "Non disponible"
            val dispoColor = if (livre.disponible) Color.GREEN else Color.RED

            val dialog = AlertDialog.Builder(holder.itemView.context)
                .setTitle(livre.titre)
                .setMessage("Prix: ${livre.prix} DH\nDisponibilité: $dispoText")
                .setPositiveButton("Fermer", null)
                .create()

            dialog.show()
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(dispoColor)
        }
    }

    override fun getItemCount(): Int = livres.size
}
