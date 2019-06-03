package com.example.parcial1pdm.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial1pdm.Adapter.MatchAdapter
import com.example.parcial1pdm.R
import com.example.parcial1pdm.database.entities.Match
import com.example.parcial1pdm.models.MatchViewModel
import kotlinx.android.synthetic.main.fragment_match_list.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MatchList.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MatchList.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MatchList : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private lateinit var MatchViewModel: MatchViewModel
    private lateinit var MatchAdapter: MatchAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_match_list, container, false)
        MatchViewModel = ViewModelProviders.of(this).get(MatchViewModel::class.java)
        initrecycler(view)
        return view
    }

    fun initrecycler(view: View){
        val linearlayoutmanager = LinearLayoutManager(this.context)

        MatchAdapter = MatchAdapter { match : Match -> listener?.onClickListElement(match)}

        view.recyclerview_match.adapter = MatchAdapter as MatchAdapter

        MatchViewModel.allData.observe(this, Observer { data ->
            data?.let {MatchAdapter.setMatch(it)}
        })

        view.recyclerview_match.apply {
            setHasFixedSize(true)
            layoutManager = linearlayoutmanager
        }

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
        fun onFragmentInteraction(match: Match)
        fun onClickScores(match: Match)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MatchList.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(): MatchList{
            var fragment = MatchList()
            return fragment
        }

    }
}
