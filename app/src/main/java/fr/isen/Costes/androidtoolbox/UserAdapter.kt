package fr.isen.Costes.androidtoolbox

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.isen.Costes.androidtoolbox.Models.UserModel
import kotlinx.android.synthetic.main.recycler_view_contact_cell.view.*
import kotlinx.android.synthetic.main.recycler_view_user_cell.view.*

class UsersAdapter(val users: ArrayList<UserModel>): RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_user_cell, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.count()
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
    }

    class UserViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(user: UserModel) {
            view.userDisplayNameTextView.text = user.fName + " " + user.lName
        }
    }
}
