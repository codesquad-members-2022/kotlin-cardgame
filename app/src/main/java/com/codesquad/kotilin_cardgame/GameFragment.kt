package com.codesquad.kotilin_cardgame

import android.os.Bundle
import android.view.*
import android.widget.RadioGroup
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
        val gameMode = view.findViewById<RadioGroup>(R.id.radiogroup_cardMode)
        gameMode.setOnCheckedChangeListener { _, checkMode ->
            val supportFragmentManager = childFragmentManager
            val transaction= supportFragmentManager.beginTransaction()
            when(checkMode){
                R.id.rbtn_twocards->  transaction.replace(R.id.frame_game, TwoCardGame()).commit()
                R.id.rbtn_threecards->transaction.replace(R.id.frame_game, ThreeCardGame()).commit()
                R.id.rbtn_fourcards->transaction.replace(R.id.frame_game, FourCardGame()).commit()
            }

        }

    }

}