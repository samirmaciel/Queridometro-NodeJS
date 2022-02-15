package com.example.queridometroapp.Feature.Modules.SelectEmojiBottomSheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.queridometroapp.Feature.Domain.Model.Emoji
import com.example.queridometroapp.Feature.Modules.Adapter.SelectEmojiRecyclerAdapter
import com.example.queridometroapp.R
import com.example.queridometroapp.databinding.BottomsheetSendemojiBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SelectEmojiBottomSheet : BottomSheetDialogFragment() {

    private var _binding : BottomsheetSendemojiBinding? = null
    private val binding : BottomsheetSendemojiBinding get() = _binding!!
    lateinit var recyclerAdapter : SelectEmojiRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BottomsheetSendemojiBinding.bind(inflater.inflate(R.layout.bottomsheet_sendemoji, container, false))
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.MyBottomSheetDialogTheme)
    }

    override fun onResume() {
        super.onResume()
        initComponents()
    }

    private fun initComponents(){
        recyclerAdapter = SelectEmojiRecyclerAdapter(getEmojiList(), requireContext())
        binding.rvSelectEmoji.layoutManager = GridLayoutManager(requireContext(),3)
        binding.rvSelectEmoji.adapter = recyclerAdapter
    }

    fun getEmojiList() : List<Emoji>{
        return listOf(
            Emoji(
                R.drawable.bomba
            ),
            Emoji(
                R.drawable.coracao
            ),
            Emoji(
                R.drawable.sorriso
            ),
            Emoji(
                R.drawable.triste
            ),
            Emoji(
                R.drawable.planta
            ),
            Emoji(
                R.drawable.planta
            )
        )
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}