package com.finesdk.imageload;

import android.net.Uri;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.finesdk.BaseApplication;
import com.finesdk.util.display.DisplayUtil;
import com.finesdk.util.common.StringUtil;

/**
 * Created by Fanhy on 2016/11/16.
 * Description: Fresco 显示图片封装
 */
public class ImageLoader {

    private static volatile ImageLoader imageLoader;

    private ImageLoader() {
    }

    public static ImageLoader getInstance(){
        if(imageLoader == null){
            synchronized (ImageLoader.class){
                if (imageLoader == null)
                    imageLoader = new ImageLoader();
            }
        }
        return imageLoader;

    }

    /**
     * 显示Image
     * @param mSimpleDraweeView
     * @param url
     */
    public void disPlayImage(SimpleDraweeView mSimpleDraweeView, String url){

        if (StringUtil.isEmpty(url))
            return;

        int width = 0;
        int heigth = 0;

        //如果layout里面没有设置宽高就给个默认高度
        width = mSimpleDraweeView.getWidth();
        heigth = mSimpleDraweeView.getHeight();

        if (width <= 0) {
            width = DisplayUtil.dip2px(BaseApplication.newInstance().getAppContext(), 40);
        }
        if (heigth <= 0) {
            heigth = DisplayUtil.dip2px(BaseApplication.newInstance().getAppContext(), 40);
        }

        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
                .setProgressiveRenderingEnabled(true)
                .setLocalThumbnailPreviewsEnabled(true)
                .setResizeOptions(new ResizeOptions(width, heigth))
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(mSimpleDraweeView.getController())
                .build();
        mSimpleDraweeView.setController(controller);
    }
}
