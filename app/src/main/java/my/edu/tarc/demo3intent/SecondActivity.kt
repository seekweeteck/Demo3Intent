package my.edu.tarc.demo3intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val value: Int = intent.getIntExtra("value", 0)
        textViewMessage.text = String.format("value = %d", value)
    }
}
