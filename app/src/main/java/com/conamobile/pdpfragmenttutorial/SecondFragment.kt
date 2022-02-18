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

class SecondFragment : Fragment() {

    private var listener: SecondListener? =null
    var tv_second: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        tv_second = view.findViewById(R.id.tv_second)
        val b_second = view.findViewById<Button>(R.id.b_second)

        b_second.setOnClickListener {
            listener!!.onSecondSend("Academy")
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is SecondListener){
            context
        }else{
            throw RuntimeException("$context SecondListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun updateSecondText(str: String?){
        tv_second?.text = str
    }

    interface SecondListener{
        fun onSecondSend(str: String?)
    }

}