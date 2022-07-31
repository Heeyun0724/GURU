package com.example.guru

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class BookNameListAdapter(var books: ArrayList<Book>, var context: Context) :
    RecyclerView.Adapter<BookNameListAdapter.ViewHolder>(), Filterable {

    var filteredBook = ArrayList<Book>()
    var itemFilter = ItemFilter()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        lateinit var tv_bookname_list : TextView
        lateinit var tv_bookauthor_list:TextView

        init {

            tv_bookauthor_list=itemView.findViewById(R.id.tv_bookauthor_list)
            tv_bookname_list=itemView.findViewById(R.id.tv_bookname_list)

            itemView.setOnClickListener {//클릭시 책 정보 팝업창 나타나기
                AlertDialog.Builder(context).apply {
                    var position =adapterPosition
                    var book=filteredBook[position]
                    setTitle(book.bookname)
                    setMessage(book.author)
                    setPositiveButton("베스트 리뷰 카테고리에서 확인 가능", DialogInterface.OnClickListener { dialog, which ->
                        Toast.makeText(context, "${book.bookname}", Toast.LENGTH_SHORT).show()
                    })

                    show()
                }

            }

        }


    }

    init{
        filteredBook.addAll(books)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //홀더 생성
        val context = parent.context
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_bookname, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //홀더 바인딩
        val book: Book = filteredBook[position]

        holder.tv_bookname_list.text=book.bookname
        holder.tv_bookauthor_list.text=book.author
    }

    override fun getItemCount(): Int {
        //리스트에 있는 데이터 갯수 반환
        return filteredBook.size
    }

    override fun getFilter(): Filter {
        return itemFilter
    }

    inner class ItemFilter : Filter(){
        //searchview에서 받은 문자열을 필터링해서 처리하는 함수
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val filterString = charSequence.toString()
            val results = FilterResults() // filter의 내부 클래스, 검색결과를 담아서 반환하면 publishresult가 반환 값을 받음
            Log.d("BookNameListAdapter", "charSequence: $charSequence")

            val filteredList : ArrayList<Book> = ArrayList<Book>()

            if(filterString.trim {it <= ' '}.isEmpty()){ //검색어가 없을 경우 원본 배열 보여주기
                results.values = books
                results.count = books.size

                return results
            }

            else { //검색어가 있을 경우
                for(book in books){
                    if (book.bookname.contains(filterString) || book.author.contains(filterString)){
                        //만약book의 bookname에 검색어가 포함되어 있거나 author에 검색어가 포함되어 있으면
                        filteredList.add(book) //리스트에 항목을 추가
                    }
                }
            }

            results.values = filteredList
            results.count=filteredList.size

            return results
        }

        @SuppressLint("NotifyDataSetChanged")
        override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
            //performfiltering이 반환한 filterresult클래스를 매개변수로 받아서 처리하는 함수
            filteredBook.clear() //어댑터 클래스에 선언한 복제 배열 초기화 후
            filteredBook.addAll(filterResults.values as ArrayList<Book>) //검색 결과의 값을 복사하고
            notifyDataSetChanged() //값이 바뀌었음을 알리기
        }
    }


}