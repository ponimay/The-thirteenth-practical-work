package ru.btpitMedia.SecondMenu

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView: ImageView = findViewById(R.id.pic)
        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.buttttton)
        val popupMenu2 = PopupMenu(this, button)
        val popupMenu3 = PopupMenu(this, textView)
        popupMenu3.inflate(R.menu.popupmenu3)
        popupMenu3.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.small_text->{
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14F)
                }
                R.id.medium_text->{
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18F)
                }
                R.id.large_text->{
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24F)
                }

            }
            false
        }
        textView.setOnClickListener{
            popupMenu3.show()
        }
        popupMenu2.inflate(R.menu.popupmenu2)
        popupMenu2.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.red -> {
                    textView.text = "u choice red color"
                    textView.background = ColorDrawable(Color.RED)
                }
                R.id.yellow -> {
                    textView.background = ColorDrawable(Color.YELLOW)
                    textView.text = "u choice yellow color"
                }
                R.id.green -> {
                    textView.background = ColorDrawable(Color.GREEN)
                    textView.text = "u choice green color"
                }
                R.id.submenu2 -> {
                    textView.background = ColorDrawable(Color.YELLOW)
                    textView.text = "u choice light-yellow color"
                }
            }
            false
        }
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            popupMenu2.setForceShowIcon(true)
        }
        button.setOnClickListener {
            popupMenu2.show()
        }
        val pop = androidx.appcompat.widget.PopupMenu(this, imageView)
        pop.inflate(R.menu.popupmenu)
        pop.setOnMenuItemClickListener {
            when (it.itemId){
                R.id.menu1 -> {
                    textView.text = "u press in PopupMenu 1"
                    true
                }
                R.id.menu2 -> {
                    textView.text = "u press in PopupMenu 2"
                    true
                }
                R.id.menu3 -> {
                    textView.text = "u press in PopupMenu 3"
                    true
                }
                else -> false
            }
        }
        imageView.setOnClickListener{
            pop.show()
        }
    }
}