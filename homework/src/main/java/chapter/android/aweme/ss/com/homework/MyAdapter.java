package chapter.android.aweme.ss.com.homework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.viewHolder> {
    List  data;
    public MyAdapter(List<Message>messages){
        data=messages;
    }

    @NonNull
    @Override
    public MyAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.im_list_item,viewGroup,false);
        MyAdapter.viewHolder viewHolder=new MyAdapter.viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.viewHolder viewHolder, int i) {
            Message datas= (Message) data.get(i);
            int drawableID=0;
        if(datas.getIcon().equals("TYPE_ROBOT"))

        {

            drawableID=R.drawable.session_robot;

        }

        else if(datas.getIcon().equals("TYPE_GAME"))

        {

            drawableID=R.drawable.icon_micro_game_comment;

        }

        else if(datas.getIcon().equals("TYPE_STRANGER"))

        {

            drawableID=R.drawable.session_stranger;

        }

        else if(datas.getIcon().equals("TYPE_USER"))

        {

            drawableID=R.drawable.icon_girl;

        }

        else if(datas.getIcon().equals("TYPE_SYSTEM"))

        {

            drawableID=R.drawable.session_system_notice;

        }





        viewHolder.name.setText(datas.getTitle());

        viewHolder.image.setImageResource(drawableID);

        viewHolder.description.setText(datas.getDescription());

        viewHolder.time.setText(datas.getTime());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class viewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView description;
        TextView time;
        CircleImageView image;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            CircleImageView circleImageView=itemView.findViewById(R.id.circle_view);
            name=itemView.findViewById(R.id.tv_title);
            description=itemView.findViewById(R.id.tv_description);
            time=itemView.findViewById(R.id.tv_time);
            image=itemView.findViewById(R.id.iv_avatar);
        }
    }


}
