package com.vsixty.taskapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.vsixty.taskapp.API.Model.CommonModel;
import com.vsixty.taskapp.Adapter.AddPeopleAdapter;
import com.vsixty.taskapp.R;

import java.util.ArrayList;

public class AddPeopeleActivity extends AppCompatActivity {

Button btAssignPeople;
ImageView ivClose;
    Toolbar toolbar;
    ArrayList<CommonModel> commonModels = new ArrayList<>();
    AddPeopleAdapter addPeopleAdapter;
    RecyclerView rvPeopleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_peopele);
        initUI();
    }

    private void initUI() {

        //toolbar function
      /*  toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add People");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
*/

        //initializing view
        rvPeopleList = findViewById(R.id.rvPeopleList);
        btAssignPeople = findViewById(R.id.btAssignPeople);
        ivClose = findViewById(R.id.ivClose);


        //Add Values into Adapter


        CommonModel seven = new CommonModel();
        seven.setId("4010");
        seven.setName("Vignesh");
        seven.setDesignation("Android");
        commonModels.add(seven);

        CommonModel three = new CommonModel();
        three.setId("2652");
        three.setName("Ponni");
        three.setDesignation("Android");
        commonModels.add(three);

        CommonModel four = new CommonModel();
        four.setId("2855");
        four.setName("Anbazhakan");
        four.setDesignation("JAVA");
        commonModels.add(four);

        CommonModel five = new CommonModel();
        five.setId("2935");
        five.setName("Ramya");
        five.setDesignation("JAVA");
        commonModels.add(five);


        CommonModel six = new CommonModel();
        six.setId("3095");
        six.setName("Karthik j");
        six.setDesignation("JAVA");
        commonModels.add(six);




        CommonModel eight = new CommonModel();
        eight.setId("4011");
        eight.setName("Vaishali");
        eight.setDesignation("JAVA");
        commonModels.add(eight);



        CommonModel nine = new CommonModel();
        nine.setId("5399");
        nine.setName("Sri Dharshini");
        nine.setDesignation("Android");
        commonModels.add(nine);



        CommonModel ten = new CommonModel();
        ten.setId("4461");
        ten.setName("Iswarya");
        ten.setDesignation("JAVA");
        commonModels.add(ten);







        addPeopleAdapter = new AddPeopleAdapter(AddPeopeleActivity.this,commonModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rvPeopleList.setLayoutManager(linearLayoutManager);
        rvPeopleList.setAdapter(addPeopleAdapter);





        btAssignPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddPeopeleActivity.this, "Successfully Added", Toast.LENGTH_SHORT).show();
            }
        });


        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddPeopeleActivity.this,BottomNavigationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });











    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(AddPeopeleActivity.this,BottomNavigationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        return super.onSupportNavigateUp();
    }
}
