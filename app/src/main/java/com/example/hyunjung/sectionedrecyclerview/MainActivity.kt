package com.example.hyunjung.sectionedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hyunjung.sectionedrecyclerview.adapter.MemberAdapter
import com.example.hyunjung.sectionedrecyclerview.data.Member
import com.example.hyunjung.sectionedrecyclerview.data.SectionModel
import com.example.hyunjung.sectionedrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val sectionModelList = ArrayList<SectionModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initView() {
        loadData()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        binding.rvMainSection.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MemberAdapter(sectionModelList)
        }
    }

    private fun loadData() {
        val firstGroup = "샤이니"
        val firstGroupMembers = ArrayList<Member>()
        firstGroupMembers.add(Member("온유", "1989.12.14", "ISFP"))
        firstGroupMembers.add(Member("종현", "1990.04.08", "CUTE"))
        firstGroupMembers.add(Member("키", "1991.09.23", "ENTJ"))
        firstGroupMembers.add(Member("민호", "1991.12.09", "ESFP"))
        firstGroupMembers.add(Member("태민", "1993.07.18", "INFP"))

        val secondGroup = "스트레이키즈"
        val secondGroupMembers = ArrayList<Member>()
        secondGroupMembers.add(Member("방찬", "1997.10.03", "ENFJ"))
        secondGroupMembers.add(Member("리노", "1998.10.25", "ISFP"))
        secondGroupMembers.add(Member("창빈", "1999.08.11", "ESFP"))
        secondGroupMembers.add(Member("현진", "2000.03.20", "INFP"))
        secondGroupMembers.add(Member("한", "2000.09.14", "ISTP"))
        secondGroupMembers.add(Member("필릭스", "2000.09.15", "ENFJ"))
        secondGroupMembers.add(Member("승민", "2000.09.22", "ISFJ"))
        secondGroupMembers.add(Member("아이엔", "2001.02.08", "INFJ"))

        val thirdGroup = "온앤오프"
        val thirdGroupMembers = ArrayList<Member>()
        thirdGroupMembers.add(Member("효진", "1994.04.22", "ESFJ"))
        thirdGroupMembers.add(Member("이션", "1994.12.24", "INFP"))
        thirdGroupMembers.add(Member("제이어스", "1995.01.13", "ENFP"))
        thirdGroupMembers.add(Member("와이엇", "1995.01.23", "ENFP"))
        thirdGroupMembers.add(Member("MK", "1995.11.16", "ESFP"))
        thirdGroupMembers.add(Member("유", "1999.03.16", "ISFJ"))

        sectionModelList.add(SectionModel(firstGroup, firstGroupMembers))
        sectionModelList.add(SectionModel(secondGroup, secondGroupMembers))
        sectionModelList.add(SectionModel(thirdGroup, thirdGroupMembers))
    }
}