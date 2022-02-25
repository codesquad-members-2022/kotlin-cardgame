package com.codesquad.kotilin_cardgame

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

class GameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



//        val gameMode = view.findViewById<RadioGroup>(R.id.radiogroup_cardMode)
//        gameMode.setOnCheckedChangeListener { _, checkMode ->
//            when(checkMode){
//                R.id.rbtn_twocards-> navController.navigate(R.id.action_gameFragment_to_twocard_game)
//                R.id.rbtn_threecards->navController.navigate(R.id.action_gameFragment_to_threecard_game)
//                R.id.rbtn_fourcards->navController.navigate(R.id.action_gameFragment_to_fourcard_game)
//            }
//
//        }

    }

}