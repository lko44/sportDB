package com.example.implementasiapi_10pplg1;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTeams;
    private TeamAdapter teamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTeams = findViewById(R.id.rvTeams);

        // Set RecyclerView's LayoutManager
        rvTeams.setLayoutManager(new LinearLayoutManager(this));

        // Initialize adapter with null list (it will be updated after data is fetched)
        teamAdapter = new TeamAdapter(this, null);
        rvTeams.setAdapter(teamAdapter);

        // Fetch teams from the API
        fetchTeams("English Premier League");
    }

    private void fetchTeams(String league) {
        APIService apiService = ApiClient.getClient().create(APIService.class);
        Call<TeamResponse> call = apiService.getTeams(league);

        // Enqueue the call to run asynchronously
        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful()) {
                    TeamResponse teamResponse = response.body();
                    if (teamResponse != null) {
                        List<Team> teams = teamResponse.getTeams();
                        if (teams == null || teams.isEmpty()) {
                            Log.e("API Response", "No teams found in the response.");
                            Toast.makeText(MainActivity.this, "No teams found", Toast.LENGTH_SHORT).show();
                        } else {
                            teamAdapter = new TeamAdapter(MainActivity.this, teams);
                            rvTeams.setAdapter(teamAdapter);
                        }
                    } else {
                        Log.e("API Error", "Response body is null");
                        Toast.makeText(MainActivity.this, "No response from server", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.e("API Error", "Response unsuccessful: " + response.message());
                    Toast.makeText(MainActivity.this, "Failed to load teams", Toast.LENGTH_SHORT).show();
                }
            }




            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                Log.e("API Error", "Request failed: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
