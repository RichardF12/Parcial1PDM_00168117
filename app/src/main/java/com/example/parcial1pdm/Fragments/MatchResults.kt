package com.example.parcial1pdm.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.parcial1pdm.R
import com.example.parcial1pdm.database.entities.Match
import kotlinx.android.synthetic.main.fragment_match_results.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MatchResults.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MatchResults.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MatchResults : Fragment() {
    // TODO: Rename and change types of parameters
    var match: Match? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_match_results, container, false)
        view.apply {
            team.text = match?.winner
            done.setOnClickListener {
                var finish = Match("","",0,0,"","","")
                listener.OnClickScores(finish)
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onClickListElement(match: Match)
        fun onClickScores(match: Match)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MatchResults.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(match: Match): MatchResult{
            var fragment = MatchResult()
            fragment.match = match
            return fragment
        }
    }
}
