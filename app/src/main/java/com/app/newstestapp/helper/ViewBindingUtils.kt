package com.app.newstestapp.helper

import android.text.TextUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("setMarquee")
fun setTextViewMarquee(mTextView: TextView, isNeeded: Boolean) {
    mTextView.isSelected = isNeeded
    mTextView.setSingleLine()
    mTextView.ellipsize = TextUtils.TruncateAt.MARQUEE
}

@BindingAdapter("imageUrl")
fun setImageUrl(mImageView: ImageView, imageUrl: String?) {
    imageUrl?.let { GlideApp.with(mImageView.context).load(it).into(mImageView) }
}


@BindingAdapter("htmlText")
fun setHtmlText(mTextView: TextView, htmlText: String?) {
    htmlText?.let { mTextView.text = HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_LEGACY) }
}

@BindingAdapter("dateText")
fun formatDate(mTextView: TextView, dateString: String?) {
    val fmt = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'", Locale.ENGLISH)
    val date: Date? = dateString?.let { fmt.parse(it) }
    val fmtOut = SimpleDateFormat("MMM dd hh:mm a", Locale.ENGLISH)
    mTextView.text = date?.let { fmtOut.format(it) }
}