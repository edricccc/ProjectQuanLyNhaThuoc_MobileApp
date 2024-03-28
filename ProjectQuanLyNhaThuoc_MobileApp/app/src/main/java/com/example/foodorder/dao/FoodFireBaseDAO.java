//package com.example.foodorder.dao;
//
//import android.content.Context;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//
//import com.example.foodorder.model.Food;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import java.util.HashMap;
//import java.util.UUID;
//
//public class FoodFireBaseDAO{
//    FirebaseFirestore db;
//    Context context;
//
//    public FoodFireBaseDAO(Context context) {
//        db = FirebaseFirestore.getInstance();
//        this.context = context;
//    }
//
//    public void Insert(Food p) {
//        // Add a new document with a generated ID
//        p.setId(UUID.randomUUID().toString());
//        HashMap<String, Object> mapproduct = p.convertHashMap();
//        db.collection("Food").document(p.getId())
//                .set(p)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//                        Toast.makeText(context, "Thêm mới sp thành công!", Toast.LENGTH_SHORT).show();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(context, "Thêm mới sp thất bại!", Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//    public void Delete(String productId) {
//
//        db.collection("Food").document(productId)
//                .delete()
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//                        Toast.makeText(context, "Xóa sp thành công!", Toast.LENGTH_SHORT).show();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(context, " Xóa sp thất bại!", Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//}
