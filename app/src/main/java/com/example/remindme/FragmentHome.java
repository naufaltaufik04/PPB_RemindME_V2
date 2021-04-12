package com.example.remindme;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.remindme.customComponent.EmptyRecyclerView;
import com.example.remindme.customComponent.SpacingItemDecorator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

public class FragmentHome extends Fragment {

    private EmptyRecyclerView recyclerView;
    private ArrayList<Content> listContent;
    private RecyclerViewAdapter recyclerViewAdapter;

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listContent = new ArrayList<>();
        try {
            initializationData();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setEmptyView(view.findViewById(R.id.emptyView));

        recyclerViewAdapter = new RecyclerViewAdapter(getContext(), listContent);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        SpacingItemDecorator itemDecorator = new SpacingItemDecorator(20, 10, 10);
        recyclerView.addItemDecoration(itemDecorator);
        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerViewAdapter.notifyDataSetChanged();
        removeContent();

        return view;
    }

    public void removeContent(){
        ItemTouchHelper.SimpleCallback itemTouchHelper =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                        listContent.remove(viewHolder.getAdapterPosition());
                        recyclerViewAdapter.notifyDataSetChanged();
                    }
                };
        //Set agar konten dapat di geser
        new ItemTouchHelper(itemTouchHelper).attachToRecyclerView(recyclerView);
    }

    public void sortingContent(int choosed){
        switch (choosed){
            case 1:{
                Collections.sort(listContent, Content.byCreated);
                break;
            }
            case 2:{
                Collections.sort(listContent, Content.byDate);
                break;
            }
            case 3:{
                Collections.sort(listContent, Content.byDifficulty);
                break;
            }
        }
        recyclerViewAdapter.notifyDataSetChanged();
    }

    public void insertContent(Content content){
        listContent.add(0, content);
        recyclerViewAdapter.notifyDataSetChanged();
    }

    public void updateContentOrder(int position){
        sortingContent(position);
    }

    public void initializationData() throws ParseException {
        listContent.add( new Content(
                "Implementasi Aplikasi",
                "Ini Detailnya",
                1,
                new SimpleDateFormat("yyyy/MM/dd").parse("2021/04/01"),
                new SimpleDateFormat("yyyy/MM/dd").parse("2021/03/31")
        ));

        listContent.add( new Content(
                "Membuat Desain Mockup",
                "Ini Detailnya",
                2,
                new SimpleDateFormat("yyyy/MM/dd").parse("2021/03/31"),
                new SimpleDateFormat("yyyy/MM/dd").parse("2021/03/31")
        ));

        listContent.add( new Content(
                "Membuat Artikel PKN",
                "Ini Detailnya",
                1,
                new SimpleDateFormat("yyyy/MM/dd").parse("2022/04/02"),
                new SimpleDateFormat("yyyy/MM/dd").parse("2021/03/31")
        ));


        listContent.add( new Content(
                "Menentukan Topik Proyek",
                "Ini Detailnya",
                2,
                new SimpleDateFormat("yyyy/MM/dd").parse("2021/03/30"),
                new SimpleDateFormat("yyyy/MM/dd").parse("2021/03/31")
        ));

        listContent.add( new Content(
                "Membuat Mind Map",
                "Ini Detailnya",
                1,
                new SimpleDateFormat("yyyy/MM/dd").parse("2021/04/21"),
                new SimpleDateFormat("yyyy/MM/dd").parse("2021/03/31")
        ));


        listContent.add( new Content(
                "Latihan Soal Statistika",
                "Ini Detailnya",
                1,
                new SimpleDateFormat("yyyy/MM/dd").parse("2022/04/31"),
                new SimpleDateFormat("yyyy/MM/dd").parse("2021/03/31")
        ));

        listContent.add( new Content(
                "Latihan 12 PPL",
                "Ini Detailnya",
                1,
                new SimpleDateFormat("yyyy/MM/dd").parse("2021/05/09"),
                new SimpleDateFormat("yyyy/MM/dd").parse("2021/03/31")
        ));

        listContent.add( new Content(
                "Santai dulu boss",
                "Ini Detailnya",
                1,
                new SimpleDateFormat("yyyy/MM/dd").parse("2022/04/02"),
                new SimpleDateFormat("yyyy/MM/dd").parse("2021/03/31")
        ));
    }

}