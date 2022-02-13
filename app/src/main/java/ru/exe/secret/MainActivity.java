package ru.exe.secret;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> title = new ArrayList<>();
    public static ArrayList<String> soder = new ArrayList<>();
    public static RecyclerView mMessageRecycler;
    public static DataAdapter dataAdapter;
    public static String ti;
    public static String so;
    Button mButton;

    @Override
    public void onBackPressed() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button2);

        title.add("В пещере тайной, в день гоненья");
        title.add("В роще карийской, любезной ловцам, таится пещера");
        title.add("Как жениться задумал царский арап");
        title.add("Как редко плату получает");
        title.add("Как сладостно!., но, боги, как опасно");
        soder.add("В пещере тайной, в день гоненья,\n" +
                "Читал я сладостный Коран,\n" +
                "Внезапно ангел утешенья,\n" +
                "Влетев, принес мне талисман.\n" +
                "\n" +
                "Его таинственная сила\n" +
                "\n" +
                "Слова святые начертила\n" +
                "На нем безвестная рука.");
        soder.add("В роще карийской, любезной ловцам, таится пещера,\n" +
                "Стройные сосны кругом склонились ветвями, и тенью\n" +
                "Вход ее заслонен на воле бродящим в извивах\n" +
                "Плющем, любовником скал и расселин. С камня на камень\n" +
                "Звонкой струится дугой, пещерное дно затопляет\n" +
                "Резвый ручей. Он, пробив глубокое русло, виется\n" +
                "Вдаль по роще густой, веселя ее сладким журчаньем.");
        soder.add("Как жениться задумал царский арап,\n" +
                "Меж боярынь арап похаживает,\n" +
                "На боярышен арап поглядывает.\n" +
                "Что выбрал арап себе сударушку,\n" +
                "Черный ворон белую лебедушку.\n" +
                "А как он, арап, чернешенек,\n" +
                "А она-то, душа, белешенька.");
        soder.add("Как редко плату получает\n" +
                "Великий добрый человек в кой-то век\n" +
                "\n" +
                "За все заботы и досады\n" +
                "(И то дивиться всякий рад!)\n" +
                "Берет достойные награды\n" +
                "Или достоин сих наград.\n" +
                "\n");
        soder.add("Как сладостно!.. но, боги, как опасно\n" +
                "Тебе внимать, твой видеть милый взор!..\n" +
                "Забуду ли улыбку, взор прекрасный\n" +
                "И огненный, волшебный разговор!\n" +
                "Волшебница, зачем тебя я видел —\n" +
                "Узнав тебя, блаженство я познал —\n" +
                "И счастие мое возненавидел.");

        try {
            FileInputStream fis = this.openFileInput("title.txt");
            ObjectInputStream is = new ObjectInputStream(fis);
            title = (ArrayList<String>) is.readObject();
            is.close();
            fis.close();
            FileInputStream fis2 = this.openFileInput("body.txt");
            ObjectInputStream is2 = new ObjectInputStream(fis2);
            soder = (ArrayList<String>) is2.readObject();
            is2.close();
            fis2.close();
        }catch (Exception e){}
        mMessageRecycler = findViewById(R.id.recycle);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));
        dataAdapter = new DataAdapter(this);
        mMessageRecycler.setAdapter(dataAdapter);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Add.class));
            }
        });

    }

    public void nextAction(){
        startActivity(new Intent(MainActivity.this, Viewl.class));
    }
}