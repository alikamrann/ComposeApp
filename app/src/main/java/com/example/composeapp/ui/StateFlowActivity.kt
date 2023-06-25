package com.example.composeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.composeapp.R
import com.example.composeapp.databinding.ActivityStateFlowBinding

class StateFlowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStateFlowBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStateFlowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModelFactory = MainActivityViewModelFactory(125)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainActivityViewModel::class.java)

//        viewModel.totalData.observe(this, Observer {
//            binding.resultTextView.text = it.toString()
//        })

        lifecycleScope.launchWhenCreated {
            viewModel.message.collect{
                Toast.makeText(this@StateFlowActivity,it,Toast.LENGTH_LONG).show()
            }
        }

        binding.insertButton.setOnClickListener {
            viewModel.setTotal(binding.inputEditText.text.toString().toInt())
        }
    }
}