package com.example.abubakir_turakulov_hw_3_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> realFriendNames = new ArrayList<>();
    private ArrayList<String> realFriendTexts = new ArrayList<>();
    private ArrayList<Integer> realAvatarResourceIds = new ArrayList<>();
    private RecyclerView rvFriendList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();
        initAdapter();
    }

    private void loadData() {
        addFriendData("Байдиль", "Не сор, не смогу\nЯ ща кушаю", R.drawable.avatar1);
        addFriendData("Дони", "Мой диплом тоже возьми с собой\nЛя ты крыса", R.drawable.avatar7);
        addFriendData("Софа", "Иди спать\nМама так сказала", R.drawable.avatar4);
        addFriendData("Даулет", "Алооо\nты куда пропал?", R.drawable.avatar3);
        addFriendData("Карина", "Вот как\nПока", R.drawable.avatar6);
        addFriendData("Kepix", "Не сегодня уж точно\nЯ в доту лучше пойду", R.drawable.avatar5);
        addFriendData("Темирлан", "Я жду\nТы где?", R.drawable.avatar10);
        addFriendData("Аман", "А я ведь знал\nНе умеет он продавать", R.drawable.avatar2);
        addFriendData("Радужный", "Я знаю где ты живёшь\nЯ иду за тобой!", R.drawable.avatar8);
        addFriendData("Гром", "Давай\nСпоки", R.drawable.avatar9);
    }

    private void addFriendData(String friendName, String friendText, int avatarResourceId) {
        realFriendNames.add(friendName);
        realFriendTexts.add(friendText);
        realAvatarResourceIds.add(avatarResourceId);
    }

    private void initAdapter() {
        ObjectAdapter adapter = new ObjectAdapter(realFriendNames, realFriendTexts, realAvatarResourceIds);
        rvFriendList.setAdapter(adapter);
    }

    private void initView() {
        rvFriendList = findViewById(R.id.rv_friend_list);
    }
}