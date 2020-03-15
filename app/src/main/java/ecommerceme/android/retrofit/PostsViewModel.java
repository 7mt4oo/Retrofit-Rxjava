package ecommerceme.android.retrofit;

import android.util.Log;
import io.reactivex.Observable;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ecommerceme.android.retrofit.Service.PostsClient;
import ecommerceme.android.retrofit.pojo.PostModel;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PostsViewModel extends ViewModel {
    private static final String TAG = "PostsViewModel";

    MutableLiveData<List<PostModel>> postsMutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> posts = new MutableLiveData<>();

    public void getPosts() {
        Single<List<PostModel>> observable = PostsClient.getINSTANCE().getPosts()
//        Observable<List<PostModel>> observable = PostsClient.getINSTANCE().getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o-> postsMutableLiveData.setValue(o) ,e-> Log.d(TAG, "getPosts:"+e));





    }


}
