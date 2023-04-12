package edu.ualr.intentsassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import edu.ualr.intentsassignment.databinding.ActivityContactFormBinding;
import edu.ualr.intentsassignment.model.Contact;


public class ContactFormActivity extends AppCompatActivity {
    // TODO 01. Create a new layout file to define the GUI elements of the ContactFormActivity.
    // TODO 02. Define the basic skeleton of the ContactFormActivity. Inflate the layout defined in the first step to display the GUI elements on screen.
    // TODO 06. Create a new method that reads the values in the several EditText elements of the layout and then uses the Contact class to send those data to ContactInfoActivity

    private ActivityContactFormBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mBinding = ActivityContactFormBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
    }

    // On button click, create a new Intent, create a new Contact, attach the Contact to the intent, startActivity
    public void onButtonClick(View view){
        Intent intent = new Intent(ContactFormActivity.this, ContactInfoActivity.class);

        Contact newContact = new Contact();
        newContact.setFirstName(mBinding.firstNameEditText.getText().toString());
        newContact.setLastName(mBinding.lastNameEditText.getText().toString());
        newContact.setPhoneNumber(mBinding.phoneEditText.getText().toString());
        newContact.setEmailAddress(mBinding.emailEditText.getText().toString());
        newContact.setAddress(mBinding.addressEditText.getText().toString());
        newContact.setWebsite(mBinding.websiteEditText.getText().toString());

        intent.putExtra("newContact", newContact);

        startActivity(intent);
    }

}
