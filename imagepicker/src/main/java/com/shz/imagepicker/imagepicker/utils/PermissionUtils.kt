package com.shz.imagepicker.imagepicker.utils

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.shz.imagepicker.imagepicker.ImagePicker

fun Activity.checkGalleryNativePermission(request: Int, action: () -> Unit) {
    if (ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_DENIED
    ) {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
            ),
            request,
        )
    } else {
        action()
    }
}

fun Activity.checkCameraPermission(request: Int, action: () -> Unit) {
    if (ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_DENIED
    ) {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.CAMERA),
            request,
        )
    } else action()
}
