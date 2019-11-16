package my.edu.tarc.demo3intent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showSecond(view : View){
        //Explicit intent

        if(editTextExtra.text.isEmpty()){
            editTextExtra.setError(getString(R.string.input_error))
            return
        }

        val intent = Intent(this, SecondActivity::class.java).apply {
            val value = editTextExtra.text.toString().toInt()
            putExtra(Companion.EXTRA_VALUE, value)
        }
        startActivityForResult(intent, REQUEST_CODE)
    }

    fun showPhone(view: View) {
        //Implicit Intent
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("tel:0123456789"))
        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{
            Toast.makeText(this,
                "No app supporting this action", Toast.LENGTH_SHORT)
                .show()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){

                data?.data.also {
                    textView2.text = data?.getStringExtra(EXTRA_MESSAGE).toString()
                }

            }
        }
    }

    companion object {
        const val EXTRA_VALUE: String = "my.edu.tarc.demo3intent.VALUE"
        const val EXTRA_MESSAGE: String = "my.edu.tarc.demo3intent.MESSAGE"
        const val REQUEST_CODE: Int = 1
    }
}
