package my.edu.tarc.demo3intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showSecond(view : View){
        //Explicit intent
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("value", 10)
        }
        startActivity(intent)
    }

    fun showPhone(view: View) {
        //Implicit Intent
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("tel:0123456789"))
        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{
            Snackbar.make(findViewById(R.id.main_layout),
                "No app supporting this action", Snackbar.LENGTH_SHORT)
                .show()
        }

    }
}
