package com.example.emptyviews

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.emptyviews.databinding.ActivityLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {
    val loginbinding by lazy { ActivityLoginBinding.inflate(layoutInflater)}
    private lateinit var auth: FirebaseAuth
    private val TAG:String = LoginActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  enableEdgeToEdge()
        setContentView(loginbinding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        loginbinding.joinsave.setOnClickListener{
            //Log.d("haadf","naya")
            //println("adfadsf")
            // Initialize Firebase Auth
            auth = Firebase.auth
            /*
                설정한 비밀번호는 6자리 이상이여야한다고 함
                애뮬레이터가 와이파이에 연결되어있는지 확인(인터넷에 연결되어있는지 확인)
                firebase에서 이메일/암호 로그인 방법이 활성화되어 있어야함
                 */
            var email = loginbinding.emailData.text.toString();
            var passwd = loginbinding.passData.text.toString()

            if(passwd.length >=6){
                auth.createUserWithEmailAndPassword(email, passwd) //비밀번호는 6자 이상 되어야 함
                    .addOnCompleteListener(this) { task ->
                        //       Log.d(TAG,"${task}")
                        if (task.isSuccessful) {
                            Log.d(TAG,"성공")
                        } else {
                            Log.d(TAG,"실패")
                        }
                    }
            }else{

            }

        }
    }
}