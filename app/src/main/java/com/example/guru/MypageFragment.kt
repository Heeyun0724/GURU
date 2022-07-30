package com.example.guru

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MypageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MypageFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var memchangeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mypage, container, false)

        val idTextView = view.findViewById<TextView>(R.id.idTextView)
        val memchangeButton: Button = view.findViewById(R.id.memchangeButton)
        val logoutButton = view.findViewById<Button>(R.id.logoutButton)
        val libraryinfoButton = view.findViewById<Button>(R.id.libraryinfoButton)


        // 공유 자원을 통해 id 관리
        var pref = requireActivity().getSharedPreferences("user",0)
        var login_id = pref.getString("id", "default").toString()

        idTextView.text = login_id

        //mypage_Btn.setOnClickListener {
        //Toast.makeText(getActivity(),"Toast Message",Toast.LENGTH_SHORT).show();
        //}

        // Inflate the layout for this fragment

        memchangeButton.setOnClickListener {
            val intent = Intent(context, ChangeMember::class.java)
            startActivity(intent)
        }
        //문냥도서관 소개 버튼을 클릭하면 라이브러리 소개 페이지로 넘어감
        libraryinfoButton.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, InfoLibraryActivity::class.java)
                startActivity(intent)
            }
        })
        //로그아웃 버튼을 누르면 첫 화면으로 넘어감
        logoutButton.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
            }
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MypageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MypageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}