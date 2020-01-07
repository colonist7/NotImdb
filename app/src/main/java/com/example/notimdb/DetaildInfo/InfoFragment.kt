package com.example.notimdb.DetaildInfo

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.notimdb.Data.response.Cast
import com.example.notimdb.Data.response.Movies


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [InfoFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [InfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InfoFragment(val data: Movies) : Fragment() {



    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private val DESCRIBABLE_KEY = "data"
    private var mDescribable: Movies? = null
//


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
//        mDescribable = arguments!!.getSerializable(
//            DESCRIBABLE_KEY
//        ) as Movies
        val v = inflater.inflate(com.example.notimdb.R.layout.fragment_info, container, false)

        val imageView = v.findViewById(com.example.notimdb.R.id.infoImg) as ImageView
        val Ititle = v.findViewById(com.example.notimdb.R.id.originalTitle) as TextView
        val Idate = v.findViewById(com.example.notimdb.R.id.releaseDate) as TextView
        val Ilang = v.findViewById(com.example.notimdb.R.id.lang) as TextView
        val Iseasons = v.findViewById(com.example.notimdb.R.id.seasons) as TextView


        Ititle.text = data.title
        Idate.text = data.date
        Ilang.text = data.language
        Iseasons.text = data.seasons.toString()

        Glide.with(this)
            .asBitmap()
            .override(500, 300)
            .load(data.imageUrl)
            .into(imageView)

        return v
    }

    override fun onResume() {
        super.onResume()


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
         * @return A new instance of fragment InfoFragment.
         */
        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            InfoFragment(data = Movies()).apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }

        //    fun newInstance(describable: Movies?): InfoFragment {
//        val fragment = InfoFragment()
//        val bundle = Bundle()
//        bundle.putSerializable(DESCRIBABLE_KEY, describable)
//        fragment.setArguments(bundle)
//        return fragment
//    }

    }
}
