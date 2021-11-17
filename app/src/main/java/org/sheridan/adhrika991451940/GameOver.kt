package org.sheridan.adhrika991451940


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import org.sheridan.adhrika991451940.databinding.FragmentGameOverBinding

/**
 * A simple [Fragment] subclass.
 */
class GameOver : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentGameOverBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_over, container, false
        )
        binding.button4.setOnClickListener {
            view!!.findNavController()!!.navigate(R.id.action_gameOver_to_mathQuiz)
        }
        return binding.root
    }


}

