package ecommerceme.android.retrofit.Service;

import java.util.List;

import ecommerceme.android.retrofit.pojo.PostModel;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    public Single<List<PostModel>> getPosts();
}
