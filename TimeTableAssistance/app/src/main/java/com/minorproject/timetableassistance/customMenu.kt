package com.minorproject.timetableassistance

import android.app.Notification.Action
import android.content.Context
import android.view.View
import android.widget.ActionMenuView
import android.widget.PopupMenu
import android.widget.Toast

class CustomMenu {

    fun customMenu(context : Context, view : View){
        val pop = PopupMenu(context, view)
        pop.inflate(R.menu.user_profile_menu)

        pop.setOnMenuItemClickListener {
            when(it!!.itemId){
                R.id.userProfileMenuItem1 -> {
                    Toast.makeText(context, "Switch to Personal",
                        Toast.LENGTH_LONG).show()
                    true }
                R.id.userProfileMenuItem2 -> {

                    Toast.makeText(context, "Logged Out",
                        Toast.LENGTH_LONG).show()
                    true}
                else -> false
            }
        }

        try {
            val fieldMPopup = PopupMenu::class.java.getDeclaredField("mPopup")
            fieldMPopup.isAccessible = true
            val mPopup = fieldMPopup.get(pop)
            mPopup.javaClass
                .getDeclaredMethod("setFoeceShowIcon", Boolean :: class.java)
                .invoke(mPopup, true)
        }
        catch (e : Exception){
            Toast.makeText(context, "${e.message.toString()}", Toast.LENGTH_SHORT).show()
        }
        finally {
            pop.show()
        }
    }

}