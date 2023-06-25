package mk.ukim.finki.examiner.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import mk.ukim.finki.examiner.R
import mk.ukim.finki.examiner.data.Predmet
import mk.ukim.finki.examiner.data.UploadData
import mk.ukim.finki.examiner.data.uipList

class Predmet2Fragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_predmet2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prasanje = view.findViewById(R.id.prasanje)
        group = view.findViewById(R.id.radioGroup)
        nextQ = view.findViewById(R.id.btnNext)
        optionOne = view.findViewById(R.id.odg1)
        optionTwo = view.findViewById(R.id.odg2)
        optionThree = view.findViewById(R.id.odg3)

        val mutable: MutableList<Predmet> = uipList()
        mutable.shuffle()
        var counter: Int = 0
        var poeni: Int = 0
        prasanje.text = mutable[counter].prasanje

        optionOne.text = mutable[counter].odgovor1
        optionTwo.text = mutable[counter].odgovor2
        optionThree.text = mutable[counter].odgovor3

        nextQ.setOnClickListener {
            var selectedOption = group.checkedRadioButtonId
            val radiobtn: RadioButton = view.findViewById(selectedOption)
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
                uploadData(poeni)
                val bundle = Bundle()
                bundle.putString("points", poeni.toString())
                val fragment = RezultatFragment()
                fragment.arguments = bundle
                parentFragmentManager.beginTransaction().add(R.id.fragment_container_view, fragment).commit()
//                parentFragmentManager.commit {
//                    replace<RezultatFragment>(R.id.fragment_container_view)
//                    setReorderingAllowed(true)
//                    addToBackStack(null)
//                }
            }
        }
    }

    fun uploadData(poeni: Int){
        val firebaseauth =  FirebaseAuth.getInstance()
        val user: FirebaseUser? = firebaseauth.currentUser
        var fullName = user?.displayName
        var mail = user?.email
        val points = poeni
        var status:String = "Испитот не е положен"
        var ocenka:Int = 5
        if(points>=25 && points<=30){
            ocenka = 6
            status = "Испитот е положен"
        } else if(points>30 && points<=35){
            ocenka = 7
            status = "Испитот е положен"
        } else if(points>35 && points<=40){
            ocenka = 8
            status = "Испитот е положен"
        }else if(points>40 && points<=45){
            ocenka = 9
            status = "Испитот е положен"
        }else if(points>45 && points<=50){
            ocenka = 10
            status = "Испитот е положен"
        }
        val userUID = user?.uid
        val data = UploadData(fullName, mail, points, status, ocenka)
        if (userUID != null) {
            FirebaseDatabase.getInstance().getReference("Управување со ИКТ проекти").child(userUID).setValue(data)
        }
    }

}