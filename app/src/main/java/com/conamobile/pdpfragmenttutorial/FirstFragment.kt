package com.conamobile.pdpfragmenttutorial

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import java.lang.RuntimeException

class FirstFragment : Fragment() {

    private var listener: FirstListener? =null
    var tv_first: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        tv_first = view.findViewById(R.id.tv_first)
        val b_first = view.findViewById<Button>(R.id.b_first)

        b_first.setOnClickListener {
            listener!!.onFirstSend("PDP")
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is FirstListener){
            context
        }else{
            throw RuntimeException("$context FirstListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun updateFirstText(str: String?){
        tv_first!!.text = str
    }

    interface FirstListener{
        fun onFirstSend(str: String?)
    }

}