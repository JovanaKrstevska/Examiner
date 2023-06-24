package mk.ukim.finki.examiner

import android.content.Intent
import android.graphics.Insets.add
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import mk.ukim.finki.examiner.fragments.Predmet1Fragment
import mk.ukim.finki.examiner.fragments.Predmet2Fragment
import mk.ukim.finki.examiner.fragments.Predmet3Fragment
import mk.ukim.finki.examiner.fragments.Predmet4Fragment

class FragmentPlaceActivity : AppCompatActivity() {

    private lateinit var kluc: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_place)

        kluc = intent.extras?.getString("kluc").toString()

        when (kluc) {
            "mpp" -> {
                    supportFragmentManager.commit {
                        replace<Predmet1Fragment>(R.id.fragment_container_view)
                        setReorderingAllowed(true)
                    }
            }
            "uip" -> {
                supportFragmentManager.commit {
                    replace<Predmet2Fragment>(R.id.fragment_container_view)
                    setReorderingAllowed(true)
                }
            }
            "evlada" -> {
                supportFragmentManager.commit {
                    replace<Predmet3Fragment>(R.id.fragment_container_view)
                    setReorderingAllowed(true)
                }
            }
            "biz" -> {
                supportFragmentManager.commit {
                    replace<Predmet4Fragment>(R.id.fragment_container_view)
                    setReorderingAllowed(true)
                }
            }
        }
    }
}