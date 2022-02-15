package com.example.queridometroapp.Feature.Modules.SelectEmojiBottomSheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.queridometroapp.R
import com.example.queridometroapp.databinding.BottomsheetSendemojiBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SelectEmojiBottomSheet : BottomSheetDialogFragment() {

    private var _binding : BottomsheetSendemojiBinding? = null
    private val binding : BottomsheetSendemojiBinding get() = _binding!!

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


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}