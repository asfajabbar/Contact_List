package com.example.contact_list;
import androidx.annotation.NonNull;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.contact_list.Second_screen;


public class recycler_adapter extends RecyclerView.Adapter<recycler_adapter.myView> {

    String d1[];
    int images[];
    Context context;


    public recycler_adapter(Context ct, String s1[],   int imag[])
    {
        context = ct;
        d1=s1;
        // d2=s2;
        images= imag;
    }
    @NonNull
    @Override
    public myView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inf = LayoutInflater.from(context);
        View view = inf.inflate(R.layout.my_row, parent, false);

        return new  myView(view);

    }

    @Override
    public void onBindViewHolder(@NonNull myView holder, final int position) {
        holder.t1.setText(d1[position]);
        //holder.t2.setText(d2[position]);
        holder.i.setImageResource(images[position]);

        holder.mainLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Second_screen.class);
                intent.putExtra("Data1", d1[position]);
                //intent.putExtra("Data2", d2[position]);
                intent.putExtra("myImage", images[position]);
                context.startActivity(intent);


            }

        });
    }







    @Override
    public int getItemCount() {
        return images.length;
    }

    public class myView extends RecyclerView.ViewHolder

    {
        TextView t1, t2;

        ImageView i;
        ConstraintLayout mainLayout1;

        public myView(@NonNull View itemView)
        {
            super(itemView);
            t1= itemView.findViewById(R.id.myText1);
            //t2= itemView.findViewById(R.id.myText2);
            i = itemView.findViewById(R.id.mainImage);

            mainLayout1= itemView.findViewById(R.id.mainLayout);




        }
    }
}