package com.example.noteapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.data.Note


class NoteAdapter(private val context: Context,
                  private var list:List<Note>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onClickListener: OnClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_note, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var note=list[position]

        if(holder is MyViewHolder){
            holder.title.text= note.title
            holder.date.text=note.date

            holder.delete.setOnClickListener {
                onClickListener?.onDeleteClick(note)
            }

            holder.itemView.setOnClickListener{
                if(onClickListener!=null){
                    onClickListener!!.onClick(position, note)
                }
             }
        }

    }
    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener=onClickListener
    }

    interface OnClickListener{
        fun onClick(position:Int,model:Note)
        fun onDeleteClick(model:Note)

    }

    class MyViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val title=view.findViewById<TextView>(R.id.tv_title)
        val date=view.findViewById<TextView>(R.id.tv_date)
        val delete=view.findViewById<ImageView>(R.id.delete_icon)
    }


}