package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import chapter.android.aweme.ss.com.homework.model.PullParser;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        List<chapter.android.aweme.ss.com.homework.model.Message> message=null;
        InputStream Input = null;
        try {
            Input = getAssets().open("data.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            message=PullParser.pull2xml(Input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mRecyclerView=findViewById(R.id.rv_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter=new MyAdapter(message);
        mRecyclerView.setAdapter(mAdapter);


    }

}
