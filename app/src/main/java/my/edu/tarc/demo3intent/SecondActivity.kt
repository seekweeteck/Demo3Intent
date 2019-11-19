package my.edu.tarc.demo3intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        when{
            intent?.action == Intent.ACTION_SEND -> {
                if(intent.type == "text/plain"){
                    handleSendText()
                }
            }
            else -> {
                handleOtherIntent()
            }
        }

        buttonSend.setOnClickListener {
            if(editTextMessage.text.isEmpty()){
                editTextMessage.setError(getString(R.string.input_error))
                return@setOnClickListener
            }

            val intent: Intent = getIntent()
            intent.putExtra(MainActivity.EXTRA_MESSAGE, editTextMessage.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }

    fun handleSendText(){
        val text = intent.getStringExtra(Intent.EXTRA_TEXT)
        textViewMessage.text = String.format("text=%s", text)
    }

    fun handleOtherIntent(){
        val value: Int = intent.getIntExtra(MainActivity.EXTRA_VALUE, 0)
        textViewMessage.text = String.format("value = %d", value)
    }
}
