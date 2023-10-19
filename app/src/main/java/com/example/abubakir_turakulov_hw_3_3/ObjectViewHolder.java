package com.example.abubakir_turakulov_hw_3_3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ObjectViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivAvatar;
    private TextView tvName;
    private TextView tvText;
    private TextView tvTime;

    public ObjectViewHolder(@NonNull View itemView) {
        super(itemView);
        ivAvatar = itemView.findViewById(R.id.iv_avatar);
        tvName = itemView.findViewById(R.id.tv_name);
        tvText = itemView.findViewById(R.id.tv_text);
        tvTime = itemView.findViewById(R.id.tv_time);
    }

    public void onBind(String friendName, String friendText, int avatarResourceId, String randomTime) {
        ivAvatar.setImageResource(avatarResourceId);

        Bitmap bitmap = BitmapFactory.decodeResource(itemView.getResources(), avatarResourceId);
        Bitmap circleBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(circleBitmap);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        canvas.drawCircle(bitmap.getWidth() / 2f, bitmap.getHeight() / 2f, bitmap.getWidth() / 2f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0, 0, paint);

        ivAvatar.setImageBitmap(circleBitmap);
        tvName.setText(friendName);
        tvText.setText(friendText);
        tvTime.setText(randomTime);
    }
}