package org.sheridan.adhrika991451940


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import org.sheridan.adhrika991451940.databinding.FragmentCongratsBinding

/**
 * A simple [Fragment] subclass.
 */
class Congrats : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCongratsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_congrats, container, false
        )
        binding.button3.setOnClickListener {
            view!!.findNavController()!!.navigate(R.id.action_congrats_to_mathQuiz)
        }
        return binding.root
    }


}
