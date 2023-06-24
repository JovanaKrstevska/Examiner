package mk.ukim.finki.examiner.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import mk.ukim.finki.examiner.DashBoardActivity
import mk.ukim.finki.examiner.R

class RezultatFragment : Fragment() {

    private lateinit var btnStart: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rezultat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnStart = view.findViewById(R.id.btnStart)

        btnStart.setOnClickListener {
            val intent = Intent(requireContext(), DashBoardActivity::class.java)
            startActivity(intent)
        }
    }
}