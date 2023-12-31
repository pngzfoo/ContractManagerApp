package com.pngzfoo.contractmanagerapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pngzfoo.contractmanagerapp.R
import com.pngzfoo.contractmanagerapp.databinding.CardItemBinding
import com.pngzfoo.contractmanagerapp.room.User

class MyRecyclerViewAdapter
    (private val userList:List<User>,
     private val clickListener:(User)->Unit
    ):RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        var binding:CardItemBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.card_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position],clickListener)
    }


}

class MyViewHolder(val binding: CardItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(user:User, clickListener: (User)->Unit){
        binding.nameTextViewCard.text = user.name
        binding.emailTextViewCard.text = user.email
        binding.listItemLayout.setOnClickListener{
            clickListener(user)
        }
    }
}