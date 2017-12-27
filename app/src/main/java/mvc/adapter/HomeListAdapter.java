package mvc.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.zl.framwork.R;
import com.zl.framwork.customizeView.RoundCornerImageView;

import java.util.ArrayList;
import java.util.List;

import mvc.bean.HomeInfo;

/**
 * 作者：zhaolong
 * 日期：2017/11/8
 * 时间：11:10
 * 邮箱：longzhao2@gmail.com
 * 电话：15209866017
 * TODO=> 首页列表适配器
 */

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.HomeViewHolder> {

    private List<HomeInfo> homeList;
    private Context mContext;
    private final ImageLoader imageLoader;
    private final DisplayImageOptions options;

    public HomeListAdapter(Context context , List<HomeInfo> list){
        this.mContext = context;
        this.homeList = list;
        if(null == homeList){
            homeList = new ArrayList<>();
        }
        //图片加载插件
        imageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.default_img_load)
                .showImageOnFail(R.drawable.default_img_load)
                .build();

    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        HomeViewHolder viewHolder = new HomeViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_rv,parent,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        if(homeList != null && homeList.size()>0){
            HomeInfo homeInfo = homeList.get(position);
            if(null == homeInfo){
                return;
            }
            holder.title.setText(homeInfo.getTitle());
            holder.content.setText(homeInfo.getContent());

            //加载头像图片和内容图片
            imageLoader.displayImage(homeInfo.getIcon(),holder.headImg,options,new SimpleImageLoadingListener(){
                @Override
                public void onLoadingStarted(String imageUri, View view) {
                    super.onLoadingStarted(imageUri, view);
                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                    super.onLoadingFailed(imageUri, view, failReason);
                }

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    super.onLoadingComplete(imageUri, view, loadedImage);
                }

                @Override
                public void onLoadingCancelled(String imageUri, View view) {
                    super.onLoadingCancelled(imageUri, view);
                }
            });

            //展示内容图片
            imageLoader.displayImage(homeInfo.getImgUrl(), holder.contentImg, options, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {

                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

                }

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

                }

                @Override
                public void onLoadingCancelled(String imageUri, View view) {

                }
            });

            holder.contentParent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return homeList.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder{

        RoundCornerImageView headImg;
        TextView title;
        TextView content;
        ImageView contentImg;
        LinearLayout contentParent;

        public HomeViewHolder(View itemView) {
            super(itemView);
            headImg = (RoundCornerImageView) itemView.findViewById(R.id.homelist_head_iv);
            title = (TextView) itemView.findViewById(R.id.homelist_title);
            content = (TextView) itemView.findViewById(R.id.homelist_content);
            contentImg = (ImageView) itemView.findViewById(R.id.homelist_content_image);
            contentParent = (LinearLayout) itemView.findViewById(R.id.content_parent_ll);
        }
    }

}
