package com.tha.wechart.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.tha.wechart.R
import com.tha.wechart.adapters.ChatsAdapter
import kotlinx.android.synthetic.main.fragment_chat.*

class ChatFragment : Fragment() {

    private lateinit var mChatsAdapter: ChatsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpChatsListRecycler()
    }

    private fun setUpChatsListRecycler() {
        mChatsAdapter = ChatsAdapter()
        rvChatsList.adapter = mChatsAdapter
        rvChatsList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

}