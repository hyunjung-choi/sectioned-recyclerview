package com.example.hyunjung.sectionedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hyunjung.sectionedrecyclerview.data.SectionModel
import com.example.hyunjung.sectionedrecyclerview.databinding.ViewSectionItemBinding

class MemberAdapter(
    private val sectionModelList: List<SectionModel>
) : RecyclerView.Adapter<MemberAdapter.MyViewHolder>() {

    class MyViewHolder(
        private val binding: ViewSectionItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(sectionModel: SectionModel) {
            binding.tvCategory.text = sectionModel.group
            binding.tvTotal.text = "${sectionModel.memberList.size}명"
            binding.rvSub.apply {
                layoutManager = LinearLayoutManager(binding.root.context)
                adapter = MemberSubAdapter(sectionModel.memberList)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ViewSectionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(sectionModelList[position])
    }

    override fun getItemCount(): Int = sectionModelList.size
}