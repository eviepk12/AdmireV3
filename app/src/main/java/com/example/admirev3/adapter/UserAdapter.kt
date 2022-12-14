package com.example.admirev3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.example.admirev3.R
import com.example.admirev3.model.User
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter(private val context: Context, private val userList:ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val user = userList[position]
        holder.txtUserName.text = user.username
        Glide.with(context).load(user.userImage).placeholder(R.drawable.profile_image).into(holder.imgUser)
    }

    override fun getItemCount(): Int {
        return userList.size

    }
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val txtUserName: TextView = view.findViewById(R.id.username)
        val txtTemp: TextView = view.findViewById(R.id.temp)
        val imgUser: CircleImageView = view.findViewById(R.id.userImage)
    }
}