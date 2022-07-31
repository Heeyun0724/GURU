package com.example.guru

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

private const val NUM_PAGES = 3

class HomeFragment : Fragment() {

    lateinit var technologyImage: ImageView
    lateinit var literatureImage: ImageView
    lateinit var societyImage: ImageView
    lateinit var essayImage: ImageView
    lateinit var searchButton: Button
    lateinit var technologyText: TextView
    lateinit var literatureText: TextView
    lateinit var societyText: TextView
    lateinit var essayText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        technologyImage = view.findViewById<ImageView>(R.id.technologyImage)
        literatureImage = view.findViewById<ImageView>(R.id.literatureImage)
        societyImage = view.findViewById<ImageView>(R.id.societyImage)
        essayImage = view.findViewById<ImageView>(R.id.essayImage)
        searchButton = view.findViewById(R.id.searchButton)
        technologyText = view.findViewById(R.id.technologyText)
        literatureText = view.findViewById(R.id.literatureText)
        societyText = view.findViewById(R.id.societyText)
        essayText = view.findViewById(R.id.essayText)

        //기술 이미지 클릭 시 기술분야 베스트리뷰 페이지로 이동
        technologyImage.setOnClickListener{
            var intent = Intent(getActivity(), TechnologyActivity::class.java)
            startActivity(intent)
        }
        //기술 텍스트 클릭 시 기술분야 베스트리뷰 페이지로 이동
        technologyText.setOnClickListener {
            var intent = Intent(getActivity(), TechnologyActivity::class.java)
            startActivity(intent)
        }
        //문학 이미지 클릭 시 문학분야 베스트리뷰 페이지로 이동
        literatureImage.setOnClickListener{
            var intent = Intent(getActivity(), LiteratureActivity::class.java)
            startActivity(intent)
        }
        //문학 텍스트 클릭 시 기술분야 베스트리뷰 페이지로 이동
        literatureText.setOnClickListener{
            var intent = Intent(getActivity(), LiteratureActivity::class.java)
            startActivity(intent)
        }
        //사회 이미지 클릭 시 사회분야 베스트리뷰 페이지로 이동
        societyImage.setOnClickListener{
            var intent = Intent(getActivity(), SocietyActivity::class.java)
            startActivity(intent)
        }
        //사회 텍스트 클릭 시 기술분야 베스트리뷰 페이지로 이동
        societyText.setOnClickListener{
            var intent = Intent(getActivity(), SocietyActivity::class.java)
            startActivity(intent)
        }
        //에세이 이미지 클릭 시 에세이분야 베스트리뷰 페이지로 이동
        essayImage.setOnClickListener{
            var intent = Intent(getActivity(), EssayActivity::class.java)
            startActivity(intent)
        }
        //에세이 텍스트 클릭 시 기술분야 베스트리뷰 페이지로 이동
        essayText.setOnClickListener{
            var intent = Intent(getActivity(), EssayActivity::class.java)
            startActivity(intent)
        }
        //리뷰 검색하기 버튼 클릭 시 검색 페이지로 이동
        searchButton.setOnClickListener{
            var intent = Intent(getActivity(), SearchActivity::class.java)
            startActivity(intent)
        }


        return view
    }
}
