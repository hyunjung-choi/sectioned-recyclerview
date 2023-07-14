package com.example.hyunjung.sectionedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hyunjung.sectionedrecyclerview.data.Member
import com.example.hyunjung.sectionedrecyclerview.databinding.ViewMemberItemBinding

class MemberSubAdapter(
    private val memberList: List<Member>
) : RecyclerView.Adapter<MemberSubAdapter.MyViewHolder>() {

    class MyViewHolder(
        private val binding: ViewMemberItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(member: Member) {
            with(binding) {
                name.text = member.name
                birth.text = member.birthDay
                mbti.text = member.mbti
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ViewMemberItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = memberList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(memberList[position])
    }


}