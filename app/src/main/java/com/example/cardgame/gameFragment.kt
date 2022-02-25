package com.example.cardgame

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class GameFragment: Fragment() {
    companion object {
        val TAG: String = "로그"

        fun newInstance(): GameFragment {
            return GameFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "GameFragment - onCreate() called")
    }

    override fun onAttach(context: Context) { //프래그먼트를 안고있는 액티비티에 붙었을떄
        super.onAttach(context)
        Log.d(TAG, "GameFragment - onAttach() called")
    }

    override fun onCreateView( //뷰가 생성됐을 떄
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d(TAG, "GameFragment - onCreateView() called")

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }
}