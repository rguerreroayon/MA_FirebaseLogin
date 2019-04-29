package rguerrero.firebase.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {


    var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        btn_registrar.setOnClickListener{
            registro()
        }
    }


    fun registro(){
        var correo = et_correo.text.toString()
        var contra = et_contra.text.toString()

        mAuth?.createUserWithEmailAndPassword(correo,contra)
            ?.addOnCompleteListener{
                task ->
                    if(task.isSuccessful){
                        Toast.makeText(this,"Se ha agregado el usuario",Toast.LENGTH_SHORT).show()

                    }else{
                        Toast.makeText(this,"No se agrego al usuario",Toast.LENGTH_SHORT).show()

                    }
            }
    }
}
