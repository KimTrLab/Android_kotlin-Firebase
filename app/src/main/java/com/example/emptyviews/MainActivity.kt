package com.example.emptyviews

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.emptyviews.databinding.ActivityLoginBinding
import com.example.emptyviews.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    private lateinit var auth: FirebaseAuth
    private val TAG:String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {  //entry point 시작점  onCreate메서드
        super.onCreate(savedInstanceState)
      //  enableEdgeToEdge()
        setContentView(binding.root)
        //  setContentView(R.layout.activity_main)
        // Initialize Firebase Auth
        auth = Firebase.auth

        //로그인하기
        binding.loginButton.setOnClickListener{
            var email = binding.emailArea.text.toString()
            var password = binding.passwordArea.text.toString()


            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                     //   val user = auth.currentUser
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
//                        Toast.makeText(
//                            baseContext,
//                            "Authentication failed.",
//                            Toast.LENGTH_SHORT,
//                        ).show()
//                        updateUI(null)
                    }
                }

        }
        //가입하기
        binding.joinButton.setOnClickListener {
         //   Log.d("hadf","naya")
            val logintent = Intent(this,LoginActivity::class.java)

            startActivity(logintent)
          //  println("adfasf")

       }

    }
}