package com.example.tournomentmanagement


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tournomentmanagement.models.Tournament

/**
 * A simple [Fragment] subclass.
 */
class NewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameEdt = activity?.findViewById<EditText>(R.id.edt_name)
        val passwordEdt = activity?.findViewById<EditText>(R.id.edt_password)
        val saveBtn = activity?.findViewById<Button>(R.id.btn_save)
        saveBtn?.setOnClickListener {
            if (!nameEdt?.text.isNullOrEmpty() && !passwordEdt?.text.isNullOrEmpty()) {
                val dbHandler = AppDBOpenHelper(activity!!, null)
                val tournament = Tournament(nameEdt?.text.toString(), passwordEdt?.text.toString())
                dbHandler.addTournament(tournament)

                Toast.makeText(activity,"تورنمنت با موقعیت درج گردید", Toast.LENGTH_LONG).show()
                val fragment = TeamFragment()
                Utils.addFragmentToActivity(activity?.supportFragmentManager, fragment)
            }
        }
    }

}
