package ir.kaaveh.recyclerviewmvvm.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view)
        .load(url)
        .into(view)
}

//@BindingAdapter("imageUrl")
//fun bindImage(imgView: ImageView, imgUrl: String?) {
//    imgUrl?.let {
//        Glide.with(imgView.context)
//            .load(it)
//            .apply(
//                RequestOptions()
//                .placeholder(R.drawable.loading_animation)
//                .error(R.drawable.ic_broken_image))
//            .into(imgView)
//    }
//}