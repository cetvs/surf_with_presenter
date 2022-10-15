package com.example.surf_with_presenter.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.surf_with_presenter.R
import com.squareup.picasso.Picasso

class HomeRecyclerAdapter(
    private var list: List<ViewPictureInfo>
) : RecyclerView.Adapter<HomeRecyclerAdapter.CustomRecyclerHolder>() {

    inner class CustomRecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.item_home_name_tv)
        private val pictureImageView: ImageView = itemView.findViewById(R.id.item_home_picture_iv)
        private val favImageView: ImageView = itemView.findViewById(R.id.item_home_favorite_iv)

        fun bind(pictureInfo: ViewPictureInfo) {
            nameTextView.text = pictureInfo.title
            Picasso.get().load(pictureInfo.photoUrl).into(pictureImageView)
//            if (pictureInfo.favoriteDate == null) {
//                favImageView.setImageResource(R.drawable.ic_unfavorite)
//            } else {
//                favImageView.setImageResource(R.drawable.ic_favorite)
//            }

//            favImageView.setOnClickListener {
//                val favoriteImageView = itemView.findViewById<ImageView>(R.id.item_favorite_favorite_iv)
//                if (favoriteImageView?.tag == R.drawable.ic_unfavorite) {
//                    favoriteImageView.setImageResource(R.drawable.ic_favorite)
//                    favoriteImageView.tag = R.drawable.ic_favorite
//                    val localDate = LocalDate.now()
//                    val date = java.sql.Date.valueOf(localDate.toString())
//                    mainViewModel.updateFavoriteInfo(pictureInfo.copy(favoriteDate = date))
//                } else {
//                    favoriteImageView?.setImageResource(R.drawable.ic_unfavorite)
//                    favoriteImageView?.tag = R.drawable.ic_unfavorite
//                    mainViewModel.updateFavoriteInfo(pictureInfo.copy(favoriteDate = null))
//                }
//            }
        }
    }

    fun setData(lst: List<ViewPictureInfo>) {
        list = lst
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomRecyclerHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_adapter_layout, parent, false)
        return CustomRecyclerHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomRecyclerHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}