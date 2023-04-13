package edu.ualr.intentsassignment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import edu.ualr.intentsassignment.databinding.ActivityContactInfoBinding;
import edu.ualr.intentsassignment.model.Contact;

public class ContactInfoActivity extends AppCompatActivity {
    // TODO 03. Create a new layout file to define the GUI elements of the ContactInfoActivity.
    // TODO 04. Define the basic skeleton of the ContactInfoActivity. Inflate the layout defined in the first step to display the GUI elements on screen.
    // TODO 07. Create a new method that reads the contact info coming from ContactFormActivity and use it to populate the several TextView elements in the layout.
    // TODO 08. Create a new method that invokes a Phone Dialer app, using as parameter the phone number included in the contact info received from ContactFormActivity in the previous step
    // TODO 09. Create a new method that invokes a Messages app, using as parameter the phone number included in the contact info received from ContactFormActivity in the 7th step
    // TODO 10. Create a new method that invokes a Maps app, using as parameter the address included in the contact info received from ContactFormActivity in the 7th step
    // TODO 11. Create a new method that invokes an Email app, using as parameter the email address included in the contact info received from ContactFormActivity in the 7th step
    // TODO 12. Create a new method that invokes an Web Browser app, using as parameter the web url included in the contact info received from ContactFormActivity in the 7th step

    private ActivityContactInfoBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mBinding = ActivityContactInfoBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        Contact c = getIntent().getParcelableExtra("newContact");

        String fullName = c.getFirstName() + " " + c.getLastName();
        mBinding.nameTextView.setText(fullName);
        mBinding.phoneEditText.setText(c.getPhoneNumber());
        mBinding.emailEditText.setText(c.getEmailAddress());
        mBinding.addressEditText.setText(c.getAddress());
        mBinding.websiteEditText.setText(c.getWebsite());
    }

    public void onButtonClick(View view){
        Intent intent = new Intent(this, ContactFormActivity.class);
        startActivity(intent);
    }

    public void onCallButtonClick(View view){
        String phoneNumberUri = mBinding.phoneEditText.getText().toString();
        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumberUri));
        startActivity(callIntent);
    }

    public void onTextButtonClick(View view){
        String phoneNumberUri = mBinding.phoneEditText.getText().toString();
        Intent textIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneNumberUri));
        startActivity(textIntent);
    }

    // Email must be setup on the device. I logged into my gmail when testing this.
    public void onEmailButtonClick(View view){
        String emailAddressString = mBinding.emailEditText.getText().toString();
        Uri emailUri = Uri.parse("mailto:" + emailAddressString + "?subject=Email" + "Subject&body=Email Body");
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, emailUri);
        startActivity(emailIntent);
    }

    public void onWebsiteButtonClick(View view){
        String websiteUrlString = mBinding.websiteEditText.getText().toString();
        // check for properly formatted url
        if (!websiteUrlString.startsWith("http://") && !websiteUrlString.startsWith("https://")){
            websiteUrlString = "http://" + websiteUrlString;
        }
        Uri websiteUri = Uri.parse(websiteUrlString);
        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, websiteUri);
        startActivity(websiteIntent);
    }

    // geo:0,0 sets the lat/long at 0,0. ?q= adds the string to the search bar.
    public void onAddressButtonClick(View view){
        String addressString = mBinding.addressEditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + addressString);
        Intent addressIntent = new Intent(Intent.ACTION_VIEW, addressUri);
        startActivity(addressIntent);
    }

}
