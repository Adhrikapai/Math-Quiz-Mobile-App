package org.sheridan.adhrika991451940


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import org.sheridan.adhrika991451940.databinding.FragmentMathQuizBinding

/**
 * A simple [Fragment] subclass.
 */
class MathQuiz : Fragment() {
    data class Question(
        val text: String,
        val answers: String)

    private val questions: MutableList<Question> = mutableListOf(
        Question(text = "2+4",
            answers = "6"),
        Question(text = "5+7",
            answers = "12"),
        Question(text = "4+6",
            answers = "10"),
        Question(text = "5+3",
            answers = "8")

        )

    lateinit var currentQuestion: Question
    var answer: Int = 0
    private var questionIndex = 0
    private val numQuestions = Math.min((questions.size + 1) / 2, 3)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMathQuizBinding>(
            inflater, R.layout.fragment_math_quiz, container, false)

        // Shuffles the questions and sets the question index to the first question.
        randomizeQuestions()

        // Bind this fragment class to the layout
        binding.game = this
        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            val userAnswer = binding.editText
                if (userAnswer.toString().equals(currentQuestion.answers)) {
                    questionIndex++
                    // Advance to the next question
                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    }
                    else{
                        view.findNavController().navigate(R.id.action_mathQuiz_to_congrats)

                    }
                } else {
                    // Game over! A wrong answer sends us to the gameOverFragment.
                    view.findNavController().navigate(R.id.action_mathQuiz_to_gameOver)

                }
            }
        return binding.root
    }

    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
    }


}
