////import android.content.Context;
////import android.support.v7.widget.RecyclerView;
////import android.text.Editable;
////import android.text.TextWatcher;
////import android.util.Log;
////import android.view.LayoutInflater;
////import android.view.View;
////import android.view.ViewGroup;
////import android.widget.EditText;
////import android.widget.ImageView;
////import android.widget.TextView;
////import java.util.ArrayList;
////
/////**
//// * Created by Parsania Hardik on 17-Apr-18.
//// */
////
////public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
////
////    private LayoutInflater inflater;
////    public static ArrayList<EditModel> editModelArrayList;
////
////
////    public CustomAdapter(Context ctx, ArrayList<EditModel> editModelArrayList) {
////
////        inflater = LayoutInflater.from(ctx);
////        this.editModelArrayList = editModelArrayList;
////    }
////
////    @Override
////    public CustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
////
////        View view = inflater.inflate(R.layout.rv_item, parent, false);
////        MyViewHolder holder = new MyViewHolder(view);
////
////        return holder;
////    }
////
////    @Override
////    public void onBindViewHolder(final CustomAdapter.MyViewHolder holder, final int position) {
////
////
////        holder.editText.setText(editModelArrayList.get(position).getEditTextValue());
////        Log.d("print", "yes");
////
////    }
////
////    @Override
////    public int getItemCount() {
////        return editModelArrayList.size();
////    }
////
////    class MyViewHolder extends RecyclerView.ViewHolder {
////
////        protected EditText editText;
////
////        public MyViewHolder(View itemView) {
////            super(itemView);
////
////            editText = (EditText) itemView.findViewById(R.id.editid);
////
////            editText.addTextChangedListener(new TextWatcher() {
////                @Override
////                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
////
////                }
////
////                @Override
////                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
////
////                    editModelArrayList.get(getAdapterPosition()).setEditTextValue(editText.getText().toString());
////                }
////
////                @Override
////                public void afterTextChanged(Editable editable) {
////
////                }
////            });
////
////        }
////
////    }
////}
//
//JOURNALDEV
//
//        JAVA, JAVA EE, ANDROID, PYTHON, WEB DEVELOPMENT TUTORIALS
//
//        JAVA TUTORIAL
//        #INDEX POSTS
//        Core Java Tutorial
//        Java Design Patterns
//        Servlet JSP Tutorial
//        Struts 2 Tutorial
//        Spring Tutorial
//        JSF Tutorial
//        Primefaces Tutorial
//        JDBC Tutorial
//        Hibernate Tutorial
//        MongoDB Tutorial
//        #INTERVIEW QUESTIONS
//        Java Interview Questions
//        Core Java Interview Questions
//        JDBC Interview Questions
//        Servlet Interview Questions
//        JSP Interview Questions
//        Struts2 Interview Questions
//        Spring Interview Questions
//        Hibernate Interview Questions
//        JSF Interview Questions
//        RESOURCES
//        YOU ARE HERE: HOME » ANDROID » ANDROID RECYCLERVIEW LOAD MORE, ENDLESS SCROLLING
//        Android RecyclerView Load More, Endless Scrolling
//        ANUPAM CHUGH 4 COMMENTS
//
//        In this tutorial, we’ll be discussing and implementing Endless Scrolling or Infinite Scroll on RecyclerView in our Android Application. The infinite scrolling in which the next set of rows are fetched from the DB/Server while showing a loading icon is commonly seen in many applications such as Facebook, Twitter.
//
//        It’s recommended to go through this tutorial before proceeding ahead.
//
//        Android RecyclerView Load More
//        In order to show Loading icon at the bottom of RecyclerView while the next set of items are fetched, we need to use Multiple View Types in our RecyclerView Adapter.
//
//        How is this implemented?
//
//        Typically in a simple RecyclerView, we load elements to the adapter from a Data Structure.
//
//        In order to show the loading icon view at the bottom of the RecyclerView, we need to first add a NULL element to the end of the Data Structure.
//
//        Why NULL?
//
//        In order to differentiate that element from the rest of the elements and show a different view type row.
//
//        After adding a null, we notify the adapter the of the new element and fetch the next set of elements.
//
//        Once the next set of elements is obtained, we remove the NULL element and add the next set to the bottom of the Data Structure.
//
//        Following diagram demonstrates what actually happens in the RecyclerView and its Adapter.
//
//        android recyclerview loadmore flow
//
//        In order to detect that the user has scrolled to the end of the RecyclerView, we need to implement OnScrollListener() on the RecyclerView.
//        Enough Talk. Let’s code.
//
//        In the following section, we’ll demonstrate Endless Scrolling on RecyclerView by populating a List of Strings and loading the next set of List after a delay using Handlers.
//
//        Project Structure
//        android recyclerview load more project structure
//
//        Code
//        The code for the activity_main.xml layout is given below:
//
//
//<?xml version="1.0" encoding="utf-8"?>
//<aoid.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
//        xmlns:app="http://schemas.android.com/apk/res-auto"
//        xmlns:tools="http://schemas.android.com/tools"
//        android:layout_width="match_parent"
//        android:layout_height="match_parent"
//        tools:context=".MainActivity">
//
//<android.support.v7.widget.RecyclerView
//        android:id="@+id/recyclerView"
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content"
//        app:layoutManager="android.support.v7.widget.LinearLayoutManager"
//        app:layout_constraintBottom_toBottomOf="parent"
//        app:layout_constraintLeft_toLeftOf="parent"
//        app:layout_constraintRight_toRightOf="parent"
//        app:layout_constraintTop_toTopOf="parent" />
//
//</android.support.constraint.ConstraintLayout>
//        The layout for the rows of the RecyclerView is defined in item_row.xml file as shown below:
//
//
//<?xml version="1.0" encoding="utf-8"?>
//<android.support.v7.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
//        xmlns:app="http://schemas.android.com/apk/res-auto"
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content"
//        app:cardElevation="8dp"
//        app:cardUseCompatPadding="true">
//
//
//<TextView
//        android:id="@+id/tvItem"
//                android:layout_width="match_parent"
//                android:layout_height="wrap_content"
//                android:padding="16dp"
//                android:text="Item X" />
//
//</android.support.v7.widget.CardView>
//        The layout for the loading view is defined in the item_loading.xml file as shown below:
//
//
//<?xml version="1.0" encoding="utf-8"?>
//<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content"
//        android:layout_margin="8dp"
//        android:orientation="vertical">
//
//<ProgressBar
//        android:id="@+id/progressBar"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_gravity="center_horizontal"
//                android:indeterminate="true"
//                android:paddingLeft="8dp"
//                android:paddingRight="8dp"
//                />
//
//</LinearLayout>ndr
//        The code for the RecyclerViewAdapter.java class is given below:
//
//
//        package com.journaldev.androidrecyclerviewloadmore;
//
//        import android.support.annotation.NonNull;
//        import android.support.v7.widget.RecyclerView;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.ProgressBar;
//        import android.widget.TextView;
//
//        import java.util.List;
//
//public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//
//    private final int VIEW_TYPE_ITEM = 0;
//    private final int VIEW_TYPE_LOADING = 1;
//
//    public List<String> mItemList;
//
//
//    public RecyclerViewAdapter(List<String> itemList) {
//
//        mItemList = itemList;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        if (viewType == VIEW_TYPE_ITEM) {
//            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
//            return new ItemViewHolder(view);
//        } else {
//            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false);
//            return new LoadingViewHolder(view);
//        }
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
//
//        if (viewHolder instanceof ItemViewHolder) {
//
//            populateItemRows((ItemViewHolder) viewHolder, position);
//        } else if (viewHolder instanceof LoadingViewHolder) {
//            showLoadingView((LoadingViewHolder) viewHolder, position);
//        }
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return mItemList == null ? 0 : mItemList.size();
//    }
//
//    /**
//     * The following method decides the type of ViewHolder to display in the RecyclerView
//     *
//     * @param position
//     * @return
//     */
//    @Override
//    public int getItemViewType(int position) {
//        return mItemList.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
//    }
//
//
//    private class ItemViewHolder extends RecyclerView.ViewHolder {
//
//        TextView tvItem;
//
//        public ItemViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            tvItem = itemView.findViewById(R.id.tvItem);
//        }
//    }
//
//    private class LoadingViewHolder extends RecyclerView.ViewHolder {
//
//        ProgressBar progressBar;
//
//        public LoadingViewHolder(@NonNull View itemView) {
//            super(itemView);
//            progressBar = itemView.findViewById(R.id.progressBar);
//        }
//    }
//
//    private void showLoadingView(LoadingViewHolder viewHolder, int position) {
//        //ProgressBar would be displayed
//
//    }
//
//    private void populateItemRows(ItemViewHolder viewHolder, int position) {
//
//        String item = mItemList.get(position);
//        viewHolder.tvItem.setText(item);
//
//    }
//
//
//}
//    getItemViewType is where we check each element of the List. If the element is NULL we set the view type as 1 else 0.
//
//        Based on the View type we instantiate the ViewHolder in the onCreateViewHolder.
//
//        Inside the onBindViewHolder we check the type of ViewHolder instance and populate the row accordingly.
//
//        Let’s look at the MainActivity.java class where we instantiate the above Adapter.
//
//
//        package com.journaldev.androidrecyclerviewloadmore;
//
//        import android.os.Handler;
//        import android.support.annotation.NonNull;
//        import android.support.v7.app.AppCompatActivity;
//        import android.os.Bundle;
//        import android.support.v7.widget.LinearLayoutManager;
//        import android.support.v7.widget.RecyclerView;
//
//        import java.util.ArrayList;
//
//public class MainActivity extends AppCompatActivity {
//
//    RecyclerView recyclerView;
//    RecyclerViewAdapter recyclerViewAdapter;
//    ArrayList<String> rowsArrayList = new ArrayList<>();
//
//    boolean isLoading = false;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        recyclerView = findViewById(R.id.recyclerView);
//        populateData();
//        initAdapter();
//        initScrollListener();
//
//
//    }
//
//    private void populateData() {
//        int i = 0;
//        while (i < 10) {
//            rowsArrayList.add("Item " + i);
//            i++;
//        }
//    }
//
//    private void initAdapter() {
//
//        recyclerViewAdapter = new RecyclerViewAdapter(rowsArrayList);
//        recyclerView.setAdapter(recyclerViewAdapter);
//    }
//
//    private void initScrollListener() {
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//            }
//
//            @Override
//            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//
//                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
//
//                if (!isLoading) {
//                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == rowsArrayList.size() - 1) {
//                        //bottom of list!
//                        loadMore();
//                        isLoading = true;
//                    }
//                }
//            }
//        });
//
//
//    }
//
//    private void loadMore() {
//        rowsArrayList.add(null);
//        recyclerViewAdapter.notifyItemInserted(rowsArrayList.size() - 1);
//
//
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                rowsArrayList.remove(rowsArrayList.size() - 1);
//                int scrollPosition = rowsArrayList.size();
//                recyclerViewAdapter.notifyItemRemoved(scrollPosition);
//                int currentSize = scrollPosition;
//                int nextLimit = currentSize + 10;
//
//                while (currentSize - 1 < nextLimit) {
//                    rowsArrayList.add("Item " + currentSize);
//                    currentSize++;
//                }
//
//                recyclerViewAdapter.notifyDataSetChanged();
//                isLoading = false;
//            }
//        }, 2000);
//
//
//    }
//}
