package es.alesagal.recycleradapterapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import es.alesagal.recycleradapter.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: RecyclerAdapter<ViewHolderImpl>
    private lateinit var mList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mList = ArrayList(listOf("one", "two", "three"))

        mAdapter = object : RecyclerAdapter<ViewHolderImpl>(mList, R.layout.row, ViewHolderImpl::class.java) {
            override fun onBindViewHolder(viewHolder: ViewHolderImpl, position: Int) {
                viewHolder.lblText.text = mList[position]

                viewHolder.view.setOnClickListener {
                    // If you want to insert only one item.
                    mList.add(position.toString())
                    notifyItemInserted(mList.size - 1)
                }
            }
        }

        recyclerView.apply {
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }

        // If you want to update the whole list.
        mList = ArrayList(listOf("one", "two", "three", "four"))
        mAdapter.setData(mList)
    }

    class ViewHolderImpl(val view: View) : RecyclerView.ViewHolder(view) {
        val lblText = view.findViewById<TextView>(R.id.lblText)!!
    }
}
