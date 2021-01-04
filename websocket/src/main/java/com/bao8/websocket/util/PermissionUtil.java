package com.bao8.websocket.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * 权限相关工具类
 */
public class PermissionUtil {

    /**
     * 判断是否有权限
     */
    public static boolean checkPermission(Context context,
                                          String permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return PackageManager.PERMISSION_GRANTED == context.getPackageManager()
                    .checkPermission(permission, context.getPackageName());
        }
        return true;
    }
}