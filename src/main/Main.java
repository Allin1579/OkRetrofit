package main;

import java.util.List;

import bean.Repo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import service.GitHubService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Retrofit retrofit = new Retrofit.Builder()
		    .baseUrl("https://api.github.com/")
		    .addConverterFactory(GsonConverterFactory.create())
		    .build();

		GitHubService service = retrofit.create(GitHubService.class);
		Call<List<Repo>> call = service.listRepos("octocat");
        call.enqueue(new Callback<List<Repo>>() {
           @Override
           public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
               System.out.println(response.toString());
           }

           @Override
           public void onFailure(Call<List<Repo>> call, Throwable t) {
        	   System.out.println(t.toString());
           }
        });
	}

}
