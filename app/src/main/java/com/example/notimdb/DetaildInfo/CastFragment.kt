package com.example.notimdb.DetaildInfo

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notimdb.Data.response.Cast
import com.example.notimdb.Data.response.Movies

import com.example.notimdb.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CastFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CastFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CastFragment(data:Movies) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    var list = mutableListOf<Cast>()
    val data = data
//    private val DESCRIBABLE_KEY = "data"
//    private var mDescribable: Movies? = null

//    fun newInstance(describable: Movies?): CastFragment {
//        val fragment = CastFragment()
//        val bundle = Bundle()
//        bundle.putSerializable(DESCRIBABLE_KEY, describable)
//        fragment.setArguments(bundle)
//        return fragment
//    }


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

        return inflater.inflate(R.layout.fragment_cast, container, false)
    }

    override fun onResume() {
        super.onResume()
        // Inflate the layout for this fragment
//        mDescribable = arguments!!.getSerializable(
//            DESCRIBABLE_KEY
//        ) as Movies?

        var recyclerView = view?.findViewById(R.id.CastList) as RecyclerView
        var j = 0
        for (i in data.cast) {
            list.add(
                Cast(
                    j,
                    i.fullName,
                    i.role,
                    i.imageUrl
            ))
            j++
        }
        val adapter = RecyclerViewAdapter(list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)

    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
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
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CastFragment.
         */
        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            CastFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
    }
}
