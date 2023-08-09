package com.example.ComposeExampleApp.contectlist.ui.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ComposeExampleApp.contectlist.ui.main.model.createContactsList
import com.example.packageinstallerapp.R

class ContactListFragment :  Fragment(){
    companion object {
        fun newInstance(id:Int) = ContactListFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_contact_list, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mContactRecycleView:RecyclerView = view.findViewById<RecyclerView>(R.id.my_contact_recycle_view)
        val mContactRecycleView2:RecyclerView = view.findViewById<RecyclerView>(R.id.my_contact_recycle_view2)

        val mContactAdapter : ContactListAdapter = ContactListAdapter(createContactsList(50))

        val layoutManager  = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        mContactRecycleView.layoutManager = layoutManager

        mContactRecycleView.adapter = mContactAdapter

        mContactRecycleView2.adapter = mContactAdapter


    }

}