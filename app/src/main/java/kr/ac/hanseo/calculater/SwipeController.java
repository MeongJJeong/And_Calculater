//package kr.ac.hanseo.calculater;
//
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.graphics.drawable.Drawable;
//import android.support.annotation.NonNull;
//import android.support.v4.content.ContextCompat;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.helper.ItemTouchHelper;
//import android.view.View;
//
//import static android.support.v7.widget.helper.ItemTouchHelper.*;
//import static android.support.v7.widget.helper.ItemTouchHelper.Callback.makeMovementFlags;
//
//public class SwipeController extends ItemTouchHelper.SimpleCallback{
//
//    private RecyclerViewAdapter adapter;
//
//    private Drawable icon;
//    private final ColorDrawable background;
//
//    public SwipeController(RecyclerViewAdapter adapter) {
//        super(0, LEFT| RIGHT);
//        this.adapter=adapter;
//
//        //icon= ContextCompat.getDrawable(adapter.get,R.drawable.delete);
//        //icon=ContextCompat.getDrawable(adapter,R.drawable.delete);
//        background=new ColorDrawable(Color.RED);
//    }
//
//    @Override
//    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
//        return false;
//    }
//
//    @Override
//    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
//        int position = viewHolder.getAdapterPosition();
//        adapter.deleteItem(position);
//    }
//
//
//    @Override
//    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
//        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//
//        View itemView = viewHolder.itemView;
//        int backgroundCornerOffset = 20; //so background is behind the rounded corners of itemView
////
////        int iconMargin = (itemView.getHeight() - icon.getIntrinsicHeight()) / 2;
////        int iconTop = itemView.getTop() + (itemView.getHeight() - icon.getIntrinsicHeight()) / 2;
////        int iconBottom = iconTop + icon.getIntrinsicHeight();
//
//        if (dX > 0) { // Swiping to the right
////            int iconLeft = itemView.getLeft() + iconMargin + icon.getIntrinsicWidth();
////            int iconRight = itemView.getLeft() + iconMargin;
////            icon.setBounds(iconLeft, iconTop, iconRight, iconBottom);
//
//            background.setBounds(itemView.getLeft(), itemView.getTop(),
//                    itemView.getLeft() + ((int) dX) + backgroundCornerOffset, itemView.getBottom());
//        } else if (dX < 0) { // Swiping to the left
////            int iconLeft = itemView.getRight() - iconMargin - icon.getIntrinsicWidth();
////            int iconRight = itemView.getRight() - iconMargin;
////            icon.setBounds(iconLeft, iconTop, iconRight, iconBottom);
//
//            background.setBounds(itemView.getRight() + ((int) dX) - backgroundCornerOffset,
//                    itemView.getTop(), itemView.getRight(), itemView.getBottom());
//        } else { // view is unSwiped
//            background.setBounds(0, 0, 0, 0);
//        }
//
//        background.draw(c);
////        icon.draw(c);
//    }
//}
