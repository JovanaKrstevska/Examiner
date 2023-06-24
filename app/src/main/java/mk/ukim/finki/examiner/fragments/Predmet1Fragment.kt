package mk.ukim.finki.examiner.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.firebase.database.FirebaseDatabase
import mk.ukim.finki.examiner.R
import mk.ukim.finki.examiner.data.Predmet
import mk.ukim.finki.examiner.data.mppList


class Predmet1Fragment : Fragment() {

    private lateinit var prasanje: TextView
    private lateinit var group: RadioGroup
    private lateinit var optionOne: RadioButton
    private lateinit var optionTwo: RadioButton
    private lateinit var optionThree: RadioButton
    private lateinit var nextQ: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_predmet1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prasanje = view.findViewById(R.id.prasanje)
        group = view.findViewById(R.id.radioGroup)
        nextQ = view.findViewById(R.id.btnNext)
        optionOne = view.findViewById(R.id.odg1)
        optionTwo = view.findViewById(R.id.odg2)
        optionThree = view.findViewById(R.id.odg3)

        val mutable: MutableList<Predmet> = mppList()
        mutable.shuffle()
        var counter: Int = 0
        var poeni: Int = 0
        prasanje.text = mutable[counter].prasanje

        optionOne.text = mutable[counter].odgovor1
        optionTwo.text = mutable[counter].odgovor2
        optionThree.text = mutable[counter].odgovor3

        nextQ.setOnClickListener {
            var selectedOption = group.checkedRadioButtonId
            val radiobtn:RadioButton = view.findViewById(selectedOption)
            if(radiobtn.text == mutable[counter].tocenOdgovor){
                poeni+=5
            }
            counter +=1
            group.clearCheck()
            if(counter<mutable.size){
                prasanje.text = mutable[counter].prasanje
                optionOne.text = mutable[counter].odgovor1
                optionTwo.text = mutable[counter].odgovor2
                optionThree.text = mutable[counter].odgovor3
            } else {
                parentFragmentManager.commit {
                    replace<RezultatFragment>(R.id.fragment_container_view)
                    setReorderingAllowed(true)
                    addToBackStack(null)
                }
            }
        }
    }
}