package com.example.pbl_sns_25

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pbl_sns_25.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.zip.Inflater

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

var user: FirebaseUser? = null
val db: FirebaseFirestore = Firebase.firestore
val itemsCollectionRef = db.collection("items")


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    //val binding = FragmentHomeBinding.inflate(inflater)
    //user = FirebaseAuth.getInstance().currentUser



//    val adapter = CustomAdapter(viewModel)
//    binding.recyclerView.adapter = adapter // RecyclerView와 CustomAdapter 연결
//    binding.recyclerView.layoutManager = LinearLayoutManager(this)
//    binding.recyclerView.setHasFixedSize(true)

//    private fun queryItem(userID: String) {
//        itemsCollectionRef.document(userID).get()
//            .addOnSuccessListener { // it: DocumentSnapshot
//                binding.textview.setText(it.id)
//                binding.editItemName.setText(it["name"].toString())
//                binding.editPrice.setText(it["price"].toString())
//        }.addOnFailureListener { }
//    }
    class Posts(val name: String, val text: String)
    val postList = arrayListOf(
        Posts("테스트1", "테스트텍스트입니다"),
        Posts("테스트2", "테스트텍스트입니다")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        _binding?.postRecyclerview?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        _binding?.postRecyclerview?.adapter = CustomAdapter(postList)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    /*companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}