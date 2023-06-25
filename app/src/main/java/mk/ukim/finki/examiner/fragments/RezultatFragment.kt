package mk.ukim.finki.examiner.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import mk.ukim.finki.examiner.DashBoardActivity
import mk.ukim.finki.examiner.R

class RezultatFragment : Fragment() {

    private lateinit var btnStart: Button
    private lateinit var result: TextView
    private lateinit var points: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rezultat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnStart = view.findViewById(R.id.btnStart)
        result = view.findViewById(R.id.predmetStatus)
        points = view.findViewById(R.id.resultsShow)

        val data = arguments?.getString("points")
        points.text = data
        val poeni = data?.toInt()
        if(poeni!=null){
            if(poeni<25){
                result.text = "Испитот не е положен"
            }
            if(poeni>=25 && poeni<=30){
                result.text = "Испитот е положен"
            } else if(poeni>30 && poeni<=35){
                result.text = "Испитот е положен"
            } else if(poeni>35 && poeni<=40){
                result.text = "Испитот е положен"
            }else if(poeni>40 && poeni<=45){
                result.text = "Испитот е положен"
            }else if(poeni>45 && poeni<=50){
                result.text = "Испитот е положен"
            }
        }

        btnStart.setOnClickListener {
            val intent = Intent(requireContext(), DashBoardActivity::class.java)
            startActivity(intent)
        }
    }
}