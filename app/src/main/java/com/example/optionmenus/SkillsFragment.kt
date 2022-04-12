package com.example.optionmenus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import android.app.AlertDialog
import kotlinx.android.synthetic.main.add_skill.view.*
import kotlinx.android.synthetic.main.fragment_skills.view.*

private const val MY_SKILLS= "skills"

class SkillsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var skills: ArrayList<String> = mutableListOf("Spring Boot", "Android Development") as ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            skills = it.getStringArrayList(MY_SKILLS) as ArrayList<String>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_skills, container, false)

        val listView:ListView = view.findViewById(R.id.skillsView) as ListView

        val listViewAdapter: ArrayAdapter<String> = ArrayAdapter(requireActivity(),
            android.R.layout.simple_list_item_1,
            skills)

        view.fab_add.setOnClickListener {
            val addSkillView = LayoutInflater.from(requireContext()).inflate(R.layout.add_skill, null)
            val addSkillBuilder = AlertDialog.Builder(requireContext()).setView(addSkillView).setTitle("Add Skill")
            val addSkillAlertDialog = addSkillBuilder.show()

            addSkillView.btn_add_new_skill.setOnClickListener {
                val skill:String = addSkillView.et_add_new_skill.text.toString()
                skills.add(skill)
                addSkillAlertDialog.dismiss()
                listViewAdapter.notifyDataSetChanged()
                Toast.makeText(requireContext(), "New skill $skill added", Toast.LENGTH_LONG).show()
            }

            addSkillView.btn_cancel.setOnClickListener {
                addSkillAlertDialog.dismiss()
                Toast.makeText(requireContext(), "Adding skill cancelled", Toast.LENGTH_SHORT).show()
            }
        }

        listView.adapter = listViewAdapter

        return view

    }
}
