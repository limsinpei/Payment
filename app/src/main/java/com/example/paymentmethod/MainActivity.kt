package com.example.paymentmethod

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern
import com.example.paymentmethod.PacNumber as PacNumber1


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val emailcheck = findViewById<EditText>(R.id.email)
        emailcheck.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            // If the event is a key-down event on the "enter" button
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                // Perform action on key press
                //Toast.makeText(applicationContext, "The email address format are wrong!!", Toast.LENGTH_LONG)
                checkemail()
                return@OnKeyListener true
            }
            false
        })

        val phonecheck = findViewById<EditText>(R.id.phonenumber)
        phonecheck.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            // If the event is a key-down event on the "enter" button
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                // Perform action on key press
                //Toast.makeText(applicationContext, "The email address format are wrong!!", Toast.LENGTH_LONG)
                checkphone()
                return@OnKeyListener true
            }
            false
        })

        val namecheck = findViewById<EditText>(R.id.name)
        namecheck.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            // If the event is a key-down event on the "enter" button
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                // Perform action on key press
                //Toast.makeText(applicationContext, "The email address format are wrong!!", Toast.LENGTH_LONG)
                checkname()
                return@OnKeyListener true
            }
            false
        })

        val cardcheck = findViewById<EditText>(R.id.cardnum)
        cardcheck.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            // If the event is a key-down event on the "enter" button
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                // Perform action on key press
                //Toast.makeText(applicationContext, "The email address format are wrong!!", Toast.LENGTH_LONG)
                checkcardnum()
                return@OnKeyListener true
            }
            false
        })

        val month = resources.getStringArray(R.array.month)
        val spinner = findViewById<Spinner>(R.id.month)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, month
            )
            spinner.adapter = adapter
        }
        checkmonth()


        //(View.OnKeyListener { v, keyCode, event ->
            // If the event is a key-down event on the "enter" button
            //if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                // Perform action on key press
                //Toast.makeText(applicationContext, "The email address format are wrong!!", Toast.LENGTH_LONG)

           //     return@OnKeyListener true
           // }
           // false
       // })

        val year = resources.getStringArray(R.array.year)
        val yearspinner = findViewById<Spinner>(R.id.year)
        if (yearspinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, year
            )
            yearspinner.adapter = adapter
        }
        //yearspinner.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            // If the event is a key-down event on the "enter" button
           // if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                // Perform action on key press
                //Toast.makeText(applicationContext, "The email address format are wrong!!", Toast.LENGTH_LONG)
                checkyear()
               // return@OnKeyListener true
           // }
           // false
       // })

        val cvvcheck = findViewById<EditText>(R.id.cardCVCEditText)
        cvvcheck.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            // If the event is a key-down event on the "enter" button
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                // Perform action on key press
                //Toast.makeText(applicationContext, "The email address format are wrong!!", Toast.LENGTH_LONG)
                checkcvv()
                return@OnKeyListener true
            }
            false
        })

        submitcheck()

        submit.setOnClickListener {
            val intent = Intent(this, PacNumber1::class.java)
            // start your next activity
            startActivity(intent)
        }
    }

    fun checkemail()
    {
        val emailcheck = findViewById<EditText>(R.id.email)
        val textemail = emailcheck.text.toString()
        val emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$"

        val pat = Pattern.compile(emailRegex)
        //val nullerror = Toast.makeText(applicationContext, "The email address cannot be null!!", Toast.LENGTH_LONG)
        //nullerror.show()
        //val error = Toast.makeText(applicationContext, "The email address format are wrong!!", Toast.LENGTH_LONG)

        if (textemail == null || textemail == "")
        {
            //nullerror.show()
            emailcheck.setText("")
            emailcheck.setError(getString(R.string.nullemail))

        }
        else if(pat.matcher(textemail).matches())
        {

        }
        else
        {
            //error.show()
            emailcheck.setText("")
            emailcheck.setError(getString(R.string.erroremail))

        }
    }

    fun checkphone()
    {
        val phone = findViewById<EditText>(R.id.phonenumber)
        val textphone = phone.text.toString()
        val letter = Pattern.compile("[a-zA-z]")
        val digit = Pattern.compile("[0-9]")
        val special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]")

        val hasLetter = letter.matcher(textphone)
        val hasDigit = digit.matcher(textphone)
        val hasSpecial = special.matcher(textphone)

        val pattern = Pattern.compile("\\d{3}-\\d{7}")

        val matcher = pattern.matcher(textphone)

        if(textphone == null || textphone == "")
        {
            phone.setText("")
            phone.setError(getString(R.string.nullname))

        }
        else if(hasLetter.find())
        {
            phone.setText("")
            phone.setError(getString(R.string.numname))

        }
        else if(matcher.matches())
        {

        }
        else
        {
            phone.setText("")
            phone.setError(getString(R.string.numname))
        }

    }

    fun checkname()
    {
        val name = findViewById<EditText>(R.id.name)
        val textname = name.text.toString()
        val letter = Pattern.compile("[a-zA-z]")
        val digit = Pattern.compile("[0-9]")
        val special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]")
        //Pattern eight = Pattern.compile (".{8}");


        //val hasLetter = letter.matcher(textname)
        val hasDigit = digit.matcher(textname)
        val hasSpecial = special.matcher(textname)

        if(textname == null || textname == "")
        {
            name.setText("")
            name.setError(getString(R.string.nullname))

        }
        else if(hasDigit.find() || hasSpecial.find())
        {
            name.setText("")
            name.setError(getString(R.string.numname))

        }
        else
        {

        }

    }


    fun checkcardnum()
    {
        val cardnum = findViewById<EditText>(R.id.cardnum)
        val card = cardnum.text.toString()
        val regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
                "(?<mastercard>5[1-5][0-9]{14})|" +
                "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
                "(?<amex>3[47][0-9]{13})|" +
                "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
                "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$"

        val letter = Pattern.compile("[a-zA-z]")
        val digit = Pattern.compile("[0-9]")
        val special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]")
        val hasLetter = letter.matcher(card)
        val hasDigit = digit.matcher(card)
        val hasSpecial = special.matcher(card)

        val pattern = Pattern.compile(regex)

        val matcher = pattern.matcher(card)

        if(card == null || card.toString() == "")
        {
            cardnum.setText("")
            cardnum.setError(getString(R.string.nullname))

        }
        else if(hasLetter.find() || hasSpecial.find())
        {
            cardnum.setText("")
            cardnum.setError(getString(R.string.erroremail))
        }
        else if (matcher.matches())
        {

        }
        else
        {
            cardnum.setText("")
            cardnum.setError(getString(R.string.erroremail))
        }

    }


    fun checkcvv()
    {
        val cvv = findViewById<EditText>(R.id.cardCVCEditText)
        val textcvv = cvv.text.toString()

        val letter = Pattern.compile("[a-zA-z]")
        val digit = Pattern.compile("[0-9]")
        val special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]")
        val hasLetter = letter.matcher(textcvv)
        val hasDigit = digit.matcher(textcvv)
        val hasSpecial = special.matcher(textcvv)

        if(textcvv == null || textcvv == "")
        {
            cvv.setText("")
            cvv.setError(getString(R.string.nullname))

        }
        else if(hasLetter.find() || hasSpecial.find())
        {
            cvv.setText("")
            cvv.setError(getString(R.string.numname))

        }
        else if(cvv.length() != 3 )
        {
            cvv.setText("")
            cvv.setError(getString(R.string.numname))
        }
        else if(hasDigit.find())
        {

        }


    }

    fun checkmonth()
    {
        val spinner = findViewById<Spinner>(R.id.month)
        if (spinner.selectedItem.toString()==""){

            Toast.makeText(getApplicationContext(),"month hasn't values",
                Toast.LENGTH_LONG).show();
        }
    }

    fun checkyear()
    {
        val yearspinner = findViewById<Spinner>(R.id.year)
        if (yearspinner.selectedItem.toString()==""){

            Toast.makeText(getApplicationContext(),"year hasn't values",
                Toast.LENGTH_LONG).show();
        }
    }

    fun submitcheck()
    {
        val button = findViewById<Button>(R.id.submit)
        val cvv = findViewById<EditText>(R.id.cardCVCEditText)
        val phone = findViewById<EditText>(R.id.phonenumber)
        val cardnum =findViewById<EditText>(R.id.cardnum)
        val email = findViewById<EditText>(R.id.email)
        val name = findViewById<EditText>(R.id.name)
        val yearspinner = findViewById<Spinner>(R.id.year)
        val spinner = findViewById<Spinner>(R.id.month)


            if(cvv.text.toString() != null)
        {
            if(phone.text.toString() != null)
            {
                if(cardnum.text.toString() != null)
                {
                    if(email.text.toString() != null)
                    {
                        if(name.text.toString() != null)
                        {
                            if (yearspinner.selectedItem.toString()!=null)
                            {
                               if (spinner.selectedItem.toString()!=null)
                                {
                                    button.isEnabled = true

                                    var sharedPreferences = getSharedPreferences("com.example.paymentmethod", Context.MODE_PRIVATE)
                                    var savephone = sharedPreferences.getString("SESSION_PHONE", getString(R.string.phonenumber))?:return

                                    with(sharedPreferences.edit()){
                                        putString("SESSION_PHONE", phone.text.toString())

                                        apply()
                                    }


                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
