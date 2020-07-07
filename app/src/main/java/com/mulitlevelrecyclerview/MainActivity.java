package com.mulitlevelrecyclerview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.multilevelview.MultiLevelRecyclerView;
import com.multilevelview.models.RecyclerViewItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private MultiLevelRecyclerView multiLevelRecyclerView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        multiLevelRecyclerView = (MultiLevelRecyclerView) findViewById(R.id.rv_list);
        multiLevelRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Item> itemList = (List<Item>) recursivePopulateFakeData(0);

        myAdapter = new MyAdapter(this, itemList, multiLevelRecyclerView);

        multiLevelRecyclerView.setAdapter(myAdapter);

        //If you are handling the click on your own then you can
        // multiLevelRecyclerView.removeItemClickListeners();
        multiLevelRecyclerView.setToggleItemOnClick(false);

        multiLevelRecyclerView.setAccordion(true);

        multiLevelRecyclerView.openTill(0, 1, 2, 3);
    }


    private List<?> recursivePopulateFakeData(int levelNumber) {
        List<RecyclerViewItem> itemList = new ArrayList<>();
        String[] parent = new String[]{"VIOLENCE",
                "FEAR", "SEXUALITY", "SIMULATED GAMBLING, REAL GAMBLING, OR CASH PAYOUTS",
                "LANGUAGE", "CONTROLLED SUBSTANCE", "CRUDE HUMOR", "MISCELLANEOUS"};
        List<RecyclerViewItem> q0 = new ArrayList<>();
        List<RecyclerViewItem> q1 = new ArrayList<>();
        List<RecyclerViewItem> q2 = new ArrayList<>();
        List<RecyclerViewItem> q3 = new ArrayList<>();
        List<RecyclerViewItem> q4 = new ArrayList<>();
        List<RecyclerViewItem> q5 = new ArrayList<>();
        List<RecyclerViewItem> q6 = new ArrayList<>();
        List<RecyclerViewItem> q7 = new ArrayList<>();
        List<RecyclerViewItem> q8 = new ArrayList<>();
        q0.add(new Item(1, "", "Does the game contain inferences of, references to, or depictions of violence?",
                "Please note that this question does not refer to user-generated content.", "radiobox",
                2, 1, "Yes", "No", "", "", "", ""));
        q1.add(new Item(23, "", "Does the game contain pictures or sounds likely to be scary or horrifying?",
                "Please note that this question does notrefer to user-generated content.", "radiobox",
                2, 1, "Yes", "No", "", "", "", ""));
        q2.add(new Item(26, "", "Does the game contain inferences of, references to, or depictions of sexuality, sexual violence, suggestiveness, revealing attire, or nudity?",
                "Please note that this question does not refer to user-generated content.",
                "radiobox", 2, 1, "Yes", "No", "", "", "", ""));
        q3.add(new Item(48, "", "Does the game contain gambling, simulations of casino gambling/bingo, or real cash payouts?",
                "Please note that this question does not refer to user-generated content.",
                "radiobox", 2, 1, "Yes", "No", "", "", "", ""));
        q4.add(new Item(52, "", "Does the game contain any potentially offensive language?",
                "Please note that this question does not refer to user-generated content.",
                "radiobox", 2, 1, "Yes", "No", "", "", "", ""));
        q5.add(new Item(57, "", "Does the game contain any reference to or use of drugs, alcohol, or tobacco?",
                "Please note that this question does not refer to user-generated content.",
                "radiobox", 2, 1, "Yes", "No", "", "", "", ""));
        q6.add(new Item(69, "", "Does the game contain any bodily functions such as belching, flatulence, or vomiting when used for humorous purposes?",
                "Please note that this question does not refer to user-generated content.",
                "radiobox", 2, 1, "Yes", "No", "", "", "", ""));
        q7.add(new Item(71, "", "Does the game natively allow users to interact or exchange content with other users through voice communication, text, or sharing images or audio?",
                "", "radiobox", 2, 1, "Yes",
                "No", "", "", "", ""));
        q7.add(new Item(72, "", "Does the game share the user''s current physical location with other users?",
                "", "radiobox", 2, 0, "Yes",
                "No", "", "", "", ""));
        q7.add(new Item(73, "", "Does the game allow users to purchase digital goods?",
                "", "radiobox", 2, 0, "Yes", "No",
                "", "", "", ""));

        switch (levelNumber) {
            case 1:
                break;
            case 2:
                break;
            case 0:
                for (int i = 0; i < parent.length; i++) {
                    Item item = new Item(0);
                    item.setTopic(parent[i]);
                    if (i == 0) {
                        item.addChildren(q0);
                    }

//                    if (i == 1) {
//                        item.addChildren(q2);
//                    }
//                    if (i == 3) {
//                        item.addChildren(q3);
//                    }
//                    if (i == 4) {
//                        item.addChildren(q4);
//                    }
//                    if (i == 5) {
//                        item.addChildren(q5);
//                    }
//                    if (i == 6) {
//                        item.addChildren(q6);
//                    }
//                    if (i == 7) {
//                        item.addChildren(q7);
//                    }
                    itemList.add(item);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + levelNumber);
        }

        return itemList;
    }

    private Object recursivePopulateFakeData1(int i) {
        List<RecyclerViewItem> itemList = new ArrayList<>();

        return itemList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
