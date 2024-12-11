package com.nagy.moviesapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val signInButton = findViewById<Button>(R.id.signInButton)

        signInButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username and password cannot be empty", Toast.LENGTH_SHORT).show()
            } else if (password.length < 8 || !password.matches(Regex(".*[a-zA-Z].*")) || !password.matches(Regex(".*\\d.*"))) {
                Toast.makeText(this, "Password must be at least 8 characters and contain a number and a letter", Toast.LENGTH_SHORT).show()
            } else {
                // Navigate to MovieListActivity
                val intent = Intent(this, MovieListActivity::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
                finish()
            }
        }
    }
}
