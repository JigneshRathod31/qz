package com.jignesh.qz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

lateinit var btnPlayQz: Button

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PlayQzFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        container?.removeAllViews()
        var view: View = inflater.inflate(R.layout.fragment_play_qz, container, false)

        btnPlayQz = view.findViewById(R.id.btn_play_qz)

        btnPlayQz.setOnClickListener(View.OnClickListener { view ->
            Utils.replaceFragment(R.id.frame_layout_container, QuizFragment(), requireFragmentManager())
        })

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlayQzFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}