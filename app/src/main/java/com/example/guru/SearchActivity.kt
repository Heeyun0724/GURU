package com.example.guru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import kotlin.concurrent.timer

private const val NUM_PAGES = 3

class SearchActivity : AppCompatActivity() {

    lateinit var rv_bookName : RecyclerView
    lateinit var bookNameListAdpater : BookNameListAdapter
    lateinit var book : ArrayList<Book>
    lateinit var searchView: SearchView
    lateinit var viewpager : ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        rv_bookName = findViewById(R.id.rv_bookName)
        searchView = findViewById(R.id.searView)
        viewpager = findViewById(R.id.viewpager)
        viewpager.adapter =ScreenSlidePagerAdapter(this)

        searchView.setOnQueryTextListener(searchViewTextListener)

        book = tempBook()
        setAdapter()

        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator) //인디케이터터
        dotsIndicator.setViewPager2(viewpager)

        timer(period = 2000){
            runOnUiThread{
                if (viewpager.currentItem < NUM_PAGES-1){
                    viewpager.currentItem++
                } else {
                    viewpager.currentItem=0
                }
            }
        }

        //액션바 뒤로가기 추가
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    //뒤로가기 코드
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() === android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    var searchViewTextListener: SearchView.OnQueryTextListener =
        object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String?): Boolean {
                //검색 버튼을 누를 때 호출, 검색 버튼 없으므로 사용 x
                return false
            }

            override fun onQueryTextChange(s: String?): Boolean {
                //텍스트 입력 or 수정시에 호출 됨
                bookNameListAdpater.filter.filter(s)
                Log.d("MainActivity", "텍스트가 변경되었음: $s")
                return false
            }
        }

    fun setAdapter(){
        //리사이클러뷰에 리사이클러뷰 어댑터 부착
        rv_bookName.layoutManager = LinearLayoutManager(this)
        bookNameListAdpater = BookNameListAdapter(book, this)
        rv_bookName.adapter=bookNameListAdpater
    }

    fun tempBook() : ArrayList<Book>{

        var tempBooks = ArrayList<Book>()
        tempBooks.add(Book(1,"곰돌이 푸, 행복한 일은 매일 있어", "곰돌이 푸 (원작)"))
        tempBooks.add(Book(2,"매일을 헤엄치는 법", "이연"))
        tempBooks.add(Book(3,"삶에서 다시 떠오르기", "에그하르트 톨레"))
        tempBooks.add(Book(4,"계속 가보겠습니다", "임은정"))
        tempBooks.add(Book(5,"왜 지금 한국인가", "가재산, 김기진"))
        tempBooks.add(Book(6,"식량위기 대한민국", "남재작"))
        tempBooks.add(Book(7,"인공지능 시대의 건축", "김성아"))
        tempBooks.add(Book(8,"처음 읽는 플랜트 엔지니어링 이야기", "박정호"))
        tempBooks.add(Book(9,"구글 엔지니어는 이렇게 일한다", "타이터스 윈터스, 톰 맨쉬랙 외1"))
        tempBooks.add(Book(10,"불편한 편의점", "김호연"))
        tempBooks.add(Book(11,"비하인드 도어", "B. A. 패리스"))
        tempBooks.add(Book(12,"아노말리", "에르베 르 텔리에"))

        return tempBooks
    }

    override fun onBackPressed() {
        if(viewpager.currentItem == 0){
            //사용자가 첫번째 페이지에서 뒤로가기 버튼을 누를 경우 종료
            super.onBackPressed()
        } else {
            //그렇지 않으면 이전 페이지로 이동
            viewpager.currentItem = viewpager.currentItem -1
        }
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa){

        //어댑터

        override fun getItemCount(): Int = NUM_PAGES//페이지(프래그먼트 수) 리턴

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> fragment1()
                1-> fragment2()
                else -> fragment3()
            }
        }
    }
}
