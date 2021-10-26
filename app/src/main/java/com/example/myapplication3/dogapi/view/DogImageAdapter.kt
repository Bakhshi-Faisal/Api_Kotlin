package com.example.myapplication3.dogapi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication3.dogapi.model.DogImageUi

import com.example.myapplication3.databinding.ActivityDogImageBinding
import com.example.myapplication3.databinding.ItemDogImageBinding
import com.example.myapplication3.dogapi.viewModel.DogImageViewModel

val diffUtils = object : DiffUtil.ItemCallback<DogImageUi>() {
    override fun areItemsTheSame(oldItem: DogImageUi, newItem: DogImageUi): Boolean {
        return oldItem == newItem
    }


    override fun areContentsTheSame(oldItem: DogImageUi, newItem: DogImageUi): Boolean {
        return oldItem == newItem
    }

}

class DogImageQuoteViewHolder(
    private val binding: ItemDogImageBinding
) : RecyclerView.ViewHolder(binding.root) {


    private lateinit var ui: DogImageUi


    fun bind(DogImageUi: DogImageUi) {
        ui = DogImageUi
        Glide.with(itemView.context)
            .load(DogImageUi.iconUrl)
            .into(binding.itemdogImageIcon)


        binding.itemdogImageQuote.text = DogImageUi.quote
    }
}

class DogImageAdapter : ListAdapter<DogImageUi, DogImageQuoteViewHolder>(diffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogImageQuoteViewHolder {
        return DogImageQuoteViewHolder(
            ItemDogImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: DogImageQuoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DogImageActivity : AppCompatActivity() {


    private lateinit var viewModel: DogImageViewModel
    private lateinit var binding : ActivityDogImageBinding
    private val adapter : DogImageAdapter = DogImageAdapter()
    private val observer = Observer<List<DogImageUi>> {
        adapter.submitList(it)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogImageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this)[DogImageViewModel::class.java]


        binding.dogImageActivityRv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.dogImageActivityRv.adapter = adapter


        binding.dogImageActivityAdd.setOnClickListener {
            viewModel.fetchNewQuote()
        }


        binding.dogImageActivityDelete.setOnClickListener {
            viewModel.deleteAll()
        }
    }
    override fun onStart() {
        super.onStart()
        viewModel.mDogImageQuoteLiveData.observe(this, observer)
    }


    override fun onStop() {
        viewModel.mDogImageQuoteLiveData.removeObserver(observer)
        super.onStop()
    }
}
