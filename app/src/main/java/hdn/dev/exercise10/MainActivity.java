package hdn.dev.exercise10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView superListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init
        superListView = findViewById(R.id.superListView);

        getSuperHeroes();

    }

    private void getSuperHeroes() {
        Call<List<SuperHero>> call = RetrofitClient.getInstance().getMyApi().getSuperHeroes();
        call.enqueue(new Callback<List<SuperHero>>() {
            @Override
            public void onResponse(Call<List<SuperHero>> call, Response<List<SuperHero>> response) {
                List<SuperHero> myheroList = response.body();
                String[] oneHeroes = new
                        String[myheroList.size()];
                for (int i = 0; i < myheroList.size(); i++) {
                    oneHeroes[i] = myheroList.get(i).getName();
                }
                superListView.setAdapter(new
                        ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_list_item_1, oneHeroes));
            }

            @Override
            public void onFailure(Call<List<SuperHero>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured",
                        Toast.LENGTH_LONG).show();


            }
        });

    }
}